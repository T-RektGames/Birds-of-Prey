package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class MainBird {

    private Vector2 position;
    private int width, height;
    private int pointer = 999999;
    private boolean isTouched;
    //private Ellipse boundingCircle;
    protected Polygon boundingShape;
    private int bulletOriginX, bulletOriginY;
    private float health = 1000;
    private boolean dead = false;


    public MainBird(int x, int y, int width, int height) {

        position = new Vector2(x, y);
        this.width = width;
        this.height = height;
        isTouched = false;

        bulletOriginX = x + width / 2;
        bulletOriginY = y + height / 2;
        //this.boundingCircle = new Ellipse(position.x + width / 2, position.y + height / 2
     //           , width, height);
        boundingShape = new Polygon(new float[] {
                0, 0,
                0, height,
                width, height,
                width, 0
        });
        boundingShape.setPosition(position.x, position.y);
    }

    public void update(float delta) {

        if (health == 0){
            dead = true;
        }
        //boundingCircle.set(position.x + width / 2, position.y + height / 2
          //      , width, height);
        boundingShape.setPosition(position.x, position.y);
        bulletOriginX = (int) (position.x + width / 2);
        bulletOriginY = (int) (position.y + height / 2);

    }

    public boolean isTouchDown(int screenX, int screenY) {

        if (boundingShape.contains(screenX, screenY)) {

            return true;

        } else {

            return false;
        }


    }

    public Vector2 getPosition() {
        return position;
    }

    public float getPositionX() {
        return position.x;
    }

    public float getPositionY() {
        return position.y;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPositionX(float positionX) {
        this.position.x = positionX;
    }

    public void setPositionY(float positionY) {
        this.position.y = positionY;
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

    public boolean isTouched() {
        return isTouched;
    }

    public void setIsTouched(boolean isTouched) {
        this.isTouched = isTouched;
    }

    public Polygon getBoundingShape() {
        return boundingShape;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public int getBulletOriginX() {
        return bulletOriginX;
    }

    public int getBulletOriginY() {
        return bulletOriginY;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
