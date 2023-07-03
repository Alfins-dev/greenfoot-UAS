import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class laser extends Actor
{
    /**
     * Act - do whatever the laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public laser(int rotation){
        setImage("laser.png");
        setRotation(rotation);
    }
    
    public void act()
    {
        gerak();
    }
    
    public void gerak()
    {
        //setLocation(getX()+10,getY());
        move(10);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }else{
            hit();
        }
    }
    
    public void hit()
    {
        if(isTouching(Musuh.class))
        {
            getWorld().addObject(new boom(),getX(),getY());
            MyWorld m=(MyWorld)getWorld();
            m.hitungSkor(10);
            //Greenfoot.playSound("explosion.wav");
            removeTouching(Musuh.class);
            getWorld().removeObject(this);
        }
    }
    
}
