package com.jonahhaney.gdxx.rendering;

import com.jonahhaney.gdxx.states.GameStateProperty;

/**
 * 
 * TODO Document
 * 
 * @author Jonah Haney
 */
public interface Renderable extends GameStateProperty {

    /**
     * Render the object. This should be called once per frame.
     * 
     * @param dt Delta-Time passed down from the render engine.
     * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
     *      Gdx.graphics.getDeltaTime()}
     */
    public void render(float dt);
}
