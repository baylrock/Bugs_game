package com.bug.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

/**
 * Created by Lego on 30.05.2015.
 */
public class BTextSymbol extends Actor {
    Sprite Number;


    BTextSymbol (int Number) {

        Texture  NumberTexture = new Texture(Gdx.files.internal("Numbers.png"));
        int TextureElementWidth = NumberTexture.getWidth()/10;
        int TextureElementHeight = NumberTexture.getHeight();
        int TextureElementX = TextureElementWidth * Number;
        int TextureElementY = 0;
        this.Number = new Sprite(
                new TextureRegion(NumberTexture,
                TextureElementX,
                TextureElementY,
                TextureElementWidth,
                TextureElementHeight));
     //   this.Number = new Sprite (new Texture("Health.png"));
        this.Number.setColor(Color.YELLOW);

    }

    public Sprite getSprite() {
        return this.Number;
    }

}
