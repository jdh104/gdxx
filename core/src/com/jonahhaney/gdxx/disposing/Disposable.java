package com.jonahhaney.gdxx.disposing;

import com.jonahhaney.gdxx.states.GameStateProperty;

/**
 * 
 * TODO Document
 * 
 * @author Jonah Haney
 */
public interface Disposable extends GameStateProperty {

    /**
     * 
     */
    public void dispose();
    
}
