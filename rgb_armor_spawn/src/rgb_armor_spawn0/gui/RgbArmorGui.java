package rgb_armor_spawn0.gui;
import java.awt.Toolkit;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class RgbArmorGui {
	public static void main(String[] args)
	{
				//创建窗体对象
				Frame f=new Frame();
				
				//设置窗体标题
				f.setTitle("RGB盔甲架生成器");
				
				//设置窗体大小
				f.setSize(400,300);
				
				//设置窗体位置
				f.setLocation(400,200);
				
				//设置布局为流式布局
				f.setLayout(new FlowLayout());
				
				//让窗口关闭
				//用适配器类改进
				f.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
				});
				
				//创建图片路径文本框
				final TextField imag_tf=new TextField(20);
				
				//创建指令生成文本域
				final TextArea command_ta=new TextArea(12,50);
				
				//创建复制到剪贴板按钮对象
				Button bu_copy=new Button("复制到剪贴板");
				bu_copy.setSize(20,10);
				
				// 按钮事件
				bu_copy.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
						String copy_str=command_ta.getText();
				        Transferable tText = new StringSelection(copy_str);  
				        clip.setContents(tText, null);
					}
				
				});
				
				
				
				//创建生成指令按钮对象
				Button bu_spawn=new Button("生成指令");
				bu_spawn.setSize(20,10);
				
				//把按钮添加到窗体
				f.add(imag_tf);
				f.add(bu_spawn);
				f.add(bu_copy);
				f.add(command_ta);
				
				// 按钮事件
				bu_spawn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String image_str=imag_tf.getText().trim();
						try {
							String[] rgb_commands=new String[4096];
							rgb_commands=SpawnMcCommands.spawnRgbArmorStand(image_str);
							int i=0;
							while(rgb_commands[i]!=null)
							{
								command_ta.append(rgb_commands[i]+"\r\n");
								i++;
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				});
				
				
				
				
				
				
				
				
				
				//调用一个方法，使得窗体可见
				f.setVisible(true);
			}
}


