package utility;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class imgoperations {
	private BufferedImage scimg;;
	private 	BufferedImage original;
	private  Graphics2D grph; 
	public boolean scaleimg(InputStream bis,double w,double h) {
		if(bis==null) {
			System.out.println("strumien null");
			return false;			
		}
		 try {
				original = ImageIO.read(bis);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
		 if(original ==null) {
			 System.out.println("bitmpaa null");
			 return false;
		 }
			double scale = w/original.getWidth();
			//int height = (int)(scale * original.getHeight());
			if(scale<=0)scale =1;
			System.out.println("skala " + w + "  " + scale);
			 scimg = new BufferedImage((int)w,(int)h,BufferedImage.TYPE_INT_ARGB);
              grph = (Graphics2D) scimg.getGraphics();
             grph.scale(scale, scale);
             grph.drawImage(original, 0, 0, null);
             grph.dispose();
             return true;
            }
	
	public boolean saveimg(int idp,String pname,int idimg) {
		File outf = new File("/var/proimages/"+idp+"img"+idimg+".png");
		try {
			ImageIO.write(scimg, "png", outf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	return true;
	}
	//https://stackoverflow.com/questions/1552812/mapping-a-directory-outside-the-web-app-to-url-in-tomcat
	

}
