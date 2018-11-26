package com.jonahhaney.gdxx;

import com.badlogic.gdx.ApplicationAdapter;

/**
 * TODO Implement
 * TODO Document
 * 
 * @author Jonah Haney
 */
public class Game extends ApplicationAdapter {/* TODO
	
	public static final float FIXED_TIME_STEP = (1f/60f);
	public static final Vector2 PLAYSTATE_GRAVITY_VECTOR = new Vector2(0, -9.81f);
	
	// virtual dimensions
	public static final float V_HEIGHT = 240f;
	public static final float V_WIDTH = 320f;
	public static final float V_SCALE = 2f;
	
	public static Content res;
	
	private float accumulated_time = 0;
	
	private OrthographicCamera cam;
	private OrthographicCamera hudCam;
	private SpriteBatch batch;
	
	private GameStateManager gsm;
	
	private Game() {
		
	}
	
	@Override
	public void create () {
		
		Gdx.input.setInputProcessor(new KeyListener());
		
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		hudCam = new OrthographicCamera();
		
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		hudCam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		
		gsm = GameStateManager.getGSM();
		gsm.pushState(new PlayState());
		
		res = new Content();
		
		{
			String pathToTexture = "blah/blah/blah.jpg";
			String keyForTexture = "blah";
			res.loadTexture(pathToTexture, keyForTexture);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public OrthographicCamera getCam() {
		return cam;
	}
	
	public static MyGdxGame getGame() {
		return (game == null ? (game = new MyGdxGame()) : game);
	}
	
	public OrthographicCamera getHudCam() {
		return hudCam;
	}

	public SpriteBatch getSpriteBatch() {
		return batch;
	}

	@Override
	public void render () {
		accumulated_time += Gdx.graphics.getDeltaTime();
		while (accumulated_time >= FIXED_TIME_STEP) {
			accumulated_time -= FIXED_TIME_STEP;
			gsm.update(FIXED_TIME_STEP);
			gsm.render();
		}
		
		MyInput.update();
	}*/
}
