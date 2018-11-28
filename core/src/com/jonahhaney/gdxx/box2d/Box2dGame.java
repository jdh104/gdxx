package com.jonahhaney.gdxx.box2d;

import com.jonahhaney.gdxx.LibGdxGame;

/**
 * TODO Document TODO Decide if this class is necessary
 * 
 * @author Jonah Haney
 */
public abstract class Box2dGame extends LibGdxGame {

    protected Box2dSettings settings;
    
    /**
     * 
     * @param debugBox2d
     */
    public Box2dGame(boolean debugBox2d) {
        super();
        this.settings = new Box2dSettings(debugBox2d);
    }

    @Override
    public abstract void create();
}
