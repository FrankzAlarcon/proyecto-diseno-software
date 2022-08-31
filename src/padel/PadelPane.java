package padel;

import main.ActividadesPane;
import main.MainFrame;
import main.ReturnHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PadelPane extends JPanel implements ReturnHandler {
    private MainFrame mainFrame;
    private JButton actionBtn;
    private JLabel marcaRaqueta, caloriasQuemadas, golpesDados,distanciaRecorrida;
    private JPanel dataPanel, actividadPanel;
    private Color acentColor = new Color(0, 75, 156);
    private boolean realizandoActividad = false;
    public PadelPane(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setOpaque(true);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Padel");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD).deriveFont(25.0f));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        actionBtn = new JButton("Iniciar partida");
        actionBtn.setBackground(acentColor);
        actionBtn.setFont(actionBtn.getFont().deriveFont(18.0f));
        actionBtn.setForeground(Color.WHITE);

        add(actionBtn, BorderLayout.SOUTH);
        dataPanel = new JPanel();
        dataPanel.setOpaque(true);
        dataPanel.setBackground(Color.BLACK);
        dataPanel.setBorder(new EmptyBorder(10,10,10,10));
        caloriasQuemadas = coloredLabel("0.0 cal", acentColor, 20.0f);
        marcaRaqueta = coloredLabel("Nox",acentColor, 20.0f);
        distanciaRecorrida = coloredLabel("15 metros",acentColor, 20.0f);
        golpesDados = coloredLabel("0 golpes",acentColor, 20.0f);

        addDataPanel();

        actividadPanel = new JPanel();
        actividadPanel.setBorder(new EmptyBorder(5,5,5,5));
        actividadPanel.setOpaque(true);
        actividadPanel.setBackground(Color.white);
        actividadPanel.add(coloredLabel("Registrando datos...", Color.WHITE, 15.0f));

        actionBtn.addActionListener(a -> {
            cambiarPaneles();
        });
        add(dataPanel, BorderLayout.CENTER);
        //add(actividadPanel, BorderLayout.CENTER);
        //actividadPanel.setVisible(false);
    }

    private void addDataPanel(){
        GridBagLayout gd = new GridBagLayout();
        gd.columnWidths = new int[]{0,0,0};
        gd.columnWeights = new double[]{1.0,1.0,1.0};
        gd.rowHeights = new int[]{0,0,0,0,0,0,0};
        gd.rowWeights = new double[]{0.0,0.0,0.0,0.0,1.0};
        dataPanel.setLayout(gd);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20,20,20,20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        dataPanel.add(coloredLabel("Marca raqueta", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(marcaRaqueta, c);
        c.gridy = 2;
        dataPanel.add(coloredLabel("Calorías quemadas", Color.WHITE, 13.0f), c);
        c.gridy = 3;
        dataPanel.add(caloriasQuemadas, c);
        c.gridx = 1;
        c.gridy = 0;
        dataPanel.add(coloredLabel("Golpes dados", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(golpesDados, c);
        c.gridy = 2;
        dataPanel.add(coloredLabel("Distancia recorrida", Color.WHITE, 13.0f), c);
        c.gridy = 3;
        dataPanel.add(distanciaRecorrida, c);
        c.gridx=2;
    }

    private JLabel coloredLabel(String title, Color c, float size){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size));
        return label;
    }

    private void cambiarPaneles(){

        if(realizandoActividad){
            actionBtn.setText("Iniciar partida");
            realizandoActividad = false;
            remove(actividadPanel);
            add(dataPanel, BorderLayout.CENTER);
            dataPanel.setVisible(true);
            actividadPanel.setVisible(false);
            //revalidate();
        }else{
            actionBtn.setText("Terminar partida");
            realizandoActividad = true;
            add(actividadPanel, BorderLayout.CENTER);
            dataPanel.setVisible(false);
            actividadPanel.setVisible(true);
            //revalidate();
        }

    }


    @Override
    public void doReturnAction() {
        mainFrame.setMainPanel(new ActividadesPane(mainFrame));
    }

    @Override
    public JPanel getReference() {
        return this;
    }
}