import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
     int time = 0;
     int animateImage = 0;
      int shootAnimateImage = 0;
     WeaponUpgrade weaponupgrade;
     Counter counter;
    public Player(){
     GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }
    public Player(WeaponUpgrade weaponupgrade, Counter counter){
    this.weaponupgrade= weaponupgrade;
    this.counter= counter;
     GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
        time++;
       turnAround();
       moveAround();
       fire();
       hitByZombie();
       animate();
       getAmmo();
      
        
    }
     public void animate(){
             if(animateImage >19)
                animateImage=0;
            setImage("survivor-move_shotgun_"+animateImage + ".png");
            animateImage++;
            getImage().scale(50,50);
           
        
    }
     public void shootAnimate(){
             if(shootAnimateImage >2)
                shootAnimateImage=0;
            setImage("survivor-shoot_shotgun_"+shootAnimateImage + ".png");
            shootAnimateImage++;
            getImage().scale(50,50);
           
        
    }
    public void turnAround(){
         if(Greenfoot.getMouseInfo() != null)
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
     public void moveAround(){
        if(Greenfoot.isKeyDown("w"))
            setLocation(getX(), getY()-speed);
        if(Greenfoot.isKeyDown("a"))
            setLocation(getX()-speed, getY());
        if(Greenfoot.isKeyDown("s"))
            setLocation(getX(), getY()+speed);
        if(Greenfoot.isKeyDown("d"))
            setLocation(getX()+speed, getY());
    }
    public void fire(){
        shootAnimate();
      if(counter.ammo > 0){
          if(Greenfoot.mousePressed(null) && weaponupgrade.status ==1){
            counter.ammo--;
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(30);
        }
        if(Greenfoot.mousePressed(null) && weaponupgrade.status ==2){
            counter.ammo -= 2;
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(25);
             Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation()+5);
            projectile2.move(25);
        }
        if(Greenfoot.mousePressed(null) && weaponupgrade.status >=3){
             counter.ammo -=3;
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(25);
             Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation()+5);
            projectile2.move(25);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(25); 
        }
        }
        
    }
    public boolean hitByZombie(){
        Actor zombie = getOneObjectAtOffset(0, 0, Zombie.class);
        if(zombie !=null){
           return true;
        }
        else return false;
    }
      public void getAmmo(){
        Actor projectiles = getOneObjectAtOffset(0, 0, Projectiles.class);
         if(projectiles !=null){
          counter.ammo += 30;
          getWorld().removeObject(projectiles);
        }
    }
   
 
}
