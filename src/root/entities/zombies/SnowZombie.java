package root.entities.zombies;

import java.awt.*;

public class SnowZombie extends Zombie {
    public SnowZombie(int x, int y) {
        super(x, y);
        health = 400;
        specialEffect = true;
        effects = Effects.BOOST;
    }

    @Override
    public Image getImage() {
        if (collided) {
            if (health >= 150) return visualMode.SnowZombieEatImage;
            else return visualMode.SnowZombieLostHeadEatImage;
        } else {
            if (health >= 150) return visualMode.SnowZombieImage;
            else return visualMode.SnowZombieLostHeadImage;
        }
    }
}
