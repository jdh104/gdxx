package com.jonahhaney.gdxx.states;

import com.jonahhaney.gdxx.input.InputManager;

public abstract class GameState {
	
	protected InputManager inputManager;
	
	public GameState() {
		
	}
	
	public GameState(InputManager inputManager) {
		
	}
	
	public void setInputManager(InputManager newInputManager) {
		
	}
	
	public abstract void dispose();
	public abstract void render();
	public void update(float dt) {
		if (inputManager != null) {
			inputManager.update(dt);
		}
	};
}
