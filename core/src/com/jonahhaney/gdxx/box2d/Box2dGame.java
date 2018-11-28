package com.jonahhaney.gdxx.box2d;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.jonahhaney.gdxx.LibGdxGame;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public abstract class Box2dGame extends LibGdxGame {

    private Box2DDebugRenderer b2dr;
    private OrthographicCamera b2drCam;
    private boolean debugBox2d;

    public Box2dGame(boolean debugBox2d) {
        super();
        /*this.debugBox2d = debugBox2d;

        if (debugBox2d) {
            b2dr = new Box2DDebugRenderer();
            b2drCam = new OrthographicCamera();
            b2drCam.setToOrtho(false, Physics.pixelsToMeters(super.settings.getWidth()),
                    Physics.pixelsToMeters(super.settings.getHeight()));
        }*/
    }
    
    @Override
    public void render() {
        super.render();
    }

    @Override
    public abstract void create();
}
