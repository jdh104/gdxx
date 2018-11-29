package com.jonahhaney.gdxx.box2d.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.jonahhaney.gdxx.box2d.Box2DSettings;
import com.jonahhaney.gdxx.box2d.Physics;
import com.jonahhaney.gdxx.rendering.Renderable;
import com.jonahhaney.gdxx.states.GameState;
import com.jonahhaney.gdxx.updating.Updatable;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public abstract class Box2DGameState extends GameState {

    protected Box2DDebugRenderer b2dr;
    protected Box2DSettings settings;
    protected OrthographicCamera b2drCam;
    private Renderable worldRender = new Box2DGameState.WorldRender();;
    private Updatable worldUpdate = new Box2DGameState.WorldUpdate();;
    protected World world;

    /**
     * 
     * @param debugWorld
     */
    public Box2DGameState(boolean debugWorld) {
        this.settings = new Box2DSettings(debugWorld);
    }
    
    /**
     * 
     * @param settings
     */
    public Box2DGameState(Box2DSettings settings) {
        this.settings = settings;
    }

    /**
     * 
     * @param world
     */
    public Box2DGameState(World world, Box2DSettings settings) {
        this.setWorld(world, settings);
    }

    /**
     * 
     * @return
     */
    public World getWorld() {
        return this.world;
    }
    
    /**
     * 
     * @param world
     */
    public void setWorld(World world) {
        this.setWorld(world, this.settings);
    }
    
    /**
     * 
     * @param world
     * @param worldSettings
     */
    public void setWorld(World world, Box2DSettings worldSettings) {
        this.world = world;
        this.settings = worldSettings;
        this.updater.add(worldUpdate);

        if (this.settings.isDebug()) {
            b2dr = new Box2DDebugRenderer();
            b2drCam = new OrthographicCamera();
            b2drCam.setToOrtho(false, Physics.pixelsToMeters(settings.getWidth()),
                    Physics.pixelsToMeters(settings.getHeight()));

            this.renderer.add(worldRender);
        } else {
            b2dr = null;
            b2drCam = null;
            
            this.renderer.remove(worldRender);
        }
    }

    @Override
    public abstract void create();

    private class WorldRender implements Renderable {
        @Override
        public void render(float dt) {
            b2dr.render(Box2DGameState.this.world, Box2DGameState.this.b2drCam.combined);
        }
    }

    private class WorldUpdate implements Updatable {
        @Override
        public void update(float dt) {
            Box2DGameState.this.world.step(dt, Box2DGameState.this.settings.getWSVelocityIterations(),
                    Box2DGameState.this.settings.getWSPositionIterations());
        }
    }
}
