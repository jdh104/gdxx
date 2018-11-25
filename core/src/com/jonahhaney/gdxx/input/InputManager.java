package com.jonahhaney.gdxx.input;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiConsumer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class InputManager implements InputProcessor {

	// Management fields
	private boolean isManagingKeys = false;
	private boolean isManagingKeysTyped = false;
	private boolean isManagingMouseButtons = false;
	private boolean isManagingMouseMovement = false;
	private boolean isManagingScrolling = false;
	private boolean isManagingTouch = false;
	private boolean isManagingTouchDrag = false;

	// Input data
	private Map<Integer, Boolean> keyPreviousStates;
	private Map<Integer, Boolean> keyStates;
	private Map<Integer, Boolean> mouseButtonStates;
	private Map<Integer, Boolean> mouseButtonPreviousStates;
	private Vector2 mousePosition;
	private Map<Integer, Vector2> mousePreviousButtonPressPositions;
	private Vector2 mousePreviousPosition;
	private Vector2 mouseVelocity;
	private int scrollAmount = 0;
	private Queue<Character> typedChars;

	/**
	 * Be sure to call {@link #update(float) update(dt)} once per frame to keep the
	 * input data accurate.
	 * 
	 * @see #enableManagingKeys(int[])
	 * @see #enableManagingKeysTyped()
	 * @see #enableManagingMouseButtons(int[])
	 * @see #enableManagingMouseMovement()
	 * @see #enableManagingScrolling()
	 * @see #enableManagingTouch()
	 * @see #enableManagingTouchDrag()
	 */
	public InputManager() {
		// do nothing...
	}

	/**
	 * Be sure to call {@link #update(float) update(dt)} once per frame to keep the
	 * input data accurate.
	 * 
	 * @param keysToManage array of key values from
	 *                     {@link com.badlogic.gdx.Input.Keys}
	 * 
	 * @see #disableManagingKeys(int[])
	 * @see #enableManagingKeysTyped()
	 * @see #enableManagingMouseButtons(int[])
	 * @see #enableManagingMouseMovement()
	 * @see #enableManagingScrolling()
	 * @see #enableManagingTouch()
	 * @see #enableManagingTouchDrag()
	 */
	public InputManager(int[] keysToManage) {
		this.enableManagingKeys(keysToManage);
	}
	
	/**
	 * 
	 */
	public void disableManagingKeys() {
		if (this.isManagingKeys) {
			this.isManagingKeys = false;
			this.keyStates = null;
			this.keyPreviousStates = null;
		}
	}

	/**
	 * 
	 * @param keysToDisable array of keycodes from
	 *                      {@link com.badlogic.gdx.Input.Keys}
	 */
	public void disableManagingKeys(int[] keysToDisable) {
		if (this.isManagingKeys) {
			for (int i = 0; i < keysToDisable.length; i++) {
				if (this.keyStates.remove(keysToDisable[i]) != null) {
					this.keyPreviousStates.remove(keysToDisable[i]);
				}
			}

			if (this.keyStates.size() == 0) {
				this.disableManagingKeys();
			}
		}
	}

	/**
	 * 
	 */
	public void disableManagingKeysTyped() {
		if (this.isManagingKeysTyped) {
			this.isManagingKeysTyped = false;
			this.typedChars = null;
		}
	}

	/**
	 * 
	 */
	public void disableManagingMouseButtons() {
		// TODO
	}

	/**
	 * 
	 */
	public void disableManagingMouseMovement() {
		if (this.isManagingMouseMovement) {
			this.isManagingMouseMovement = false;
			this.mousePosition = null;
			this.mousePreviousPosition = null;
			this.mouseVelocity = null;
		}
	}

	/**
	 * 
	 */
	public void disableManagingScrolling() {
		this.scrollAmount = 0;
		this.isManagingScrolling = false;
	}

	/**
	 * 
	 */
	public void disableManagingTouch() {
		if (this.isManagingTouch) {
			this.isManagingTouch = false;
			// TODO deallocate input data
		}
	}

	/**
	 * 
	 */
	public void disableManagingTouchDrag() {
		if (this.isManagingTouchDrag) {
			this.isManagingTouchDrag = false;
			// TODO deallocate input data
		}
	}

	/**
	 * 
	 * @param keysToEnable array of keycodes from
	 *                     {@link com.badlogic.gdx.Input.Keys}
	 * 
	 * @see KeyCodeSets
	 */
	public void enableManagingKeys(int[] keysToEnable) {
		if (!this.isManagingKeys) {
			this.keyStates = new HashMap<Integer, Boolean>();
			this.keyPreviousStates = new HashMap<Integer, Boolean>();
			for (int i = 0; i < keysToEnable.length; i++) {
				keyStates.put(keysToEnable[i], false);
				keyPreviousStates.put(keysToEnable[i], false);
			}
			this.isManagingKeys = true;
		} else {
			for (int i = 0; i < keysToEnable.length; i++) {
				if (keyStates.putIfAbsent(keysToEnable[i], false) == null) {
					keyPreviousStates.putIfAbsent(keysToEnable[i], false);
				}
			}
		}
	}

	/**
	 * 
	 */
	public void enableManagingKeysTyped() {
		if (!this.isManagingKeysTyped) {
			this.typedChars = new LinkedList<Character>();
			this.isManagingKeysTyped = true;
		}
	}

	/**
	 * 
	 * @param mouseButtonsToEnable
	 */
	public void enableManagingMouseButtons(int[] mouseButtonsToEnable) {
		// TODO
	}

	/**
	 * 
	 */
	public void enableManagingMouseMovement() {
		if (!this.isManagingMouseMovement) {
			this.mousePosition = new Vector2();
			this.mousePreviousPosition = new Vector2();
			this.mouseVelocity = new Vector2();
			this.isManagingMouseMovement = true;
		}
	}

	/**
	 * 
	 */
	public void enableManagingScrolling() {
		this.isManagingScrolling = true;
	}

	/**
	 * 
	 */
	public void enableManagingTouch() {
		if (!this.isManagingTouch) {
			// TODO allocate stuff for input data storage
			this.isManagingTouch = true;
		}
	}

	/**
	 * 
	 */
	public void enableManagingTouchDrag() {
		if (!this.isManagingTouchDrag) {
			// TODO allocate stuff for input data storage
			this.isManagingTouchDrag = true;
		}
	}

	/**
	 * 
	 * @return The currently active {@link InputProcessor} if and only if it is an
	 *         instance of {@link InputManager}, null otherwise.
	 */
	public static InputManager getActiveInputManager() {
		InputProcessor i = Gdx.input.getInputProcessor();
		return i instanceof InputManager ? (InputManager) i : null;
	}

	/**
	 * 
	 * @return The next-most recent mouse position, or null if mouse movement is not
	 *         being managed.
	 */
	public Vector2 getMousePreviousPosition() {
		return mousePreviousPosition;
	}

	/**
	 * 
	 * @return The current mouse position, or null if mouse movement is not being
	 *         managed.
	 */
	public Vector2 getMousePosition() {
		return mousePosition;
	}

	/**
	 * 
	 * @return The current mouse velocity, or null if mouse movement is not being
	 *         managed.
	 */
	public Vector2 getMouseVelocity() {
		return mouseVelocity;
	}

	/**
	 * Consume and return user's typing input.
	 * 
	 * @return
	 */
	public String getTypedString() {
		String input = "";

		while (!typedChars.isEmpty()) {
			input += typedChars.remove();
		}

		return input;
	}

	/**
	 * 
	 * @param keycode from {@link com.badlogic.gdx.Input.Keys}.
	 * @return
	 */
	public boolean isKeyDown(int keycode) {
		return this.isManagingKeys && keyStates.getOrDefault(keycode, false);
	}

	/**
	 * 
	 * @param keycode from {@link com.badlogic.gdx.Input.Keys}.
	 * @return
	 */
	public boolean isKeyFallingEdge(int keycode) {
		return this.isManagingKeys && !keyStates.getOrDefault(keycode, true) && keyPreviousStates.get(keycode);
	}

	/**
	 * 
	 * @param keycode from {@link com.badlogic.gdx.Input.Keys}.
	 * @return
	 */
	public boolean isKeyRisingEdge(int keycode) {
		return this.isManagingKeys && keyStates.getOrDefault(keycode, false) && !keyPreviousStates.get(keycode);
	}

	/**
	 * 
	 * @return
	 */
	public boolean isMouseMoving() {
		return this.isManagingMouseMovement
				&& (mousePosition.x != mousePreviousPosition.x || mousePosition.y != mousePreviousPosition.y);
	}

	/**
	 * 
	 * @return
	 */
	public boolean isScrolling() {
		return this.scrollAmount != 0;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isScrollingDown() {
		return this.scrollAmount == -1;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isScrollingUp() {
		return this.scrollAmount == 1;
	}

	@Override
	public boolean keyDown(int keycode) {
		return this.isManagingKeys && this.keyStates.replace(keycode, true);
	}

	@Override
	public boolean keyUp(int keycode) {
		return this.isManagingKeys && this.keyStates.replace(keycode, false);
	}

	@Override
	public boolean keyTyped(char character) {
		return this.isManagingKeysTyped && this.typedChars.add(character);
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		if (!this.isManagingMouseMovement) {
			return false;
		} else {
			this.mousePosition.x = screenX;
			this.mousePosition.y = screenY;
			return true;
		}
	}

	@Override
	public boolean scrolled(int amount) {
		if (!this.isManagingScrolling) {
			return false;
		} else {
			this.scrollAmount = amount;
			return true;
		}
	}

	/**
	 * Set this {@link InputManager} object as the current active
	 * {@link InputProcessor} of {@link com.badlogic.gdx.Gdx#input Gdx.input}
	 * 
	 * Note that only one {@link InputManager} object can be enabled at one time.
	 * 
	 * @see com.badlogic.gdx.Input#setInputProcessor(InputProcessor)
	 *      Gdx.input.setInputProcessor(InputProcessor)
	 */
	public void setAsGdxInputProcessor() {
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (!this.isManagingTouch) {
			return false;
		} else {
			// TODO actually manage the input
			return true;
		}
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (!this.isManagingTouch) {
			return false;
		} else {
			// TODO actually manage the input
			return true;
		}
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if (!this.isManagingTouchDrag) {
			return false;
		} else {
			// TODO actually manage the input
			return true;
		}
	}

	/**
	 * Update all managed input data.
	 * 
	 * This method should be called by the application once per frame.
	 * 
	 * @param dt Delta time, passed down from the graphics engine.
	 */
	public void update(float dt) {
		if (this.isManagingKeys) {
			this.keyStates.forEach(new BiConsumer<Integer, Boolean>() {
				@Override
				public void accept(Integer keycode, Boolean state) {
					InputManager.this.keyPreviousStates.put(keycode, state);
				}
			});
		}

		if (this.isManagingMouseMovement) {
			this.mousePreviousPosition.x = this.mousePosition.x;
			this.mousePreviousPosition.y = this.mousePosition.y;

			if (dt != 0) {
				this.mouseVelocity.x = (this.mousePosition.x - this.mousePreviousPosition.x) / dt;
				this.mouseVelocity.y = (this.mousePosition.y - this.mousePreviousPosition.y) / dt;
			}
		}

		if (this.isManagingScrolling) {
			this.scrollAmount = 0;
		}
	}
}
