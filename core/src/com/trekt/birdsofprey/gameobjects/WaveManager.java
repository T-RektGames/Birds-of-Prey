package com.trekt.birdsofprey.gameobjects;

import com.trekt.birdsofprey.gameworld.GameWorld;

import java.util.ArrayList;

/**
 * Created by AadityaPatwari on 17/12/15.
 */
public class WaveManager {
    private PenguinManager penguinManager;
    private GameWorld gameWorld;
    private ArrayList<Penguin>currentPenguins,  wave0, wave1, wave2, wave3, wave4, wave5;
    private SplinePenguin[] goodSplinePenguins, badSplinePenguins;
    private PathManager pathManager;

    public WaveManager(GameWorld gameWorld){
        this.gameWorld = gameWorld;
        penguinManager = gameWorld.getPenguinManager();
        this.goodSplinePenguins = penguinManager.getGoodSplinePenguins();
        this.badSplinePenguins = penguinManager.getBadSplinePenguins();
        pathManager = penguinManager.getPathManager();


        wave0 = new ArrayList<>();
        wave1 = new ArrayList<>();
        wave2 = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            wave0.add(goodSplinePenguins[i]);
            wave0.add(badSplinePenguins[i]);
        }
        for (int i = 5; i < 15; i++) {
            goodSplinePenguins[i].setSpline(pathManager.getGoodSpline1());
            goodSplinePenguins[i].setCurrent((i - 5) * -0.05f - 0.1f);
            wave1.add(goodSplinePenguins[i]);
            badSplinePenguins[i].setSpline(pathManager.getBadSpline1());
            badSplinePenguins[i].setCurrent ((i-5)*-0.05f - 0.1f);
            wave1.add(badSplinePenguins[i]);

        }

        for (int i = 15; i < 25; i++) {
            goodSplinePenguins[i].setSpline(pathManager.getGoodSpline2());
            goodSplinePenguins[i].setCurrent((i - 15) * -0.05f - 0.1f);
            wave2.add(goodSplinePenguins[i]);
            badSplinePenguins[i].setSpline(pathManager.getBadSpline2());
            badSplinePenguins[i].setCurrent ((i-15)*-0.05f - 0.1f);
            wave2.add(badSplinePenguins[i]);

        }
        penguinManager.setCurrentPenguins(wave0);


    }

    public void update(float delta){
        currentPenguins = penguinManager.getCurrentPenguins();
        for (int i = currentPenguins.size()-1; i>=0; i--){
            SplinePenguin splinePenguin = (SplinePenguin)currentPenguins.get(i);
            if (splinePenguin.getCurrent() == 0.90f || splinePenguin.isDead()){
                currentPenguins.remove(splinePenguin);
            }
            if (currentPenguins.size() == 0 ){

                if (currentPenguins == wave0) {
                    penguinManager.setCurrentPenguins(wave1);
                }

                if (currentPenguins == wave1){
                    penguinManager.setCurrentPenguins(wave2);
                }

                if (currentPenguins == wave2){

                }


            }


        }



    }




}
