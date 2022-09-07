/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package running;

import javax.swing.JPanel;
import main.ActividadesPane;
import main.MainFrame;
import main.ReturnHandler;

/**
 *
 * @author Stalin
 */
public class ResultadosPersonalizadoPanel extends javax.swing.JPanel implements ReturnHandler {

    MainFrame mainframe;
    

    public ResultadosPersonalizadoPanel(MainFrame mainframe) {

        this.mainframe = mainframe;
        initComponents();
        asignarValores();
    }

    public ResultadosPersonalizadoPanel() {
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

        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDistancia = new javax.swing.JLabel();
        lblCalorias = new javax.swing.JLabel();
        lblVelocidadMedia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Running");

        jLabel1.setText("Distancia recorrida (Km/h)");

        jLabel2.setText("Calorias quemadas");

        jLabel3.setText("Velocidad");

        lblDistancia.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        lblDistancia.setForeground(new java.awt.Color(226, 135, 67));
        lblDistancia.setText("0.0 Km");

        lblCalorias.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        lblCalorias.setForeground(new java.awt.Color(226, 135, 67));
        lblCalorias.setText("0.0 cal");

        lblVelocidadMedia.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        lblVelocidadMedia.setForeground(new java.awt.Color(226, 135, 67));
        lblVelocidadMedia.setText("0.0 m/s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCalorias))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblDistancia))
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVelocidadMedia)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(lblTitulo)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDistancia)
                    .addComponent(lblVelocidadMedia))
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblCalorias)
                .addContainerGap(425, Short.MAX_VALUE))
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

    public void asignarValores() {
        double calorias;
        double velocidad;
        double distancia;
        
        distancia = mainframe.getAplicacion().seleccionarRunning().seleccionarPersonalizada().getDistancia();
        velocidad = mainframe.getAplicacion().seleccionarRunning().seleccionarPersonalizada().getNivelVelocidad()*1.2;
        calorias = mainframe.getAplicacion().seleccionarRunning().seleccionarPersonalizada().getCaloriasQuemadas();
        //System.out.println(Calorias); 
        System.out.println(mainframe.getAplicacion().seleccionarRunning().seleccionarPersonalizada().getCaloriasQuemadas()); 
             
        lblCalorias.setText(String.format("%.2f cal", calorias));
        lblVelocidadMedia.setText(String.format("%.2f km/h", velocidad));
        lblDistancia.setText(String.format("%.2f Km", distancia));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCalorias;
    private javax.swing.JLabel lblDistancia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVelocidadMedia;
    // End of variables declaration//GEN-END:variables
}
