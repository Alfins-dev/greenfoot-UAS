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
    public int skor=0;
    public int nyawa=3;
    //public int timer;
    public int perisai=3;
    private int regenerate=1;
    private int regen;
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
        Shield();
        regenPerisai();
    }
    
    // HUD
    private void Nyawa(){
        showText("Nyawa : "+nyawa,84,30);
    }
    private void Shield(){
        showText("Perisai : "+perisai,500,30);
    }
    private void Score(){
        showText("Skor : "+skor,900,30);
    }
    
    // Hitung Skor
    public void hitungSkor(int points)
    {
        skor += points;
    }
    
    // Fungsi Perisai
    public int statPerisai(){
        return perisai;
    }
    public void hitPerisai(int hit){
        perisai += hit;
    }
    public void hitNyawa(int hit){
        nyawa += hit;
    }
    private void regenPerisai(){
        
        if(perisai<3){
            regen = (regen+1)%100;
            if (regen == 0) perisai+=regenerate;
        }
    }
    
    // Status pemain
    private void Status()
    {
        if(skor>1000) {
            //showText("Anda Menang", 500, 500);
            addObject(new Dialog(), getWidth()/2, getHeight()/2);
            Dialog kotak = getObjects(Dialog.class).get(0);
            kotak.tampilDialog("KAMU MENANG", "SCORE KAMU : " +skor);
            Greenfoot.stop();
        }
    }
    
    // Spawner
    private void spawnMusuh()
    {
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Musuh(), 1000, nomorAcak(50,550));
        }
    }
    private void spawnBonus()
    {
        List adaBonus = getObjects(bonus.class);
        if (Greenfoot.getRandomNumber(1000) < 1 && adaBonus.size() == 0)
        {
            int RNG = Greenfoot.getRandomNumber(3);
            switch (RNG) {
            case 0 : addObject(new bonus1(), 1000, nomorAcak(50,550)); break;
            case 1 : addObject(new bonus2(), 1000, nomorAcak(50,550)); break;
            case 2 : addObject(new bonus3(), 1000, nomorAcak(50,550)); break;
            }
        }
    }
    public void respawn(){
        if (nyawa>0){
            Pesawat pesawat = new Pesawat();
            addObject(pesawat,86,287);
            perisai = 3;
        } else {
            addObject(new Dialog(), getWidth()/2, getHeight()/2);
            Dialog kotak = getObjects(Dialog.class).get(0);
            kotak.tampilDialog("KAMU KALAH", "SCORE KAMU : " +skor);
            Greenfoot.stop();
        }
    }
    
    // RNG (Random NumberGenerator) untuk selisih angka 
    public int nomorAcak(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    //Debug
}
