package com.jonahhaney.gdxx.input;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.badlogic.gdx.Input.Keys;

/**
 * Static collection of default sets of key codes (so that the dev doesn't have
 * to manually create large arrays of keycodes)
 * 
 * Yes, this class works correctly...
 * 
 * @author Jonah Haney
 */
public class KeyCodeSets {

	/**
	 * Array containing all key codes in {@link Keys}
	 */
	public static final int[] ALL_KEY_CODES;

	/**
	 * Array containing key codes for WASD.
	 */
	public static final int[] WASD = new int[] { Keys.W, Keys.A, Keys.S, Keys.D };

	/**
	 * Array containing key codes for keyboard arrow keys.
	 */
	public static final int[] ARROW_KEYS = new int[] { Keys.UP, Keys.LEFT, Keys.DOWN, Keys.RIGHT };

	/**
	 * Array containing key codes for number keys at the top of the keyboard.
	 */
	public static final int[] NUMBER_KEYS = new int[] { Keys.NUM_0, Keys.NUM_1, Keys.NUM_2, Keys.NUM_3, Keys.NUM_4,
			Keys.NUM_5, Keys.NUM_6, Keys.NUM_7, Keys.NUM_8, Keys.NUM_9 };

	// Extract all the keycodes for ALL_KEY_CODES using Java Reflection
	static {
		ArrayList<Integer> allKeyCodesList = new ArrayList<Integer>();
		Field[] keysClassFields = Keys.class.getDeclaredFields();

		for (Field keysField : keysClassFields) {
			if (Modifier.isStatic(keysField.getModifiers()) && Modifier.isFinal(keysField.getModifiers())) {
				try {
					keysField.setAccessible(true);
					allKeyCodesList.add(new Integer(keysField.getInt(null)));
				} catch (Exception e) {
					continue; // We only want the ints anyway.
				}
			}
		}

		Integer t1[] = allKeyCodesList.toArray(new Integer[0]);
		int t2[] = new int[t1.length];
		for (int i = 0; i < t1.length; i++) {
			t2[i] = t1[i];
		}

		ALL_KEY_CODES = t2.clone();
	}
}
