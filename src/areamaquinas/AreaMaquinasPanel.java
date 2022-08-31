/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import main.*;


/**
 *
 * @author Emilio Montalvo
 */


public class AreaMaquinasPanel extends javax.swing.JPanel implements ReturnHandler {

    
    JButton[][] maquinasBotones; 
    MainFrame mainframe;
    ListaMaquinas lista;
    int n=2;
    int m=3;
    
    
    
    public AreaMaquinasPanel(MainFrame mainframe) {
        initComponents();
        this.mainframe = mainframe;
        lista=new ListaMaquinas();
        lista.agregar(new PrensaPiernas(1, false, 4));
        lista.agregar(new PrensaPiernas(2, false, 4));
        lista.agregar(new Dorsalera(1, true, 4));
        lista.agregar(new Dorsalera(2, true, 4));
        lista.agregar(new MaquinaPoleas(1, false, 4));
        lista.agregar(new MaquinaPoleas(2, true, 4));
        
        setBackground(Color.BLACK);
        setLayout(new GridLayout(m,n,5,5));
        setBorder(new EmptyBorder(10,10,10,10));
        setMatriz();
        
    }
    
    public void setMatriz(){
       
        int c=0;
        maquinasBotones=new JButton[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               
                
                if(lista.getMaquina(c).isOcupado()){
                     maquinasBotones[i][j]=createStyledButton(lista.getMaquina(c).toString(), new Color(92, 161, 2), Color.WHITE);
                }else{
                     maquinasBotones[i][j]=createStyledButton(lista.getMaquina(c).toString(),new Color(203, 50, 52) , Color.WHITE);
                }
                /*maquinasBotones[i][j].setBounds(x, y, ancho, alto);
                maquinasBotones[i][j].setText(lista.getMaquina(c).toString());
                */
                ButtonController bt = new ButtonController();
                maquinasBotones[i][j].addActionListener(bt);
                
                this.add(maquinasBotones[i][j]);
                c++;
            }
            
        }   
    }

    private JButton createStyledButton(String title, Color bg, Color fg){
        JButton button = new JButton(title);
        button.setFont(button.getFont().deriveFont(Font.BOLD).deriveFont(15.0f));
        button.setBackground(bg);
        button.setForeground(fg);
        return button;
    }
    
     private class ButtonController implements ActionListener{

        @Override			
        public void actionPerformed(ActionEvent e) {
            int c=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    
                    if (e.getSource().equals(maquinasBotones[i][j])) {
                            
                            mainframe.setMainPanel(new RutinaMaquinaPane(mainframe));
                            
                        }
                        
                    }
                c++;
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
