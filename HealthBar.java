import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50;
    public HealthBar(){
        setImage(new GreenfootImage(52,12));
        getImage().drawRect(0, 0, 51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health, 10);
    }
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage(52,12));
        getImage().drawRect(0, 0, 51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health, 10);
          World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer().getX(),myWorld.getPlayer().getY() - 40);
        loseHealth();   
        heal();
    }
    public void loseHealth(){
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getPlayer().hitByZombie()){
            health--;
        }
        if(health<= 0){
             getWorld().showText("You Lose! - You lasted "+ (myWorld.getPlayer().time/60) + "seconds" , getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
      public void heal(){
        Actor heal = getOneObjectAtOffset(0, 0, Heal.class);
         if(heal !=null){
           if(health < 50){
             health+=10;
            }
          getWorld().removeObject(heal);
        }
    }
 
     
}
