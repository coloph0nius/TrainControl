package ControlServer.packets;

import java.net.DatagramPacket;
import java.util.Map;
import java.util.TreeMap;

import ControlServer.parts.Locomotive;

public class LocomotivePacket
{
    public static Map <String, Locomotive> locoMap = new TreeMap<String, Locomotive> ();
    private static final String LOCOMOTIVE_PACKET ="locomotive-packet";
    
    public static void addLocomotive(String packetcontent[], DatagramPacket packet)
    {
        int length = packetcontent.length;
        if (length == 2 && packetcontent[0].equals(LOCOMOTIVE_PACKET))
        {
            locoMap.put(packetcontent[1], new Locomotive (packetcontent[1], packet));
        }
    }

}
