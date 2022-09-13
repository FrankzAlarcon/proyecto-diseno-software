/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package running;

import javax.swing.*;

import main.MainFrame;
import main.ReturnHandler;

import running.RunningPanel;

import java.awt.*;

/**
 *
 * @author Stalin narvaez
 */
public class TiempoPanel extends javax.swing.JPanel implements ReturnHandler{
    MainFrame mainframe;
    private JButton basico, moderado, avanzado;
    private Color acentColor = new Color(168, 95, 0);
    public TiempoPanel(MainFrame mainframe) {
        this.mainframe = mainframe;

        RutinaEstandarRunning rutina = mainframe.getAplicacion().seleccionarRunning().seleccionarEstandar();
        rutina.setMainFrame(mainframe);

        this.mainframe = mainframe;
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        JLabel titulo = coloredLabel("Selecciona el nivel", Color.WHITE, 20.0f);
        add(titulo, BorderLayout.NORTH);

        //botones
        basico = createButton("Básico", 15.0f);
        moderado = createButton("Moderado", 15.0f);
        avanzado = createButton("Avanzado", 15.0f);

        basico.addActionListener(a -> {
            rutina.cambiarNivel(new Basico(rutina));
            mainframe.setMainPanel(new RutinaEnCursoEstandar(mainframe,0));

        });
        moderado.addActionListener(a -> {
            rutina.cambiarNivel(new Moderado(rutina));
            mainframe.setMainPanel(new RutinaEnCursoEstandar(mainframe,0));

        });
        avanzado.addActionListener(a -> {
            rutina.cambiarNivel(new Avanzado(rutina));
            mainframe.setMainPanel(new RutinaEnCursoEstandar(mainframe,0));
        });

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3,1,10,10));
        panel.add(basico);
        panel.add(moderado);
        panel.add(avanzado);

        add(panel, BorderLayout.CENTER);

    }

    private JButton createButton(String title, float size){
        JButton btn = new JButton(title);
        btn.setBackground(acentColor);
        btn.setForeground(Color.WHITE);
        btn.setFont(btn.getFont().deriveFont(size));
        return btn;
    }


    private JLabel coloredLabel(String title, Color c, float size){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        label.setFont(label.getFont().deriveFont(size));
        return label;
    }


    @Override
    public void doReturnAction() {
        mainframe.setMainPanel(new RunningPanel(mainframe));
    }

    @Override
    public JPanel getReference() {
        return this;
    }

    // End of variables declaration                   
}
