/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

import javax.swing.JPanel;
import main.*;

/**
 *
 * @author Frankz
 */
public class AreaMaquinasPanel extends javax.swing.JPanel implements ReturnHandler {

    /**
     * Creates new form AreaMaquinasPanel
     */
    MainFrame mainframe;
    public AreaMaquinasPanel(MainFrame mainframe) {
        this.mainframe = mainframe;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrensaPiernas = new javax.swing.JButton();
        btnMaquinaPoleas = new javax.swing.JButton();
        btnDorsalera = new javax.swing.JButton();

        btnPrensaPiernas.setText("Prensa de Piernas");
        btnPrensaPiernas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrensaPiernasActionPerformed(evt);
            }
        });

        btnMaquinaPoleas.setText("Maquina de Poleas");
        btnMaquinaPoleas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaquinaPoleasActionPerformed(evt);
            }
        });

        btnDorsalera.setText("Dorsalera");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrensaPiernas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaquinaPoleas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDorsalera, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(btnMaquinaPoleas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnPrensaPiernas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDorsalera, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrensaPiernasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrensaPiernasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrensaPiernasActionPerformed

    private void btnMaquinaPoleasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaquinaPoleasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaquinaPoleasActionPerformed

    @Override
    public void doReturnAction() {
        mainframe.setMainPanel(new ActividadesPane(mainframe));
    }

    @Override
    public JPanel getReference() {
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDorsalera;
    private javax.swing.JButton btnMaquinaPoleas;
    private javax.swing.JButton btnPrensaPiernas;
    // End of variables declaration//GEN-END:variables
}
