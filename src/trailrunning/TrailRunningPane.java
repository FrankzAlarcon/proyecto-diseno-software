package trailrunning;

import main.ActividadesPane;
import main.MainFrame;
import main.ReturnHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TrailRunningPane extends JPanel implements ReturnHandler {
    private MainFrame mainFrame;
    private JButton actionBtn;
    private JLabel caloriasQuemadas, distanciaRecorrida, elevacion, consumoOxigeno;
    private JPanel dataPanel, actividadPanel;
    private Color acentColor = new Color(92, 161, 2);
    private boolean realizandoActividad = false;
    private TrailRunning trailRunning;
    public TrailRunningPane(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        trailRunning = mainFrame.getAplicacion().seleccionarTrailRunning();
        setOpaque(true);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Trail Running");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD).deriveFont(25.0f));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        actionBtn = new JButton("Iniciar recorrido");
        actionBtn.setBackground(acentColor);
        actionBtn.setFont(actionBtn.getFont().deriveFont(18.0f));
        actionBtn.setForeground(Color.WHITE);

        add(actionBtn, BorderLayout.SOUTH);
        dataPanel = new JPanel();
        dataPanel.setOpaque(true);
        dataPanel.setBackground(Color.BLACK);
        dataPanel.setBorder(new EmptyBorder(10,10,10,10));
        caloriasQuemadas = coloredLabel("0.0 cal", acentColor, 20.0f);
        distanciaRecorrida = coloredLabel("0.0 km",acentColor, 20.0f);
        consumoOxigeno = coloredLabel("0.0 O2",acentColor, 20.0f);
        addDataPanel();
        actividadPanel = new JPanel();
        actividadPanel.setBorder(new EmptyBorder(10,10,10,10));
        actividadPanel.setOpaque(true);
        actividadPanel.setBackground(Color.BLACK);
        actividadPanel.setLayout(new BorderLayout());
        //actividadPanel.add(coloredLabel("Registrando datos...", Color.WHITE, 15.0f));

        JLabel regLabel = coloredLabel("Registrando datos...", Color.WHITE, 15.0f);
        regLabel.setHorizontalAlignment(JLabel.CENTER);
        actividadPanel.add(regLabel, BorderLayout.NORTH);
        JLabel icon = new JLabel();
        try {
            ImageIcon image = new ImageIcon(this.getClass().getResource("/res/trail.png"));
            icon.setIcon(new ImageIcon(image.getImage().getScaledInstance(120,120,Image.SCALE_AREA_AVERAGING)));
            icon.setHorizontalAlignment(JLabel.CENTER);
            actividadPanel.add(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }

        actionBtn.addActionListener(a -> {
            accionBoton();
        });
        add(dataPanel, BorderLayout.CENTER);
        //add(actividadPanel, BorderLayout.CENTER);
        //actividadPanel.setVisible(false);
    }

    private void addDataPanel(){
        GridBagLayout gd = new GridBagLayout();
        gd.columnWidths = new int[]{0,0};
        gd.columnWeights = new double[]{1.0,1.0};
        gd.rowHeights = new int[]{0,0,0,0,0};
        gd.rowWeights = new double[]{0.0,0.0,0.0,0.0,1.0};
        dataPanel.setLayout(gd);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        dataPanel.add(coloredLabel("Distancia recorrida", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(distanciaRecorrida, c);
        c.gridy = 2;
        dataPanel.add(coloredLabel("Calorías quemadas", Color.WHITE, 13.0f), c);
        c.gridy = 3;
        dataPanel.add(caloriasQuemadas, c);
        c.gridy = 0;
        c.gridx = 1;
        dataPanel.add(coloredLabel("Consumo de oxígeno", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(consumoOxigeno, c);

    }

    private JLabel coloredLabel(String title, Color c, float size){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size));
        return label;
    }

    private void accionBoton() {
        if(realizandoActividad){
            trailRunning.detener();
            ResumenTrailRunning resumenTrailRunning = trailRunning.getResumen();
            caloriasQuemadas.setText(String.format("%.2f cal",resumenTrailRunning.getCaloriasQuemadas()));
            distanciaRecorrida.setText(String.format("%.2f m",resumenTrailRunning.getDistanciaRecorrida()));
            consumoOxigeno.setText(String.format("%.2f O2",resumenTrailRunning.getOxigenoConsumido()));

        }else{
            trailRunning.iniciar();
        }
        cambiarPaneles();
    }

    private void cambiarPaneles(){

        if(realizandoActividad){
            actionBtn.setText("Iniciar recorrido");
            realizandoActividad = false;
            remove(actividadPanel);
            add(dataPanel, BorderLayout.CENTER);
            dataPanel.setVisible(true);
            actividadPanel.setVisible(false);
            //revalidate();
        }else{
            actionBtn.setText("Terminar recorrido");
            realizandoActividad = true;
            add(actividadPanel, BorderLayout.CENTER);
            dataPanel.setVisible(false);
            actividadPanel.setVisible(true);
            //revalidate();
        }

    }


    @Override
    public void doReturnAction() {
        if(realizandoActividad) trailRunning.detener();
        mainFrame.setMainPanel(new ActividadesPane(mainFrame));
    }

    @Override
    public JPanel getReference() {
        return this;
    }
}
