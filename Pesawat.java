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
    private int ROF;
    public int tipeSenjata = 1;
    public void act()
    {
        kontrol();
        if (jedaTembak > 0) jedaTembak--;
        if (jedaTembak == 0) jedaTembak=ROF;
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
            switch(tipeSenjata){
            case 1 : bedil(); break;
            case 2 : repeater(); break;
            case 3 : tigaArah(); break;
            }
            //bedil();
            //repeater();
            //tigaArah();
        }
    }
    
    // Tipe Senjata
    private void bedil()
    {
        ROF = 20;
        if (jedaTembak ==1) getWorld().addObject(new laser(),getX()+60,getY());
    }
    private void repeater()
    {
        ROF = 40;
        if (jedaTembak ==1){
            int i = 0;
            do {
                getWorld().addObject(new laser(),getX()+(40*i),getY());
                i++;
            } while(i<4);
        }
    }
    private void tigaArah()
    {
        ROF = 20;
        if (jedaTembak ==1) 
        {
            for (int i=1; i<4; i++)
            {
                laser laser = new laser();
                getWorld().addObject(laser,getX()+60,getY()); 
                laser.setRotation((45*i)-90);
            }
        }
    }
    private void megaCanon()
    {
        
    }
}
