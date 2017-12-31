package ControlServer.packets;

import java.net.InetAddress;

public class RemotePacket
{
    private static final String REMOTE_PACKET ="remote-packet";
    private static final String REQUEST_LIST = "request-list";
    private static final String SET_LOCO = "set-loco";
    private static final String NO_LOCO = "no locomotives registered yet";
    private static final int REMOTE_PORT = 4712;
    
    public static void processRemoteRequest(String packetcontent[], InetAddress address)
    {
        int length = packetcontent.length;
        if (length == 2 && packetcontent[0].equals(REMOTE_PACKET) && packetcontent[1].equals(REQUEST_LIST))
        {
            System.out.println("send locoMap");
            String message = NO_LOCO;
            if(!LocomotivePacket.locoMap.isEmpty())
            {
                message = "";
                for (String key : LocomotivePacket.locoMap.keySet())
                {
                    message+=key+";";
                }
            }
            SendDatagramPacket.sendPacket(message, address, REMOTE_PORT);
           
           
        }
        else if (length == 5 && packetcontent[1].equals(SET_LOCO))
        {
            if (LocomotivePacket.locoMap.containsKey(packetcontent[2]))
            {
                LocomotivePacket.locoMap.get(packetcontent[2]).setSpeed(Integer.parseInt(packetcontent[3]), Integer.parseInt(packetcontent[4]));
            }
        }
    }
}
