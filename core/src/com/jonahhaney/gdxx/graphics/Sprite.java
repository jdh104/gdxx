package com.jonahhaney.gdxx.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.jonahhaney.gdxx.rendering.Renderable;
import com.jonahhaney.gdxx.updating.Updatable;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Sprite implements Renderable, Updatable {

    protected Animation animation;
    protected float width, height;
    protected SpriteBatch spriteBatch;
    protected TextureRegion frame;
    protected Vector2 position = new Vector2();

    /**
     * 
     * @param sb
     */
    public Sprite(SpriteBatch sb) {
        this.spriteBatch = sb;
    }

    /**
     * 
     * @return
     */
    public TextureRegion getFrame() {
        return this.frame;
    }

    /**
     * 
     * @return
     */
    public Vector2 getPosition() {
        return this.position;
    }

    /**
     * 
     * @return
     */
    public Vector2 getPositionTopLeft() {
        return new Vector2(this.position.x - this.width / 2, this.position.y - this.height / 2);
    }

    /**
     * 
     * @return
     */
    public float getWidth() {
        return this.width;
    }

    /**
     * 
     * @return
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * 
     * @param reg
     * @param delay
     */
    public void setAnimation(TextureRegion[] reg, float delay) {
        this.animation = new Animation(reg, delay);
        this.width = reg[0].getRegionWidth();
        this.height = reg[0].getRegionHeight();
    }

    @Override
    public void update(float dt) {
        this.frame = this.animation.getFrame();
    }

    @Override
    public void render(float dt) {
        this.spriteBatch.begin();
        this.spriteBatch.draw(this.frame, this.getPositionTopLeft().x, this.getPositionTopLeft().y);
        this.spriteBatch.end();
    }
}
