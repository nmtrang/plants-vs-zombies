package root;

import javax.swing.JFrame;
import root.GUI.GamePanel;

public class PlantsVsZombies extends JFrame {
    int numberOfStage = 1;

//    public int getNumberofStage() {
//        return numberOfStage;
//    }

    public PlantsVsZombies(int i) {
        this.numberOfStage = i;
        initUI();
    }

    private void initUI() {
        add(new GamePanel(numberOfStage));
        pack();
        setTitle("Plants Versus Zombies Clone");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
