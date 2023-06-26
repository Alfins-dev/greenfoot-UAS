import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialog extends Actor
{
    /**
     * Act - do whatever the Dialog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public static final float FONTSIZE = 40.0f;
    public static final int WIDTH    = 400;
    public static final int HEIGHT   = 300;
    
    public void tampilDialog(String info, String info2)
    {
        GreenfootImage image = new GreenfootImage(WIDTH,HEIGHT);
        image.setColor(new Color(0, 0, 0, 100));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONTSIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(info, 60, 100);
        image.drawString(info2, 10, 200);
        setImage(image);
    }
}
