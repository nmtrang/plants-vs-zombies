package root.GameMode.Stage;

import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import root.GUI.GamePanel;
import root.GUI.IconButton;
import root.GameMode.Visuals.NoScalingMode;
import root.GameMode.Visuals.VisualMode;
import root.entities.GameEntity;
import root.entities.movable.MovableObjects;
import root.entities.plants.Lawnmower;
import root.entities.plants.Plant;
import root.entities.zombies.Zombie;
import root.etc.CellsManager;

public abstract class Stage {

    public static LinkedList<Class<? extends Stage>> stage = new LinkedList<>(List.of(StageDay.class, StageNight.class));
    public VisualMode visualMode = new NoScalingMode();
    public ArrayList<MovableObjects> movableObjects = new ArrayList<>();
    public ArrayList<Zombie> zombies = new ArrayList<>();
    public ArrayList<Class<? extends Plant>> plantClasses = new ArrayList<>();
    public ArrayList<Class<? extends Zombie>> zombieClasses = new ArrayList<>();
    public ArrayList<IconButton> cards = new ArrayList<>(5);
    public ArrayList<Lawnmower> lawnmowers = new ArrayList<>(5);
    public Map<Point, Integer> zombieKilledPosition = new ConcurrentHashMap<>();
    public int MAX_ZOMBIES;
    public int zombieCount, zombieKilled;

    public Stage() {

    }

    public Stage(GamePanel gamePanel) {
        CellsManager.init(gamePanel.visualMode);
        GameEntity.setGamePanel(gamePanel);
        GameEntity.setVisualMode();
        zombieCount = 0;
        zombieKilled = 0;
    }

    public static Stage getStage(int stageNumber, GamePanel gamePanel) {
        if (stageNumber < stage.size()) {
            try {
                return stage.get(stageNumber).getConstructor(GamePanel.class).newInstance(gamePanel);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static VisualMode getVisualMode(int levelNumber) {
        if (levelNumber < stage.size()) {
            try {
                return stage.get(levelNumber).getConstructor().newInstance().visualMode;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public boolean end() {
        return zombieCount >= MAX_ZOMBIES;
    }

    public void addZombie(VisualMode visualMode) {
        try {
            int index = (new Random()).nextInt(zombieClasses.size());
            zombies.add(zombieClasses.get(index).getConstructor(int.class, int.class)
                    .newInstance(visualMode.GameDim.width + 10, CellsManager.lanes[new Random().nextInt(CellsManager.lanes.length)]));
            zombieCount++;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
