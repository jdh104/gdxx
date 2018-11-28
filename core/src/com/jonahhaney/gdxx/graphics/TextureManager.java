package com.jonahhaney.gdxx.graphics;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.jonahhaney.gdxx.disposing.Disposable;

/**
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class TextureManager implements Disposable {

    private HashMap<String, Texture> textures = new HashMap<String, Texture>();

    /**
     * 
     */
    public TextureManager() {

    }
    
    /**
     * 
     * @param pathToFile
     * @param key
     */
    public void load(String pathToFile, String key) {
        this.textures.put(key, new Texture(Gdx.files.internal(pathToFile)));
    }

    /**
     * 
     * @param key
     * @return
     */
    public Texture get(String key) {
        return this.textures.get(key);
    }

    @Override
    public void dispose() {
        for (String key : this.textures.keySet()) {
            this.textures.get(key).dispose();
            this.textures.remove(key);
        }
    }

    /**
     * 
     * @param key
     */
    public void dispose(String key) {
        Texture t = this.textures.get(key);
        if (t != null) {
            t.dispose();
        }
    }
}
