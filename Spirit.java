package GameObjects;

import java.awt.*;

/**
 * Created by zhitnikov.bronislav on 07.10.2015.
 */
public class Spirit implements GameObject{

    private int Width=100;
    private int Height=100;
    private int X;
    private int Y;
    @Override
    public Image draw() {
        return null;
    }

    @Override
    public int GetX() {
        return 0;
    }

    @Override
    public int GetY() {
        return 0;
    }

    @Override
    public int GetWidth() {
        return 0;
    }

    @Override
    public int GetHeight() {
        return 0;
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
        return null;
    }
}
