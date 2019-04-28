package rgb_armor_spawn0.gui;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ReadRgbColor {
	public int getImagePixelInMc(String image,int x,int y) throws Exception
	{
		int[] rgb = new int[3];
		int rgb_in_mc;
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();
		int pixel = bi.getRGB(x,y);
		rgb[0] = (pixel & 0xff0000) >> 16;
		rgb[1] = (pixel & 0xff00) >> 8;
		rgb[2] = (pixel & 0xff);
		rgb_in_mc=rgb[0]*65536+rgb[1]*256+rgb[2]*1;
		return rgb_in_mc;
	}
	public int getWidth(String image) throws Exception
	{
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		return width;
	}
	public int getHeight(String image) throws Exception

	{
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int height = bi.getHeight();
		return height;
	}

}
