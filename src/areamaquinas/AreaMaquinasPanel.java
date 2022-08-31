/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import main.*;
import padel.PadelPane;

/**
 *
 * @author Frankz
 */


public class AreaMaquinasPanel extends javax.swing.JPanel implements ReturnHandler {

    
    JButton[][] maquinasBotones; 
    MainFrame mainframe;
    ListaMaquinas lista;
    int n=2;
    int m=3;
    
    
    
    public AreaMaquinasPanel(MainFrame mainframe) {
        this.mainframe = mainframe;
        lista.agregar(new Dorsalera(1, true, 4));
        lista.agregar(new Dorsalera(2, false, 4));
        lista.agregar(new Dorsalera(3, true, 4));
        lista.agregar(new Dorsalera(4, true, 4));
        lista.agregar(new PrensaPiernas(5, false, 4));
        lista.agregar(new MaquinaPoleas(6, true, 4));
        initComponents();
    }
    
    public void setMatriz(){
        int x=10,y=10;
        int c=0;
        maquinasBotones=new JButton[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maquinasBotones[i][j]=new JButton();
                
                if(lista.getMaquina(c).isOcupado()){
                    maquinasBotones[i][j].setBackground(Color.RED);
                }else{
                    maquinasBotones[i][j].setBackground(Color.GREEN);
                }
                maquinasBotones[i][j].setBounds(x, y, 48, 48);
                maquinasBotones[i][j].setText(lista.getMaquina(c).toString());
                
                ButtonController bt = new ButtonController();
                maquinasBotones[i][j].addActionListener(bt);
                
                this.add(maquinasBotones[i][j]);
                x+=47;
                c++;
            }
            x=10;
            y+=47;
        }   
    }//Cierre del Mëtodo
    
    private class ButtonController implements ActionListener{

        @Override			
        public void actionPerformed(ActionEvent e) {
            int c=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    c++;
                    if (e.getSource().equals(maquinasBotones[i][j])) {
                            System.out.println("Hola");
                            //mainframe.setMainPanel(new RutinaPanel(mainframe));
                        }
                        
                    }
                }
            }
      
     }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void doReturnAction() {
       mainframe.setMainPanel(new ActividadesPane(mainframe));
    }

    @Override
    public JPanel getReference() {
        return this;
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
