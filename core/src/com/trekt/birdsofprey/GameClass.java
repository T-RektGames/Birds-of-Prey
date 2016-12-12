package com.trekt.birdsofprey;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.trekt.birdsofprey.helpers.AssetLoader;
import com.trekt.birdsofprey.screens.GameScreen;
import com.trekt.birdsofprey.screens.SplashScreen;

public class GameClass extends Game {

	
	@Override
	public void create () {
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
