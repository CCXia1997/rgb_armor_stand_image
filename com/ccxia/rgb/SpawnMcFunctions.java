package com.ccxia.rgb;

public class SpawnMcFunctions {
	
	public static void spawnRgbArmorStand(String image) throws Exception
	{
		ReadRgbColor rgb=new ReadRgbColor();
		int width=rgb.getWidth(image);
		int height=rgb.getHeight(image);
		for(int i=0;i<width;i++)
			for(int j=0;j<height;j++)
			{
				int rgb_in_mc=rgb.getImagePixelInMc(image,i,j);
				System.out.println("summon armor_stand ~"+(double)i*0.8+" ~1 ~"+(double)j*0.8+" {NoGravity:1b,ArmorItems:[{},{},{},{id:\"leather_helmet\",Count:1b,tag:{display:{color:"+rgb_in_mc+"}}}],Invisible:1b,Small:0b}");
			}

	}
	public static void main(String[] args) throws Exception
	{
		String image1=new String("C:\\Users\\lenovo\\Desktop\\пн╡ъ\\1.12.2jar\\assets\\minecraft\\textures\\blocks\\bookshelf.png");
		spawnRgbArmorStand(image1);
	}
}
