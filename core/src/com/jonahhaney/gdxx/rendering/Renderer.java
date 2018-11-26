package com.jonahhaney.gdxx.rendering;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Renderer {

	private Set<Renderable> renderables;

	/**
	 * 
	 */
	public Renderer() {
		renderables = new HashSet<Renderable>();
	}

	/**
	 * 
	 * @param renderableToAdd
	 * @return true if this Renderer did not already contain the specified Renderable
	 */
	public boolean add(Renderable renderableToAdd) {
		return renderables.add(renderableToAdd);
	}

	/**
	 * 
	 * @param renderableToRemove
	 * @return true if the Renderer contained the specified Renderable
	 */
	public boolean remove(Renderable renderableToRemove) {
		return renderables.remove(renderableToRemove);
	}

	/**
	 * 
	 * @param dt Delta-Time passed down from the render engine.
	 * @see {@link com.badlogic.gdx.Graphics#getDeltaTime()
	 *      Gdx.graphics.getDeltaTime()}
	 */
	public void renderAll(float dt) {
		for (Renderable target : renderables) {
			target.render(dt);
		}
	}
}
