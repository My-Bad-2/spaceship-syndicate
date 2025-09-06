package com.syndicate.starship.client.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.graphics.Pixmap;

import java.util.HashMap;
import java.util.Map;

public class Assets implements Disposable {
    private final Map<String, TextureRegion> textureMap = new HashMap<>();

    private enum Shape {
        TRIANGLE,
        CIRCLE,
        RECTANGLE,
    }

    private void createPlaceholder(String name, int width, int height, Color color, Shape shape) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);

        switch(shape) {
            case CIRCLE:
                pixmap.fillCircle(width / 2, height / 2, width / 2 - 1);
                break;
            case TRIANGLE:
                pixmap.fillTriangle(0, 0, width, 0, width / 2, height);
                break;
            case RECTANGLE:
                pixmap.fillRectangle(0, 0, width, height);
                break;
        }

        Texture texture = new Texture(pixmap);
        textureMap.put(name, new TextureRegion(texture));

        pixmap.dispose();
    }

    public TextureRegion get(String name) {
        return textureMap.get(name);
    }

    public void load() {
        createPlaceholder("player_ship", 32, 32, Color.GREEN, Shape.TRIANGLE);
        createPlaceholder("enemy_ship", 32, 32, Color.RED, Shape.RECTANGLE);
        createPlaceholder("laser_bolt", 8, 8, Color.YELLOW, Shape.CIRCLE);
    }

    @Override
    public void dispose() {
        for (TextureRegion region : textureMap.values()) {
            region.getTexture().dispose();
        }
    }
}
