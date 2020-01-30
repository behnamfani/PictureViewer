package photo;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class test {

	public static void main(String[] args) throws IOException  
	{
		MainFrame frame = new MainFrame();
	
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.setTitle("<< This Thing :| >>");
		
		ImageIcon icon = new ImageIcon("icon.png");
		frame.setIconImage(icon.getImage());
	}
}

