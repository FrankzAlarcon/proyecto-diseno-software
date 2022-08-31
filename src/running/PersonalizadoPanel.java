/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package running;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import main.MainFrame;
import main.ReturnHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


import running.RunningPanel;
/**
 *
 * @author Stalin
 */
public class PersonalizadoPanel extends javax.swing.JPanel implements ReturnHandler{
    private MainFrame mainframe;
    private JButton actionBtn;
    private JLabel caloriasQuemadas, distanciaRecorrida, elevacion, consumoOxigeno;
    private JPanel dataPanel, actividadPanel;
    private Color acentColor = new Color(92, 161, 2);
    private boolean realizandoActividad = false;
    public PersonalizadoPanel(MainFrame mainframe) {
         initComponents();
        this.mainframe = mainframe;
        
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
    /**
     * Creates new form PersonalizadoPanel
     */
    public PersonalizadoPanel() {
        initComponents();
    }
    
private JLabel coloredLabel(String title, Color c, float size){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size));
        return label;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Tiempo");

        jLabel2.setText("Velocidad");

        jLabel3.setText("Inclinacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void doReturnAction() {
        mainframe.setMainPanel(new RunningPanel(mainframe)); //To change body of generated methods, choose Tools | Templates.
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
    public JPanel getReference() {
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
