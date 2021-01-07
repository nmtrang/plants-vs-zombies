package root.GUI;

import root.GameMode.Visuals.NoScalingMode;
import root.GameMode.Visuals.VisualMode;
import root.etc.ResourcesPath;

import javax.swing.*;
import java.awt.*;

public class MenuClass extends JPanel implements ResourcesPath {
    public VisualMode visualMode = new NoScalingMode();

    public MenuClass() {
        setLayout(null);
        setPreferredSize(visualMode.Menu_Dim);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(visualMode.MenuGame, 0, 0, this);
    }
}
