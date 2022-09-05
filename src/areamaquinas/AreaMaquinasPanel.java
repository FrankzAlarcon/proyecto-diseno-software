/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    ResumenRutina resumen;
    AreaMaquinas areaMaquianas;
    
    
    public AreaMaquinasPanel(MainFrame mainframe) {
        initComponents();
        this.mainframe = mainframe;
        this.areaMaquianas=this.mainframe.getAplicacion().seleccionarAreaMaquina();
        
        
        lista=new ListaMaquinas();
        lista.agregar(new PrensaPiernas(1, false, 4));
        lista.agregar(new PrensaPiernas(2, false, 4));
        lista.agregar(new Dorsalera(1, true, 4));
        lista.agregar(new Dorsalera(2, false, 4));
        lista.agregar(new MaquinaPoleas(1, false, 4));
        lista.agregar(new MaquinaPoleas(2, true, 4));
        areaMaquianas.setLista(lista);
        
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());        
        setBorder(new EmptyBorder(10,10,10,10));
        setMatriz();
        
    }
    
    public void setMatriz(){
        
        int c=0;
        maquinasBotones=new JButton[m][n];
        int posicionesY[] = {0,2,4};
        String nombres[] = {"Prensas de Piernas", "Dorsaleras", "Máquinas de Poleas"};
        for (int i = 0; i < m; i++) {
            setTitulo(nombres[i], 0, posicionesY[i], 2);
            for (int j = 0; j < n; j++) {                               
                if(areaMaquianas.getMaquina(c).isOcupado()){
                     maquinasBotones[i][j]=createStyledButton(areaMaquianas.getMaquina(c).toString(), new Color(92, 161, 2), Color.WHITE);
                }else{
                     maquinasBotones[i][j]=createStyledButton(areaMaquianas.getMaquina(c).toString(),new Color(203, 50, 52) , Color.WHITE);
                }
                /*maquinasBotones[i][j].setBounds(x, y, ancho, alto);
                maquinasBotones[i][j].setText(lista.getMaquina(c).toString());
                */
                ButtonController bt = new ButtonController();
                maquinasBotones[i][j].addActionListener(bt);
                GridBagConstraints restricciones = generarRestriccionesLayout(j + 1,  posicionesY[i] + 1 , 1, true);
                this.add(maquinasBotones[i][j], restricciones);
                c++;
            }
            
        }   
    }
    
    public void setTitulo(String text, int x, int y, int gridWidth) {
        JPanel panel = new JPanel();        
        panel.setBackground(new Color(1, 1, 1, 0));
        panel.add(coloredLabel(text,Color.WHITE, 15.0f));
        GridBagConstraints restricciones = generarRestriccionesLayout(x, y, gridWidth, false);
        this.add(panel, restricciones);
    }
    
    private GridBagConstraints generarRestriccionesLayout(int x, int y, int gridWidth, boolean isButton) {
        GridBagConstraints restricciones = new GridBagConstraints();
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        restricciones.gridx = x;
        restricciones.gridy = y;
        restricciones.gridwidth = gridWidth;     
        restricciones.insets = new Insets(3, 5, 3, 5);
        if (isButton) {
           restricciones.ipady = 140; 
        }
        return restricciones;
    }

    private JLabel coloredLabel(String title, Color c, float size){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size).deriveFont(Font.BOLD));
        return label;
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
                            
                        Maquina m=areaMaquianas.seleccionarMaquina(c, mainframe);
                           if(m!=null){
                               resumen=new ResumenRutina(m, new RutinaMaquinas());
                               areaMaquianas.setResumen(resumen);
                               mainframe.setMainPanel(new RutinaMaquinaPane(mainframe));
                           }                          
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
