package main;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JPanel implements ReturnHandler {

    private JTextField usuarioIn;
    private JPasswordField contraseniaIn;
    private JButton ingresarBtn, registrarseBtn;
    private MainFrame mainFrame;
    public LogIn(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        ingresarBtn = new JButton("Ingresar");
        ingresarBtn.setBackground(new Color(0, 75, 156));
        ingresarBtn.setForeground(Color.WHITE);
        registrarseBtn = new JButton("Registrarse");
        usuarioIn = new JTextField(25);
        contraseniaIn = new JPasswordField(25);

        GridBagLayout gd = new GridBagLayout();
        setLayout(gd);
        setOpaque(true);
        setBackground(Color.BLACK);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 2;
        add(new JLabel("Usuario"), c);
        c.gridy = 1;
        add(usuarioIn, c);
        c.gridy = 2;
        add(new JLabel("Contraseña"), c);
        c.gridy = 3;
        add(contraseniaIn, c);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        add(ingresarBtn, c);
        c.gridx = 1;
        add(registrarseBtn, c);

        ingresarBtn.addActionListener(a -> {
            mostarPanelActividades();
        });

        registrarseBtn.addActionListener(a -> {
            mainFrame.setMainPanel(new RegistroPane(mainFrame));
        });

    }

    private void validarDatos(){

    }

    private void mostarPanelActividades(){
        mainFrame.setMainPanel(new ActividadesPane(mainFrame));
    }

    @Override
    public void doReturnAction() {

    }

    @Override
    public JPanel getReference() {
        return this;
    }
}