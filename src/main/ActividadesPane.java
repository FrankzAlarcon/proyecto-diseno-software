package main;

import areamaquinas.AreaMaquinasPanel;
import trailrunning.TrailRunningPane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import padel.PadelPane;

public class ActividadesPane extends JPanel implements ReturnHandler{
    private JButton runningBtn, trailRunningBtn, cyclingBtn, padelBtn, areaMaquinasBtn;
    private MainFrame mainFrame;
    public ActividadesPane(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        runningBtn = createStyledButton("Running", new Color(168, 95, 0), Color.WHITE);
        trailRunningBtn = createStyledButton("Trail Running", new Color(92, 161, 2), Color.WHITE);
        cyclingBtn = createStyledButton("Cycling", new Color(2, 153, 143), Color.WHITE);
        padelBtn = createStyledButton("Padel", new Color(0, 75, 156), Color.WHITE);
        areaMaquinasBtn = createStyledButton("Área Máquinas", new Color(96, 2, 163), Color.WHITE);
        setLayout(new GridLayout(0,2,5,5));
        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(10,10,10,10));
        add(runningBtn);
        add(trailRunningBtn);
        add(cyclingBtn);
        add(padelBtn);
        add(areaMaquinasBtn);

        runningBtn.addActionListener(a -> {
            mostrarPanelPrincipalRunning();
        });

        trailRunningBtn.addActionListener(a -> {
            mostrarPanelPrincipalTrailRunning();
        });

        areaMaquinasBtn.addActionListener(a -> {
            mostrarPanelAreaMaquinas();
        });

        cyclingBtn.addActionListener(a -> {
            mostrarPanelPrincipalCycling();
        });

        padelBtn.addActionListener(a -> {
            mostrarPanelPadel();
        });
    }

    private JButton createStyledButton(String title, Color bg, Color fg){
        JButton button = new JButton(title);
        button.setFont(button.getFont().deriveFont(Font.BOLD).deriveFont(15.0f));
        button.setBackground(bg);
        button.setForeground(fg);
        return button;
    }
    private void mostrarPanelPrincipalRunning(){

    }
    private void mostrarPanelPrincipalTrailRunning(){
        mainFrame.setMainPanel(new TrailRunningPane(mainFrame));
    }
    private void mostrarPanelPrincipalCycling(){

    }
    private void mostrarPanelAreaMaquinas(){
        mainFrame.setMainPanel(new AreaMaquinasPanel(mainFrame));
    }

    private void mostrarPanelPadel(){
        mainFrame.setMainPanel(new PadelPane(mainFrame));
    }
    @Override
    public void doReturnAction() {

    }

    @Override
    public JPanel getReference() {
        return this;
    }
}
