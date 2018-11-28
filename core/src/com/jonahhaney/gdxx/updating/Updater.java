package com.jonahhaney.gdxx.updating;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Updater {

    private Set<Updatable> updatables = new HashSet<Updatable>();

    /**
     * 
     */
    public Updater() {

    }

    /**
     * 
     * @param updatableToAdd
     * @return true if this Updater did not already contain the specified Updatable
     */
    public boolean add(Updatable updatableToAdd) {
        return updatables.add(updatableToAdd);
    }

    /**
     * 
     * @param updatableToRemove
     * @return true if the Updater contained the specified Updatable
     */
    public boolean remove(Updatable updatableToRemove) {
        return updatables.remove(updatableToRemove);
    }

    /**
     * 
     * @param dt Delta-Time passed down from the render engine
     * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
     *      Gdx.graphics.getDeltaTime()}
     */
    public void updateAll(float dt) {
        for (Updatable target : updatables) {
            target.update(dt);
        }
    }
}
