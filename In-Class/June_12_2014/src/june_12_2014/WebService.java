/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package june_12_2014;

/**
 *
 * @author Tyler
 */
import java.util.Scanner;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.net.URLDecoder;

/**
   This program provides a web service that can only serve the GET command.
   It will return the file or the 404 Not Found message.
*/
public class WebService
{
   private Socket s;
   private PrintWriter out; 

   /**
      Constructs a service object that serve the GET command
      @param aSocket the socket
   */
   public WebService(Socket aSocket)
   {
      s = aSocket;
   }

   /**
      Reads from the client and execute the command.
   */
   public void doService()
         throws IOException
   {
      Scanner in; 
      String line;
      in = new Scanner(s.getInputStream());
      out = new PrintWriter(s.getOutputStream());          
          
      line = null;
      while (in.hasNextLine())
      {
         line = in.nextLine();
         executeCommand(line);
         break;
      }
   }

   /**
      This will execute the GET command.
      @param command the command that needs to be execute
   */
   public void executeCommand(String command)
         throws IOException
   {
      String method = "";
      String filepath = "";
      String protocolVersion = null;

      StringTokenizer st = new StringTokenizer(command, " ");
      method = st.nextToken();
      if (method.equals("GET"))
      {
         filepath = st.nextToken();
         protocolVersion = st.nextToken();
         reply(protocolVersion, filepath);
      }
   }

   /**
      This replys to the client if it finds the file, else it will
      reply an error message such as 404 Not Found.
      @param protocolVersion the version of the protocol that the client use
      @param filepath the path of the file that the client request
   */
   public void reply(String protocolVersion, String filepath)
         throws IOException
   {
      filepath = URLDecoder.decode(filepath, "UTF-8");      
      Scanner in = null;
      int input = -1;
      out.print(protocolVersion + " 200 OK\n\n");
        
      try
      {  
         in = new Scanner(new FileInputStream(filepath));
         while (in.hasNextLine())
         {   
            out.println(in.nextLine());
         } 
      }
      catch(FileNotFoundException exception)
      {
         out.println("404 Not Found: " + filepath);
      }
      out.flush();
   }
}
