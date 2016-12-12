package com.trekt.birdsofprey.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.trekt.birdsofprey.GameClass;
import com.trekt.birdsofprey.gameworld.GameRenderer;
import com.trekt.birdsofprey.gameworld.GameWorld;
import com.trekt.birdsofprey.helpers.AssetLoader;
import com.trekt.birdsofprey.helpers.InputHandler;

import sun.rmi.runtime.Log;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class GameScreen implements Screen{

    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();
    float gameWidth = AssetLoader.gameWidth;
    float gameHeight = AssetLoader.gameHeight;
    private GameWorld gameWorld;
    private GameRenderer gameRenderer;


    public GameScreen(GameClass game){
        gameWorld = new GameWorld();
        gameRenderer = new GameRenderer(gameWorld);
        Gdx.input.setInputProcessor(new InputHandler(gameWorld, screenWidth / gameWidth, screenHeight / gameHeight));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        gameWorld.update(delta);
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
