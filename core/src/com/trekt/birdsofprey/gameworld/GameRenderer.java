package com.trekt.birdsofprey.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.trekt.birdsofprey.gameobjects.Bullet;
import com.trekt.birdsofprey.gameobjects.EnemyBullet;
import com.trekt.birdsofprey.gameobjects.MainBird;
import com.trekt.birdsofprey.gameobjects.Penguin;
import com.trekt.birdsofprey.gameobjects.RandomPenguin;
import com.trekt.birdsofprey.helpers.AssetLoader;

import java.util.ArrayList;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class GameRenderer {

    private int gameWidth = AssetLoader.gameWidth;
    private int gameHeight = AssetLoader.gameHeight;
    private SpriteBatch batcher;
    private GameWorld gameWorld;
    private OrthographicCamera cam;
    private MainBird mainBird;
    private ShapeRenderer shapeRenderer;
    private ArrayList<Bullet> shotBullets;
    private ArrayList<EnemyBullet> shotEnemyBullets;
    private ArrayList<Penguin> currentPenguins;

    public GameRenderer(GameWorld gameWorld) {

        this.gameWorld = gameWorld;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, gameWidth, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        mainBird = gameWorld.getMainBird();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        shotBullets = gameWorld.getBulletManager().getShotBullets();
        shotEnemyBullets = gameWorld.getEnemyBulletManager().getShotEnemyBullets();



    }

    private void drawMainBird() {
        if (!mainBird.isDead()) {
            batcher.draw(AssetLoader.mainBird, mainBird.getPositionX(), mainBird.getPositionY(), mainBird.getWidth(), mainBird.getHeight());

        }
    }

    private void drawBoundingShapes() {
        //shapeRenderer.ellipse(mainBird.getBoundingCircle().x - mainBird.getBoundingCircle().width / 2, mainBird.getBoundingCircle().y - mainBird.getBoundingCircle().height / 2, mainBird.getBoundingCircle().width,
          //      mainBird.getBoundingCircle().height);
        shapeRenderer.polygon(mainBird.getBoundingShape().getTransformedVertices());
        for (int i = 0; i < shotBullets.size(); i++) {
            shapeRenderer.polygon(shotBullets.get(i).getBoundingShape().getTransformedVertices());
        }
        for (int i = 0; i < currentPenguins.size(); i++) {
            Penguin penguin = currentPenguins.get(i);
            if (!penguin.isDead()) {
                shapeRenderer.polygon(penguin.getBoundingShape().getTransformedVertices());
            }
        }
        //shapeRenderer.rect();
    }

    private void drawBullets() {
        //shotBullets = gameWorld.getBulletManager().getShotBullets();
        for (int i = 0; i < shotBullets.size(); i++) {
            Bullet shotBullet = shotBullets.get(i);

            // AssetLoader.bullet.r
            batcher.draw(AssetLoader.bullet, shotBullet.getPositionX(), shotBullet.getPositionY(), 0, 0, shotBullet.getWidth(), shotBullet.getHeight(), 1, 1, (float) (360 - shotBullet.getRotateAngle()));
        }
    }

    private void drawEnemyBullets() {
        //shotBullets = gameWorld.getBulletManager().getShotBullets();
        for (int i = 0; i < shotEnemyBullets.size(); i++) {
            Bullet shotBullet = shotEnemyBullets.get(i);

            // AssetLoader.bullet.r
            batcher.draw(AssetLoader.enemyBullet, shotBullet.getPositionX(), shotBullet.getPositionY(), 0, 0, shotBullet.getWidth(), shotBullet.getHeight(), 1, 1, (float) (360 - shotBullet.getRotateAngle()));
        }
    }

    private void drawcurrentPenguins() {
        currentPenguins = gameWorld.getPenguinManager().getCurrentPenguins();
        for (int i = 0; i < currentPenguins.size(); i++) {
            Penguin penguin = currentPenguins.get(i);
            if (!penguin.isDead()) {
                batcher.draw(AssetLoader.penguin, penguin.getPositionX(), penguin.getPositionY(), penguin.getWidth(), penguin.getHeight());
                // batcher.draw(AssetLoader.bullet, currentPenguins.get(i).getBoundingShape().getX(), currentPenguins.get(i).getBoundingShape().getY(), currentPenguins.get(i).getWidth(), currentPenguins.get(i).getHeight());
            }
        }
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();
        drawMainBird();
        drawBullets();
        drawEnemyBullets();
        drawcurrentPenguins();
        batcher.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        drawBoundingShapes();
        shapeRenderer.end();
    }
}
