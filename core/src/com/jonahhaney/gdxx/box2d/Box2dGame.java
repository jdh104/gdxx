package com.jonahhaney.gdxx.box2d;

import com.jonahhaney.gdxx.LibGdxGame;

/**
 * TODO Document TODO Decide if this class is necessary
 * 
 * @author Jonah Haney
 */
public abstract class Box2dGame extends LibGdxGame {

    /**
     * 
     * @param debugBox2d
     */
    public Box2dGame(boolean debugBox2d) {
        super();
    }

    @Override
    public abstract void create();
}
