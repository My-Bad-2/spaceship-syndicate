package com.syndicate.starship.client.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.syndicate.starship.client.rendering.Renderer;
import com.syndicate.starship.shared.state.EnemyState;
import com.syndicate.starship.shared.state.GameState;
import com.syndicate.starship.shared.state.PlayerState;
import com.syndicate.starship.shared.state.ProjectileState;
import com.syndicate.starship.client.ClientGame;

public class GameScreen extends ScreenAdapter {
    private final Renderer renderer;

    private GameState gameState;

    public GameScreen(ClientGame clientGame) {
        this.renderer = new Renderer(clientGame.batch);

        createMockGameState();
    }

    private void createMockGameState() {
        this.gameState = new GameState();
        gameState.status = GameState.GameStatus.IN_PROGRESS;

        gameState.playerShip.posX = 200;
        gameState.playerShip.posY = 300;
        gameState.playerShip.rotationDegrees = 45f;

        EnemyState enemy = new EnemyState();
        enemy.id = 1;
        enemy.posX = 600;
        enemy.posY = 400;

        enemy.rotationDegrees = -90f;
        gameState.enemies.put(enemy.id, enemy);

        ProjectileState laser = new ProjectileState();
        laser.id = 1;
        laser.posX = 400;
        laser.posY = 350;
        laser.rotationDegrees = 0f;
        gameState.projectiles.add(laser);
    }

    private void updateMockGameState(float delta) {
        gameState.playerShip.rotationDegrees += 60 * delta;
        gameState.enemies.get(1).posX = 600 + (float) Math.cos(gameState.missionTimer) * 100f;
        gameState.enemies.get(1).posY = 400 + (float) Math.cos(gameState.missionTimer) * 100f;

        gameState.projectiles.get(0).posX += 200 * delta;

        gameState.missionTimer += delta;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        updateMockGameState(delta);

        renderer.render(gameState);
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
