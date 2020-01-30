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

public class SettingPanel extends JPanel {

	JPanel panel = new JPanel(); 
	
	JLabel Speed = new  JLabel("SPEED");
	JRadioButton slowradiobutton = new JRadioButton("Slow");
	JRadioButton normalradiobutton =new JRadioButton("Normal");
	JRadioButton fastradiobutton = new JRadioButton("Fast");
	ButtonGroup Setting =new ButtonGroup();
	
	Font font =new Font("Algerian",Font.BOLD,40);
	Font font1 = new Font("Palace Script MT",Font.BOLD,40);
	
	static int speed = 2000;
	
	public SettingPanel()throws IOException
	{
		
		Setting.add(slowradiobutton);
		Setting.add(normalradiobutton );
		Setting.add(fastradiobutton);
		
		Speed.setFont(font);
		slowradiobutton.setFont(font1);
		fastradiobutton.setFont(font1);
		normalradiobutton.setFont(font1);
		
		panel.add(Speed);
		panel.add(fastradiobutton);
		panel.add(normalradiobutton);
		panel.add(slowradiobutton);
		panel.setPreferredSize(new Dimension(300, 350));
		panel.setBackground(Color.green);
		this.add(panel,BorderLayout.EAST);
		
		slowradiobutton.setBackground(Color.yellow);
		slowradiobutton.setPreferredSize(new Dimension(300, 100));
		normalradiobutton.setBackground(Color.cyan);
		normalradiobutton.setPreferredSize(new Dimension(300, 100));
		fastradiobutton.setBackground(Color.red);
		fastradiobutton.setPreferredSize(new Dimension(300, 100));
		
		time();
		
	}
	//*****************************************************************************
	public void time()
	{
		slowradiobutton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				speed = 3000;
			}
		});
		
		normalradiobutton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				speed =2000;
			}
		});
		
		fastradiobutton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				speed=1000;
			}
		});
	}
}

