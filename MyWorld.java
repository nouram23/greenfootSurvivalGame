import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count = 0;
    int spawnSpeed = 50;
     int randomSpawn;
    public Player mainPlayer = new Player();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    WeaponUpgrade weaponupgrade = new WeaponUpgrade(counter);
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        mainPlayer = new Player(weaponupgrade);
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 110, 50);
        addObject(healthbar, mainPlayer.getX(), mainPlayer.getY()-40);
        addObject(weaponupgrade, 700, 60);
    }
    public Player getPlayer(){
        return mainPlayer;
    }
    public void act(){
        count++;
       spawnZombies();
    }
    public void spawnZombies(){
         if(count % spawnSpeed == 0){
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn){
                case 0 : addObject(new Zombie(mainPlayer ,counter), 0,0); break;
                case 1 : addObject(new Zombie(mainPlayer , counter), getWidth()/2 ,0); break;
                case 2 : addObject(new Zombie(mainPlayer, counter), getWidth() ,0); break;
                case 3 : addObject(new Zombie(mainPlayer, counter), 0 ,getHeight()/2); break;
                case 4 : addObject(new Zombie(mainPlayer, counter), 0,getHeight()); break;
                case 5 : addObject(new Zombie(mainPlayer, counter), getWidth()/2 ,getHeight()); break;
                case 6 : addObject(new Zombie(mainPlayer,counter), getWidth() ,getHeight()/2); break;
                case 7 : addObject(new Zombie(mainPlayer,counter), getWidth() , getHeight()); break;
                                    
        
                                                  
            }
           
        }
    }    
  

    
}
