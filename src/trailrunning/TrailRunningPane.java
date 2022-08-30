package trailrunning;

import main.MainFrame;
import main.ReturnHandler;

import javax.swing.*;
import java.awt.*;

public class TrailRunningPane extends JPanel implements ReturnHandler {
    private MainFrame mainFrame;
    public TrailRunningPane(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setOpaque(true);
        setBackground(Color.RED);
        add(new JLabel("Trailing 1"));
    }

    @Override
    public void doReturnAction() {
        mainFrame.setMainPanel(new PanelPrueba(mainFrame));
    }

    @Override
    public JPanel getReference() {
        return this;
    }
}
