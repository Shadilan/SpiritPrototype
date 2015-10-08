package GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by zhitnikov.bronislav on 07.10.2015.
 */
public class Player implements GameObject {

    Image img;
    Graphics graphics;
    int X;
    int Y;
    int Width;
    int Height;
    int Life;
    int Energy;
    int Power;
    ArrayList<Spirit> Spirits;
    public Player(int x,int y){
        Width=40;
        Height=40;
        X=x;
        Y=y;
        Life=20;
        Energy=20;
        Power=0;

        img=new BufferedImage(40,40,BufferedImage.TYPE_INT_ARGB);
        graphics = img.getGraphics();
        graphics.setColor(Color.white);
        //graphics.clearRect(0, 0, Width, Height);

        double rnd=Math.random();
        int www=(int) rnd*Width;
        int hhh=(int) rnd*Height;
        graphics.setColor(Color.white);
        graphics.drawOval(0, 0, Width-1, Height-1);
        Spirits=new ArrayList<Spirit>();

    }
    public  void Move(int xcoord,int ycoord){
        X+=xcoord;
        Y+=ycoord;
    }
    @Override
    public Image draw() {
        return img;
    }

    @Override
    public int GetX() {
        return X;
    }

    @Override
    public int GetY() {
        return Y;
    }

    @Override
    public int GetWidth() {
        return Width;
    }

    @Override
    public int GetHeight() {
        return Height;
    }

    @Override
    public void Tick(World world) {
       /* Graphics graphics = img.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.clearRect(0, 0, Width, Height);

        double rnd=Math.random();
        int www=(int) rnd*Width;
        int hhh=(int) rnd*Height;
        graphics.setColor(Color.BLACK);
        graphics.drawOval(0,0,Width,Height);
        graphics.drawLine(www,0,Width-www,Height);
        graphics.drawLine(0,hhh,Width,Height-hhh);*/
    }

    @Override
    public void destroy(World world) {

    }

    @Override
    public void Action(World world, GameObject actor) {

    }

    @Override
    public String GetType() {
        return "Player";
    }
}
