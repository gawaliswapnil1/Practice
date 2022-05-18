package com.epam.learning;

/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
**  Instructions:
**
**  Given a list of student test scores, find the best average grade.
**  Each student may have more than one test score in the list.
**
**  Complete the bestAverageGrade function in the editor below.
**  It has one parameter, scores, which is an array of student test scores.
**  Each element in the array is a two-element array of the form [student name, test score]
**  e.g. [ "Bobby", "87" ].
**  Test scores may be positive or negative integers.
**
**  If you end up with an average grade that is not an integer, you should
**  use a floor function to return the largest integer less than or equal to the average.
**  Return 0 for an empty input.
**
**  Example:
**
**  Input:
**  [ [ "Bobby", "87" ],
**    [ "Charles", "100" ],
**    [ "Eric", "64" ],
**    [ "Charles", "22" ] ].
**
**  Expected output: 87
**  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
**  respectively. 87 is the highest.
*/

class Solution
{
  /*
  **  Find the best average grade.
  */
  public static Integer bestAverageGrade(String[][] scores)
  {
    // TODO: implement this function

    int row= scores.length;
    
    
    
    Map<String,Integer> avgScore=new HashMap<>();
    Map<String,Integer> freMap=new HashMap<>();
    for(int i=0;i<row;i++){
     
      if(!avgScore.containsKey(scores[i][0])){
       avgScore.put(scores[i][0] ,Integer.parseInt(scores[i][1]));
       freMap.put(scores[i][0],1);
      }
      else{
        Integer existingValue=avgScore.get(scores[i][0]);
        existingValue=existingValue + Integer.parseInt(scores[i][1]);
        avgScore.put(scores[i][0] ,existingValue);
        freMap.put(scores[i][0],freMap.get(scores[i][0])+1);
        }
    }
    Double highestAvg=0.0;
    
    for(Entry<String,Integer> e: avgScore.entrySet()){
      
      String name=e.getKey();
      Integer total=e.getValue();
      int frq=freMap.get(name);
     
      if(highestAvg<total/frq){
      highestAvg=(double) (total/frq);
      }

    }
    return (int) Math.floor(highestAvg);
  }

  /*
  **  Returns true if the tests pass. Otherwise, returns false;
  */
  public static boolean doTestsPass()
  {
    // TODO: implement more test cases
    String[][] tc1 = { { "Bobby", "87" },
               { "Charles", "100" },
               { "Eric", "64" },
               { "Charles", "22" } };

    return bestAverageGrade(tc1) == 87;
  }

  /*
  **  Execution entry point.
  */
  public static void main(String[] args)
  {
    // Run the tests
    if(doTestsPass())
    {
      System.out.println("All tests pass");
    }
    else
    {
      System.out.println("Tests fail.");
    }
  }
}

