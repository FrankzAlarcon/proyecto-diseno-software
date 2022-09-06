/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cycling;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.MainFrame;
import main.ReturnHandler;
import main.Ubicacion;

/**
 *
 * @author Freddy Pallo <fredy.pallo@epn.edu.ec>
 */
public class RutinaExternaPanel extends JPanel implements ReturnHandler {

    private MainFrame mainFrame;
    private JButton actionBtn;
    private JLabel caloriasQuemadas, distanciaRecorrida, ubicaciones;
    private boolean realizandoActividad = false;
    private Color acentColor = new Color(2, 153, 143);
    private JPanel dataPanel, actividadPanel;
    private RutinaExternaCycling rutinaExterna;
    /**
     * Creates new form RutinaExternaPanel
     */
    public RutinaExternaPanel(MainFrame mainFrame) {
        // initComponents();
        this.mainFrame = mainFrame;
        this.rutinaExterna = mainFrame.getAplicacion().seleccionarCycling().seleccionarRutinaExterna();
        setOpaque(true);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Rutina Externa");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD).deriveFont(20.0f));
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
        dataPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        caloriasQuemadas = coloredLabel("0.0 cal", acentColor, 20.0f);
        distanciaRecorrida = coloredLabel("0 m", acentColor, 20.0f);
        ubicaciones = coloredLabel("",acentColor,20.0f);
        

        
        

        addDataPanel();

        actividadPanel = new JPanel();
        actividadPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        actividadPanel.setOpaque(true);
        actividadPanel.setBackground(Color.BLACK);
        actividadPanel.setLayout(new BorderLayout());
        JLabel regLabel = coloredLabel("Registrando datos...", Color.WHITE, 15.0f);
        regLabel.setHorizontalAlignment(JLabel.CENTER);
        actividadPanel.add(regLabel, BorderLayout.NORTH);
        JLabel icon = new JLabel();
        try {
            ImageIcon image = new ImageIcon(this.getClass().getResource("/res/cyclingExterna.png"));
            icon.setIcon(new ImageIcon(image.getImage().getScaledInstance(120, 120, Image.SCALE_FAST)));
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

    private void addDataPanel() {
        GridBagLayout gd = new GridBagLayout();
        gd.columnWidths = new int[]{0, 0};
        gd.columnWeights = new double[]{1.0, 1.0};
        gd.rowHeights = new int[]{0, 0, 0, 0, 0};
        gd.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0};
        dataPanel.setLayout(gd);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        dataPanel.add(coloredLabel("Distancia recorrida", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(distanciaRecorrida, c);
        c.gridy = 0;
        c.gridx = 1;
        dataPanel.add(coloredLabel("Calorias Quemadas", Color.WHITE, 13.0f), c);

        c.gridy = 1;
        dataPanel.add(caloriasQuemadas, c);
        c.gridy = 2;
        c.gridx = 0;
        dataPanel.add(coloredLabel("Ubicaciones", Color.WHITE, 13.0f), c);
        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        ubicaciones.setOpaque(true);
        ubicaciones.setBackground(Color.BLACK);
        ubicaciones.setVerticalAlignment(JLabel.TOP);
        JScrollPane scrollPane = new JScrollPane(ubicaciones);
        scrollPane.setBackground(Color.BLACK);
        dataPanel.add(scrollPane, c);


    }

    private JLabel coloredLabel(String title, Color c, float size) {
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size));
        return label;
    }

    private void accionBoton() {
        if(realizandoActividad) {
            rutinaExterna.detener();
            distanciaRecorrida.setText(String.format("%.2f cm",rutinaExterna.calcularDistancia()));
            caloriasQuemadas.setText(rutinaExterna.calcularCaloriasQuemadas() + " cal");
            String ubicacionesTxt = "<html>";
            for(Ubicacion u : rutinaExterna.getRuta().getUbicaciones()){
                ubicacionesTxt += String.format("%.4f; %.4f <p>", u.getLatitud(), u.getLongitud());
            }
            ubicacionesTxt += "</html>";
            ubicaciones.setText(ubicacionesTxt);
        }else{
            rutinaExterna.iniciar();
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



    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void doReturnAction() {
        mainFrame.setMainPanel(new CyclingPane(mainFrame));

    }

    @Override
    public JPanel getReference() {
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
