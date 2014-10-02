import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] suzy;
int count = 100;
public void setup()
{
  size(300,300);
  background(0);
  suzy = new SnowFlake[count];
  for (int i = 0; i < count; i++) {
    suzy[i]= new SnowFlake();
  }
}
public void draw() {
  //  background(0);
  for (int a=0;a<count;a++) {
    suzy[a].erase();
    suzy[a].lookDown();
    suzy[a].move();
    suzy[a].wrap();
    suzy[a].show();
  }
}
public void mouseDragged()
{
  if (mouseButton== LEFT) {
    noStroke();
    fill(0,255,0);
    ellipse(mouseX,mouseY,10,10);
  }

  if (mouseButton==RIGHT) {
    noStroke();
    fill(0);
    ellipse(mouseX,mouseY,10,10);
  }

}

class SnowFlake
{
  int myX,myY;
  boolean isMoving;
  SnowFlake()
  {
    myX = (int)(Math.random()*300);
    myY = (int)(Math.random()*300)+2;
    isMoving = true;
  }
  public void show()
  {
    noStroke();
    fill(255);
    ellipse(myX,myY,6,6);
  }
  public void lookDown()
  {
    if (myY > 0 && myY < 300 && get(myX,myY+5) != color(0)) {
      isMoving = false;
    } else {
      isMoving = true;
    }
  }
  public void erase()
  {
    noStroke();
    fill(0);
    ellipse(myX,myY,8,8);
  }
  public void move()
  {
    if (isMoving==true) {
      myY +=1;
    }
  }
  public void wrap()
  {
    if (myY > 259) {
      myY = 0;
      myX = (int)(Math.random()*300);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
