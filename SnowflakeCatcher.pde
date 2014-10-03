SnowFlake [] suzy;
int count = 100;
void setup()
{
  size(300,300);
  background(0);
  suzy = new SnowFlake[count];
  for (int i = 0; i < count; i++) {
    suzy[i]= new SnowFlake();
  }
}
void draw() {
  //  background(0);
  for (int a=0;a<count;a++) {
    suzy[a].erase();
    suzy[a].lookDown();
    suzy[a].move();
    suzy[a].wrap();
    suzy[a].show();
  }
}
void mouseDragged()
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
  void show()
  {
    noStroke();
    fill(255);
    ellipse(myX,myY,6,6);
  }
  void lookDown()
  {
    if ( get(myX,myY+4) != color(0)) {
      isMoving = false;
    } else {
      isMoving = true;
    }
  }
  void erase()
  {
    noStroke();
    fill(0);
    ellipse(myX,myY,8,8);
  }
  void move()
  {
    if (isMoving==true) {
      myY +=1;
    }
  }
  void wrap()
  {
    if (myY > 290) {
    erase();
      myY = 0;
      myX = (int)(Math.random()*300);
    }
  }
}


