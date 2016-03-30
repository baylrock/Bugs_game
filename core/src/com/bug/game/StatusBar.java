package com.bug.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lego on 30.05.2015.
 */
public class StatusBar extends Actor {

    Texture CellTexture = new Texture(Gdx.files.internal("Numbers.png"));
    int TextureElementWidth = CellTexture.getWidth()/10;
    int TextureElementHeight = CellTexture.getHeight();

    private Sprite BackGround = new Sprite(new Texture("StatusBar_BG.png"));
    private Sprite SpeedIcon = new Sprite(new Texture("Srpeed.png"));
    private Sprite HealthIcon = new Sprite(new Texture("Health.png"));
    private Sprite PowerIcon = new Sprite(new Texture("Attack.png"));
    private int StartX;
    private int StartY;
    private int Width;
    private int Height;
    private float IconSize;
    private float StartIconsPositionY;
    private float StartIconsPositionX;
    Bug bug;
    ArrayList<Sprite> LableHelth = new ArrayList<Sprite>();
    ArrayList<Sprite> LableSpeed = new ArrayList<Sprite>();
    ArrayList<Sprite> LablePower = new ArrayList<Sprite>();


    public void BuildStatusBar(int StartX, int StartY, int Width, int Height) {
        this.StartX = StartX;
        this.StartY = StartY;
        this.Width = Width;
        this.Height = Height;
        this.IconSize = Height/8;
        this.StartIconsPositionY = Height-IconSize*4;
        this.StartIconsPositionX = this.StartX+(Width/5);

        setBackGround();



            setHelth();
            setSpeed();
            setPower();
        }





    private void setBackGround () {
        BackGround.setPosition(StartX+10,StartY);
        BackGround.setSize(Width, Height);
    }

    private void setHelth () {
        HealthIcon.setPosition(StartIconsPositionX, StartIconsPositionY);
        HealthIcon.setSize(IconSize, IconSize);
    }

    private void setSpeed () {
        SpeedIcon.setPosition(HealthIcon.getX(), HealthIcon.getY() - IconSize - (IconSize / 2));
        SpeedIcon.setSize(IconSize, IconSize);
    }

    private void setPower () {
        PowerIcon.setPosition(SpeedIcon.getX(),SpeedIcon.getY()-IconSize-(IconSize/2));
        PowerIcon.setSize(IconSize, IconSize);
    }

    public void setBug (Bug bug) {
        this.bug = bug;
    }

    private ArrayList<Sprite> getLabel (String String, int X, int Y) {
        ArrayList<Sprite> LabelSprites = new ArrayList<Sprite>();
        for (int i = 0; i<String.length(); i++) {
            LabelSprites.add(new BTextSymbol(String.charAt(i)).getSprite());
            LabelSprites.get(i).setPosition(X+(IconSize*i),Y);
            LabelSprites.get(i).setSize(IconSize,IconSize);

        }
        return LabelSprites;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        BackGround.draw(batch, parentAlpha);
        if (bug != null) {

            HealthIcon.draw(batch, parentAlpha);
            for (Sprite Sprite : getLabel(String.valueOf(bug.getDurability()),(int)(HealthIcon.getX()+IconSize),(int)HealthIcon.getY())) {
                Sprite.draw(batch, parentAlpha);
            }

            SpeedIcon.draw(batch, parentAlpha);
            for (Sprite Sprite : getLabel(String.valueOf(bug.CruisingRange),(int)(SpeedIcon.getX()+IconSize),(int)SpeedIcon.getY())) {
                Sprite.draw(batch, parentAlpha);
            }

            PowerIcon.draw(batch, parentAlpha);
            for (Sprite Sprite : getLabel(String.valueOf(bug.getPower()),(int)(PowerIcon.getX()+IconSize),(int)PowerIcon.getY())) {
                Sprite.draw(batch, parentAlpha);
            }
        }

    }
}
