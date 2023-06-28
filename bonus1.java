import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bonus1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bonus1 extends bonus
{
    
    /**
     * Act - do whatever the bonus1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        gerak();
        bonus = 20;
        tipeBonus = 1;
        dptBonus();
    }
}
