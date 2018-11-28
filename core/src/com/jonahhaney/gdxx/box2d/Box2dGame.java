package com.jonahhaney.gdxx.box2d;

import com.jonahhaney.gdxx.LibGdxGame;

/**
 * TODO Document TODO Decide if this class is necessary
 * 
 * @author Jonah Haney
 */
public abstract class Box2dGame extends LibGdxGame {

    protected Box2dSettings settings = new Box2dSettings(false);
    
    /**
     * 
     * @param debugBox2d
     */
    public Box2dGame() {
        super();
    }

    @Override
    public abstract void create();
}
