package com.jonahhaney.gdxx.states;

import java.util.Stack;

import com.jonahhaney.gdxx.disposing.Disposable;
import com.jonahhaney.gdxx.rendering.Renderable;
import com.jonahhaney.gdxx.updating.Updatable;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class GameStateManager implements Disposable, Renderable, Updatable {

    private RootGameState rootState = new RootGameState();
    private Stack<GameState> states = new Stack<GameState>();

    /**
     * 
     */
    public GameStateManager() {
        this.states.push(rootState);
    }
    
    @Override
    public void dispose() {
        while (this.popState());
    }
    
    /**
     * 
     * @return
     */
    public GameState getState() {
        return this.states.peek();
    }
    
    /**
     * 
     * @return
     */
    public boolean hasState() {
        return this.states.peek() != rootState;
    }
    
    /**
     * 
     * @param state
     */
    public void pushState(GameState state) {
        this.states.push(state);
    }
    
    /**
     * 
     */
    public boolean popState() {
        if (this.states.peek() != rootState) {
            this.states.pop().dispose();
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void render(float dt) {
        this.states.peek().render(dt);
    }
    
    /**
     * 
     * @param newState
     */
    public void setState(GameState newState) {
        this.popState();
        this.states.push(newState);
    }

    @Override
    public void update(float dt) {
        this.states.peek().update(dt);
    }
}
