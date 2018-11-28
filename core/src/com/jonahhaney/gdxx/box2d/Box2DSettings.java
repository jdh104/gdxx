package com.jonahhaney.gdxx.box2d;

import com.jonahhaney.gdxx.Settings;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Box2DSettings extends Settings {

    public static final int DEFAULT_WORLD_STEP_POSITION_ITERATIONS = 2;
    public static final int DEFAULT_WORLD_STEP_VELOCITY_ITERATIONS = 6;
    
    private boolean debug;
    private int worldStepPositionIterations = DEFAULT_WORLD_STEP_POSITION_ITERATIONS;
    private int worldStepVelocityIterations = DEFAULT_WORLD_STEP_VELOCITY_ITERATIONS;
    
    /**
     * 
     */
    public Box2DSettings(boolean debug) {
        this.debug = debug;
    }
    
    /**
     * 
     * @return
     */
    public int getWSPositionIterations() {
        return this.worldStepPositionIterations;
    }
    
    /**
     * 
     * @return
     */
    public int getWSVelocityIterations() {
        return this.worldStepVelocityIterations;
    }
    
    /**
     * 
     * @return
     */
    public boolean isDebug() {
        return this.debug;
    }
    
    /**
     * 
     * @param wspi
     */
    public void setWSPositionIterations(int wspi) {
        this.worldStepPositionIterations = wspi;
    }
    
    /**
     * 
     * @param wsvi
     */
    public void setWSVelocityIterations(int wsvi) {
        this.worldStepVelocityIterations = wsvi;
    }
}
