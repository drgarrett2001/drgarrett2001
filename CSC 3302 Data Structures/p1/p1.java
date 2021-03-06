
/**
 * Purpose: Read in card values, sort cart values, calculate, and print the score to screen
 * Programmer:David Garrett
 *Class: CSCI 3302-002
 *Date Started: September 4, 2020
 *Date Completed: September 7, 2020
 *variables used:
   int a, i, j, k, l, m, n, o, p: all used for loops
   int numberOfHands: counts number of hands in text file
   int clubs, diamonds, spades, hearts = used for counting the number of values in every suit
   int points: calculate points
   int temp: swapping values
   String temp: swapping values
   int[] value: compare values of a string indeces using numerical values
   String[] hand:dividing text file by hands 
   String[][] divided: dividing cards by values
   String[][][] hands:dividing the cards by hand, suit and value
   String[][][] separated: sorted card values
 *files needed/used:text file p1.dat containing all card values, formatted with one hand per line
 *ADTs used: none
 *Sample input: 2C QD TC AD 6C 3D TD 3H 5H 7H AS JH KH 
 *Sample Output: Clubs        10     6     2
 *               Diamonds     A      Q     10    3
 *               Hearts       K      J     7     5     3
 *               Spades       A 
 *               Points  =  16

 */

import java.util.*;
import  java.io.*;

public class p1
{
    public static void main(String[] args) throws IOException{
        //initialize counter and scanners
       int a;
       int numberOfHands = 0;
       Scanner counter = new Scanner(new File(args[0])); 
       Scanner potatoboiyo = new Scanner(new File(args[0]));      
      
       //count number of hands
       while(counter.hasNextLine()) { 
            if(!counter.nextLine().equals("")) 
                numberOfHands++;
       }
       
       //read in number of lines
       String[] hand = new String[numberOfHands];
       for(a=0;a<numberOfHands;a++){
         hand[a] = potatoboiyo.nextLine();  
       }
       
       // separate the individiual card values 
       String[][] divided = divide(hand);
       // separate card values by suit
       String[][][] hands = divideAgain(divided);
       //order the hands by values
       String[][][] separated = sort(hands);
       
       // initialize counters for loops
      int points;
      int i;
      int j;
      //count points
      for(j=0;j<hands.length;j++){
        points=0;
        i=0;
        //clubs
        System.out.print("Clubs     ");
        for(int k = 0; k<13; k++){
            if(hands[j][i][k] == null){}
            else if(hands[j][i][k].contains("T")){
                System.out.print("10   ");
            }
            else{
                System.out.print(hands[j][i][k] + "   ");
                if(hands[j][i][k].contains("A"))
                    points= points+4;
                else if(hands[j][i][k].contains("K"))
                    points= points +3;
                else if(hands[j][i][k].contains("Q"))
                    points=points+2;
                else if(hands[j][i][k].contains("J"))
                    points=points+1;
            
            }
        }
        
        if(hands[j][i][0] == null)
            points= points +3;
        if(hands[j][i][1] == null && hands[j][i][0] != hands[j][i][1])
            points= points+2; 
        if(hands[j][i][2] == null && hands[j][i][1] != hands[j][i][2])
            points= points+1;
        for(int k = 6; k<13; k++){
            if(hands[j][i][k] == null && hands[j][i][k-1] != hands[j][i][k])
            points++;
        }
        System.out.println();
        i++;
        
        //Diamonds
        System.out.print("Diamonds  ");
        for(int l = 0; l<13; l++){
            if(hands[j][i][l] == null){}
            else if(hands[j][i][l].contains("T")){
                System.out.print("10   ");
            }
            else{
                System.out.print(hands[j][i][l] + "   ");
                if(hands[j][i][l].contains("A"))
                    points= points+4;
                else if(hands[j][i][l].contains("K"))
                    points= points +3;
                else if(hands[j][i][l].contains("Q"))
                    points=points+2;
                else if(hands[j][i][l].contains("J"))
                    points=points+1;
            }
        }
        if(hands[j][i][0] == null)
            points= points +3;
        if(hands[j][i][1] == null && hands[j][i][0] != hands[j][i][1])
            points= points+2; 
        if(hands[j][i][2] == null && hands[j][i][1] != hands[j][i][2])
            points= points+1;
        for(int k = 6; k<13; k++){
            if(hands[j][i][k] == null && hands[j][i][k-1] != hands[j][i][k])
            points++;
        }
        System.out.println(); 
        i++;
        
        //Hearts
        System.out.print("Hearts    ");
        for(int m = 0; m<13; m++){
            if(hands[j][i][m] == null){}
            else if(hands[j][i][m].contains("T")){
                System.out.print("10   ");
            }
            else{
                System.out.print(hands[j][i][m] + "   ");
                if(hands[j][i][m].contains("A"))
                    points= points+4;
                else if(hands[j][i][m].contains("K"))
                    points= points +3;
                else if(hands[j][i][m].contains("Q"))
                    points=points+2;
                else if(hands[j][i][m].contains("J"))
                    points=points+1;
            }
        }
        if(hands[j][i][0] == null)
            points= points +3;
        if(hands[j][i][1] == null && hands[j][i][0] != hands[j][i][1])
            points= points+2; 
        if(hands[j][i][2] == null && hands[j][i][1] != hands[j][i][2])
            points= points+1;
        for(int k = 6; k<13; k++){
            if(hands[j][i][k] == null && hands[j][i][k-1] != hands[j][i][k])
            points++;
        }
        System.out.println(); 
        i++;
        
        //Spades
        System.out.print("Spades    ");
        for(int n = 0; n<13; n++){
            if(hands[j][i][n] == null){}
            else if(hands[j][i][n].contains("T")){
                System.out.print("10   ");
            }
            else{
                System.out.print(hands[j][i][n] + "   ");
                if(hands[j][i][n].contains("A"))
                    points= points+4;
                else if(hands[j][i][n].contains("K"))
                    points= points +3;
                else if(hands[j][i][n].contains("Q"))
                    points=points+2;
                else if(hands[j][i][n].contains("J"))
                    points=points+1;
            }
        }
        if(hands[j][i][0] == null)
            points= points +3;
        if(hands[j][i][1] == null && hands[j][i][0] != hands[j][i][1])
            points= points+2; 
        if(hands[j][i][2] == null && hands[j][i][1] != hands[j][i][2])
            points= points+1;
        for(int k = 6; k<13; k++){
            if(hands[j][i][k] == null && hands[j][i][k-1] != hands[j][i][k])
            points++;
        }
        System.out.println(); 
        System.out.println("Points = " + points);
        System.out.println();
        System.out.println();
       }
       counter.close();
       potatoboiyo.close();
       
    }//end main

    public static String[][] divide(String[] hands){
        //initialize output
        String[][] separated = new String[hands.length][13];
        
        //read separate the hands into individual coordinate
        for(int i = 0; i< hands.length;i++){
            for(int j= 0; j< 13 ;j++){
                separated[i][j]=hands[i].substring((3*j),(3*j)+2);
            }
        }
        return separated;
    }//end divide
    
    public static String[][][] divideAgain(String[][] hands){
        //initiallize output and counters
        String[][][] sorted = new String[hands.length][4][13];
        int clubs;
        int diamonds;
        int hearts;
        int spades;
        
        for(int i = 0; i< hands.length;i++){
            //reset values for every hand
            clubs=0;
            diamonds=0;
            hearts=0;
            spades=0;
            
            //sort cards based on suit
            for(int j= 0; j < hands[i].length ;j++){
                if(hands[i][j].contains("C")){
                    
                    sorted[i][0][clubs]=hands[i][j].substring(0,1);
                    clubs++;
                }
                else if(hands[i][j].contains("D")){
                    
                    sorted[i][1][diamonds]=hands[i][j].substring(0,1);
                    diamonds++;
                }
                else if(hands[i][j].contains("H")){
                    
                    sorted[i][2][hearts]=hands[i][j].substring(0,1);
                    hearts++;
                }
                else if(hands[i][j].contains("S")){
                    
                    sorted[i][3][spades]=hands[i][j].substring(0,1);
                    spades++;
                }
                
            }
        }
        
        return sorted;
    }//end divideAgain
    
    public static String[][][] sort(String[][][] hands){
        //initiallize output and swap variables
        String[][][] sorted= new String[hands.length][4][13];
        int temp;
        String temps;
        
        //match the index of the string array to that of an integer for comparison
        for(int i = 0; i< hands.length;i++){
            for(int j= 0; j < 4 ;j++){
                int[] value=new int[13];
                for(int k= 0; k < 13 ;k++){
                    if (hands[i][j][k]==null){}
                    else if (hands[i][j][k].contains("A") )
                        value[k]= 14;
                    else if (hands[i][j][k].contains("K") )
                        value[k]= 13;
                    else if (hands[i][j][k].contains("Q") )
                        value[k]= 12;
                    else if (hands[i][j][k].contains("J") )
                        value[k]= 11;
                    else if (hands[i][j][k].contains("T") )
                        value[k]= 10;
                    else if (hands[i][j][k].contains("9") )
                        value[k]= 9;
                    else if (hands[i][j][k].contains("8") )
                        value[k]= 8;
                    else if (hands[i][j][k].contains("7") )
                        value[k]= 7;
                    else if (hands[i][j][k].contains("6") )
                        value[k]= 6;
                    else if (hands[i][j][k].contains("5") )
                        value[k]= 5;
                    else if (hands[i][j][k].contains("4") )
                        value[k]= 4;
                    else if (hands[i][j][k].contains("3") )
                        value[k]= 3;
                    else if (hands[i][j][k].contains("2") )
                        value[k]= 2;
                    else
                        value[k]=0;
                }
                
                //sort value order based on the value of the value array
                for(int k= 0; k < 13 ;k++){
                    for(int l= 0; l < (13-k) ;l++){
                        if(value[k] == 0){}
                        else if(value[k]<value[k+l]){
                            temp=value[k];
                            temps=hands[i][j][k];
                            
                            value[k]=value[k+l];
                            hands[i][j][k]=hands[i][j][k+l];
                            
                            value[k+l]=temp;
                            hands[i][j][k+l]=temps;
                        }
                            
                        }
                    }
                }
        }
        return sorted;   
    }//end sort
}