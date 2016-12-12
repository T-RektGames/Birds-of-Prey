package com.trekt.birdsofprey.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class AssetLoader {

    public static Texture gameObjects, trekt;
    public static TextureRegion mainBird, bullet, enemyBullet, penguin;
    public static TextureRegion trekt1, trekt2, trekt3, trekt4, trekt5, trekt6, trekt7, trekt8, trekt9, trekt10,
            trekt11, trekt12, trekt13, trekt14, trekt15, trekt16;
    public static Animation trektanimation;
    public static Sound slash;
    public static int gameWidth = 256;
    public static int gameHeight = 144;

    public static void load(){

        gameObjects = new Texture(Gdx.files.internal("data/EE.texture1.5.png"));
        gameObjects.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trekt = new Texture(Gdx.files.internal("data/t-rekt logo v2-01.png"));
        trekt.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        trekt1 = new TextureRegion(trekt, 0, 0, 512, 256);
        trekt2 = new TextureRegion(trekt, 512, 0, 512, 256);
        trekt3 = new TextureRegion(trekt, 1024, 0, 512, 256);
        trekt4 = new TextureRegion(trekt, 1536, 0, 512, 256);
        trekt5 = new TextureRegion(trekt, 0, 256, 512, 256);
        trekt6 = new TextureRegion(trekt, 512, 256, 512, 256);
        trekt7 = new TextureRegion(trekt, 1024, 256, 512, 256);
        trekt8 = new TextureRegion(trekt, 1536, 256, 512, 256);
        trekt9 = new TextureRegion(trekt, 0, 512, 512, 256);
        trekt10 = new TextureRegion(trekt, 512, 512, 512, 256);
        trekt11 = new TextureRegion(trekt, 1024, 512, 512, 256);
        trekt12 = new TextureRegion(trekt, 1536, 512, 512, 256);
        trekt13 = new TextureRegion(trekt, 0, 768, 512, 256);
        trekt14 = new TextureRegion(trekt, 512, 768, 512, 256);
        trekt15 = new TextureRegion(trekt, 1024, 768, 512, 256);
        trekt16 = new TextureRegion(trekt, 1536, 768, 512, 256);
        TextureRegion[] trekts = { trekt1, trekt2, trekt3, trekt4, trekt5, trekt6, trekt7, trekt8, trekt9, trekt10,
                trekt11, trekt12, trekt13, trekt14, trekt15, trekt16 };
        trektanimation = new Animation(0.0125f, trekts);
        trektanimation.setPlayMode(Animation.PlayMode.NORMAL);

        mainBird = new TextureRegion(gameObjects, 0, 0, 11, 8);
        mainBird.flip(false, true);
        bullet = new TextureRegion(gameObjects, 0, 8, 1, 5);
        enemyBullet = new TextureRegion(gameObjects,5, 8, 1, 1);
        penguin = new TextureRegion(gameObjects, 16, 13, 16, 10);
        penguin.flip(false, true);

        slash = Gdx.audio.newSound(Gdx.files.internal("data/slash.mp3"));

    }

    public static void dispose(){
        gameObjects.dispose();


    }
}
