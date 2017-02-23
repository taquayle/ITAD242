/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_03_tyler_quayle;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Quayle
 */
public class Assignment_03_Tyler_Quayle {

    /**
     * @param args the command line arguments
     */
    
    /* QUESTION 01 */
//    public static void main(String[] args) {
//        String word1 = "catalog";
//        String word2 = "cat";
//        
//        System.out.println(word1.compareTo("aaa"));
//        System.out.println(word2.compareTo(word1.substring(0,3)));
//        System.out.println(word2.compareTo(word1));
//        System.out.println(word1.compareTo(word2));
//        System.out.println(word2.equals(word1));
//        System.out.println(word2.equals(word1.substring(0,3)));
//    }
//    /* QUESTION 02 */
//    public static void main(String[] args)
//   {
//      Scanner in = new Scanner(System.in);
//      System.out.println("Enter the first integer: ");
//      int x = in.nextInt();
//      System.out.println("x = " + x);
//      System.out.println("Enter the second integer: ");
//      int y = in.nextInt();
//      System.out.println("y = " + y);
//      // Your gcd computation code goes here
//      while(x != 0)
//      {
//         if(x > y)x = x - y;
//         else if(x < y) y = y - x;
//         else if(x == y) x = y - x;
//      }
//      System.out.println("GCD: " + y);
//   }   
public class Card
{
   private String name;

   public Card()
   {
      name = "";
   }

   public Card(String n)
   {
      name = n;
   }

   public String getName()
   {
      return name;
   }

   public boolean isExpired()
   {
      return false;
   }

   public String format()
   {
      return "Card holder:\t" + name;
   }
}

public static class IDCard extends Card
{
    private String idNumber;
    
    public IDCard(String s, String id)
    {
        super(s);
        idNumber = id;
    }
    public boolean isExpired(){return super.isExpired();}
    public String format()
    {
        return super.format() + "\nID Number:\t" + idNumber;
    }
}

public static class CallingCard extends Card
{
    private String cardNumber;
    private String pinNumber;
    
    public CallingCard(String s, String car, String pin)
    {
        super(s);
        cardNumber = car;
        pinNumber = pin;
    }
    
    public boolean isExpired(){return super.isExpired();}
    
    public String format()
    {
        return super.format() + "\nCard Number:\t" + cardNumber +
                                "\nPIN Number:\t" + pinNumber;
    }
}

public static class DriverLicense extends Card
{
    private int expirationYear;
    GregorianCalendar calendar = new GregorianCalendar();
    
    public DriverLicense(String s, int exp)
    {
        super(s);
        expirationYear = exp;
    }
    
    public boolean isExpired()
    {
        if(expirationYear < calendar.get(calendar.YEAR))
            return false;
        
        else return true;
    }
    public String format()
    {
         return super.format() + "\nExpiration Year:\t" + expirationYear;
    }
}

public static class Billfold extends Card
{
    Card cardOne;
    Card cardTwo;
    
    public void addCard(Card input)
    {
        if(cardOne == null)
        {
            cardOne = input;
            return;
        }
        if(cardTwo == null)
            cardTwo = input;  
    }
    
    public int getExpiredCardCount()
    {
        return (cardOne.isExpired() ? 1 : 0) + (cardTwo.isExpired() ? 1 : 0);
    }
    public String formatCards()
    {
        if(cardOne != null && cardTwo != null)
            return "\nCARD ONE:\n" + cardOne.format() + 
                    "\n\nCARD TWO:\n" + cardTwo.format();
        else if(cardOne != null)
            return "\nCARD ONE:\n" + cardOne.format();
        else if(cardTwo != null)
            return "\nCARD TWO:\n" + cardTwo.format();
        return "ERROR: NO CARDS FOUND!";
    }
}


    public static void main(String [] args)
    { 
        CallingCard cc_test = new CallingCard("Tyler Quayle", "1230", "1988");
        DriverLicense dl_test = new DriverLicense("Tyler Quayle", 2016);
        Billfold bf_test = new Billfold();
        
        bf_test.addCard(cc_test);
        bf_test.addCard(dl_test);
        System.out.println(bf_test.formatCards());
        System.out.println("\nExpired Cards: " + bf_test.getExpiredCardCount());
        

    }

}
