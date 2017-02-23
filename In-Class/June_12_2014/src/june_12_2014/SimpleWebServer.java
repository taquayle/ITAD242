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
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
   This is a simple Web Server that takes only the GET command.
*/
public class SimpleWebServer
{  
   public static void main(String[] args ) throws IOException
   {  
      final int PORT = 8080;
      ServerSocket server = new ServerSocket(PORT);
      System.out.println("Web server is up...");

      Socket s;
      while (true)
      {  
         s = server.accept();
         WebService service = new WebService(s);
         service.doService();
         s.close();
      }
   }
}