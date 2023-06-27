import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pesawat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pesawat extends Actor
{
    /**
     * Act - do whatever the Pesawat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int jedaTembak;
    public void act()
    {
        kontrol();
        if (jedaTembak > 0) jedaTembak--;
        
    }
    
    private void kontrol() 
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-6);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(6);
        }
        if (Greenfoot.isKeyDown("up"))
        {          
            setLocation(getX(), getY() - 6); 
        }
        if (Greenfoot.isKeyDown("down"))
        { 
            setLocation(getX(), getY() + 6);
        }
        if(Greenfoot.isKeyDown("Space"))
        {
            //getWorld().addObject(new laser(),getX()+60,getY());
            repeater();
        }
    }
    
    private void meriam()
    {
        if (jedaTembak == 0) jedaTembak=20;
        if (jedaTembak ==1) getWorld().addObject(new laser(),getX()+60,getY());
    }
    private void repeater()
    {
        if (jedaTembak == 0) jedaTembak=50;
        if (jedaTembak ==1){
            int i = 0;
            do {
                getWorld().addObject(new laser(),getX()+(20*i),getY());
                i++;
            } while(i<4);
        }
    }
}
