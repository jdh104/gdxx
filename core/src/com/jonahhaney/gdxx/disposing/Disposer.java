package com.jonahhaney.gdxx.disposing;

import java.util.HashSet;
import java.util.Set;

import com.jonahhaney.gdxx.disposing.Disposable;

/**
 * 
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Disposer {
    
    private Set<Disposable> disposables;

    /**
     * 
     */
    public Disposer() {
        disposables = new HashSet<Disposable>();
    }

    /**
     * 
     * @param disposableToAdd
     * @return true if this Disposer did not already contain the specified
     *         Disposable
     */
    public boolean add(Disposable disposableToAdd) {
        return disposables.add(disposableToAdd);
    }

    /**
     * 
     * @param disposableToRemove
     * @return true if this Disposer contained the specified Disposable
     */
    public boolean remove(Disposable disposableToRemove) {
        return disposables.remove(disposableToRemove);
    }

    /**
     * 
     * @param dt Delta-Time passed down from the render engine.
     * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
     *      Gdx.graphics.getDeltaTime()}
     */
    public void disposeAll() {
        for (Disposable target : disposables) {
            target.dispose();
        }
    }
}
