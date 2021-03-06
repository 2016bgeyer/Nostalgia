package arcade.Asteroids;
   
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   public class AsteroidsGame extends Applet implements Runnable, KeyListener{
      Thread thread;
      Dimension dim;
      Image img;
      Graphics g;
      long endTime, startTime, framePeriod;
      Ship ship;
      boolean paused; // True if the game is paused. Enter is the pause key
      Shot[] shots;
      int numShots;
      boolean shooting;
      Asteroid[] asteroids; //the array of asteroids
      int numAsteroids; //the number of asteroids currently in the array
      double astRadius, minAstVel,maxAstVel; //values used to create asteroids
      int astNumHits,astNumSplit;
      int level; //the current level number
      public void init(){
         resize(500,500);
         shots=new Shot[41]; //41 is a shot's life period plus one.
      //since at most one shot can be fired per frame,
      //there will never be more than 41 shots if each one only
      //lives for 40 frames.
         numAsteroids=0;
         level=0; //will be incremented to 1 when first level is set up
         astRadius=60; //values used to create the asteroids
         minAstVel=.5;
         maxAstVel=5;
         astNumHits=3;
         astNumSplit=2;
         endTime=0;
         startTime=0;
         framePeriod=25;
         addKeyListener(this); //tell it to listen for KeyEvents
         dim=getSize();
         img=createImage(dim.width, dim.height);
         g=img.getGraphics();
         thread=new Thread(this);
         thread.start();
      }
      public void
       setUpNextLevel(){ //start new level with one more asteroid
         level++;
      // create a new, inactive ship centered on the screen
      // I like .35 for acceleration, .98 for velocityDecay, and
      // .1 for rotationalSpeed. They give the controls a nice feel.
         ship=new Ship(250,250,0,.35,.98,.1,12);
         numShots=0; //no shots on the screen at beginning of level
         paused=false;
         shooting=false;
      //create an array large enough to hold the biggest number
      //of asteroids possible on this level (plus one because
      //the split asteroids are created first, then the original
      //one is deleted). The level number is equal to the
      //number of asteroids at it's start.
         asteroids=new Asteroid[level * (int)Math.pow(astNumSplit,astNumHits-1)+1];
         numAsteroids=level;
      //create asteroids in random spots on the screen
         for(int i=0;i<numAsteroids;i++)
            asteroids[i]=new Asteroid(Math.random()*dim.width,
               Math.random()*dim.height,astRadius,minAstVel,
               maxAstVel,astNumHits,astNumSplit);
      }
      public void paint(Graphics gfx){
         g.setColor(Color.black);
         g.fillRect(0,0,500,500);
         for(int i=0;i<numShots;i++) //draw all the shots on the screen
            shots[i].draw(g);
         for(int i=0;i<numAsteroids;i++)
            asteroids[i].draw(g);
         ship.draw(g); //draw the ship
         g.setColor(Color.cyan); //Display level number in top left corner
         g.drawString("Level " + level,20,20);
         gfx.drawImage(img,0,0,this);
      }
      public void update(Graphics gfx){
         paint(gfx);
      }
   
      public void run(){
         for(;;){
            startTime=System.currentTimeMillis();
         //start next level when all asteroids are destroyed
            if(numAsteroids<=0)
               setUpNextLevel();
            if(!paused){
               ship.move(dim.width,dim.height); // move the ship
            //move shots and remove dead shots
               for(int i=0;i<numShots;i++){
                  shots[i].move(dim.width,dim.height);
               //removes shot if it has gone for too long
               //without hitting anything
                  if(shots[i].getLifeLeft()<=0){
                  //shifts all the next shots up one
                  //space in the array
                     deleteShot(i);
                     i--; // move the outer loop back one so
                  // the shot shifted up is not skipped
                  }
               }
            //move asteroids and check for collisions
               updateAsteroids();
               if(shooting && ship.canShoot()){
               //add a shot on to the array
                  shots[numShots]=ship.shoot();
                  numShots++;
               }
            }
            repaint();
            try{
               endTime=System.currentTimeMillis();
               if(framePeriod-(endTime-startTime)>0)
                  Thread.sleep(framePeriod-(endTime-startTime));
            }
               catch(InterruptedException e){
               }
         }
      }
      private void deleteShot(int index){
      //delete shot and move all shots after it up in the array
         numShots--;
         for(int i=index;i<numShots;i++)
            shots[i]=shots[i+1];
         shots[numShots]=null;
      }
      private void deleteAsteroid(int index){
      //delete asteroid and shift ones after it up in the array
         numAsteroids--;
         for(int i=index;i<numAsteroids;i++)
            asteroids[i]=asteroids[i+1];
         asteroids[numAsteroids]=null;
      }
      private void addAsteroid(Asteroid ast){
      //adds the asteroid passed in to the end of the array
         asteroids[numAsteroids]=ast;
         numAsteroids++;
      }
      private void updateAsteroids(){
         for(int i=0;i<numAsteroids;i++){
         // move each asteroid
            asteroids[i].move(dim.width,dim.height);
         //check for collisions with the ship, restart the
         //level if the ship gets hit
            if(asteroids[i].shipCollision(ship)){
               level--; //restart this level
               numAsteroids=0;
               return;
            }
         //check for collisions with any of the shots
            for(int j=0;j<numShots;j++){
               if(asteroids[i].shotCollision(shots[j])){
               //if the shot hit an asteroid, delete the shot
                  deleteShot(j);
               //split the asteroid up if needed
                  if(asteroids[i].getHitsLeft()>1){
                     for(int k=0;k<asteroids[i].getNumSplit();
                     k++)
                        addAsteroid(
                           asteroids[i].createSplitAsteroid(
                           minAstVel,maxAstVel));
                  }
               //delete the original asteroid
                  deleteAsteroid(i);
                  j=numShots; //break out of inner loop - it has
               //already been hit, don't need to check
               //for collision with other shots
                  i--; //don't skip asteroid shifted back into
               //the deleted asteroid's position
               }
            }
         }
      }
      public void keyPressed(KeyEvent e){
         if(e.getKeyCode()==KeyEvent.VK_ENTER){
         //These first two lines allow the asteroids to move
         //while the player chooses when to enter the game.
         //This happens when the player is starting a new life.
            if(!ship.isActive() && !paused)
               ship.setActive(true);
            else{
               paused=!paused; //enter is the pause button
               if(paused) // grays out the ship if paused
                  ship.setActive(false);
               else
                  ship.setActive(true);
            }
         }
         else if(paused || !ship.isActive()) //if the game is
            return; //paused or ship is inactive, do not respond
         //to the controls except for enter to unpause
         else if(e.getKeyCode()==KeyEvent.VK_UP)
            ship.setAccelerating(true);
         else if(e.getKeyCode()==KeyEvent.VK_LEFT)
            ship.setTurningLeft(true);
         else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            ship.setTurningRight(true);
         else if(e.getKeyCode()==KeyEvent.VK_CONTROL)
            shooting=true; //Start shooting if ctrl is pushed
      }
      public void keyReleased(KeyEvent e){
         if(e.getKeyCode()==KeyEvent.VK_UP)
            ship.setAccelerating(false);
         else if(e.getKeyCode()==KeyEvent.VK_LEFT)
            ship.setTurningLeft(false);
         else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            ship.setTurningRight(false);
         else if(e.getKeyCode()==KeyEvent.VK_CONTROL)
            shooting=false;
      }
      public void keyTyped(KeyEvent e){
      }
   }