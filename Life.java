public class Life implements ILife {

  private static String[] nextGen = {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " };

 private static String[] test = {  "*****",
                                      "*****",
                                      "*****",
                                      "*****",
                                      "*****" };
  
  public static void main(String[] args) {
    Life l = new Life(nextGen);
    l = (Life) l.nextGeneration();
  }


  public Life() {
    nukeAll();
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
    // TODO Auto-generated method stub
    nextGen[0] = "     ";
    nextGen[1] = "     ";
    nextGen[2] = "     ";
    nextGen[3] = "     ";
    nextGen[4] = "     ";
    //nextGen[0].replaceAll("*", " ");
    //nextGen[1].replaceAll("*", " ");
    //nextGen[2].replaceAll("*", " ");
    //nextGen[3].replaceAll("*", " ");
    //nextGen[4].replaceAll("*", " ");

    

  }

  @Override
  public void setAlive(int x, int y) {
    // TODO Auto-generated method stub

     nextGen[y] = nextGen[y].substring(0,x)+'*'+nextGen[y].substring(x + 1);

  }

  @Override
  public void setDead(int x, int y) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isAlive(int x, int y) {
    // TODO Auto-generated method stub
    if(nextGen[y].charAt(x) == '*'){
      return true;
    }
    return false;
  }

  @Override
  public ILife nextGeneration() {
    // TODO Auto-generated method stub
    for (int y = 0; y < nextGen.length; y++)
      for (int x = 0; x < nextGen[y].length(); x++)
      
    if(checkAround(x, y) == 3) setAlive(x, y);
    Life t = new Life(nextGen);

    return t;
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
        if(isAlive(h - 1, v -1)) counter++;   //oben links
        if(isAlive(h - 1, v)) counter++;   //mitte links
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
       if(isAlive(h + 1, v - 1)) counter++;   //oben rechts
       if(isAlive(h , v-1)) counter++;   //oben mitte 
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