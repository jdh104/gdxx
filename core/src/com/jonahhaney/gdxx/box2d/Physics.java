package com.jonahhaney.gdxx.box2d;

import java.awt.AWTError;
import java.awt.HeadlessException;
import java.awt.Toolkit;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Physics {

    public static final float DEFAULT_ACCEL_GRAVITY = -9.81f;
    public static final float INCHES_PER_METER = 39.37f;
    private static final int STANDARD_PPI = 72;

    /**
     * Actual-size calculation using Java Toolkit screen resolution API
     */
    public static final float DEFAULT_PPM;

    // Calculate actual-size ppm
    static {
        float default_ppm = (float)STANDARD_PPI * INCHES_PER_METER;
        try {
            default_ppm = Toolkit.getDefaultToolkit().getScreenResolution() * INCHES_PER_METER;
        } catch (AWTError | HeadlessException ex) {
            System.err.println("Could not get screen resolution, using industry standard of " + STANDARD_PPI + " ppi instead.");
        } finally {
            DEFAULT_PPM = default_ppm;
        }
    }

    public static float accelGravity = DEFAULT_ACCEL_GRAVITY;
    public static float pixelsPerMeter = DEFAULT_PPM;

    /**
     * 
     * @param meters
     * @return
     */
    public static float metersToPixels(float meters) {
        return meters * Physics.pixelsPerMeter;
    }

    /**
     * 
     * @param pixels
     * @return
     */
    public static float pixelsToMeters(float pixels) {
        return pixels / Physics.pixelsPerMeter;
    }
}
