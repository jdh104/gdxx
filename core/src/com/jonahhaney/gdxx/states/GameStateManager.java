package com.jonahhaney.gdxx.states;

import java.util.Stack;

public class GameStateManager {
	
	private static GameStateManager instance;
	
	private Stack<GameState> states;
	
	private GameStateManager() {
		
	}
	
}
