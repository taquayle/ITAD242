/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package june_12_2014;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.URLEncoder;
/**
 *
 * @author Tyler
 */
public class June_12_2014 {

/**
   This program demonstrates how to use a socket to communicate
   with a web server. Supply the name of the host and the
   resource on the command-line, for example
   java WebGet java.sun.com index.html
*/

   public static void main(String[] args) throws IOException
   {
      // Start the server
      class ServerRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               SimpleWebServer.main(new String[] {});
            }
            catch (IOException ex)
            {
               ex.printStackTrace();
            }
         }
      };
      Thread t1 = new Thread(new ServerRunnable());
      t1.start();

      // Get command-line arguments

      String host;
      String resource;
      int port;

      if (args.length == 3)
      {
         host = args[0];
         port = Integer.parseInt(args[1]);
         resource = args[2];
      }
      else
      {
         System.out.println("Getting / from java.sun.com");
         host = "microsoft.com";
         port = 80;
         resource = "/";
      }

      // Open socket

      Socket s = new Socket(host, port);

      // Get streams
      
      InputStream instream = s.getInputStream();
      OutputStream outstream = s.getOutputStream();

      // Turn streams into scanners and writers

      Scanner in = new Scanner(instream);
      PrintWriter out = new PrintWriter(outstream);      

      // Send command

      String command = "GET " + URLEncoder.encode(resource, "UTF-8") + " HTTP/1.0\n\n";
      out.print(command);
      out.flush();

      // Read server response

      while (in.hasNextLine())
      {
         String input = in.nextLine();
         System.out.println(input);
      }

      // Always close the socket at the end

      s.close();

      System.exit(0);      
   }
}







