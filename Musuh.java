import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Musuh extends Actor
{
    private int jeda=0;
    int animateImage = 5;
    int animateSpeed = 5;
    int count;
    /**
     * Act - do whatever the Musuh wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        bergerak();
        menembak();
        animate();
    }
    
    private void animate(){
        if (count % animateSpeed == 0)
        {
            if (animateImage == 5)
            {
                animateImage = 1;
            }
            setImage("enemy"+animateImage+".png");
            animateImage++;
            getImage().scale(62, 30);
        }
    }
    
    private void bergerak()
    {
        //setLocation(getX()-1, getY());
        move(-1);
        //if (getX() == 10){
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }else{
            tabrak();
        }
    }
    
    private void menembak()
    {
        if(jeda>0)jeda--;
        if(jeda==1)getWorld().addObject(new bullet(0),getX(),getY());
        if(jeda==0)jeda=120;
    }
    
    private void tabrak()
    {
        if(isTouching(Pesawat.class))
        {
            getWorld().addObject(new boom(),getX(),getY());
            MyWorld w=(MyWorld)getWorld();
            //m.hitungSkor(-90);
            (w.getObjects(Pesawat.class).get(0)).terTembak(-1);
            getWorld().removeObject(this);
            //Greenfoot.playSound("meledak.mp3");
        }

    }
    
}
