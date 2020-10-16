package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class FinalState extends State {

    private Texture mensajefinal;

    protected FinalState(GameStateManager gameStateManager) {
        super(gameStateManager);
        mensajefinal = new Texture("final.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();

        spriteBatch.draw(mensajefinal,(MyGdxGame.WIDTH/2-mensajefinal.getWidth()/2),(MyGdxGame.HEIGHT/2-mensajefinal.getHeight()/2));
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
