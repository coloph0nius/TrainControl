package ControlServer.packets;

public class RemotePacket
{
    private static final String LOCOMOTIVE_PACKET ="remote-packet";
    private static final String REQUEST_LIST = "request-list";
    private static final String SET_LOCO = "set-loco";
    
    public static void processRemoteRequest(String packetcontent[])
    {
        int length = packetcontent.length;
        if (length == 2 && packetcontent[1].equals(REQUEST_LIST))
        {
            //TODO send locoMap
            System.out.println("send locoMap");
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
