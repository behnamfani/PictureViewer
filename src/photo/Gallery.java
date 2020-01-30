package photo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gallery extends AlbumPanel {
	
	ArrayList<File> pictureFile = new ArrayList<File>();
	
	static JLabel pictureLabel = new JLabel();
	
	static int NumOfAlbum =0;
	static int currentGalery =-1;
	
	int  CurrentImage = 0 ;
	
	public Gallery() throws IOException {}
	//***************************************************************************************
	public void setpicture() throws IOException 
	{
		// TODO Auto-generated method stub
		CurrentImage %= pictureFile.size();
		BufferedImage bufferedimage = ImageIO.read(pictureFile.get(CurrentImage));
		pictureLabel.setIcon(new ImageIcon(bufferedimage));
	}


}

