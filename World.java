package GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Shadilan on 07.10.2015.
 */
public class World {
    private int CenterX;
    private int CenterY;
    private int VisibleWidth;
    private int VisibleHeight;
    private int Height;
    private int Width;
    private ArrayList<GameObject> Objects;
    private ArrayList<GameObject> ObjToAdd;
    private ArrayList<GameObject> ObjToRem;
    public World(int width, int height,int visibleWidth,int visibleHeight,int centerX,int centerY){
        Width=width;
        Height=height;
        VisibleHeight=visibleHeight;
        VisibleWidth=visibleWidth;
        CenterX=centerX;
        CenterY=centerY;
        ObjToAdd=new ArrayList<GameObject>();
        ObjToRem=new ArrayList<GameObject>();
        Objects=new ArrayList<GameObject>();
    }
    public World(int width, int height,int visibleWidth,int visibleHeight){
        Width=width;
        Height=height;
        VisibleHeight=visibleHeight;
        VisibleWidth=visibleWidth;
        CenterX=width/2;
        CenterY=height/2;
        ObjToAdd=new ArrayList<GameObject>();
        ObjToRem=new ArrayList<GameObject>();
        Objects=new ArrayList<GameObject>();


    }
    public void SetCenter(int x,int y){
        CenterY=y;
        CenterX=x;
    }
    public void AddObject(GameObject obj){
        ObjToAdd.add(obj);
    }
    public void RemoveObject(GameObject obj){

        ObjToRem.remove(obj);

    }

    public void Draw(Canvas canvas){
        Image img=canvas.createImage(VisibleWidth,VisibleHeight);
        Graphics bufferGraphics=img.getGraphics();

        //Graphics bufferGraphics=img.getGraphics();
        //Graphics bufferGraphics=canvas.getGraphics();
        bufferGraphics.setColor(Color.cyan);
        int smX=(CenterX%100);
        int smY=(CenterY%100);
        for (int i=0;i<Math.round(VisibleWidth/100)+2;i++){
            int ix=i*100-smX;
            bufferGraphics.drawLine(ix,0,ix,VisibleHeight);
        }
        for (int i=0;i<Math.round(VisibleHeight/100)+2;i++){
            int iy=i*100-smY;
            bufferGraphics.drawLine(0,iy,VisibleWidth,iy);
        }
        for (GameObject obj:Objects){
            int objX=obj.GetX();
            int objY=obj.GetY();

            if (objX>CenterX-VisibleWidth/2 && objX<CenterX+VisibleWidth/2 && objY>CenterY-VisibleHeight/2 && objY<CenterY+VisibleHeight/2){
                Image objImg=obj.draw();
                bufferGraphics.drawImage(objImg,objX-obj.GetWidth()/2-(CenterX-VisibleWidth/2),objY-obj.GetHeight()/2-(CenterY-VisibleHeight/2),null);
            }
        }
        bufferGraphics.setColor(Color.gray);
        bufferGraphics.drawString("x:" + CenterX, 0, 10);
        bufferGraphics.drawString("y:"+CenterY,0,20);
        canvas.getGraphics().drawImage(img, 0, 0, null);

    }
    public  void Tick(){
        Objects.removeAll(ObjToRem);
        Objects.addAll(ObjToAdd);
        for (GameObject obj:Objects){
            obj.Tick(this);
        }
    }

}
