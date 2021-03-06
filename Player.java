package GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Shadilan on 07.10.2015.
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
    Image StatView;
    ArrayList<Spirit> Spirits;
    public Image drawStat(){
       StatView=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
        Graphics gr=StatView.getGraphics();
        gr.clearRect(0, 0, 100, 100);
        gr.setColor(Color.white);
        gr.drawString("Life:", 5, 10);
        gr.drawString("Energy:",5,20);
        gr.drawString("Power:",5,30);
        gr.drawString("Spirits:",5,40);
        gr.drawString(""+Life,50,10);
        gr.drawString(""+Energy,50,20);
        gr.drawString(""+Power,50,30);
        gr.drawString("" + Spirits.size(), 50, 40);
        return StatView;

    }
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
        graphics.drawOval(0, 0, Width - 1, Height - 1);
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
    public int GetRadius() {
        return 20;
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
    public void Act(World world){
        System.out.println("Act");
        ArrayList<GameObject> Intersects=world.getObject(X,Y,GetRadius());
        GameObject Target=null;
        for (GameObject obj:Intersects){
            if (obj!=this){
                Target=obj;
                break;
            }
        }
        if (Target!=null) {
            System.out.println("Target Take");
            if (Target.GetType().equals("Anomaly")) {
                System.out.println("Anomaly");
                if (((Anomaly)Target).GetOwner()!=this && Life>=5) {
                    Life -= 5;
                    Energy += 5;
                }
            } else if (Target.GetType().equals("Spirit")) {
                System.out.println("Spirit");
                if (((Spirit)Target).GetOwner()!=null) {
                    System.out.println("Owner not NULL");
                    if (((Anomaly)((Spirit)Target).GetOwner()).GetOwner()==null) {
                        System.out.println("Anomaly owner NULL");
                        if (Spirits.size()<Power/10+10) {
                            System.out.println("We have Energy to catch");
                            ((Anomaly) ((Spirit) Target).GetOwner()).RemoveSpirit((Spirit) Target);
                            ((Spirit) Target).SetOwner(this);
                            world.RemoveObject(Target);
                            Spirits.add((Spirit) Target);
                            Energy-=5;
                        }
                    }
                } else
                {
                    System.out.println("Spirit owner NULL");
                    if (Spirits.size()<Power/10+10) {
                        System.out.println("We have Energy to catch");

                        ((Spirit) Target).SetOwner(this);
                        world.RemoveObject(Target);
                        Spirits.add((Spirit) Target);
                        Energy-=5;
                    }
                }

            }
            ;
        }
    }
}
