import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spark extends Actor
{
    private int jeda=7;
    /**
     * Act - do whatever the spark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(jeda>0)
        {
            jeda--;
        } else {
            getWorld().removeObject(this);
        }
    }
}
