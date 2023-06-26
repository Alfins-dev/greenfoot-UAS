import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet extends Actor
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        gerak();
    }
    
    public void gerak()
    {
        //setLocation(getX()-5,getY());
        move(-5);
        if(getX()<1)
        {
            getWorld().removeObject(this);
        }else{
            hit();
        }
    }
    
    public void hit()
    {
        if(isTouching(Pesawat.class))
        {
            getWorld().addObject(new spark(),getX(),getY());
            MyWorld m=(MyWorld)getWorld();
            m.hitungSkor(-100);
            getWorld().removeObject(this);
            //Greenfoot.playSound("meledak.mp3");
        }

    }
}
