package com.jonahhaney.gdxx.states;

import com.jonahhaney.gdxx.input.InputManager;
import com.jonahhaney.gdxx.rendering.Renderable;
import com.jonahhaney.gdxx.rendering.Renderer;
import com.jonahhaney.gdxx.rendering.UpdatableRenderable;
import com.jonahhaney.gdxx.updating.Updatable;
import com.jonahhaney.gdxx.updating.Updater;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public abstract class GameState {

	private Updater updater = new Updater();
	private Renderer renderer = new Renderer();

	/**
	 * 
	 */
	public GameState() {

	}

	/**
	 * 
	 * @param inputManager
	 */
	public GameState(InputManager inputManager) {
		updater.add(inputManager);
	}

	/**
	 * 
	 * @param newInputManager
	 */
	public void setInputManager(InputManager newInputManager) {
		updater.add(newInputManager);
	}

	/**
	 * 
	 * @param r
	 * @return true if the Renderer did not already contain the specified Renderable
	 */
	public boolean addRenderable(Renderable r) {
		return this.renderer.add(r);
	}

	/**
	 * 
	 * @param u
	 * @return true if the Updater did not already contain the specified Updatable
	 */
	public boolean addUpdatable(Updatable u) {
		return this.updater.add(u);
	}

	/**
	 * 
	 * @param ur
	 * @return true if the either the Renderer or the Updater did not already
	 *         contain the specified UpdatableRenderable
	 */
	public boolean addUpdatableRenderable(UpdatableRenderable ur) {
		return this.updater.add(ur) | this.renderer.add(ur);
		// We DO NOT want this to short circuit, hence the | instead of ||
	}

	/**
	 * 
	 * @param dt Delta-Time passed down from the render engine.
	 * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
	 *      Gdx.graphics.getDeltaTime()}
	 */
	public void render(float dt) {
		this.renderer.renderAll(dt);
	}

	/**
	 * 
	 * @param dt Delta-Time passed down from the render engine.
	 * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
	 *      Gdx.graphics.getDeltaTime()}
	 */
	public void update(float dt) {
		this.updater.updateAll(dt);
	};

	/**
	 * Called upon creation of the Gamestate object. Put initialization code here.
	 */
	public abstract void create();

	/**
	 * Called upon disposal of the Gamestate object. Put cleanup code here.
	 */
	public abstract void dispose();
}
