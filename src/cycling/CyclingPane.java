/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cycling;

import com.formdev.flatlaf.FlatDarkLaf;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.ActividadesPane;
import main.MainFrame;
import main.ReturnHandler;

/**
 *
 * @author BRYAN_ANDRADE
 */
public class CyclingPane extends JPanel implements ReturnHandler{
    MainFrame mainFrame;
    /**
     * Creates new form CyclingPane
     */
    public CyclingPane(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        setBackground(Color.BLACK);
       
    }
    
    public CyclingPane(){
        initComponents();
        
    }
    
    
    @SuppressWarnings("unchecked")
    
   /* public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
           
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CyclingPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }/*

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rutinaInternaBtn = new javax.swing.JToggleButton();
        rutinaExternaBtn = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(439, 463));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cycling");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Escoga la rutina:");

        rutinaInternaBtn.setBackground(new java.awt.Color(255, 51, 204));
        rutinaInternaBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rutinaInternaBtn.setForeground(new java.awt.Color(255, 255, 255));
        rutinaInternaBtn.setText("Interna");
        rutinaInternaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llamarRutinaInterna(evt);
            }
        });

        rutinaExternaBtn.setBackground(new java.awt.Color(0, 204, 204));
        rutinaExternaBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rutinaExternaBtn.setForeground(new java.awt.Color(255, 255, 255));
        rutinaExternaBtn.setText("Externa");
        rutinaExternaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llamarRutinaExterna(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(rutinaInternaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(rutinaExternaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutinaInternaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutinaExternaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void llamarRutinaInterna(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        mainFrame.setMainPanel(new RutinaInternaPanel(mainFrame));
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void llamarRutinaExterna(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        mainFrame.setMainPanel(new RutinaExternaPanel(mainFrame));
    }//GEN-LAST:event_jToggleButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton rutinaInternaBtn;
    private javax.swing.JToggleButton rutinaExternaBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doReturnAction() {
        mainFrame.setMainPanel(new ActividadesPane(mainFrame));
    }

    @Override
    public JPanel getReference() {
        return this;
    }
}
