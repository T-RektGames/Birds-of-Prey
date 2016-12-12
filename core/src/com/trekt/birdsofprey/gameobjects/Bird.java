package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class Bird {
    private Vector2 position, velocity;
    private int width, height;


    public Bird(int x, int y, int width, int height) {

        position = new Vector2(x, y);
        velocity = new Vector2();
        this.width = width;
        this.height = height;

    }

    public void update(float delta){

    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
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


}
