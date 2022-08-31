/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cycling;

import cycling.CyclingPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.MainFrame;
import main.ReturnHandler;

/**
 *
 * @author Freddy Pallo <fredy.pallo@epn.edu.ec>
 */
public class RutinaInternaPanel extends JPanel implements ReturnHandler {

    private MainFrame mainFrame;

    /**
     * Creates new form RutinaInterno
     */
    public RutinaInternaPanel(MainFrame mainFrame) {
        //initComponents();
 
        this.mainFrame = mainFrame;
        setOpaque(true);
        setBackground(Color.RED);
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Rutina Interna");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD).deriveFont(20.0f));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);
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
