package root.GameMode.Stage;

import root.GUI.GamePanel;
import root.GUI.IconButton;
import root.GameMode.Visuals.NightMode;
import root.entities.plants.PuffShroom;
import root.entities.plants.SunShroom;
import root.entities.zombies.SnowZombie;

public class StageNight extends StageDay{
    public StageNight() {
        visualMode = new NightMode();
    }

    public StageNight(GamePanel gamePanel) {
        super(gamePanel);

        //zombie
        zombieClasses.add(SnowZombie.class);

        //plant
        plantClasses.add(SunShroom.class);
        cards.add(new IconButton(gamePanel.visualMode.SunShroomCardIcon, gamePanel.visualMode.GameDim.width * 52 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.SunShroomImage, gamePanel));

        plantClasses.add(PuffShroom.class);
        cards.add(new IconButton(gamePanel.visualMode.PuffShroomCardIcon, gamePanel.visualMode.GameDim.width * 46 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.PuffShroomImage, gamePanel));

        MAX_ZOMBIES = 80;
    }
}
