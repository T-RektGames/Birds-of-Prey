package com.trekt.birdsofprey.helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.trekt.birdsofprey.gameobjects.BulletManager;
import com.trekt.birdsofprey.gameobjects.MainBird;
import com.trekt.birdsofprey.gameworld.GameWorld;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class InputHandler implements InputProcessor {

    private float scaleFactorX;
    private float scaleFactorY;
    private GameWorld gameWorld;
    private MainBird mainBird;
   // private Vector2 newPosition;
    private int gameWidth = AssetLoader.gameWidth;
    private int gameHeight = AssetLoader.gameHeight;
    private BulletManager bulletManager;
    private float runtime = 0;

    public InputHandler(GameWorld gameWorld, float scaleFactorX, float scaleFactorY) {

        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
        this.gameWorld = gameWorld;
        mainBird = gameWorld.getMainBird();
        //newPosition = new Vector2();
        bulletManager = gameWorld.getBulletManager();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        screenX = scaleX(screenX);
        screenY = scaleY(screenY);
        //Sprite a = new Sprite()

        if (mainBird.isTouchDown(screenX, screenY) && mainBird.getPointer() == 999999){
            mainBird.setIsTouched(true);
            mainBird.setPointer(pointer);

        }   else{
            if(bulletManager.getPointer() == 999999){
                bulletManager.setPointer(pointer);
                bulletManager.shoot(screenX, screenY);
            }
        }



        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        screenX = scaleX(screenX);
        screenY = scaleY(screenY);
        //System.out.println(screenX);

//        if (mainBird.isTouchDown(screenX, screenY)){
//
//            mainBird.setIsTouched(false);
//        }

        if (mainBird.getPointer() == pointer){
            mainBird.setPointer(999999);
        }

        if (bulletManager.getPointer() == pointer){
            bulletManager.setPointer(999999);
        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);



//        if (mainBird.isTouched()){
//            System.out.println("ISSSSSTOUCHEEEEEEEDDDDDD");
//            newPosition.set(screenX-mainBird.getWidth()/2, screenY-mainBird.getHeight()/2);
//            mainBird.setPosition(newPosition);
//        }

        if (mainBird.getPointer() == pointer){
            //newPosition.set(screenX-mainBird.getWidth()/2, screenY-mainBird.getHeight()/2);
            mainBird.setPositionX(screenX-mainBird.getWidth()/2);
            mainBird.setPositionY(screenY-mainBird.getHeight()/2);
        }

        if (bulletManager.getPointer() == pointer){
//            runtime+=1;
//            if (runtime == 60){
                bulletManager.shoot(screenX, screenY);
//                runtime =0;
//            }
        }


        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }
}
