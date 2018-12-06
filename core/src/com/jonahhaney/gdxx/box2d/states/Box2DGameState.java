package com.jonahhaney.gdxx.box2d.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.jonahhaney.gdxx.box2d.Box2DSettings;
import com.jonahhaney.gdxx.box2d.Physics;
import com.jonahhaney.gdxx.box2d.graphics.Box2DSprite;
import com.jonahhaney.gdxx.rendering.Renderable;
import com.jonahhaney.gdxx.states.GameState;
import com.jonahhaney.gdxx.states.GameStateProperty;
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
    private Renderable worldRender = new Box2DGameState.WorldRender();
    private Updatable worldUpdate = new Box2DGameState.WorldUpdate();
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
     * @param gsSettings
     */
    public Box2DGameState(Box2DSettings gsSettings) {
        this.settings = gsSettings;
    }

    /**
     * 
     * @param gsWorld
     * @param gsSettings
     */
    public Box2DGameState(World gsWorld, Box2DSettings gsSettings) {
        this.setWorld(gsWorld, gsSettings);
    }
    
    @Override
    public boolean add(GameStateProperty propertyToAdd) {
        if (super.add(propertyToAdd)) {
            if (propertyToAdd instanceof Box2DSprite) {
                Box2DSprite b2ds = (Box2DSprite)propertyToAdd;
                b2ds.setBody(this.world.createBody(b2ds.getBodyDef()));
                b2ds.createFixtures();
            } return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param bdef
     * @return
     */
    public Body createBody(BodyDef bdef) {
        return this.world.createBody(bdef);
    }

    /**
     * 
     * @return
     */
    public World getWorld() {
        return this.world;
    }
    
    @Override
    public boolean remove(GameStateProperty propertyToRemove) {
        if (super.remove(propertyToRemove)) {
            if (propertyToRemove instanceof Box2DSprite) {
                this.world.destroyBody(((Box2DSprite)propertyToRemove).getBody());
            } return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param gsWorld
     */
    public void setWorld(World gsWorld) {
        this.setWorld(gsWorld, this.settings);
    }
    
    /**
     * 
     * @param gsWorld
     * @param gsSettings
     */
    public void setWorld(World gsWorld, Box2DSettings gsSettings) {
        this.world = gsWorld;
        this.settings = gsSettings;
        this.updater.add(this.worldUpdate);

        if (this.settings.isDebug()) {
            this.b2dr = new Box2DDebugRenderer();
            this.b2drCam = new OrthographicCamera();
            this.b2drCam.setToOrtho(false, Physics.pixelsToMeters(this.settings.getWidth()),
                    Physics.pixelsToMeters(this.settings.getHeight()));

            this.renderer.add(this.worldRender);
        } else {
            this.b2dr = null;
            this.b2drCam = null;
            
            this.renderer.remove(this.worldRender);
        }
    }

    @Override
    public abstract void create();

    /**
     * Internal class used to render a {@link Box2DDebugRenderer}.
     * 
     * @author Jonah Haney
     */
    private class WorldRender implements Renderable {
        @Override
        public void render(float dt) {
            Box2DGameState.this.b2dr.render(Box2DGameState.this.world, Box2DGameState.this.b2drCam.combined);
        }
    }

    /**
     * Internal class used to update the Box2D {@link World}.
     * 
     * @author Jonah Haney
     */
    private class WorldUpdate implements Updatable {
        
        private int wspi = Box2DGameState.this.settings.getWSPositionIterations();
        private int wsvi = Box2DGameState.this.settings.getWSVelocityIterations();
        
        @Override
        public void update(float dt) {
            Box2DGameState.this.world.step(dt, this.wsvi, this.wspi);
        }
    }
}
