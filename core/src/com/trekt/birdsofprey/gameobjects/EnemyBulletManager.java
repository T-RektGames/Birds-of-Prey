package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Intersector;
import com.trekt.birdsofprey.gameworld.GameWorld;
import com.trekt.birdsofprey.helpers.AssetLoader;

import java.util.ArrayList;

/**
 * Created by AadityaPatwari on 17/12/15.
 */
public class EnemyBulletManager {

    private EnemyBullet[] enemyBullets;
    private ArrayList<EnemyBullet> availibleEnemyBullets, shotEnemyBullets;
    private int PROJECTILE_WIDTH = 2;
    private int PROJECTILE_HEIGHT = 10;
    private int BULLET_SPEED = 50;
    private MainBird mainBird;
    private int gameHeight = AssetLoader.gameHeight;
    private int gameWidth = AssetLoader.gameWidth;
    private boolean canShoot = true;
    private float runTime = 0;
    private ArrayList<Penguin> currentPenguins;
    private GameWorld gameWorld;

    public EnemyBulletManager(GameWorld gameWorld){
        this.gameWorld = gameWorld;
        availibleEnemyBullets = new ArrayList<>();
        shotEnemyBullets = new ArrayList<>();

        mainBird = gameWorld.getMainBird();



    }

    public void update(float delta) {
//        runTime += delta;
//        if (runTime > 0.5){
//            runTime = 0;
//            canShoot = true;
//            for (int i =0; i<currentPenguins.size(); i++){
//                shoot(currentPenguins.get(i));
//            }
//        }
/*
        for (int i = 0; i<currentPenguins.size(); i++){
            if (canShoot = true){
                shoot(currentPenguins.get(i));
            }

            if (i == currentPenguins.size()-1){
                canShoot = false;
            }
        }
        */
        currentPenguins = gameWorld.getPenguinManager().getCurrentPenguins();

        for (int i = 0; i < currentPenguins.size(); i++){
            if (currentPenguins.get(i).isCanShoot()){
                shoot(currentPenguins.get(i));
                currentPenguins.get(i).setCanShoot(false);
            }
        }

        for (int i = shotEnemyBullets.size() - 1; i >= 0; i--) {
            EnemyBullet shotBullet = shotEnemyBullets.get(i);
            shotBullet.update(delta);
            //for (int j = currentPenguins.size() - 1; j >= 0; j--) {
                //Penguin penguin = currentPenguins.get(j);
                if (mainBird.isDead()) {
                    continue;
                }
                if (Intersector.overlapConvexPolygons(shotBullet.getBoundingShape(), mainBird.getBoundingShape())) {
                    availibleEnemyBullets.add(shotBullet);
                    shotEnemyBullets.remove(i);
                    mainBird.setHealth(mainBird.getHealth() - 1);
                    break;
                }
            //}
            if (shotBullet.getPositionY() + shotBullet.getHeight() < 0
                    || shotBullet.getPositionY()  > gameHeight
                    || shotBullet.getPositionX() + shotBullet.getWidth() < 0
                    || shotBullet.getPositionX() > gameWidth) {

                availibleEnemyBullets.add(shotBullet);
                shotEnemyBullets.remove(i);
            }
        }

    }

    public void shoot(Penguin penguin) {
        //currTime =  System.currentTimeMillis();
        // System.out.println(String.valueOf(currTime - oldTime) +"youaregay "+ String.valueOf(currTime));

        //if (oldTime != 0 && currTime - oldTime > 0.5) {
        if(!penguin.isDead()) {
            if (availibleEnemyBullets.size() >= 1) {

                shotEnemyBullets.add(availibleEnemyBullets.get(0));
                availibleEnemyBullets.remove(0);
                EnemyBullet shotBullet = shotEnemyBullets.get(shotEnemyBullets.size()-1);
                shotBullet.setPositionX(penguin.getBulletOriginX());
                shotBullet.setPositionY(penguin.getBulletOriginY());
                double distance = Math.sqrt(
                        ((mainBird.getBulletOriginX() - penguin.getBulletOriginX()) * (mainBird.getBulletOriginX() - penguin.getBulletOriginX())) + ((mainBird.getBulletOriginY() - penguin.getBulletOriginY()) * (mainBird.getBulletOriginY() - penguin.getBulletOriginY())));
                double time = distance / BULLET_SPEED;
                float velocityX = (float) ((mainBird.getBulletOriginX() - penguin.getBulletOriginX()) / time);
                float velocityY = (float) ((mainBird.getBulletOriginY() - penguin.getBulletOriginY()) / time);
                shotBullet.setVelocityX(velocityX);
                shotBullet.setVelocityY(velocityY);
                double rotationAngle = 90 - Math.toDegrees(Math.atan2(mainBird.getBulletOriginY() -penguin.getBulletOriginY(), mainBird.getBulletOriginX() - penguin.getBulletOriginX()));
                shotBullet.setRotateAngle(rotationAngle);
                canShoot = false;
                runTime = 0;
            }
        }


    }

    public ArrayList<EnemyBullet> getShotEnemyBullets(){
        return this.shotEnemyBullets;
    }

}
