package com.jonahhaney.gdxx.states;

import com.jonahhaney.gdxx.disposing.Disposable;
import com.jonahhaney.gdxx.disposing.Disposer;
import com.jonahhaney.gdxx.input.InputManager;
import com.jonahhaney.gdxx.rendering.Renderable;
import com.jonahhaney.gdxx.rendering.Renderer;
import com.jonahhaney.gdxx.updating.Updatable;
import com.jonahhaney.gdxx.updating.Updater;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public abstract class GameState implements Disposable, Renderable, Updatable {

    protected Disposer disposer = new Disposer();
    protected Renderer renderer = new Renderer();
    protected Updater updater = new Updater();
    protected InputManager inputManager = new InputManager();

    /**
     * 
     */
    public GameState() {
        this.create();
    }

    /**
     * 
     * @param inputManager
     */
    public GameState(InputManager inputManager) {
        this.setInputManager(inputManager);
        this.create();
    }

    /**
     * 
     * @param property
     * @return
     */
    public boolean add(GameStateProperty property) {
        boolean flag = false;

        if (property instanceof Disposable) {
            flag |= this.disposer.add((Disposable) property);
        }

        if (property instanceof Renderable) {
            flag |= this.renderer.add((Renderable) property);
        }

        if (property instanceof Updatable) {
            flag |= this.updater.add((Updatable) property);
        }

        return flag;
    }

    /**
     * 
     * @param property
     * @return
     */
    public boolean remove(GameStateProperty property) {
        boolean flag = false;

        if (property instanceof Disposable) {
            flag |= this.disposer.remove((Disposable) property);
        }

        if (property instanceof Renderable) {
            flag |= this.renderer.remove((Renderable) property);
        }

        if (property instanceof Updatable) {
            flag |= this.updater.remove((Updatable) property);
        }

        return flag;
    }

    @Override
    public void dispose() {
        this.disposer.disposeAll();
    }

    /**
     * 
     * @param d
     * @return
     */
    public boolean disposeProperty(Disposable d) {
        if (this.remove(d)) {
            d.dispose();
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param newInputManager
     */
    public void setInputManager(InputManager newInputManager) {
        this.remove(this.inputManager);
        this.add(newInputManager);
        this.inputManager = newInputManager;
    }

    @Override
    public void render(float dt) {
        this.renderer.renderAll(dt);
    }

    @Override
    public void update(float dt) {
        this.updater.updateAll(dt);
    }

    /**
     * Called upon creation of the Gamestate object. Put initialization code here.
     */
    public abstract void create();
}
