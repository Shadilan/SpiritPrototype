package GameObjects;

import java.awt.*;

/**
 * Created by zhitnikov.bronislav on 07.10.2015.
 */
public interface GameObject {
    public Image draw();
    public int GetX();
    public int GetY();
    public int GetWidth();
    public int GetHeight();
    public int GetRadius();

    public void Tick(World world);
    public void destroy(World world);
    public void Action(World world,GameObject actor);
    public String GetType();

}
