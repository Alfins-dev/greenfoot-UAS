import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bonus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bonus extends Actor
{
    /**
     * Act - do whatever the bonus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        gerak();
    }
    protected void gerak()
    {
        move(-1);
        if (getX() == 10){
            getWorld().removeObject(this);
        }
    }
}
