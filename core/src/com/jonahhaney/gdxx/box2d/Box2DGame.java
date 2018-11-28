package com.jonahhaney.gdxx.box2d;

import com.jonahhaney.gdxx.LibGdxGame;

/**
 * TODO Document TODO Decide if this class is necessary
 * 
 * @author Jonah Haney
 */
public abstract class Box2DGame extends LibGdxGame {

    protected Box2DSettings settings;
    
    /**
     * 
     * @param debugBox2d
     */
    public Box2DGame(boolean debugBox2d) {
        super();
        this.settings = new Box2DSettings(debugBox2d);
    }

    @Override
    public abstract void create();
}
