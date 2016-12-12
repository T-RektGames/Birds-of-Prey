package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.trekt.birdsofprey.helpers.AssetLoader;

import java.util.Random;

/**
 * Created by AadityaPatwari on 17/12/15.
 */
public class Penguin {
   protected Vector2 position, velocity;
   protected int width, height;
   protected Polygon boundingShape;
   protected int gameWidth = AssetLoader.gameWidth;
   protected int gameHeight = AssetLoader.gameHeight;
    protected boolean dead = false;
    protected int health;
    protected int bulletOriginX, bulletOriginY;
    protected boolean canShoot = false;
    protected float runTime = 0;
    protected boolean good;

    public Penguin(int x, int y, int width, int height, boolean good) {

        position = new Vector2(x, y);
        velocity = new Vector2();
        this.width = width;
        this.height = height;
        this.good = good;
        boundingShape = new Polygon(new float[] {
                0, 0,
                0, height,
                width, height,
                width, 0
        });
        boundingShape.setPosition(position.x, position.y);

        bulletOriginX = x + width / 2;
        bulletOriginY = y + height / 2;

    }

    public void update(float delta) {


        if (health == 0) {
            dead = true;
        }


        position.add(velocity.cpy().scl(delta));
        boundingShape.setPosition(position.x, position.y);
        bulletOriginX = (int) (position.x +width/2);
        bulletOriginY = (int) (position.y + height/2);
    }

    public Polygon getBoundingShape() {
        return boundingShape;
    }

    public void setBoundingShape(Polygon boundingShape) {
        this.boundingShape = boundingShape;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public float getPositionX() {
        return position.x;
    }

    public float getPositionY() {
        return position.y;
    }

    public void setPositionX(float positionX) {
        this.position.x = positionX;
    }

    public void setPositionY(float positionY) {
        this.position.y = positionY;
    }

    public float getVelocityX() {
        return velocity.x;
    }

    public float getVelocityY() {
        return velocity.y;
    }

    public void setVelocityX(float velocityX) {
        this.velocity.x = velocityX;
    }

    public void setVelocityY(float velocityY) {
        this.velocity.y = velocityY;
    }


    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBulletOriginX() {
        return bulletOriginX;
    }

    public void setBulletOriginX(int bulletOriginX) {
        this.bulletOriginX = bulletOriginX;
    }

    public int getBulletOriginY() {
        return bulletOriginY;
    }

    public void setBulletOriginY(int bulletOriginY) {
        this.bulletOriginY = bulletOriginY;
    }

    public boolean isCanShoot() {
        return canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }
}
