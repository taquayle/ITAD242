

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
   This program tests the bank server.
*/
public class BankClient
{      
   public static void main(String[] args) throws IOException
   {
       /*
      // start the server
      class ServerRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               BankServer.main(null);
            }
            catch (IOException ex)
            {
               ex.printStackTrace();
            }
         }
      };
      
      Thread t = new Thread(new ServerRunnable());
      t.start();
      */
      final int SBAP_PORT = 8888;
      //Socket s = new Socket("localhost", SBAP_PORT);
      
      //REZA this one is for connecting to local ip
      Socket s = new Socket("10.10.5.123", SBAP_PORT);
      InputStream instream = s.getInputStream();
      OutputStream outstream = s.getOutputStream();
      Scanner in = new Scanner(instream);
      PrintWriter out = new PrintWriter(outstream); 
      
      String command = "DEPOSIT 3 1000\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      String response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "WITHDRAW 3 5000\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);

      command = "DEPOSIT -3 1000\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "DEPOSIT 30 5000\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "DEPOSIT 3 500\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "DEPOSIT 3 -30\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "WRONG 3\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "BALANCE 3\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();
      response = in.nextLine();
      System.out.println("Receiving: " + response);
      
      command = "QUIT\n";
      System.out.print("Sending: " + command);
      out.print(command);
      out.flush();

      s.close();
      
      System.exit(0);
   }
}
