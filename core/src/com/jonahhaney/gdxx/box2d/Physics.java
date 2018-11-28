package com.jonahhaney.gdxx.box2d;

import java.awt.AWTError;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import com.badlogic.gdx.math.Vector2;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Physics {

    /**
     * Earth's acceleration due to gravity (g)
     */
    public static final float DEFAULT_ACCEL_GRAVITY = -9.81f;
    
    /**
     * Conversion scalar
     */
    public static final float INCHES_PER_METER = 39.37f;
    private static final int STANDARD_PPI = 72;

    /**
     * Actual-size calculation using Java Toolkit screen resolution API
     */
    public static final float DEFAULT_PPM;

    // Calculate actual-size ppm
    static {
        float default_ppm = (float) STANDARD_PPI * INCHES_PER_METER;
        try {
            default_ppm = Toolkit.getDefaultToolkit().getScreenResolution() * INCHES_PER_METER;
        } catch (AWTError | HeadlessException ex) {
            System.err.println(
                    "Could not get screen resolution, using industry standard of " + STANDARD_PPI + " ppi instead.");
        } finally {
            DEFAULT_PPM = default_ppm;
        }
    }

    public static float accelGravity = DEFAULT_ACCEL_GRAVITY;
    public static float pixelsPerMeter = DEFAULT_PPM;

    /**
     * Convert a dimension of {@link com.badlogic.gdx.physics.box2d.Box2D Box2D}
     * meters to pixels for rendering purposes.
     * 
     * @param meters the dimension to convert
     * @return the dimension converted to pixels
     */
    public static float metersToPixels(float meters) {
        return meters * Physics.pixelsPerMeter;
    }

    /**
     * Scale a vector. This method does not mutate the given argument.
     * 
     * @param mVector the pixel vector to scale
     * @return a new {@link Vector2} object representing the scaled vector.
     */
    public static Vector2 metersToPixels(Vector2 mVector) {
        return new Vector2(mVector.x * Physics.pixelsPerMeter, mVector.y * Physics.pixelsPerMeter);
    }

    /**
     * Convert a dimension of pixels to meters for
     * {@link com.badlogic.gdx.physics.box2d.Box2D Box2D}
     * 
     * @param pixels the dimension to convert
     * @return the dimension converted to meters
     */
    public static float pixelsToMeters(float pixels) {
        return pixels / Physics.pixelsPerMeter;
    }

    /**
     * Scale a vector. This method does not mutate the given argument.
     * 
     * @param pVector the pixel vector to scale
     * @return a new {@link Vector2} object representing the scaled vector.
     */
    public static Vector2 pixelsToMeters(Vector2 pVector) {
        return new Vector2(pVector.x / Physics.pixelsPerMeter, pVector.y / Physics.pixelsPerMeter);
    }
}
