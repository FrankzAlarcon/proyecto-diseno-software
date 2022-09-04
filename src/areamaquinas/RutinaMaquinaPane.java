
package areamaquinas;

/**
 *
 * @author dell
 */
import main.ActividadesPane;
import main.MainFrame;
import main.ReturnHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
 
public class RutinaMaquinaPane extends JPanel implements ReturnHandler{
    private MainFrame mainFrame;
    private JButton actionBtn, realizarRepeticionBtn, cambiarPesoBtn;
    private JLabel nombreMaquina, numRepeticiones, pesoActual;
    private JPanel dataPanel, actividadPanel;
    private Color acentColor = new Color(96, 2, 163); //Color Morado
    private boolean realizandoActividad = false;
    private ResumenRutina resumen;
    
    
    public RutinaMaquinaPane(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        //this.resumen=mainFrame.getAplicacion().seleccionarAreaMaquina();
        setOpaque(true);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Maquina XX");
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
        pesoActual= coloredLabel("0.0 Kg", acentColor, 20.0f);
        nombreMaquina = coloredLabel("Maquina de xx",acentColor, 20.0f);
        numRepeticiones = coloredLabel("0 repeticiones",acentColor, 20.0f);

        addDataPanel();

        actividadPanel = new JPanel();
        actividadPanel.setBorder(new EmptyBorder(10,10,10,10));
        actividadPanel.setOpaque(true);
        actividadPanel.setBackground(Color.BLACK);
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
        dataPanel.add(coloredLabel("Nombre Maquina", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(nombreMaquina, c);
        c.gridy = 2;
        dataPanel.add(coloredLabel("Peso Actual", Color.WHITE, 13.0f), c);
        c.gridy = 3;
        dataPanel.add(pesoActual, c);
        c.gridy = 0;
        c.gridx = 1;
        dataPanel.add(coloredLabel("Repeticiones", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(numRepeticiones, c);

    }

    private JLabel coloredLabel(String title, Color c, float size){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size));
        return label;
    }
    
    private void iniciarRutina(){
        
    }

    private void cambiarPaneles(){

        if(realizandoActividad){
            actionBtn.setText("Iniciar rutina");
            realizandoActividad = false;
            remove(actividadPanel);
            add(dataPanel, BorderLayout.CENTER);
            dataPanel.setVisible(true);
            actividadPanel.setVisible(false);
            //revalidate();
        }else{
            actionBtn.setText("Terminar rutina");
            realizandoActividad = true;
            add(actividadPanel, BorderLayout.CENTER);
            dataPanel.setVisible(false);
            actividadPanel.setVisible(true);
            //revalidate();
        }

    }

    @Override
    public void doReturnAction() {
        mainFrame.setMainPanel(new AreaMaquinasPanel(mainFrame));
    }

    @Override
    public JPanel getReference() {
        return this;
    }
}
