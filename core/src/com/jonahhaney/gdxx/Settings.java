package com.jonahhaney.gdxx;

import java.util.HashMap;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Settings {

    public static float DEFAULT_FRAME_RATE = 60f;
    public static float DEFAULT_HEIGHT = 100f;
    public static float DEFAULT_SCALE = 1f;
    public static float DEFAULT_WIDTH = 100f;

    private HashMap<String, Setting<? super Object>> settings = new HashMap<String, Setting<? super Object>>();

    private float frameRate = DEFAULT_FRAME_RATE;
    private float frameStepTime = 1 / DEFAULT_FRAME_RATE;
    private float vHeight = DEFAULT_HEIGHT;
    private float vWidth = DEFAULT_WIDTH;
    private float vScale = DEFAULT_SCALE;

    /**
     * 
     */
    public Settings() {

    }

    /**
     * 
     * @param newSetting
     */
    public void addSetting(Setting<? super Object> newSetting) {
        this.settings.put(newSetting.getName(), newSetting);
    }

    /**
     * 
     * @return
     */
    public float getFrameRate() {
        return this.frameRate;
    }

    /**
     * 
     * @return
     */
    public float getFrameStepTime() {
        return this.frameStepTime;
    }

    /**
     * 
     * @return
     */
    public float getHeight() {
        return this.vHeight;
    }

    /**
     * 
     * @return
     */
    public float getScale() {
        return this.vScale;
    }

    /**
     * 
     * @return
     */
    public float getWidth() {
        return this.vWidth;
    }

    /**
     * 
     * @param name
     * @return
     */
    public Setting<? super Object> getSetting(String name) {
        return this.settings.get(name);
    }

    /**
     * 
     * @param newFrameRate
     */
    public void setFrameRate(float newFrameRate) {
        this.frameRate = newFrameRate;
        this.frameStepTime = 1 / newFrameRate;
    }

    /**
     * 
     * @param vHeight
     * @param vWidth
     * @param vScale
     */
    public void setVirtualDimensions(float vHeight, float vWidth, float vScale) {
        this.vHeight = vHeight;
        this.vWidth = vWidth;
        this.vScale = vScale;
    }

    /**
     * 
     */
    public void resetAllDefaults() {
        this.setFrameRate(Settings.DEFAULT_FRAME_RATE);

        for (Setting<? super Object> setting : this.settings.values()) {
            setting.resetToDefault();
        }
    }
}
