package main;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class LogIn {
    private String usuario;
    private String contrasenia;
    private MainFrame mainFrame;

    public LogIn() {
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("./user.conf"), StandardCharsets.UTF_8);
            Properties p = new Properties();
            p.load(reader);
            usuario = p.getProperty("user","admin");
            contrasenia = p.getProperty("password", "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validarCredenciales(String user, String password) {
        if( usuario.equals(user) && contrasenia.equals(password)){
            Aplicacion aplicacion = new Aplicacion();
            mainFrame.setAplicacion(aplicacion);
            mainFrame.getAplicacion().setUsuario(new Usuario(
                    "Juan Pérez",
                    25,
                    65.25,
                    1.75,
                    'M'
            ));
            mainFrame.setMainPanel(new ActividadesPane(mainFrame));
        }else{
            JOptionPane.showMessageDialog(mainFrame, "Usuario y/o contraseña incorrecto(s)","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarVentana() {

        LogInPane logInPane = new LogInPane(mainFrame);
        logInPane.setLogIn(this);
        mainFrame.setMainPanel(logInPane);
        mainFrame.setVisible(true);
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
