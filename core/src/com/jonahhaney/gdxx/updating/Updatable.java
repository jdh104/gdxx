package com.jonahhaney.gdxx.updating;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public interface Updatable {

    /**
     * Update the object. This should be called once per frame before rendering.
     * 
     * @param dt Delta-Time passed down from the render engine.
     * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
     *      Gdx.graphics.getDeltaTime()}
     */
    public void update(float dt);
}
