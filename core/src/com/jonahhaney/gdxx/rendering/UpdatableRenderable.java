package com.jonahhaney.gdxx.rendering;

import com.jonahhaney.gdxx.updating.Updatable;

/**
 * Metadata interface for classes that implement both {@link Renderable} and
 * {@link com.jonahhaney.gdxx.updating.Updatable Updatable}
 * 
 * @author Jonah Haney
 */
public interface UpdatableRenderable extends Renderable, Updatable {
	// nothing to do here really, just for metadata.
}
