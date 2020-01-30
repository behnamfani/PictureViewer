package photo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.file.Files;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	
	JMenuBar MenuBar = new JMenuBar();
	
	JMenu File =new JMenu("File");
	JMenuItem New = new JMenuItem("New ");
	JMenuItem Exit = new JMenuItem("Exit");
	
	JMenu Help =new JMenu("Help");
	JMenuItem About = new JMenuItem("About");
	
	static JPanel Picture =new JPanel();
	
	ControlPanel control = new ControlPanel();
	SettingPanel setting = new SettingPanel();
	AlbumPanel album = new AlbumPanel();
	
	static Gallery [] galleries = new Gallery [10];
	
	Font font = new Font("Kristen ITC",Font.PLAIN,30);
	Font font1 = new Font("Kristen ITC",Font.PLAIN,20);
	

	
	public MainFrame()throws IOException
		{
			MenuBar();
			PicturePanel();
			ControlPanel();
			AlbumPanel ();
			
			
			JPanel right = new JPanel();
			this.add(right,BorderLayout.EAST);
			right.add(setting,BorderLayout.EAST);
			right.setBackground(Color.BLACK);
		}
		//***************************************************************************************
		
		private void MenuBar ()throws IOException
		{
			Exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()== Exit)
				{
						int result= JOptionPane.showConfirmDialog(Exit, "Are you sure that you want to close Image Viewer.", "Confirm Exit", JOptionPane.YES_NO_OPTION);
						if(result== JOptionPane.YES_OPTION)
						System.exit(0);
				}
				}
			});
			
			New.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String result =JOptionPane.showInputDialog(New,"Name:");
					Gallery.currentGalery = Gallery.NumOfAlbum;
					album.AddAlbum(result);
					Gallery.NumOfAlbum++;
					
					try {
						galleries[Gallery.currentGalery] = new Gallery();
					} catch (IOException e) {
						e.printStackTrace();
					}
					}
			});
			
			About.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {			
				
							JOptionPane note = new JOptionPane("PhotoPlayer version 1.0 made by Mr Behnam Fani :D");
							JDialog noted = note.createDialog(null, "About this photo player");
							noted.setSize(150, 150);
							noted.setVisible(true);
						}
						
					});
			
			
				
	
			MenuBar.add(File);
			MenuBar.add(Help);
			File.add(New);
			File.addSeparator();
			File.add(Exit);
			Help.add(About);
			File.setFont(font);
			New.setFont(font1);
			Exit.setFont(font1);
			About.setFont(font1);
			Help.setFont(font);
			this.setJMenuBar(MenuBar);
		}
		//***************************************************************************************
		private void PicturePanel() throws IOException
		{
			this.add(Picture,BorderLayout.CENTER);
			Picture.setBackground(Color.white);
			Picture.add(Gallery.pictureLabel);
		}
		//***************************************************************************************
		private void AlbumPanel ()throws IOException
		{
			this.add(album,BorderLayout.WEST);
			album.setBackground(Color.black);
			album.setPreferredSize(new Dimension(300, 0));
			
		}
		//***************************************************************************************
		private void ControlPanel()throws IOException
		{
			this.add(control,BorderLayout.SOUTH);
			control.setBackground(Color.BLACK);
		}
		//***************************************************************************************
		public static void show(int number) throws IOException
		{
			galleries[Gallery.currentGalery].setpicture();
			galleries[Gallery.currentGalery].CurrentImage=0;
		}
		//***************************************************************************************
		public static void choose(int t) throws IOException
		{
			JFileChooser chosser =new JFileChooser();
			chosser.setMultiSelectionEnabled(true);
			if(chosser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
				File [] file =  chosser.getSelectedFiles();
				for (int i=0;i<file.length;i++){
					galleries[Gallery.currentGalery].pictureFile.add(file[i]);
					galleries[Gallery.currentGalery].setpicture();
				}	
			}
		}
		//***************************************************************************************
		public void windowClosed(WindowEvent e) {}

		public void windowIconified(WindowEvent e) {}

		public void windowDeiconified(WindowEvent e) {}

		public void windowActivated(WindowEvent e) {}
		
		public void windowDeactivated(WindowEvent e) {}
		
		public void windowOpened(WindowEvent e) {}

		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
		
			System.exit(0);
		}
}




