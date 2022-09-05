package main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import trailrunning.TrailRunningPane;
import running.RunningPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    private JButton regresarBtn;
    private ReturnHandler currentPane;
    private JPanel mainPanel;
    private Aplicacion aplicacion;
    public MainFrame(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        regresarBtn = new JButton("Regresar");
        mainPanel = new JPanel(new BorderLayout());
        //mainPanel.add(regresarBtn);
        setContentPane(mainPanel);


        JPanel buttonPane = new JPanel();
        regresarBtn.addActionListener(a -> {
            currentPane.doReturnAction();
        });

        buttonPane.add(regresarBtn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,700);

        mainPanel.add(buttonPane, BorderLayout.SOUTH);
       //setResizable(false);

    }

    public void setMainPanel(ReturnHandler panel){
        if(currentPane != null)
            mainPanel.remove(currentPane.getReference());
        currentPane = panel;
        mainPanel.add(panel.getReference(), BorderLayout.CENTER);
        mainPanel.revalidate();
    }
}
