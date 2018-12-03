package com.jonahhaney.gdxx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jonahhaney.gdxx.disposing.Disposable;
import com.jonahhaney.gdxx.graphics.TextureManager;
import com.jonahhaney.gdxx.states.GameStateManager;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public abstract class LibGdxGame extends ApplicationAdapter implements Disposable, ApplicationListener {

    protected GameStateManager gameStateManager = new GameStateManager();
    protected Settings settings = new Settings();
    protected SpriteBatch spriteBatch;
    protected TextureManager textureManager = new TextureManager();

    protected float time_since_rendering = 0;

    /**
     * 
     */
    public LibGdxGame() {

    }
    
    /**
     * 
     * @param fps
     */
    public LibGdxGame(float fps) {
        this.settings.setFrameRate(fps);
    }
    
    /**
     * 
     * @param vHeight
     * @param vWidth
     * @param vScale
     */
    public LibGdxGame(float vHeight, float vWidth, float vScale) {
        this.settings.setVirtualDimensions(vHeight, vWidth, vScale);
    }
    
    /**
     * 
     * @param fps
     * @param vHeight
     * @param vWidth
     * @param vScale
     */
    public LibGdxGame(float fps, float vHeight, float vWidth, float vScale) {
        this.settings.setFrameRate(fps);
        this.settings.setVirtualDimensions(vHeight, vWidth, vScale);
    }

    @Override
    public void dispose() {
        this.gameStateManager.dispose();
        this.spriteBatch.dispose();
    }

    /**
     * 
     * @return
     */
    public synchronized SpriteBatch getSpriteBatch() {
        return this.spriteBatch == null ? this.spriteBatch = new SpriteBatch() : this.spriteBatch;
    }

    @Override
    public void render() {
        float dt = this.settings.getFrameStepTime();
        this.time_since_rendering += Gdx.graphics.getDeltaTime();
        while (this.time_since_rendering >= dt) {
            this.gameStateManager.update(dt);
            this.gameStateManager.render(dt);
            this.time_since_rendering -= dt;
        }
    }

    @Override
    public abstract void create();
}
