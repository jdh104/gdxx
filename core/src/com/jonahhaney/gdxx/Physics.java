package com.jonahhaney.gdxx;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Physics {

    public static final float DEFAULT_PPM = 100f;
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
