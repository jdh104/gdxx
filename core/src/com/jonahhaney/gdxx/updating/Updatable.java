package com.jonahhaney.gdxx.updating;

import com.jonahhaney.gdxx.states.GameStateProperty;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public interface Updatable extends GameStateProperty {

    /**
     * Update the object. This should be called once per frame before rendering.
     * 
     * @param dt Delta-Time passed down from the render engine.
     * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
     *      Gdx.graphics.getDeltaTime()}
     */
    public void update(float dt);
}
