import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Charge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charge extends Actor
{
    int x;
    int y;
    int rad=10;
    
    public Charge(int rad)
    {
        setImage(new GreenfootImage(2*rad, 2*rad));
        getImage().setColor(Color.YELLOW);
        getImage().fillOval(0,0,2*rad,2*rad);
    }
    
    /**
     * Act - do whatever the Charge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
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
        }
        if(isTouching(bullet.class))
        {
            removeTouching(bullet.class);
        }
    }
}
