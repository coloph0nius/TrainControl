package ControlServer.packets;

public class RemotePacket
{
    private static final String REMOTE_PACKET ="remote-packet";
    private static final String REQUEST_LIST = "request-list";
    private static final String SET_LOCO = "set-loco";
    
    public static void processRemoteRequest(String packetcontent[])
    {
        int length = packetcontent.length;
        if (length == 2 && packetcontent[0].equals(REMOTE_PACKET) && packetcontent[1].equals(REQUEST_LIST))
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
