package ControlServer.parts;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ControlServer 
{
    private DatagramSocket socket;
    private boolean running;
    private static final int SERVERPORT = 4711;
    private byte[] buf = new byte[1024];
    
    public ControlServer()
    {
        try
        {
            socket = new DatagramSocket(SERVERPORT);
            System.out.println("server started on port "+ SERVERPORT + "...");
        } 
        catch (SocketException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void run()
    {
        running = true;
        while (running)
        {
            DatagramPacket packet = new DatagramPacket (buf, buf.length);
            try
            {
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                String received = new String (packet.getData(), 0, packet.getLength());
                System.out.printf("Received from %s, Port: %d. Message: %s\n", address.toString(), port, received);
                if (received.equals("end"))
                {
                    running = false;
                }
            } 
            catch (IOException e)
            {
                e.printStackTrace();
            }
           
        }
        socket.close();
        
    }
}
