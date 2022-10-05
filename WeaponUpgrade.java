import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeapenUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponUpgrade extends Actor
{
    /**
     * Act - do whatever the WeapenUpgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Counter counter;
    int status = 1;
    public WeaponUpgrade(Counter counter){
        this.counter = counter;
        setImage(new GreenfootImage("Weapen \n Upgrade", 25, Color.BLACK, new Color(0,0,0,0)));       
    }
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this) &&  counter.money > 99 && status < 4){
          
                 counter.money-=100;
                 status++;
                      
        }
    }
}
