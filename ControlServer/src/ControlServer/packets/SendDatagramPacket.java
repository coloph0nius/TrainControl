package ControlServer.packets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendDatagramPacket
{
    public static void sendPacket(String messageasstring, InetAddress address, int port)
    {
        byte [] message = messageasstring.getBytes();
        DatagramPacket packet = new DatagramPacket(message, message.length,
                address, port);
        DatagramSocket dsocket;
        try
        {
            dsocket = new DatagramSocket();
            dsocket.send(packet);
            dsocket.close();
        } 
        catch (SocketException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
}
