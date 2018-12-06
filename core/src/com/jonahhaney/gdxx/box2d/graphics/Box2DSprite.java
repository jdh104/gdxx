package com.jonahhaney.gdxx.box2d.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.jonahhaney.gdxx.box2d.Physics;
import com.jonahhaney.gdxx.graphics.Sprite;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public abstract class Box2DSprite extends Sprite {

    /**
     * The {@link Body} associated with this Sprite.
     */
    protected Body body;
    
    /**
     * Cached return value of {@link #defineBody()}
     */
    protected BodyDef bodyDef;

    /**
     * 
     * @param sb
     */
    public Box2DSprite(SpriteBatch sb) {
        super(sb);
        this.bodyDef = this.defineBody();
    }
    
    /**
     * 
     * @param fdef
     * @return
     */
    public Fixture createFixture(FixtureDef fdef) {
        return this.body.createFixture(fdef);
    }

    /**
     * 
     * @return
     */
    public Body getBody() {
        return this.body;
    }
    
    /**
     * Get the cached {@link BodyDef} object defined by {@link #defineBody()}
     * @return
     */
    public BodyDef getBodyDef() {
        return this.bodyDef;
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
    
    /**
     * Define this Sprite's initial body.
     * @return
     */
    public abstract BodyDef defineBody();
    
    /**
     * Create this Sprite's initial Fixtures using {@link Box2DSprite#body}.
     * @return
     * @see {@link Body#createFixture(FixtureDef)}
     */
    public abstract Fixture[] createFixtures();
}
