
package areamaquinas;

/**
 *
 * @author dell
 */
import main.MainFrame;
import main.ReturnHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RutinaMaquinaPane extends JPanel implements ReturnHandler{
    private MainFrame mainFrame;
    private JButton actionBtn;
    private JLabel caloriasQuemadas, numRepeticionesTotales, pesoFinal, titulo, regLabel;
    private JPanel dataPanel, actividadPanel;
    private Color acentColor = new Color(96, 2, 163); //Color Morado
    private boolean realizandoActividad = false;
    private RutinaMaquinas rutinaActual;
    private Maquina maquina;
    /*
    private int numEjercicio = 0;
    private Peso auxPeso;
    private SensorPeso sensorPesoSctual;
    private ControladorPeso controladorPeso;

    private NumeroRepeticion auxRepeticion;
    private SensorRepeticion sensorRepeticionActual;
    private ControladorRepeticiones controladorRepeticion;
    */
    
    public RutinaMaquinaPane(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        maquina = mainFrame.getAplicacion().seleccionarAreaMaquina().getRutina().getMaquina();
        rutinaActual = mainFrame.getAplicacion().seleccionarAreaMaquina().getRutina();
        rutinaActual.setMaquina(maquina);
        rutinaActual.setAreaMaquinas(mainFrame.getAplicacion().seleccionarAreaMaquina());

        setOpaque(true);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        titulo = new JLabel(maquina.toString());
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD).deriveFont(25.0f));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        actionBtn = new JButton("Iniciar Rutina");
        actionBtn.setBackground(acentColor);
        actionBtn.setFont(actionBtn.getFont().deriveFont(18.0f));
        actionBtn.setForeground(Color.WHITE);

        add(actionBtn, BorderLayout.SOUTH);
        dataPanel = new JPanel();
        dataPanel.setOpaque(true);
        dataPanel.setBackground(Color.BLACK);
        dataPanel.setBorder(new EmptyBorder(10,10,10,10));
        pesoFinal= coloredLabel("0.0 Kg", acentColor, 20.0f);
        caloriasQuemadas = coloredLabel("0.0 cal",acentColor, 20.0f);
        numRepeticionesTotales = coloredLabel("0 repeticiones",acentColor, 20.0f);

        addDataPanel();

        actividadPanel = new JPanel();
        actividadPanel.setBorder(new EmptyBorder(10,10,10,10));
        actividadPanel.setOpaque(true);
        actividadPanel.setBackground(Color.BLACK);
        actividadPanel.setLayout(new BorderLayout());        
        
        regLabel = coloredLabel("Registrando datos...", Color.WHITE, 15.0f);
        regLabel.setHorizontalAlignment(JLabel.CENTER);
        actividadPanel.add(regLabel, BorderLayout.NORTH);
        JLabel icon = new JLabel();
        try {
            ImageIcon image = rutinaActual.getMaquina().utilizar();
            icon.setIcon(new ImageIcon(image.getImage().getScaledInstance(120,120,Image.SCALE_AREA_AVERAGING)));
            icon.setHorizontalAlignment(JLabel.CENTER);
            actividadPanel.add(icon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      
        
        actionBtn.addActionListener(a -> {
            accionBoton();
        });
        add(dataPanel, BorderLayout.CENTER);
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
        dataPanel.add(coloredLabel("Calorias Quemadas", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(caloriasQuemadas, c);
        c.gridy = 2;
        dataPanel.add(coloredLabel("Peso Total Levantado", Color.WHITE, 13.0f), c);
        c.gridy = 3;
        dataPanel.add(pesoFinal, c);
        c.gridy = 0;
        c.gridx = 1;
        dataPanel.add(coloredLabel("Num Repeticiones Totales", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(numRepeticionesTotales, c);
    }
    

    private JLabel coloredLabel(String title, Color c, float size){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size));
        return label;
    }
    private void accionBoton() {
        if(realizandoActividad){
            rutinaActual.detener();
            caloriasQuemadas.setText(String.format("%.2f cal",rutinaActual.calcularCaloriasQuemadas()));
            pesoFinal.setText(String.format("%.2f kg",rutinaActual.getPesos().calcularPromedio()));
            numRepeticionesTotales.setText(String.format("%d ",rutinaActual.getNumRepeticiones().calcularTotal()));
            this.rutinaActual = new RutinaMaquinas(maquina);
            this.rutinaActual.setAreaMaquinas(mainFrame.getAplicacion().seleccionarAreaMaquina());

        }else{
            rutinaActual.iniciar();
        }
        cambiarPaneles();
    }
    private void cambiarPaneles(){

        if(realizandoActividad){
            actionBtn.setText("Iniciar rutina");
            realizandoActividad = false;
            remove(actividadPanel);            
            remove(regLabel);
            titulo = new JLabel(maquina.toString());
            titulo.setFont(titulo.getFont().deriveFont(Font.BOLD).deriveFont(25.0f));
            titulo.setForeground(Color.WHITE);
            titulo.setHorizontalAlignment(JLabel.CENTER);
            add(titulo, BorderLayout.NORTH);
            add(dataPanel, BorderLayout.CENTER);
            dataPanel.setVisible(true);
         actividadPanel.setVisible(false);
            
        }else{
            actionBtn.setText("Terminar rutina");
            realizandoActividad = true;
            remove(dataPanel);
            remove(titulo);
            add(actividadPanel, BorderLayout.CENTER);
            dataPanel.setVisible(false);
            actividadPanel.setVisible(true);
            //revalidate();
        }

    }

    @Override
    public void doReturnAction() {
        if(realizandoActividad) rutinaActual.detener();
        mainFrame.setMainPanel(new AreaMaquinasPanel(mainFrame));
    }

    @Override
    public JPanel getReference() {
        return this;
    }
}
