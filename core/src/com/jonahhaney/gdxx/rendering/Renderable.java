package com.jonahhaney.gdxx.rendering;

/**
 * 
 * TODO Document
 * 
 * @author Jonah Haney
 */
public interface Renderable {

    /**
     * Render the object. This should be called once per frame.
     * 
     * @param dt Delta-Time passed down from the render engine.
     * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
     *      Gdx.graphics.getDeltaTime()}
     */
    public void render(float dt);
}
