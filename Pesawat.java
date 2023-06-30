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
    public int tipeSenjata=0;
    
    int animateImage = 7;
    int animateSpeed = 5;
    int count;
    
    public void act()
    {
        kontrol();
        if (jedaTembak > 0) jedaTembak--;
        if (jedaTembak == 0) jedaTembak=ROF;
        animate();
    }
    
    private void animate(){
        if (count % animateSpeed == 0)
        {
            if (animateImage == 7)
            {
                animateImage = 1;
            }
            setImage("plane"+animateImage+".png");
            animateImage++;
            getImage().scale(100, 50);
        }
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
            switch(tipeSenjata){
            case 0 : bedil(); break;
            case 1 : dual(); break;
            case 2 : repeater(); break;
            case 3 : tigaArah(); break;
            }
        }
    }
    
    // Tipe Senjata
    private void bedil()
    {
        ROF = 20;
        if (jedaTembak ==1) getWorld().addObject(new laser(),getX()+60,getY()+10);
    }
    private void dual()
    {
        ROF = 20;
        if (jedaTembak ==1) {
            getWorld().addObject(new laser(),getX()+60,getY()+20);
            getWorld().addObject(new laser(),getX()+60,getY()+10);
        }
    }
    private void repeater()
    {
        ROF = 40;
        if (jedaTembak ==1){
            int i = 0;
            do {
                getWorld().addObject(new laser(),getX()+(40*i),getY()+10);
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
                getWorld().addObject(laser,getX()+60,getY()+10); 
                laser.setRotation((45*i)-90);
            }
        }
    }
    
    // Status
    public void terTembak(int damage)
    {
        MyWorld w=(MyWorld)getWorld();
        int perisai = w.statPerisai();
        if(perisai>0){
            w.hitPerisai(damage);
            getWorld().addObject(new spark(),getX(),getY());
        } else {
            w.hitNyawa(-1);
            getWorld().addObject(new boom(),getX(),getY());
            w.removeObject(this);
            w.hitungSkor(-100);
            w.respawn();
        }
    }
    
}
