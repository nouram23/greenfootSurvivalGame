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
    int attackImage = 0;

    int animateSpeed = 5;
     int attackSpeed = 3;
    int count;
    int health = 3;
    Player player;
    Counter counter;

    public Zombie (Player mainPlayer, Counter counter){
        this.counter= counter;
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
           if(health == 2){
            setImage("ylSkeleton_move_"+animateImage + ".png");
              
            } else if(health ==1)
                setImage("redSkeleton_move_"+animateImage + ".png");
            else setImage("skeleton-move_"+animateImage + ".png");
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
        int x, y;
        if(projectile != null){
            health--;
            getWorld().removeObject(projectile);
        }
        
        if(health == 0){
            counter.score++;
            counter.money+=5;
            x = this.getX();
            y = this.getY();
            getWorld().removeObject(this);
           
                    
        }

    }
    public void attackAnimation(){
         World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getPlayer().hitByZombie()){
            if(count % attackSpeed == 0){
                if(attackImage >8)
                    attackImage=0;
                setImage("skeleton-attack_"+attackImage + ".png");
                attackImage++;
                getImage().scale(60,60);
        }
    }
    }
    

}
