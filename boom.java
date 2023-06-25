import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boom extends Actor
{
    private int jeda=5;
    /**
     * Act - do whatever the boom wants to do. This method is called whenever
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
