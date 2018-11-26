package com.jonahhaney.gdxx;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 *
 * @param <V> The value type associated with this setting.
 */
public class Setting <V extends Object> {
	
	private String name;
	private V defaultValue;
	private V value = null;
	
	/**
	 * 
	 * @param name
	 * @param defaultValue
	 */
	public Setting(String name, V defaultValue) {
		this.name = name;
		this.defaultValue = defaultValue;
	}
	
	/**
	 * 
	 * @return
	 */
	public V getDefaultValue() {
		return defaultValue;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public V getValue() {
		return value == null ? defaultValue : value;
	}
	
	/**
	 * 
	 */
	public void resetToDefault() {
		value = null;
	}
	
	/**
	 * 
	 * @param newValue
	 */
	public void setValue(V newValue) {
		value = newValue;
	}
}
