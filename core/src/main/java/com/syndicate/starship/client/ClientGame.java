package com.syndicate.starship.client;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.syndicate.starship.client.screens.GameScreen;

public class ClientGame extends Game {
    public SpriteBatch batch;
    public BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        Gdx.app.log("Starship Syndicate", "Application created. Setting GameScreen.");
        this.setScreen((Screen) new GameScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        Gdx.app.log("ClientGame", "Application shutting down. Disposing resources.");

        batch.dispose();
        font.dispose();

        if(screen != null) {
            screen.dispose();
        }
    }
}
