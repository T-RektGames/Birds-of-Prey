package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.trekt.birdsofprey.gameworld.GameWorld;
import com.trekt.birdsofprey.helpers.AssetLoader;

import java.util.ArrayList;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class BulletManager {


    private ArrayList<Bullet> availibleBullets, shotBullets;
    private Bullet bullet0, bullet1, bullet2, bullet3, bullet4, bullet5, bullet6, bullet7, bullet8, bullet9;
    private int PROJECTILE_WIDTH = 2;
    private int PROJECTILE_HEIGHT = 10;
    private int BULLET_SPEED = 50;
    private GameWorld gameWorld;
    private MainBird mainBird;
    private int pointer = 999999;
    private int gameHeight = AssetLoader.gameHeight;
    private int gameWidth = AssetLoader.gameWidth;
    private boolean canShoot = true;
    private float runTime = 0;
    private ArrayList<Penguin> currentPenguins;
   // private float oldTime = 0;
   // private float currTime;
    //private boolean canShoot = true;

    //private Vector2 newVelocity, newPosition;

    public BulletManager(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        bullet0 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet1 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet2 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet3 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet4 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet5 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet6 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet7 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet8 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        bullet9 = new Bullet(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT);
        shotBullets = new ArrayList<>();
        availibleBullets = new ArrayList();
        availibleBullets.add(bullet0);
        availibleBullets.add(bullet1);
        availibleBullets.add(bullet2);
        availibleBullets.add(bullet3);
        availibleBullets.add(bullet4);
        availibleBullets.add(bullet5);
        availibleBullets.add(bullet6);
        availibleBullets.add(bullet7);
        availibleBullets.add(bullet8);
        availibleBullets.add(bullet9);
        mainBird = gameWorld.getMainBird();


    }

    public void update(float delta) {
        currentPenguins = gameWorld.getPenguinManager().getCurrentPenguins();

        runTime += delta;
        if (runTime > 0.5){
            runTime = 0;
            canShoot = true;
        }

        for (int i = shotBullets.size() - 1; i >= 0; i--) {
            Bullet shotBullet = shotBullets.get(i);
            shotBullet.update(delta);
            for (int j = currentPenguins.size() - 1; j >= 0; j--) {
                Penguin penguin = currentPenguins.get(j);
                if (penguin.isDead()) {
                    continue;
                }
                if (Intersector.overlapConvexPolygons(shotBullet.getBoundingShape(), penguin.getBoundingShape())) {
                    availibleBullets.add(shotBullet);
                    shotBullets.remove(i);
                    penguin.setHealth(penguin.getHealth() - 1);
                    break;
                }
            }
            if (shotBullet.getPositionY() + shotBullet.getHeight() < 0
                    || shotBullet.getPositionY()  > gameHeight
                    || shotBullet.getPositionX() + shotBullet.getWidth() < 0
                    || shotBullet.getPositionX() > gameWidth) {

                availibleBullets.add(shotBullet);
                shotBullets.remove(i);
            }
        }

    }

    public void shoot(int screenX, int screenY) {
        //currTime =  System.currentTimeMillis();
       // System.out.println(String.valueOf(currTime - oldTime) +"youaregay "+ String.valueOf(currTime));

        //if (oldTime != 0 && currTime - oldTime > 0.5) {
        if(canShoot) {
            if (availibleBullets.size() >= 1) {

                shotBullets.add(availibleBullets.get(0));
                availibleBullets.remove(0);
                Bullet shotBullet = shotBullets.get(shotBullets.size()-1);
                shotBullet.setPositionX(mainBird.getBulletOriginX());
                shotBullet.setPositionY(mainBird.getBulletOriginY());
                double distance = Math.sqrt(
                        ((screenX - mainBird.getBulletOriginX()) * (screenX - mainBird.getBulletOriginX())) + ((screenY - mainBird.getBulletOriginY()) * (screenY - mainBird.getBulletOriginY())));
                double time = distance / BULLET_SPEED;
                float velocityX = (float) ((screenX - mainBird.getBulletOriginX()) / time);
                float velocityY = (float) ((screenY - mainBird.getBulletOriginY()) / time);
                shotBullet.setVelocityX(velocityX);
                shotBullet.setVelocityY(velocityY);
                double rotationAngle = 90 - Math.toDegrees(Math.atan2(screenY - mainBird.getBulletOriginY(), screenX - mainBird.getBulletOriginX()));
                shotBullet.setRotateAngle(rotationAngle);
                canShoot = false;
                runTime = 0;
            }
        }


    }

    private void checkCollisionsWithPenguin(Bullet bullet) {

    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public ArrayList<Bullet> getShotBullets() {
        return this.shotBullets;
    }


}
