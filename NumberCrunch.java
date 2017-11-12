/*
 * Dongpeng Xia, Georgetown University
 * NumberCrunch is a mental math training program written in Java.
 * It'll display 3 digits with 2 blanks in between the 3 digits,
 * signifying the missing operators. To the right side of the equals sign is the 
 * result (following order of operations). The goal is to type in the first operator
 * followed immediately by the second operator to satisfy the equation. 
 * For example:

   4 _ 9 _ 5 = -41.0
   Please enter the first operator followed immediately by the second.
   -*
   You're right!
   
 * The user input is "-*"
 * 4 - 9 * 5 = -41, thus the operation succeeds. 
 *  
 */

import java.util.Scanner;

public class NumberCrunch
{
    public static void main(String args[]) 
    {
        int num1, num2, num3, numCorrect = 0, totalTries = 10;
        double ans;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < totalTries; i++)
        {
          //Generate numbers and answers
          num1 = (int)(Math.random() * 9) + 1;
          num2 = (int)(Math.random() * 9) + 1;
          num3 = (int)(Math.random() * 9) + 1;
          ans = generateAnswer(num1,num2,num3);
          System.out.println(num1 + " _ " + num2 + " _ " + num3 + " = " + ans);
          System.out.println("Please enter the first operator followed immediately by the second.");
          
          //Scan in string, inputs first and second characters as operators
          scanner = new Scanner(System.in);
          String strInput = scanner.next();
          char input1 = strInput.charAt(0);
          char input2 = strInput.charAt(1);
          
          //Verify if user's operators are correct
          if(verifyAnswer(num1, num2, num3, ans, input1, input2))
          {
              System.out.println("You're right!");
              numCorrect++;
          }
          else
          {
              System.out.println("Sorry, it didn't work out.");
          }
        }
        scanner.close();
        System.out.println("The program has finished.");
        System.out.println("You got " + numCorrect + " out of " + totalTries + " correct.");
        
    }//end main
    
    //generateAnswer produces a value for the right side of the equation when given the three digits
    public static double generateAnswer(int num1, int num2, int num3)
    {
    	double ans;
    	int combNum = (int)(Math.random() * 16) + 1;
        switch(combNum)
        {
          case 1: ans = num1 + num2 + num3;
              break;
          case 2: ans = num1 + num2 - num3;
              break;
          case 3: ans = num1 + num2 * num3;
              break;
          case 4: ans = num1 + ((double)num2 / num3);
              break;
          case 5: ans = num1 - num2 + num3;
              break;
          case 6: ans = num1 - num2 - num3;
              break;
          case 7: ans = num1 - num2 * num3;
              break;
          case 8: ans = num1 - ((double)num2 / num3);
              break;
          case 9: ans = num1 * num2 + num3;
              break;
          case 10: ans = num1 * num2 - num3;
              break;
          case 11: ans = num1 * num2 * num3;
              break;
          case 12: ans = num1 * ((double)num2 / num3);
              break;
          case 13: ans = ((double)num1 / num2) + num3;
              break;
          case 14: ans = ((double)num1 / num2) - num3;
              break;
          case 15: ans = ((double)num1 / num2) * num3;
              break;
          default : ans = ((double)num1 / num2) / num3;
        }
        return ans;
        
    }//end generateAnswer
    
    //verifyAnswer checks if the 3 digits and 2 character operators work to produce the correct answer (double ans).
    public static boolean verifyAnswer(int num1, int num2, int num3, double ans, char input1, char input2)
    {
    	double inputans = 0;
    	if(input1 == '+' && input2 == '+')
        {
            inputans = num1 + num2 + num3;
        }
        else if(input1 == '+' && input2 == '-')
        {
            inputans = num1 + num2 - num3;
        }
        else if(input1 == '+' && input2 == '*')
        {
            inputans = num1 + num2 * num3;
        }
        else if(input1 == '+' && input2 == '/')
        {
            inputans = num1 + ((double)num2 / num3);
        }
        else if(input1 == '-' && input2 == '+')
        {
            inputans = num1 - num2 + num3;
        }
        else if(input1 == '-' && input2 == '-')
        {
            inputans = num1 - num2 - num3;
        }
        else if(input1 == '-' && input2 == '*')
        {
            inputans = num1 - num2 * num3;
        }
        else if(input1 == '-' && input2 == '/')
        {
            inputans = num1 - ((double)num2 / num3);
        }
        else if(input1 == '*' && input2 == '+')
        {
            inputans = num1 * num2 + num3;
        }
        else if(input1 == '*' && input2 == '-')
        {
            inputans = num1 * num2 - num3;
        }
        else if(input1 == '*' && input2 == '*')
        {
            inputans = num1 * num2 * num3;
        }
        else if(input1 == '*' && input2 == '/')
        {
            inputans = num1 * ((double)num2 / num3);
        }
        else if(input1 == '/' && input2 == '+')
        {
            inputans = ((double)num1 / num2) + num3;
        }
        else if(input1 == '/' && input2 == '-')
        {
            inputans = ((double)num1 / num2) - num3;
        }
        else if(input1 == '/' && input2 == '*')
        {
            inputans = ((double)num1 / num2) * num3;
        }
        else if(input1 == '/' && input2 == '/')
        {
            inputans =((double)num1 / num2) / num3;
        }
    	
    	//if the new answer equals the expected result (floating point numbers complicate things a bit)
    	if(Math.abs(inputans-ans) <= Math.abs(ans * 0.0000000001))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
        
    }//end verifyAnswer
}//end NumberCrunch