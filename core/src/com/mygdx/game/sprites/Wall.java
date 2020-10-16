package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Wall {
    private Vector2 position;
    private Texture wall;


    private Rectangle boundsWall;


    public Wall(int x, int y){
        position = new Vector2(x,y);
        wall = new Texture("wall2.png");
        boundsWall = new Rectangle(position.x,position.y,wall.getWidth(),wall.getHeight());

    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsWall);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getWall() {
        return wall;
    }

    public void dispose(){
        wall.dispose();
    }


}
