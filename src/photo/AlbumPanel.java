package photo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class AlbumPanel extends JPanel {
	
	ArrayList<JButton> box = new ArrayList<JButton>();
	
	Font font = new Font("Forte",Font.PLAIN,30);
	
	public void AddAlbum(String name)
	{
		int currentgall = Gallery.currentGalery;
		
		box.add(new JButton());
		box.get(Gallery.currentGalery).setVisible(false);
		box.get(Gallery.currentGalery).addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseExited(MouseEvent arg0) {}
			
			public void mouseEntered(MouseEvent arg0) {}
			
			int NumGall = Gallery.currentGalery;
			
			public void mouseClicked(MouseEvent e) {
				if ( e.getButton()==MouseEvent.BUTTON3)
				{
					try {
						MainFrame.choose(NumGall);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					try {
						if(!MainFrame.galleries[NumGall].pictureFile.isEmpty())
						{
							Gallery.currentGalery = NumGall;
							MainFrame.galleries[NumGall].setpicture();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		box.get(currentgall).setLayout(new GridLayout(10, 1));
		box.get(currentgall).setPreferredSize(new Dimension(300,100));
		box.get(currentgall).setBackground(Color.green);
		box.get(currentgall).setVisible(true);
		box.get(currentgall).setText(name);
		box.get(currentgall).setFont(font);
		this.add(box.get(currentgall));
		this.revalidate();
		this.repaint();
		
	}

}

