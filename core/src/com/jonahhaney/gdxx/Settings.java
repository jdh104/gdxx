package com.jonahhaney.gdxx;

import java.util.HashMap;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Settings {
	
	public static int DEFAULT_FRAME_RATE = 60;
	
	private static volatile Settings instance = new Settings();
	
	private HashMap<String, Setting<? super Object>> settings = new HashMap<String, Setting<? super Object>>();
	
	private int frameRate = DEFAULT_FRAME_RATE;
	private float frameStepTime = 1 / (float)DEFAULT_FRAME_RATE;
	
	/**
	 * 
	 */
	private Settings() { }
	
	/**
	 * 
	 * @param newSetting
	 */
	public static void addSetting(Setting<? super Object> newSetting) {
		instance.settings.put(newSetting.getName(), newSetting);
	}
	
	/**
	 * 
	 * @return
	 */
	public static int getFrameRate() {
		return instance.frameRate;
	}
	
	/**
	 * 
	 * @return
	 */
	public static float getFrameStepTime() {
		return instance.frameStepTime;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Setting<? super Object> getSetting(String name) {
		return instance.settings.get(name);
	}
	
	/**
	 * 
	 * @param newFrameRate
	 */
	public static void setFrameRate(int newFrameRate) {
		instance.frameRate = newFrameRate;
		instance.frameStepTime = 1 / (float)newFrameRate;
	}
	
	/**
	 * 
	 */
	public static void resetAllDefaults() {
		Settings.setFrameRate(Settings.DEFAULT_FRAME_RATE);
		
		for (Setting<? super Object> setting : instance.settings.values()) {
			setting.resetToDefault();
		}
	}
}
