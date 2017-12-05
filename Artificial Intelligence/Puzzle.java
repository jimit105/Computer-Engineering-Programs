class Puzzle
{
      public static int newTable [] = {0,1,3,4,2,5,7,8,6};
      public static int table [] = {0,1,3,4,2,5,7,8,6};              
      public static int goalTable[] = {1,2,3,4,5,6,7,8,0};            
      public static int blankSpot;                                                      
      public static int a=0, b=0, c=0, x;
      public static int numCorrect=0;
      public static int origNum, leftNum,rightNum,upNum,downNum;

      public static void main(String args[])
      {
     		puzzSolver();
      }

      static void puzzSolver()
      {
            int a;
            printinitvalues();       

            for (a=0; a<5; ++a)
                  {
                        countTiles();

                        branch();
                        
                  }
      }


      static void branch()
      {
            if (numCorrect<9)
                  {
                        countTiles();
                        locateSpace();                  
                        checkNum();
                        getLarge();
                    

                        if(x==leftNum)
                              changeTableLeft();
                        else if(x==rightNum)
                               changeTableRight();
                        else if(x==upNum)
                                changeTableUp();
                        else
                               changeTableDown();
                        printinitvalues();
                  }
      }


      static void countTiles()
      {
            int i;
            numCorrect =0;
            for (i=0; i<9; ++i)
                  {
                        if (newTable[i]==goalTable[i])
                        {
                              numCorrect = numCorrect + 1;
                        }
                  }
      }


      static void checkNum()
      {
            makeMoveLeft();
            locateSpace();                 
            countTiles();
            leftNum = numCorrect;
           
            resetTable();

            makeMoveUp();
                    
            locateSpace();                  
            countTiles();
            upNum = numCorrect;
            
            resetTable();

            makeMoveRight();
                   
            locateSpace();                  
            countTiles();
            rightNum = numCorrect;
            
            resetTable();

            makeMoveDown();
                      
            locateSpace();                 
            countTiles();
            downNum = numCorrect;
            
            resetTable();
      }


      static void getLarge()
      {
            x=rightNum;

            if (x<leftNum)
                 {
                        x=leftNum;
                  }

            if (x<upNum)
                  {
                        x=upNum;
                  }

            if (x<downNum)
                  {
                        x=downNum;
                  }
      }


      static void changeTableLeft()
      {
      		System.out.println("Left");  
            makeMoveLeft();
            int a;
            for (a=0; a<9; ++a)
            {
                  table[a] = newTable[a];
            }
      }





      static void changeTableRight()
      {
      		System.out.println("Right");  
            makeMoveRight();
            int a;
            for (a=0; a<9; ++a)
                  {
                        table[a] = newTable[a];
                  }
      }


      static void changeTableDown()
      {
      		System.out.println("Down");  
            makeMoveDown();
            int a;
            for (a=0; a<9; ++a)
                  {
                        table[a] = newTable[a];
                  }
      }


      static void changeTableUp()
      {
      		System.out.println("Up");  
            makeMoveUp();
            int a;
            for (a=0; a<9; ++a)
                  {
                        table[a] = newTable[a];
                  }
      }


      static void makeMoveLeft()
      {      
      	  
		if(blankSpot!=0)
            {
                  if (blankSpot !=3)
                  {
                        if (blankSpot !=6)
                        {
                              int temp;
                              temp = table[blankSpot-1];
                                    if (temp != goalTable[blankSpot-1])
                                          {
                                                newTable[blankSpot-1]=table[blankSpot];
                                                newTable[blankSpot] = temp;
                                                countTiles();
                                          }
                        }
                  }
            }           
      }


      static void makeMoveRight()
      {
            if(blankSpot!=2)
                  {
                        if (blankSpot !=5)
                              {
                                    if (blankSpot !=8)
                                          {
                                                int temp;
                                                temp = table[blankSpot+1];
                                                if (temp != goalTable[blankSpot+1])
                                                      {
                                                            newTable[blankSpot+1]=table[blankSpot];
                                                            newTable[blankSpot] = temp;
                                                            return;
                                                      }
                                          }
                              }
                  }

      }


      static void makeMoveUp()
      {
            if(blankSpot!=0)
                  {
                        if (blankSpot !=1)
                              {
                                    if (blankSpot !=2)
                                          {
                                                int temp;
                                                temp = table[blankSpot-3];
                                                if (temp != goalTable[blankSpot-3])
                                                      {
                                                            newTable[blankSpot-3]=table[blankSpot];
                                                            newTable[blankSpot] = temp;
                                                      }
                                          }
                              }
                  }

      }


      static void makeMoveDown()
      {
            if(blankSpot!=6)
                  {
                        if (blankSpot !=7)
                              {
                                    if (blankSpot !=8)
                                          {
                                                int temp;
                                                temp = table[blankSpot+3];
                                                if (temp != goalTable[blankSpot+3])
                                                      {
                                                            newTable[blankSpot+3]=table[blankSpot];
                                                            newTable[blankSpot] = temp;
                                                      }
                                          }
                              }
                  }

      }


      static void printinitvalues()
            {
                  int t, i=1;
                  for (t=0; t<9; ++t)
                        {
                              System.out.print(table [t] + "  ");
                                    if (i == 3)                                          
                                          {
                                                System.out.println();
                                                i = i - 3;
                                          }
                              i = i + 1;
                        }
                              System.out.println();
                              System.out.println();
            }



      static void printGoalvalues()
      {
                  int t, i=1;
                  for (t=0; t<9; ++t)
                        {
                              System.out.print(goalTable [t] + "  ");
                                    if (i == 3)                                          
                                          {
                                                System.out.println();
                                                i = i - 3;
                                          }
                              i = i + 1;
                        }
                              System.out.println();
                              System.out.println();
      }



      static void printNewValues()
            {
                  int t, i=1;
                  for (t=0; t<9; ++t)
                        {
                              System.out.print(newTable [t] + "  ");
                                    if (i == 3)                                          
                                          {
                                                System.out.println();
                                                i = i - 3;
                                          }
                              i = i + 1;
                        }
                              System.out.println();
                              System.out.println();
            }


      static void locateSpace()
      {
            int t;
            for (t=0; t<9; ++t)
                  {
                        if (table[t]==0)
                              {
                                    blankSpot = t;
                                    return;
                              }
                  }
      }


      static void resetTable()
      {
            int i;
            for (i=0; i<9; ++i)
            {
                  newTable[i]=table[i];
            }
      }

}


/* OUTPUT
 *
 *0  1  3  
4  2  5  
7  8  6  


Right
1  0  3  
4  2  5  
7  8  6  


Down
1  2  3  
4  0  5  
7  8  6  


Right
1  2  3  
4  5  0  
7  8  6  


Down
1  2  3  
4  5  6  
7  8  0  

*/



