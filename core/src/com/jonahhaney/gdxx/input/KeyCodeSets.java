package com.jonahhaney.gdxx.input;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.badlogic.gdx.Input.Keys;

/**
 * Static collection of default sets of key codes (so that the dev doesn't have
 * to manually create large arrays of keycodes)
 * 
 * @author Jonah Haney
 */
public class KeyCodeSets {

    /**
     * Array containing all keycodes in {@link Keys}
     */
    public static final int[] ALL_KEY_CODES;

    /**
     * Array containing keycodes for WASD.
     */
    public static final int[] WASD = new int[] { Keys.W, Keys.A, Keys.S, Keys.D };

    /**
     * Array containing keycodes for keyboard arrow keys.
     */
    public static final int[] ARROW_KEYS = new int[] { Keys.UP, Keys.LEFT, Keys.DOWN, Keys.RIGHT };

    /**
     * Array containing keycodes for number keys at the top of the keyboard.
     * 
     * @see #NUMPAD_KEYS
     */
    public static final int[] NUMBER_KEYS = new int[] { Keys.NUM_0, Keys.NUM_1, Keys.NUM_2, Keys.NUM_3, Keys.NUM_4,
            Keys.NUM_5, Keys.NUM_6, Keys.NUM_7, Keys.NUM_8, Keys.NUM_9 };

    /**
     * Array containing keycodes for number keys on the number pad.
     * 
     * @see #NUMBER_KEYS
     */
    public static final int[] NUMPAD_KEYS = new int[] { Keys.NUMPAD_0, Keys.NUMPAD_1, Keys.NUMPAD_2, Keys.NUMPAD_3,
            Keys.NUMPAD_4, Keys.NUMPAD_5, Keys.NUMPAD_6, Keys.NUMPAD_7, Keys.NUMPAD_8, Keys.NUMPAD_9 };

    // Extract all the keycodes for ALL_KEY_CODES using Java Reflection
    // Yes, this works correctly....
    static {
        ArrayList<Integer> allKeyCodesList = new ArrayList<Integer>();
        Field[] keysClassFields = Keys.class.getDeclaredFields();
        boolean illegalAccessFlag = false;

        for (Field keysField : keysClassFields) {
            int fieldModifiers = keysField.getModifiers();
            if (Modifier.isStatic(fieldModifiers) && Modifier.isFinal(fieldModifiers)) {
                try {
                    keysField.setAccessible(true);
                    allKeyCodesList.add(new Integer(keysField.getInt(null)));
                } catch (IllegalArgumentException e) {
                    continue; // we only want the ints anyway.
                } catch (IllegalAccessException e) {
                    illegalAccessFlag = true;
                    continue; // not sure what would cause this.
                }
            }
        }

        if (illegalAccessFlag) {
            System.err.println(
                    "IllegalAccessException occurred when extracting keycodes, " + "some keycodes may be unusable...");
        }

        Integer t1[] = allKeyCodesList.toArray(new Integer[0]);
        int t2[] = new int[t1.length];
        for (int i = 0; i < t1.length; i++) {
            t2[i] = t1[i].intValue();
        }

        ALL_KEY_CODES = t2.clone();
    }
}
