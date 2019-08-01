package sslserver;
import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
       SSLServerSocketFactory ssf =
           (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
       ServerSocket sslServerSocket = ssf.createServerSocket(50000);

       //Wait for a connection
       System.out.println("Waiting for a connection");
       Socket sock = sslServerSocket.accept();
       System.out.println("Got a connection");
       // Get the input stream. This will be automatically decrypted
       BufferedReader bR =
               new BufferedReader(new InputStreamReader(sock.getInputStream()));
       String line = bR.readLine();
       while (line != null)
       {
           System.out.println(line);
           line = bR.readLine();
       }
       // Close the buffered reader and underlying input stream
       bR.close();
       // close the socket
       sock.close();
    }
}
