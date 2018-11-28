package com.jonahhaney.gdxx.box2d.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.jonahhaney.gdxx.graphics.Sprite;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Box2DSprite extends Sprite {

    protected Body body;
    private Vector2 position = new Vector2();
    
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
    
    @Override
    public void render(float dt) {
        
    }

    /**
     * 
     * @param body
     */
    public void setBody(Body body) {
        this.body = body;
        this.position = body.getPosition();
    }
    
    @Override
    public void update(float dt) {
        
    }
}
