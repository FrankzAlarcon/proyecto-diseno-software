package main;

import javax.swing.*;
import java.awt.*;

public class RegistroPane extends JPanel implements ReturnHandler {

    private JTextField nombre, edad, peso, altura;
    private JComboBox<String> sexo;
    private JButton registrarBtn, limpiarCamposBtn;
    private MainFrame mainFrame;
    public RegistroPane(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        nombre = createTextField();
        edad = createTextField();
        peso = createTextField();
        altura = createTextField();
        sexo = new JComboBox<>(new String[]{"M","F"});
        registrarBtn = new JButton("Registrarse");
        registrarBtn.setBackground(new Color(0, 75, 156));
        registrarBtn.setForeground(Color.WHITE);
        limpiarCamposBtn = new JButton("Limpiar campos");
        setOpaque(true);
        setBackground(Color.BLACK);
        GridBagLayout gd = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gd);
        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        addComponentAt(coloredLabel("Nombre", Color.WHITE), 0,0, c);
        addComponentAt(nombre, 0,1, c);
        addComponentAt(coloredLabel("Edad", Color.WHITE), 0,2, c);
        addComponentAt(edad, 0,3, c);
        addComponentAt(coloredLabel("Peso (kg)", Color.WHITE), 0,4, c);
        addComponentAt(peso, 0,5, c);
        addComponentAt(coloredLabel("Altura (m)", Color.WHITE), 0,6, c);
        addComponentAt(altura, 0,7, c);
        addComponentAt(coloredLabel("Sexo", Color.WHITE), 0,8, c);
        addComponentAt(sexo, 0,9, c);
        c.gridwidth = 1;
        addComponentAt(registrarBtn, 0,10,c);
        addComponentAt(limpiarCamposBtn, 1,10,c);

        registrarBtn.addActionListener(a -> {
            registrarUsuario();
        });
    }

    private void registrarUsuario() {
        try {
            Usuario user = new Usuario(
                    nombre.getText(),
                    Integer.parseInt(edad.getText()),
                    Double.parseDouble(peso.getText()),
                    Double.parseDouble(altura.getText()),
                    ((String) sexo.getSelectedItem()).charAt(0)
            );
            JOptionPane.showMessageDialog(mainFrame,"Registro exitoso","Registro...",JOptionPane.PLAIN_MESSAGE);
            mainFrame.getAplicacion().setUsuario(user);
            mainFrame.setMainPanel(new ActividadesPane(mainFrame));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private JTextField createTextField(){
        JTextField textField = new JTextField(25);
        textField.setMinimumSize(new Dimension(150,15));
        return textField;
    }

    private JLabel coloredLabel(String title, Color c){
        JLabel label = new JLabel(title);
        label.setForeground(c);
        //label.setFont(label.getFont().deriveFont(size));
        return label;
    }

    private void addComponentAt(JComponent component, int x, int y, GridBagConstraints constraints){
        constraints.gridy = y;
        constraints.gridx = x;
        add(component, constraints);
    }

    @Override
    public void doReturnAction() {
        mainFrame.setMainPanel(new LogIn(mainFrame));
    }

    @Override
    public JPanel getReference() {
        return this;
    }
}
