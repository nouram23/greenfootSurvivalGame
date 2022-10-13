import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heal extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Heal(){
       GreenfootImage image = getImage();
        image.scale(40, 30);
        setImage(image);}
    
    public void act()
    {
        // Add your action code here.
    }
}
