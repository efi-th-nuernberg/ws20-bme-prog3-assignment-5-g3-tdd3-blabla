public class Life implements ILife {

  private static String[] nextGen = { "     ",
                                      "     ",
                                      "     ",
                                      "     ",
                                      "     " };

  private  String[] AliveReminder = { "     ",                             
                                            "     ",
                                            "     ",
                                            "     ",
                                            "     " };

  public static void main(String[] args) {
    Life l = new Life(nextGen);
    l = (Life) l.nextGeneration();
  }

  public Life() {
    //nukeAll();   //sorry 
  }

  public Life(String[] setup) {
    this();  
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != ' ')
          setAlive(x, y);
  }

  @Override
  public void nukeAll() {
    //TODO Auto-generated method stub
    nextGen[0] = "     ";
    nextGen[1] = "     ";
    nextGen[2] = "     ";
    nextGen[3] = "     ";
    nextGen[4] = "     ";
  }

  public void nukeAllReminder() {
    // TODO Auto-generated method stub
    AliveReminder[0] = "     ";
    AliveReminder[1] = "     ";
    AliveReminder[2] = "     ";
    AliveReminder[3] = "     ";
    AliveReminder[4] = "     ";
  }

  @Override
  public void setAlive(int x, int y) {
    // TODO Auto-generated method stub
    nextGen[y] = nextGen[y].substring(0,x)+'*'+nextGen[y].substring(x + 1);
  }

  public void setAliveReminder(int x, int y) {
    // TODO Auto-generated method stub
    AliveReminder[y] = AliveReminder[y].substring(0,x)+'*'+AliveReminder[y].substring(x + 1);

     nextGen[y] = nextGen[y].substring(0,x)+'*'+nextGen[y].substring(x + 1);

  }

  @Override
  public void setDead(int x, int y) {
    // TODO Auto-generated method stub
    AliveReminder[y] = AliveReminder[y].substring(0,x)+' '+AliveReminder[y].substring(x + 1);
  }

  @Override
  public boolean isAlive(int x, int y) {
    // TODO Auto-generated method stub
   
    if(nextGen[y].charAt(x) == '*')
    {           
      return true; 
    }
    return false;
  }

  @Override
  public ILife nextGeneration() {
    Life tmp = new Life(nextGen);

    for (int y = 0; y < nextGen.length; y++) {
      for (int x = 0; x < nextGen[y].length(); x++) {

        if((isAlive(x, y) == true && checkAround(x, y) < 4) && (checkAround(x, y) == 2 || checkAround(x, y) == 3)) {
          setAliveReminder(x, y);
        }
        else if(checkAround(x, y) == 3 && checkAround(x, y) < 4) {     
          setAliveReminder(x, y);
        }
        else {
          setDead(x, y);
        }
      }
    }

    System.arraycopy(AliveReminder,0,nextGen,0,AliveReminder.length);
    nukeAllReminder();

    return tmp;
    
  }

  public int checkAround(int h, int v)
   { 
     //oben links
     int counter = 0;
     if(h==0 && v==0)
     {
       if(isAlive(h + 1, v )) counter++;   //mitte rechts
       if(isAlive(h +1, v +1)) counter++;   //unten recht
       if(isAlive(h, v +1)) counter++;   //unten mitte
     }

     //unten rechts
     if(h==4 && v==4)
     {
       if(isAlive(h - 1, v -1)) counter++;   //oben links
       if(isAlive(h - 1, v)) counter++;   //mitte links
       if(isAlive(h , v-1)) counter++;   //oben mitte 
     }

     //oben rechts
     if(h==4 && v==0)
     {
       if(isAlive(h - 1, v)) counter++;   //mitte links
       if(isAlive(h, v +1)) counter++;   //unten mitte
       if(isAlive(h - 1, v +1)) counter++;   //unten links
     }

     //unten links
     if(h==0 && v==4)
     {
       if(isAlive(h , v-1)) counter++;   //oben mitte 
       if(isAlive(h + 1, v )) counter++;   //mitte rechts
       if(isAlive(h + 1, v - 1)) counter++;   //oben rechts
     }

     //linker rand
     if (h==0 && v>0 && v!=4)
     {
       if(isAlive(h, v +1)) counter++;   //unten mitte
       if(isAlive(h +1, v +1)) counter++;   //unten recht
       if(isAlive(h , v-1)) counter++;   //oben mitte 
       if(isAlive(h + 1, v )) counter++;   //mitte rechts
       if(isAlive(h + 1, v - 1)) counter++;   //oben rechts  
     }
     
     //oberer rand
     if (v==0 && h>0 && h!=4)
     {
       if(isAlive(h + 1, v )) counter++;   //mitte rechts
       if(isAlive(h +1, v +1)) counter++;   //unten recht
       if(isAlive(h, v +1)) counter++;   //unten mitte
       if(isAlive(h - 1, v +1)) counter++;   //unten links
       if(isAlive(h - 1, v)) counter++;   //mitte links  
     }
  
  //rechter Rand
    if (h==4 && v>0 && v!=4)
    {
      if(isAlive(h - 1, v -1)) counter++;   //oben links
      if(isAlive(h , v-1)) counter++;   //oben mitte
      if(isAlive(h, v +1)) counter++;   //unten mitte 
      if(isAlive(h - 1, v +1)) counter++;   //unten links
      if(isAlive(h - 1, v)) counter++;   //mitte links
    }

    //unten Rand
    if (v==4 && h>0 && h!=4)
    {
      if(isAlive(h - 1, v -1)) counter++;   //oben links
      if(isAlive(h , v-1)) counter++;   //oben mitte
      if(isAlive(h + 1, v - 1)) counter++;   //oben rechts
      if(isAlive(h + 1, v )) counter++;   //mitte rechts
      if(isAlive(h - 1, v)) counter++;   //mitte links
    }

     // mitte
     if(h>0 && h<4 && v>0 && v<4)
     {
       if(isAlive(h - 1, v -1)) counter++;   //oben links
       if(isAlive(h , v-1)) counter++;   //oben mitte
       if(isAlive(h + 1, v - 1)) counter++;   //oben rechts
       if(isAlive(h + 1, v )) counter++;   //mitte rechts
       if(isAlive(h +1, v +1)) counter++;   //unten rechts
       if(isAlive(h, v +1)) counter++;   //unten mitte 
       if(isAlive(h - 1, v +1)) counter++;   //unten links
       if(isAlive(h - 1, v)) counter++;   //mitte links
     }
     return(counter);    
  }
}
