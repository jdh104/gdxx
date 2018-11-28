package com.jonahhaney.gdxx.graphics;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jonahhaney.gdxx.updating.Updatable;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Animation implements Updatable {

    private TextureRegion[] frames;
    private float time = 0f, delay;
    private int currentFrame = 0, timesPlayed = 0;

    /**
     * 
     * @param frames
     * @param delay
     */
    public Animation(TextureRegion[] frames, float delay) {
        this.frames = frames;
        this.delay = delay;
    }

    /**
     * 
     * @return
     */
    public TextureRegion getFrame() {
        return this.frames[currentFrame];
    }

    /**
     * 
     * @return
     */
    public int getTimesPlayed() {
        return this.timesPlayed;
    }

    /**
     * 
     */
    private void step() {
        this.time -= delay;
        this.currentFrame++;
        if (this.currentFrame == this.frames.length) {
            this.currentFrame = 0;
            this.timesPlayed++;
        }
    }

    @Override
    public void update(float dt) {
        if (this.delay > 0) {
            this.time += dt;
            while (this.time >= this.delay) {
                this.step();
            }
        }
    }
}
