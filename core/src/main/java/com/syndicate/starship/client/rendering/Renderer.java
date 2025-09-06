package com.syndicate.starship.client.rendering;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Disposable;

import com.syndicate.starship.client.utils.Assets;
import com.syndicate.starship.shared.state.EnemyState;
import com.syndicate.starship.shared.state.GameState;
import com.syndicate.starship.shared.state.ProjectileState;

public class Renderer implements Disposable {
    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final Assets assets;

    public Renderer(SpriteBatch batch) {
        this.batch = batch;
        this.camera = new OrthographicCamera();
        this.assets =  new Assets();

        assets.load();
    }

    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    private void draw(TextureRegion region, float x, float y, float rotation) {
        if(region == null) {
            return;
        }

        float width = region.getRegionWidth();
        float height = region.getRegionHeight();

        // LibGDX draws from the bottom-left, so we offset by half the size to center the sprite.
        // The rotation is also around the origin (bottom-left), so we must specify the center.
        batch.draw(region, x - width / 2, y - height / 2, width / 2, height / 2, width, height, 1, 1, rotation);
    }

    public void render(GameState state) {
        if(state == null) {
            return;
        }

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        if(state.playerShip != null) {
            draw(assets.get("player_ship"), state.playerShip.posX, state.playerShip.posY, state.playerShip.rotationDegrees);
        }

        for(EnemyState enemy : state.enemies.values()) {
            draw(assets.get("enemy_ship"), enemy.posX, enemy.posY, enemy.rotationDegrees);
        }

        for(ProjectileState projectile : state.projectiles) {
            draw(assets.get("laser_bolt"), projectile.posX, projectile.posY, projectile.rotationDegrees);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        assets.dispose();
    }
}
