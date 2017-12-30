package ControlServer.parts;

public class ServerLauncher 
{

	public static void main(String[] args)
	{
	    ControlServer cServer = new ControlServer();
	    cServer.run();
	    System.out.println("Server closed.");
	}

}
