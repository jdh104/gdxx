package com.jonahhaney.gdxx.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Box2DSprite extends Sprite {

    protected Body body;

    /**
     * 
     * @param sb
     */
    public Box2DSprite(SpriteBatch sb) {
        super(sb);
    }
    
    /**
     * 
     * @return
     */
    public Body getBody() {
        return body;
    }

    /**
     * 
     * @param body
     */
    public void setBody(Body body) {
        this.body = body;
        this.position = body.getPosition();
    }
}
