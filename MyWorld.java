import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int skor=1000;
    public int nyawa=3;
    public int timer;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Pesawat pesawat = new Pesawat();
        addObject(pesawat,86,287);
        
    }
    
    // Fungsi Utama
    public void act()
    {
        spawnMusuh();
        spawnBonus();
        Nyawa();
        Score();
        Status();
    }
    
    // HUD
    public void Nyawa()
    {
        showText("Nyawa : "+nyawa,84,30);
    }
    private void Score()
    {
        showText("Skor : "+skor,900,30);
    }
    
    // Hitung Skor
    public void hitungSkor(int points)
    {
        skor = skor+points;
        //Score();
    }
    
    // Status pemain
    private void Status()
    {
        if(skor>1500) {
            //showText("Anda Menang", 500, 500);
            addObject(new Dialog(), getWidth()/2, getHeight()/2);
            Dialog kotak = getObjects(Dialog.class).get(0);
            kotak.tampilDialog("KAMU MENANG", "SCORE KAMU : " +skor);
            Greenfoot.stop();
        } else if(skor<0) {
            //showText("Anda Kalah", 500, 500);
            addObject(new Dialog(), getWidth()/2, getHeight()/2);
            Dialog kotak = getObjects(Dialog.class).get(0);
            kotak.tampilDialog("KAMU KALAH", "SCORE KAMU : " +skor);
            Greenfoot.stop();
        }
    }
    
    // Spawner
    private void spawnMusuh()
    {
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Musuh(), 1000, getRandomNumber(50,550));
        }
    }
    private void spawnBonus()
    {
        List adaBonus = getObjects(bonus.class);
        if (Greenfoot.getRandomNumber(1000) < 1 && adaBonus.size() == 0)
        {
            int RNG = Greenfoot.getRandomNumber(3);
            switch (RNG) {
            case 0 : addObject(new bonus1(), 1000, getRandomNumber(50,550)); break;
            case 1 : addObject(new bonus2(), 1000, getRandomNumber(50,550)); break;
            case 2 : addObject(new bonus3(), 1000, getRandomNumber(50,550)); break;
            }
        }
    }
    
    // RNG (Random NumberGenerator) untuk selisih angka 
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
}
