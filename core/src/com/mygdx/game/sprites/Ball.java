package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Ball {

    private static final int GRAVITY = -15;

    private Vector3 position;
    //private Vector3 velocity;

    private int auxdex = 0;
    private int auxdey = 0;

    private Texture ball;
    private Rectangle bounds;

    public Ball(){
        position = new Vector3(40,40,0);
        //velocity = new Vector3(0,0,0);
        ball = new Texture("bola.png");
        bounds = new Rectangle(position.x,position.y,ball.getWidth(),ball.getHeight());
    }

    public void update(float dt){
        //velocity.add(0,GRAVITY,0);
        //velocity.scl(dt);
        //position.add(0,velocity.y,0);
        //velocity.scl(1/dt);
        position.x = auxdex;
        position.y = auxdey;
        bounds.setPosition(position.x,position.y);
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBall() {
        return ball;
    }

    public void up(int x, int y){
        auxdex = x;
        auxdey = y;
    }

    public void dispose(){
        ball.dispose();
    }
}
