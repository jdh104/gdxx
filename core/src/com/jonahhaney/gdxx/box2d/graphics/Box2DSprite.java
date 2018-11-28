package com.jonahhaney.gdxx.box2d.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.jonahhaney.gdxx.box2d.Physics;
import com.jonahhaney.gdxx.graphics.Sprite;

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
     * @param sb
     * @param body
     */
    public Box2DSprite(SpriteBatch sb, Body body) {
        super(sb);
        this.body = body;
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
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        this.position = Physics.metersToPixels(this.body.getPosition());
    }
}
