package com.trekt.birdsofprey.gameworld;

import com.trekt.birdsofprey.gameobjects.BulletManager;
import com.trekt.birdsofprey.gameobjects.EnemyBulletManager;
import com.trekt.birdsofprey.gameobjects.MainBird;
import com.trekt.birdsofprey.gameobjects.PenguinManager;
import com.trekt.birdsofprey.gameobjects.WaveManager;
import com.trekt.birdsofprey.helpers.AssetLoader;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class GameWorld {

    private MainBird mainBird;
    private int gameWidth = AssetLoader.gameWidth;
    private int gameHeight = AssetLoader.gameHeight;
    private BulletManager bulletManager;
    private PenguinManager penguinManager;
    private EnemyBulletManager enemyBulletManager;
    private WaveManager waveManager;

    public GameWorld(){
        mainBird = new MainBird(gameWidth/2-11, gameHeight/2-8, 22, 16 );
        penguinManager = new PenguinManager(this);
        waveManager = new WaveManager(this);
        bulletManager = new BulletManager(this);
        enemyBulletManager = new EnemyBulletManager(this);

    }

    public void update(float delta){
        mainBird.update(delta);
        penguinManager.update(delta);
        waveManager.update(delta);
        bulletManager.update(delta);
        enemyBulletManager.update(delta);



    }

    public MainBird getMainBird() {
        return mainBird;
    }

    public BulletManager getBulletManager(){
        return this.bulletManager;
    }

    public EnemyBulletManager getEnemyBulletManager(){
        return this.enemyBulletManager;
    }

    public PenguinManager getPenguinManager(){
        return this.penguinManager;
    }

    public WaveManager getWaveManager() {
        return waveManager;
    }
}
