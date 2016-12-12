package com.trekt.birdsofprey.gameobjects;

import com.trekt.birdsofprey.gameworld.GameWorld;
import com.trekt.birdsofprey.helpers.AssetLoader;

import java.util.ArrayList;

/**
 * Created by AadityaPatwari on 15/12/15.
 */
public class PenguinManager {
    private int gameWidth = AssetLoader.gameWidth;
    private int gameHeight = AssetLoader.gameHeight;
    //private ArrayList<Penguin> currentPenguins, wave0, wave1, wave2, wave3, wave4, wave5;
    private ArrayList<Penguin> currentPenguins;
    private SplinePenguin[] goodSplinePenguins, badSplinePenguins;
    private GameWorld gameWorld;
    private PathManager pathManager;
   // private WaveManager waveManager;

    public PenguinManager(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        pathManager = new PathManager();
       // waveManager = gameWorld.getWaveManager();
        currentPenguins = new ArrayList<>();
//        currentPenguins = new ArrayList<>();
//        wave0 = new ArrayList<>();
//        wave1 = new ArrayList<>();
//        wave2 = new ArrayList<>();
       goodSplinePenguins = new SplinePenguin[50];
        for (int i = 0; i < goodSplinePenguins.length; i++) {
            goodSplinePenguins[i] = new SplinePenguin(-100, -100 , 16, 10, true,( -i*0.05)-0.1, pathManager.getGoodSpline0());
        }

        badSplinePenguins = new SplinePenguin[50];
        for (int i = 0; i < badSplinePenguins.length; i++) {
            badSplinePenguins[i] = new SplinePenguin(-100, -100, 16, 10, false,( -i * 0.05 )-0.1, pathManager.getBadSpline0());
        }


//       for (int i = 0; i < 3; i++) {
  //          wave0.add(splinePenguins[i]);
//        }
//        for (int i = 3; i < 8; i++) {
//            splinePenguins[i].setSpline(pathManager.getSpline1());
//            splinePenguins[i].setCurrent((float) ((i-2)*0.1));
//            wave1.add(splinePenguins[i]);
//        }
//        currentPenguins = wave0;


    }

    public void update(float delta) {
        for (int i = currentPenguins.size() - 1; i >= 0; i--) {
            Penguin penguin = currentPenguins.get(i);
            if (!penguin.isDead()) {
                penguin.update(delta);

            }
        }

       // System.out.println("Currentpenguinsize " + String.valueOf(currentPenguins.size()));




    }


    public SplinePenguin[] getGoodSplinePenguins() {
        return goodSplinePenguins;
    }

    public SplinePenguin[] getBadSplinePenguins() {
        return badSplinePenguins;
    }

    public PathManager getPathManager() {
        return pathManager;
    }

    public ArrayList<Penguin> getCurrentPenguins() {
        return currentPenguins;
    }

    public void setCurrentPenguins(ArrayList<Penguin> currentPenguins) {
        this.currentPenguins = currentPenguins;
    }
}
