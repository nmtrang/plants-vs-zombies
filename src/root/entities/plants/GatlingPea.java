package root.entities.plants;
import java.awt.Image;

import root.entities.movable.Pea;

public class GatlingPea extends Repeater{
    public GatlingPea(int x, int y) {
        super(x, y);
        price = 250;
        health = 200;
    }

    @Override
    public Image getImage() {
        return visualMode.GatlingPeaImage;
    }

    @Override
    public void dealWithZom() {
        super.dealWithZom();
    }

    @Override
    public void shoot() {
        if (LoopCounter % 6 == 0) {
            Stuffs.add(new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y));
            Stuffs.add(new Pea(position.x + stuffShooter.x + 60, position.y + stuffShooter.y));
            Stuffs.add(new Pea(position.x + stuffShooter.x + 120, position.y + stuffShooter.y));
        }

//        Stuffs.add(new Pea(position.x + stuffShooter.x + 180, position.y + stuffShooter.y));
    }
}
