package ControlServer.parts;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import ControlServer.packets.LocomotivePacket;
import ControlServer.packets.RemotePacket;

public class ControlServer 
{
    private DatagramSocket socket;
    
    private byte[] buf = new byte[1024];
    private boolean running = true;
    
    private static final int SERVERPORT = 4711;
    private static final String END = "end";
    private static final String LOCOMOTIVE_PACKET ="locomotive-packet";
    private static final String REMOTE_PACKET ="remote-packet";
    
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
        while (running)
        {
            DatagramPacket packet = new DatagramPacket (buf, buf.length);
            try
            {
                socket.receive(packet);
                processPacket(packet);
            } 
            catch (IOException e)
            {
                e.printStackTrace();
            }
           
        }
        socket.close();
        
    }
   
    public void processPacket(DatagramPacket packet)
    {
        String received = new String (packet.getData(), 0, packet.getLength());
        String results [] = received.split(";");
        if (results.length == 1 )
        {
            if (results[0].equals(END))
            {
                running = false;
            } 
        }
        else
        {
            if (results[0].equals(LOCOMOTIVE_PACKET))
            {
                LocomotivePacket.addLocomotive(results, packet);
            }
            else if (results[0].equals(REMOTE_PACKET))
            {
                RemotePacket.processRemoteRequest(results);
            }
        }
        
    }
}
