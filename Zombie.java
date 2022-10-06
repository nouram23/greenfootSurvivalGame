import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0;
    int animateSpeed = 5;
    int count;
    int health = 3;
    Player player;
    Counter counter;
     Projectiles projectiles;

    public Zombie (Player mainPlayer, Counter counter){
        this.counter= counter;
        player = mainPlayer;
        setImage("skeleton-idle_0.png");
        getImage().scale(60,60);
    }
     public Zombie (Player mainPlayer, Counter counter,Projectiles projectiles ){
        this.counter= counter;
        this.projectiles = projectiles;
        player = mainPlayer;
        setImage("skeleton-idle_0.png");
        getImage().scale(60,60);
    }
    public void act()
    {
        // Add your action code here.
        count++;
        animate();
        moveAround();
        hitByProjectile();
    }
    
    public void animate(){
        if(count % animateSpeed == 0){
             if(animateImage >16)
                animateImage=0;
            setImage("skeleton-move_"+animateImage + ".png");
            animateImage++;
            getImage().scale(60,60);
           
        }
    }
      public void moveAround(){
 
        move(1);
        turnTowards(player.getX(), player.getY());
    }
    public void hitByProjectile(){
    Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null){
            health--;
            
            getWorld().removeObject(projectile);
        }
        if(health == 0){
            counter.score++;
            counter.money+=5;
            getWorld().removeObject(this);
           

            getWorld().addObject( new Projectiles(), 10, 10);
         
        }

    }

}
