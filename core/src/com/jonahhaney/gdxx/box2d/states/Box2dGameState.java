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
public abstract class Box2dGameState extends GameState {

    protected Box2DDebugRenderer b2dr;
    protected Box2DSettings settings;
    protected OrthographicCamera b2drCam;
    protected World world;

    /**
     * 
     * @param world
     */
    public Box2dGameState(World world, Box2DSettings settings) {
        this.world = world;
        this.settings = settings;

        this.updater.add(new Updatable() {
            @Override
            public void update(float dt) {
                Box2dGameState.this.world.step(dt, Box2dGameState.this.settings.getWSVelocityIterations(),
                        Box2dGameState.this.settings.getWSPositionIterations());
            }
        });

        if (this.settings.isDebug()) {
            b2dr = new Box2DDebugRenderer();
            b2drCam = new OrthographicCamera();
            b2drCam.setToOrtho(false, Physics.pixelsToMeters(settings.getWidth()),
                    Physics.pixelsToMeters(settings.getHeight()));

            this.renderer.add(new Renderable() {
                @Override
                public void render(float dt) {
                    b2dr.render(Box2dGameState.this.world, Box2dGameState.this.b2drCam.combined);
                }
            });
        }
    }

    @Override
    public abstract void create();
}
