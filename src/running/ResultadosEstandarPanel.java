/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package running;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.ActividadesPane;
import main.MainFrame;
import main.ReturnHandler;

import java.awt.*;

/**
 *
 * @author Stalin
 */
public class ResultadosEstandarPanel extends javax.swing.JPanel implements ReturnHandler{
    private MainFrame mainFrame;
    private JLabel caloriasQuemadas, tiempo;
    private JPanel dataPanel;
    private Color acentColor = new Color(168, 95, 0);
    private RutinaEstandarRunning rutina;
    public ResultadosEstandarPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        rutina = mainFrame.getAplicacion().seleccionarRunning().seleccionarEstandar();
        setOpaque(true);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Rutina Estandar Running");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD).deriveFont(25.0f));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        //add(actionBtn, BorderLayout.SOUTH);
        dataPanel = new JPanel();
        dataPanel.setOpaque(true);
        dataPanel.setBackground(Color.BLACK);
        dataPanel.setBorder(new EmptyBorder(10,10,10,10));
        caloriasQuemadas = coloredLabel("0.0 cal", acentColor, 20.0f);
        caloriasQuemadas.setText(String.format("%.2f cal", rutina.getCaloriasQuemadas()));
        tiempo = coloredLabel("0.0 km",acentColor, 20.0f);
        tiempo.setText(String.format("%d min", rutina.getTiempo()));

        addDataPanel();
        add(dataPanel, BorderLayout.CENTER);
        //actividadPanel.add(coloredLabel("Registrando datos...", Color.WHITE, 15.0f));


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
        dataPanel.add(coloredLabel("Tiempo", Color.WHITE, 13.0f), c);
        c.gridy = 1;
        dataPanel.add(tiempo, c);
        c.gridy = 2;
        dataPanel.add(coloredLabel("Calorías quemadas", Color.WHITE, 13.0f), c);
        c.gridy = 3;
        dataPanel.add(caloriasQuemadas, c);



    }

    private JLabel coloredLabel(String title, Color c, float size){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size));
        return label;
    }

    @Override
    public void doReturnAction() {
        mainFrame.setMainPanel(new RunningPanel(mainFrame));
    }

    @Override
    public JPanel getReference() {
        return this;
    }
}
