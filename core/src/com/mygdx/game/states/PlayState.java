package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Ball;
import com.mygdx.game.sprites.Wall;

import java.util.ArrayList;

public class PlayState extends State{


    private Ball ball;
    private Wall wall;
    private Texture trophy;
    private Texture camino;
    private boolean finalstate = false;
    long start,end;
    public float tiempoTotal=0;
    private int[] aleatorios = new int[40];
    public ArrayList<Wall> array = new ArrayList<Wall>();





    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);


        ball = new Ball();
        wall = new Wall(0,0);
        array.add(wall);
        trophy = new Texture("trofeo2.png");
        camino = new Texture("camino2.png");
        setaleatorios();

        start = System.currentTimeMillis();


    }

    public void setaleatorios() {
        aleatorios[0]=1;
        for(int i = 1;i<aleatorios.length;i++){
            aleatorios[i] = (int)Math.floor(Math.random()*3);
        }


    }

    public int getaleatorios(int cont) {
        return aleatorios[cont];
    }


    @Override
    protected void handleInput() {

        if(Gdx.input.isTouched()){

            int x = Gdx.input.getX();
            int y = MyGdxGame.HEIGHT - Gdx.input.getY();
            ball.up(x,y);

        }else{
            int x = 110;
            int y = 410;
            ball.up(x,y);
        }
        if(finalstate)
            gsm.set(new FinalState(gsm));
    }

    @Override
    protected void update(float dt) {
        handleInput();
        for(int i=0;i<array.size();i++)
        {
            if(array.get(i).collides(ball.getBounds())){

                tiempoTotal += 1; //cambiar tiempo

            }


        }

        ball.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        //spriteBatch.setProjectionMatrix(camera.combined);
        int contador = 0;
        int alea = 0;
        spriteBatch.begin();




        for(int i=0; i<MyGdxGame.WIDTH;i++){
            for(int j=0;j<MyGdxGame.HEIGHT;j++){
                if(i==0 && j%99==0 || j==0 && i%99==0 || i==(MyGdxGame.WIDTH) && j%99==0 || i%99==0 && j==(MyGdxGame.HEIGHT)  || i%99==0 && j%99==0){
                    wall = new Wall(i,j);
                    array.add(wall);

                    spriteBatch.draw(wall.getWall(),i,j);
                }


            }
        }



        int x = 99;
        int y = 396;

        //pintar inicio
        spriteBatch.draw(camino,x,y);
        //spriteBatch.draw(camino,x+99,y);
       // spriteBatch.draw(camino,x,y+99);
        //spriteBatch.draw(camino,x+99,y+99);

        for(int i=0; i<aleatorios.length; i++)
        {
            alea =  getaleatorios(i);


            switch(alea){
                case 0:


                    if(y<MyGdxGame.WIDTH-300 && x<MyGdxGame.HEIGHT-300){
                        if(i==0){
                            x = x+99;
                            spriteBatch.draw(camino,x,y);
                            //spriteBatch.draw(camino,x+99,y);
                            //spriteBatch.draw(camino,x,y+99);
                            //spriteBatch.draw(camino,x+99,y+99);
                            y = y + 99;
                            spriteBatch.draw(camino, x, y);
                            //spriteBatch.draw(camino, x, y + 99);
                            //spriteBatch.draw(camino, x + 99, y);
                            //spriteBatch.draw(camino, x + 99, y + 99);

                        }else if(aleatorios[i-1]!=2){
                            x = x+99;
                            spriteBatch.draw(camino,x,y);
                            //spriteBatch.draw(camino,x+99,y);
                            //spriteBatch.draw(camino,x,y+99);
                            //spriteBatch.draw(camino,x+99,y+99);
                            y = y + 99;
                            spriteBatch.draw(camino, x, y);
                            //spriteBatch.draw(camino, x, y + 99);
                            //spriteBatch.draw(camino, x + 99, y);
                            //spriteBatch.draw(camino, x + 99, y + 99);

                        }

                    }

                    //}
                    break;
                case 1:
                    if(x < MyGdxGame.WIDTH-300){
                        x = x+99;
                        spriteBatch.draw(camino,x,y);
                        //spriteBatch.draw(camino,x+99,y);
                        //spriteBatch.draw(camino,x,y+99);
                        //spriteBatch.draw(camino,x+99,y+99);
                        //x = x+99;
                        //spriteBatch.draw(camino,x,y);
                        //spriteBatch.draw(camino,x+99,y);
                        //spriteBatch.draw(camino,x,y+99);
                        //spriteBatch.draw(camino,x+99,y+99);
                    }



                    break;
                case 2:
                    if(y<MyGdxGame.HEIGHT-100 && x<MyGdxGame.WIDTH-200 && y > 99) {
                        if(aleatorios[i-1]==1){
                            x = x+99;
                            spriteBatch.draw(camino,x,y);
                            //spriteBatch.draw(camino,x+99,y);
                            //spriteBatch.draw(camino,x,y+99);
                            //spriteBatch.draw(camino,x+99,y+99);
                            y=y-99;
                            spriteBatch.draw(camino,x,y);
                            //spriteBatch.draw(camino,x,y+99);
                            //spriteBatch.draw(camino,x+99,y);
                            //spriteBatch.draw(camino,x+99,y+99);


                        }
                    }

                    break;
            }

        }

        spriteBatch.draw(ball.getBall(), ball.getPosition().x,ball.getPosition().y);

        spriteBatch.draw(trophy,x+10,y);
        if(ball.getPosition().x > x+10 && ball.getPosition().y < y+10 && ball.getPosition().y > y-10) {
            finalstate = true;
            end = System.currentTimeMillis();
            System.out.println("Tiempo del recorrido : " + ((end - start) / 1000) + " seconds");
            System.out.println("Tiempo tocando paredes : " + tiempoTotal/1000 + " seconds");
            System.out.println("Probabilidad : " + String.format("%.2f", ((float)(tiempoTotal)/(float)(end - start)*100))+ " %");
            disposeTotal();
        }





        dispose();
        spriteBatch.end();

    }

    @Override
    public void dispose() {
        camino.dispose();
        wall.dispose();
        //ball.dispose();

    }

    public void disposeTotal(){
        ball.dispose();
        camino.dispose();
        wall.dispose();
        trophy.dispose();
    }
}
