package photo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.*;
import java.util.Timer;

public class ControlPanel extends JPanel{
	
	JButton next = new JButton();
	JButton back = new JButton();
	
	ToggleButton toggel  =new ToggleButton();
	
	Timer timer;
	
	public ControlPanel() throws IOException{
	 	File RepeatOff =new File("Repeat-100.png");
		BufferedImage image3 = ImageIO.read(RepeatOff);
		toggel.Repeat.setIcon(new ImageIcon(image3));
		this.add(toggel.Repeat);
		this.add(new JSeparator());
		//***************************************************************************************
		
		File file = new File("Rewind-104.png");
		BufferedImage image = ImageIO.read(file);
		back.setIcon(new ImageIcon(image));
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if ( MainFrame.galleries[Gallery.currentGalery].CurrentImage<=0)
					MainFrame.galleries[Gallery.currentGalery].CurrentImage=MainFrame.galleries[Gallery.currentGalery].pictureFile.size();
				
				MainFrame.galleries[Gallery.currentGalery].CurrentImage--;
				
				try {
					MainFrame.galleries[Gallery.currentGalery].setpicture();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		this.add(back);
		this.add(new JSeparator());
		
		//***************************************************************************************
		
		File play =new File("Play Filled-100.png");
		BufferedImage image4 = ImageIO.read(play);
		toggel.Play.setIcon(new ImageIcon(image4));
		this.add(toggel.Play);
		this.add(new JSeparator());
		
		//***************************************************************************************
		
		file= new File("FastForward-.png");
		image = ImageIO.read(file);
		next.setIcon(new ImageIcon(image));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				if ( MainFrame.galleries[Gallery.currentGalery].CurrentImage>= MainFrame.galleries[Gallery.currentGalery].pictureFile.size()-1)
					MainFrame.galleries[Gallery.currentGalery].CurrentImage = -1;
				
				MainFrame.galleries[Gallery.currentGalery].CurrentImage++;
				
				try {
					MainFrame.galleries[Gallery.currentGalery].setpicture();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		this.add(next);
		this.add(new JSeparator());
		//***************************************************************************************
	
		File ShuffleOff =new File("Shuffle-96.png");
		BufferedImage image2 = ImageIO.read(ShuffleOff);
		toggel.Shuffle.setIcon(new ImageIcon(image2));
		this.add(toggel.Shuffle);
		this.setBackground(Color.white);
	}
}

