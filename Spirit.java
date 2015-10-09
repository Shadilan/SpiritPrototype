package GameObjects;

import sun.org.mozilla.javascript.internal.ast.WithStatement;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.rmi.MarshalledObject;
import java.security.acl.Owner;

/**
 * Created by Shadilan on 07.10.2015.
 */
public class Spirit implements GameObject{

    private int Width=40;
    private int Height=40;
    private int X;
    private int Y;
    private int faze=1;
    private GameObject owner;

    private Image img1;
    private Image img2;
    private Image img3;


    public Spirit(int x,int y,GameObject owner){
        img1=new BufferedImage(40,40,BufferedImage.TYPE_INT_ARGB);
        Graphics gr=img1.getGraphics();
        gr.setColor(Color.GRAY);
        gr.drawLine(1, 1, 38, 1);
        gr.drawLine(1, 1, 19, 38);
        gr.drawLine(38,1,19,38);
        gr.setColor(Color.yellow);
        gr.fillOval(10, 10, 5, 5);
        gr.fillOval(24, 10, 5, 5);
        img2=new BufferedImage(40,40,BufferedImage.TYPE_INT_ARGB);
        gr=img2.getGraphics();
        gr.setColor(Color.GRAY);
        gr.drawLine(1, 1, 38, 1);
        gr.drawLine(1, 1, 19, 38);
        gr.drawLine(38, 1, 19, 38);
        gr.setColor(Color.orange);
        gr.fillOval(10, 10, 5, 5);
        gr.fillOval(24, 10, 5, 5);
        img3=new BufferedImage(40,40,BufferedImage.TYPE_INT_ARGB);
        gr=img3.getGraphics();
        gr.setColor(Color.GRAY);
        gr.drawLine(1, 1, 38, 1);
        gr.drawLine(1, 1, 19, 38);
        gr.drawLine(38, 1, 19, 38);
        gr.setColor(Color.red);
        gr.fillOval(10, 10, 5, 5);
        gr.fillOval(24, 10, 5, 5);
        X=x;
        Y=y;
        this.owner=owner;
    }
    @Override
    public Image draw() {
        if (faze==1) return img1;
        else if (faze==3) return img3;
        else return img2;

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
    public int GetRadius() {
        return 20;
    }

    @Override
    public void Tick(World world) {
        faze++;
        if (faze>4) faze=1;
    }

    @Override
    public void destroy(World world) {

    }

    @Override
    public void Action(World world, GameObject actor) {

    }

    @Override
    public String GetType() {
        return "Spirit";
    }
    public GameObject GetOwner(){
        return owner;
    }
    public void SetOwner(GameObject owner){
        this.owner=owner;
    }
}
