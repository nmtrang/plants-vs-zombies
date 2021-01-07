package root.GameMode.Stage;

import root.GUI.GamePanel;
import root.GUI.IconButton;
import root.GameMode.Visuals.NoScalingMode;
import root.entities.plants.*;
import root.entities.zombies.*;
import root.etc.CellsManager;

public class StageDay extends Stage {
    public StageDay() {
        visualMode = new NoScalingMode();
    }

    public StageDay(GamePanel gamePanel) {
        super(gamePanel);

        cards.add(new IconButton(gamePanel.visualMode.ShovelButtonIcon, gamePanel.visualMode.GameDim.width * 66 / 100, 0,
                gamePanel.visualMode.ShovelImage, gamePanel));

        // Add zombies for this Stage
        zombieClasses.add(NormalZombie.class);
        zombieClasses.add(FlagZombie.class);
        zombieClasses.add(ConeHeadZombie.class);
        zombieClasses.add(BucketHeadZombie.class);
        zombieClasses.add(NewspaperZombie.class);

        //plant
        plantClasses.add(SunFlower.class);
        cards.add(new IconButton(gamePanel.visualMode.SunFlowerCardIcon, gamePanel.visualMode.GameDim.width * 10 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.SunFlowerImage, gamePanel));

        plantClasses.add(PeaShooter.class);
        cards.add(new IconButton(gamePanel.visualMode.PeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 16 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.PeaShooterImage, gamePanel));

        plantClasses.add(Walnut.class);
        cards.add(new IconButton(gamePanel.visualMode.WalnutCardIcon, gamePanel.visualMode.GameDim.width * 22 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.Walnut1, gamePanel));

        plantClasses.add(SnowPea.class);
        cards.add(new IconButton(gamePanel.visualMode.SnowPeaCardIcon, gamePanel.visualMode.GameDim.width * 28 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.SnowPeaImage, gamePanel));

        plantClasses.add(Repeater.class);
        cards.add(new IconButton(gamePanel.visualMode.RepeaterCardIcon, gamePanel.visualMode.GameDim.width * 34 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.RepeaterImage, gamePanel));

        plantClasses.add(GatlingPea.class);
        cards.add(new IconButton(gamePanel.visualMode.GatlingPeaCardIcon, gamePanel.visualMode.GameDim.width * 40 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.GatlingPeaImage, gamePanel));


        for (int lane : CellsManager.lanes) {
            lawnmowers.add(new Lawnmower(0, lane));
        }

        MAX_ZOMBIES = 50;

    }

}
