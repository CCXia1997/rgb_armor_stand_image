package rgb_armor_spawn0.gui;

public class SpawnMcCommands {
	public static String[] spawnRgbArmorStand(String image) throws Exception
	{
		ReadRgbColor rgb=new ReadRgbColor();
		int width=rgb.getWidth(image);
		int height=rgb.getHeight(image);
		String[] rgb_commands=new String[4096]; 
		for(int i=0;i<width;i++)
			for(int j=0;j<height;j++)
			{
				int rgb_in_mc=rgb.getImagePixelInMc(image,i,j);
				rgb_commands[i*height+j]="summon armor_stand ~"+(double)i*0.8+" ~1 ~"+(double)j*0.8+" {NoGravity:1b,ArmorItems:[{},{},{},{id:\"leather_helmet\",Count:1b,tag:{display:{color:"+rgb_in_mc+"}}}],Invisible:1b,Small:0b}";
			}
		return rgb_commands;
	}

}
