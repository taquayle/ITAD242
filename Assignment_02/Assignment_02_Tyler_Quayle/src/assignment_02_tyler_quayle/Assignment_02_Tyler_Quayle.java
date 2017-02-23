/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_02_tyler_quayle;

/**
 *
 * @author Quayle
 */

public class Assignment_02_Tyler_Quayle {

/* QUESTION 01 */
//public static void main(String[] args) 
//{
//    double length = 3.4;  
//    double width = 8.4; 
//
//    System.out.println("Rectangle: \nWidth: " + width + "\nLength: " + length);
//    System.out.println("Area of Rectangle is: " + AreaOfRectangle(width, length));
//}
///**
// * Method which accepts two double variables in order to calculate the area of
// * a rectangle
// * @param input_Width
// * @param input_Length
// * @return 
// */
//    public static double AreaOfRectangle(double input_Width, double input_Length)
//    {  
//        double rectangle_area = input_Length * input_Width;
//        return rectangle_area;
//    }
    
    /* QUESTION 04 */
//    public static void main(String[] args)
//   {
////       makeRow(5,"*");
////       makeRow(5,"=");
////       makeRow(5,"*");
////       printUpTriangle(13, "*");
////       printDownTriangle(13, "*");
//       printPyramid(21, "*");
////       printHouse(11, "*");
//   }
//        
//       public static void makeRow(int n, String s)
//       {
//           for(int i = 0; i < n; i++)
//               System.out.print(s);
//       }
//       
//       public static void printPyramid(int n, String s)
//       {
//        
//           for(int i = 1; i <= (n/2)+1; i++)
//           {
//               makeRow((n/2-i)+1," ");
//               makeRow(i,s);
//               makeRow(i-1,s);
//               System.out.println();
//           }
//       }
//       
//       public static void printHouse(int n, String s)
//       {
//           printPyramid(n, s);
//           for(int i = 1; i < n; i++)
//           {
//               makeRow(n, s);
//               System.out.println();
//           }
//       }
//       
//       public static void printUpTriangle(int n, String s)
//       {
//           for(int i = 1; i <= n; i++)
//           {
//               makeRow((n-i)," ");
//               makeRow(i,s);
//               System.out.println();
//                       
//           }
//       }
//       
//       public static void printDownTriangle(int n, String s)
//       {
//           for(int i = 0; i <= n; i++)
//           {
//               makeRow(i," ");
//               makeRow((n-i),s);
//               System.out.println();
//                       
//           }
//       }

    /*  QUESTION 05  */
    public static void main(String[] args)
    {
      int num = 2315778;
      System.out.println("Credit card number: " + num + " is " + checkDigits(num));
      num = 1234567;
      System.out.println("Credit card number: " + num + " is " + checkDigits(num));
      num = 7654321;
      System.out.println("Credit card number: " + num + " is " + checkDigits(num));
      num = 1111111;
      System.out.println("Credit card number: " + num + " is " + checkDigits(num));

    }
//    
    public static String checkDigits(int cNum)
    {
        int cardSum = 0, currentDigit;
        for(int i = 1; i < 8; i++)
        {
            currentDigit = cNum % 10;
            cNum = cNum / 10;
            
            if(i % 2 == 0)
                cardSum += decode(currentDigit, true);
            else
                cardSum += decode(currentDigit, false);
        }
        if ((cardSum % 10) == 0)
            return "Valid";
        else
            return "Invalid";
    }
    public static int decode(int digit, boolean even)
    {
        if(!even){
            return digit;}
        else
        {
           int double_digit = 2 * digit;
           if(double_digit < 10)
               return double_digit;
           else
              return (double_digit%10)+1; 
        }
    }
    
    /*  QUESTION 06 */
//    public static void main(String [] args)
//    {
//       for(int i = 0; i < 16; i++)
//       {
//        byte my_byte = (byte)i;
//        System.out.println( "Byte: " + my_byte + " is " + 
//                            bitsToHex(my_byte) + " in hexadecimal");
//       }
//    }
//    
//    public static String bitsToHex(byte input_byte)
//    {
//        String toHex[] ={"0", "1", "2","3", "4", "5", "6", "7", "8", "9", 
//                        "A", "B", "C", "D", "E", "F"};
//        return toHex[input_byte];
//    }
    /* Question 7 */
//    public static class Door{
//        private String name;
//        private String state;
//        
//        public Door(String input_name, String input_state)
//        {
//            name = input_name;
//            state = input_state;
//        }
//        
//        public String getName(){return name;}
//        public String getState(){return state;}
//        public void setName(String newName){name = newName;}
//        public void setState(String newState){state = newState;}
//        public void close() {state = "Closed";}
//        public void open() {state = "Open";}
//    };
//    
//    public static void main(String [] args)
//    {
//       
//      Door frontDoor = new Door("Front", "open");
//      System.out.println("The front door is " + frontDoor.getState());
//      System.out.println("Expected:  open");
//      Door backDoor = new Door("Back", "closed");
//      System.out.println("The back door is " + backDoor.getState());
//      System.out.println("Expected:  closed");        
//      // Use the mutator to change the state variable
//      backDoor.setState("open");
//      System.out.println("The back door is " + backDoor.getState());
//      System.out.println("Expected:  open");
//      // Add code to test the setName mutator here 
//      Door sideDoor = new Door("Side", "closed");
//      System.out.println("The side door is " + sideDoor.getState());
//      System.out.println("Expected: closed");
//      sideDoor.setState("open");
//      System.out.println("The side door is " + sideDoor.getState());
//      System.out.println("Expected: open");
//    }
    
    /* Question 08 */
//    public static class VendingMachine
//    {
//        private int tokens;
//        private int cans;
//        
//        public VendingMachine()
//        {
//            tokens = 0;
//            cans = 10;
//        }
//        public VendingMachine(int numCans)
//        {
//            tokens = 0;
//            cans = numCans;
//        }
//        public void insertToken()
//        {
//            if(cans > 0)
//            { 
//                --cans;
//                ++tokens;
//            }
//            else
//                System.out.println("ERROR: no more cans");
//        }
//        public void fillUp() { cans++; }
//        public void fillUp(int numCans) { cans += numCans;}
//        public int getCanCount() { return cans; }
//        public int getTokenCount() { return tokens; }
//    }
//    public static void main(String[] args)
//   {
//      VendingMachine machine = new VendingMachine();
//      machine.fillUp(10); // Fill up with ten cans
//      machine.insertToken();
//      machine.insertToken();
//      System.out.print("Token count: ");
//      System.out.println(machine.getTokenCount());
//      System.out.println("Expected: . . .");
//      System.out.print("Can count: ");
//      System.out.println(machine.getCanCount()); 
//      System.out.println("Expected: . . .");
//   } 
    /* Question 09 */
//public static class Postcard
//{
//   private String message;
//   private String sender;
//   private String recipient;
//
//   public Postcard(String aSender, String aMessage)
//   {
//      message = aMessage;
//      sender = aSender;
//      recipient = "";
//   }
//   // Your method here
//  public void setRecipient(String aRecipient) { recipient = ("Dear " +aRecipient + ": "); }
//  
//  public void print() 
//  { 
//      System.out.println(recipient + message + "\nLove,\n" + sender);
//  } 
//}
//   public static void main(String[] args)
//   {
//      String text = "I am having a great time on\nthe island of Java. Weather\nis great. Wish you were here!";
//      Postcard postcard = new Postcard("Janice", text);
//      postcard.setRecipient("Sue");
//      postcard.print();
//      postcard.setRecipient("Tim");
//      postcard.print();
//   } 

        /* Question 10 */
//    public static void main(String[] args)
//   {
//       Person p1 = new Person("Test1");
//       p1.printCount();
//       Person p2 = new Person("Test2");
//       p1.printCount();
//       Person p3 = new Person("Test3");
//       p1.printCount();
//       Person p4 = new Person("Test4");
//       p1.printCount();
//   }    
//
//
//public static class Person
//{
//   private String name;
//   private static int count = 0;
//    
//   public Person()
//   {
//       name = null;
//       count++;
//   }
//   public Person(String name)
//   {
//      this.name = name;
//      count++;
//   }
//   public void setName(String name)
//   {
//      this.name = name;
//   }
//   public String getName()
//   {
//      return name;
//   }
//   public void speak()
//   {
//      System.out.println("My name is " + name);
//   }
//   public void printCount()
//   {
//       System.out.println("Current count: "  + count);
//   }
//}
//}
