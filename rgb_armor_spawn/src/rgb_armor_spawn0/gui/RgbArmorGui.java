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
				//�����������
				Frame f=new Frame();
				
				//���ô������
				f.setTitle("RGB���׼�������");
				
				//���ô����С
				f.setSize(400,300);
				
				//���ô���λ��
				f.setLocation(400,200);
				
				//���ò���Ϊ��ʽ����
				f.setLayout(new FlowLayout());
				
				//�ô��ڹر�
				//����������Ľ�
				f.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
				});
				
				//����ͼƬ·���ı���
				final TextField imag_tf=new TextField(20);
				
				//����ָ�������ı���
				final TextArea command_ta=new TextArea(12,50);
				
				//�������Ƶ������尴ť����
				Button bu_copy=new Button("���Ƶ�������");
				bu_copy.setSize(20,10);
				
				// ��ť�¼�
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
				
				
				
				//��������ָ�ť����
				Button bu_spawn=new Button("����ָ��");
				bu_spawn.setSize(20,10);
				
				//�Ѱ�ť��ӵ�����
				f.add(imag_tf);
				f.add(bu_spawn);
				f.add(bu_copy);
				f.add(command_ta);
				
				// ��ť�¼�
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
				
				
				
				
				
				
				
				
				
				//����һ��������ʹ�ô���ɼ�
				f.setVisible(true);
			}
}


