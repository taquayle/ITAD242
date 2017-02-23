/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asssignment_05_tyler_quayle;

import java.util.GregorianCalendar;

/**
 *
 * @author Quayle
 */
public class Asssignment_05_Tyler_Quayle {

    /**
     * @param args the command line arguments
     */
public class Card
{
   protected String name;

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
   @Override
   public String toString()
   {
       return "Card [name = " + name + "]";
   }
   
   public boolean equals(Card rightCard)
   {
       if(name.equals(rightCard.getName()))
           return true;
       else
           return false;
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
    public String getIDNumber() { return idNumber;}
    @Override
    public boolean isExpired(){return super.isExpired();}
    @Override
    public String format()
    {
        return super.format() + "\nID Number:\t" + idNumber;
    }
    @Override
    public String toString()
    {
        return "ID Card\t\t[name = " + super.getName() + "] [ID Number = " 
                + idNumber + "]";
    }
    
    public boolean equals(IDCard rightCard)
    {
        if(super.equals(rightCard))
            if(idNumber.equals(rightCard.getIDNumber()))
                return true;
        return false;
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
    public String getCardNumber() { return cardNumber; }
    public String getpinNumber() { return pinNumber; }
    @Override
    public boolean isExpired(){return super.isExpired();}
    @Override
    public String format()
    {
        return super.format() + "\nCard Number:\t" + cardNumber +
                                "\nPIN Number:\t" + pinNumber;
    }
    @Override
    public String toString()
    {
        return "Calling Card\t[name = " + super.name + "] [number = " 
                + cardNumber +", pin = "+ pinNumber +"]";
    }
    public boolean equals(CallingCard rightCard)
    {
        if(super.equals(rightCard))
            if(cardNumber.equals(rightCard.getCardNumber()))
                if(pinNumber.equals(rightCard.getpinNumber()))
                    return true;
  
        return false;
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
    public int getExpirationYear() { return expirationYear; }
    @Override
    public String format()
    {
         return super.format() + "\nExpiration Year:\t" + expirationYear;
    }
    
    @Override
    public String toString()
    {
        return "Driver License\t[name = " + super.getName() + 
                "] [Expiration Year = " + expirationYear +"]";
    }
    
    public boolean equals(DriverLicense rightCard)
    {
        if(super.equals(rightCard))
            if(expirationYear == rightCard.getExpirationYear())
                return true;
  
        return false;
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
        CallingCard cc_equal_test = new CallingCard("Tyler Quayle", "1230", "1922");
        
        DriverLicense dl_test = new DriverLicense("Tyler Quayle", 2016);
        DriverLicense dl_equal_test = new DriverLicense("Tyler Quayle", 2016);
        
        IDCard id_test = new IDCard("Tyler Quayle", "12421");
        IDCard id_equal_test = new IDCard("Tyler Quayle", "999999");
        
        System.out.println("Testing Calling Card Equals Method: Expecting DNE");
        if(cc_test.equals(cc_equal_test))
            System.out.println(cc_test + "\n\t Equals \n" + cc_equal_test);
        else
            System.out.println(cc_test + "\n\tDoes not Equal\n" + cc_equal_test);
        
        System.out.println("\nTesting Driver License Equals Method: Expecting EQUAL");
        if(dl_test.equals(dl_equal_test))
            System.out.println(dl_test + "\n\t Equals\n" + dl_equal_test);
        else
            System.out.println(dl_test + "\n\t Does not Equal\n" + dl_equal_test);
        
        System.out.println("\nTesting Driver License Equals Method: Expecting DNE");
        if(id_test.equals(id_equal_test))
            System.out.println(id_test + "\n\t Equals\n" + id_equal_test);
        else
            System.out.println(id_test + "\n\t Does not Equal \n" + id_equal_test);
    }

}
    

