package GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by zhitnikov.bronislav on 07.10.2015.
 */
public class Anomaly implements GameObject {

    private int Width=100;
    private int Height=100;
    private int X;
    private int Y;
    private int Power=100;

    private Image img;
    private  GameObject Owner;
    private ArrayList<Spirit> Spirits;

    public  Anomaly(int x,int y){
        X=x;
        Y=y;
        img=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = img.getGraphics();
        graphics.setColor(Color.YELLOW);
        graphics.drawOval(0, 0, Width-1, Height-1);
        Spirits=new ArrayList<Spirit>();
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

    }

    @Override
    public void destroy(World world) {

    }

    @Override
    public void Action(World world, GameObject actor) {

    }

    @Override
    public String GetType() {
        return "Anomaly";
    }
}
