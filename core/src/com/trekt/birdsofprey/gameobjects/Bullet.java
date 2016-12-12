package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class Bullet {

    private Vector2 position, velocity;
    private int width, height;
    private boolean isShot;
    private double rotateAngle;
    private Polygon boundingShape;


    public Bullet(int x, int y, int width, int height) {
        position = new Vector2(x , y);
        velocity = new Vector2(0, 0);
        this.width = width;
        this.height = height;
        isShot = false;
        boundingShape = new Polygon(new float[] {
            0, 0,
            0, height,
            width, height,
            width, 0
        });
        boundingShape.setPosition(position.x, position.y);
    }

    public void update(float delta){
        position.add(velocity.cpy().scl(delta));
        boundingShape.setPosition(position.x, position.y);
        boundingShape.setRotation(360 - (float) rotateAngle);
    }

    public Polygon getBoundingShape() {
        return boundingShape;
    }

    public void setBoundingShape(Polygon boundingShape) {
        this.boundingShape = boundingShape;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getPositionX(){
        return this.position.x;
    }

    public float getPositionY(){
        return this.position.y;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPositionX(float positionX){
        this.position.x = positionX;
    }

    public void setPositionY(float positionY){
        this.position.y = positionY;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setVelocityX(float velocityX){
        this.velocity.x = velocityX;
    }

    public void setVelocityY(float velocityY){
        this.velocity.y = velocityY;
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

    public boolean isShot() {
        return isShot;
    }

    public void setIsShot(boolean isShot) {
        this.isShot = isShot;
    }

    public double getRotateAngle() {
        return rotateAngle;
    }

    public void setRotateAngle(double rotateAngle) {
        this.rotateAngle = rotateAngle;
    }
}
