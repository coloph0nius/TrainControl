package TrainRemote.parts;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RemoteUI
{
    public RemoteUI()
    {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.open();
        
        
        
        
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
             {
                display.sleep();
             }
        }
        display.dispose();
    }
}
