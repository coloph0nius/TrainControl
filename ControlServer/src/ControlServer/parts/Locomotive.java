package ControlServer.parts;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * Class which holds the information about a locomotive
 * @author Arff
 *
 */
public class Locomotive
{
    private String _name;
    private int _direction;
    private int _speed;
    private InetAddress _address;
    
    /**
     * creates a new locomotive object with the given string as name and zero for direction and speed
     * @param name the name as string 
     */
    public Locomotive (String name, DatagramPacket packet)
    {
        _name = name;
        _direction = 0;
        _speed = 0;
        _address = packet.getAddress();
    }
    
    /**
     * Sets direction and speed of the locomotive
     * @param direction the direction
     * @param speed the pwm speed
     */
    public void setSpeed(int direction, int speed)
    {
        _direction = direction;
        if (0 <= speed && speed <= 255)
        {
            _speed = speed;
        }
        else _speed = 0;
        
    }
    
    /**
     * Returns an int array with two fields, the first contains the direction, the second the pwm speed
     * @return int [direction, speed]
     */
    public int[] getSpeed()
    {
        int data[] = {_direction, _speed};
        return data;
        
    }
    
    /**
     * returns the name of the locomotive
     * @return returns name as string
     */
    public String getName()
    {
        return _name;
    }
    
    /**
     * returns the IP address of the locomotive
     * @return returns IP as INetAddress
     */
    public InetAddress getIP()
    {
        return _address;
    }
}
