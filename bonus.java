import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bonus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bonus extends Actor
{
    protected int bonus;
    protected int tipeBonus;
    /**
     * Act - do whatever the bonus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        gerak();
    }
    protected void gerak()
    {
        move(-1);
        if (isAtEdge()) getWorld().removeObject(this);
    }
    protected void dptBonus()
    {
        if(isTouching(Pesawat.class))
        {
            MyWorld m=(MyWorld)getWorld();
            m.hitungSkor(bonus);
            Pesawat pesawat = (Pesawat) getWorld().getObjects(Pesawat.class).get(0);
            pesawat.tipeSenjata = tipeBonus;
            getWorld().removeObject(this);
            //Greenfoot.playSound("meledak.mp3");
        }
    }
    
}
