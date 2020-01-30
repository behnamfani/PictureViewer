package photo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Timer;
import java.io.*;

public class ToggleButton extends JButton {
	
	Timer timer = new Timer(); 
	TimerTask timerT ; 
	
	static JToggleButton Play = new JToggleButton();
	
	File play =new File("Play Filled-100.png");
	BufferedImage image = ImageIO.read(play);
	
	File pause = new File("Pause Filled-100.png");
	BufferedImage image0 = ImageIO.read(pause);
		
	static JToggleButton Shuffle = new JToggleButton();

	File ShuffleOff =new File("Shuffle-96.png");
	BufferedImage image1 = ImageIO.read(ShuffleOff);
	
	File shuffleOn = new File("Shuffle-96 (1).png");
	BufferedImage image2 = ImageIO.read(shuffleOn);
	
	static JToggleButton Repeat = new JToggleButton();
	
	File RepeatOff =new File("Repeat-100.png");
	BufferedImage image3 = ImageIO.read(RepeatOff);
	
	File RepeatOn = new File("Repeat-100 (1).png");
	BufferedImage image4 = ImageIO.read(RepeatOn);
	
	
	public ToggleButton() throws IOException 
	{
		// TODO Auto-generated constructor stub
		Play();
		Shuffle();
		Repeat();
	}
	//***************************************************************************************
	public void Play ()
	{
		Play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(Play.isSelected())
				{
					Play.setIcon(new ImageIcon(image0));
					
					Timertask();

				}
				else
				{
					Play.setIcon(new ImageIcon(image));
					stop();
					Shuffle.setSelected(false);
					Repeat.setSelected(false);
				}
			}
		});
	}
	//***************************************************************************************
	public void Shuffle ()
	{
		Shuffle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(Shuffle.isSelected())
				{
					Shuffle.setIcon(new ImageIcon(image2));
					Repeat.setSelected(false);
				}
				else
					Shuffle.setIcon(new ImageIcon(image1));
				
			}
		});
	}
	//***************************************************************************************
	public void Repeat()
	{
		Repeat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(Repeat.isSelected())
				{
					Repeat.setIcon(new ImageIcon(image4));
					Shuffle.setSelected(false);
				}
				else
					Repeat.setIcon(new ImageIcon(image3));
			}
		});
	}
	//***************************************************************************************
	private void stop()
	{
		timer.cancel();
		timer.purge();
		timer= new Timer();
	}
	//***************************************************************************************
	private void Timertask()
	{
			timerT = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(Shuffle.isSelected()==false && Repeat.isSelected()==false)
				{
					
					
					try {
						MainFrame.galleries[Gallery.currentGalery].setpicture();
					} catch (IOException e) {}
					
					MainFrame.galleries[Gallery.currentGalery].CurrentImage ++;
					
					if (MainFrame.galleries[Gallery.currentGalery].CurrentImage==MainFrame.galleries[Gallery.currentGalery].pictureFile.size())
					{
						MainFrame.galleries[Gallery.currentGalery].CurrentImage=0;
						stop();
					}
				}
				else if(Shuffle.isSelected())
				{
					int random = (int) ((MainFrame.galleries[Gallery.currentGalery].pictureFile.size())*Math.random());
					
					if(random == MainFrame.galleries[Gallery.currentGalery].CurrentImage){
						random++;
						
						random %= MainFrame.galleries[Gallery.currentGalery].pictureFile.size();
				}

					try {
						
						MainFrame.galleries[Gallery.currentGalery].CurrentImage = random;
						MainFrame.galleries[Gallery.currentGalery].setpicture();
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(Repeat.isSelected())
				{
					Shuffle.setSelected(false);
					
					if(MainFrame.galleries[Gallery.currentGalery].CurrentImage<MainFrame.galleries[Gallery.currentGalery].pictureFile.size())
						MainFrame.galleries[Gallery.currentGalery].CurrentImage++ ;
					
					else
					{
						MainFrame.galleries[Gallery.currentGalery].CurrentImage=0;
					}
					try {
					
						MainFrame.galleries[Gallery.currentGalery].setpicture();
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					if(MainFrame.galleries[Gallery.currentGalery].CurrentImage<MainFrame.galleries[Gallery.currentGalery].pictureFile.size())
					{}
					
					else
					{
						if(Shuffle.isSelected()==false)
							stop();
						return;
					}
				}
			}
		};
		timer.schedule(timerT, 500 ,SettingPanel.speed);
	}
}

