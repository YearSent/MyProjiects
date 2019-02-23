package shou_xieV2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Listener  implements MouseListener {
	Graphics g;
	AListener al;
	HashMap<Integer, Integer> hash= new HashMap<>();
	int x0 = 0, y0 = 100, x1, y1;
	int countout=1,countin=0;
	//�Ա�ÿ��λ�õ����ݲ�ֵ
	int kk=0;
	int[] k = new int[150];int count=0;
	int min;
	// ����ߴ�
	public static final int width = 600;
	public static final int height = 500;
	// ��λ����ߴ�
	public static final int size = 15;
	int[][] sz;
	//��¼ʶ�����������
	String shuzi;
	JTextField LcalShow;
	//����һ�����������ķ���
	public void setCalShow(JTextField text)
	{
		LcalShow=text;
	}
	public Listener(Graphics g, int[][] sz,AListener al) {
		this.g = g;
		this.sz = sz;
		this.al=al;
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < width / size; i++)
			for (int j = 0; j < height / size; j++) {
				g.setColor(Color.black);
				g.fillRect(x0 + i * size, y0 + j * size, size, size);
			}
		//��ȡ�ĵ����ݲ����
//		int a;
//		String pathname,filename;
//		countin=countin+1;
//		filename=Integer.toString(countin);
//		pathname="D:\\java_study\\180717��дʶ��\\src\\exersize_data\\"+filename+".txt";
//		File file = new File(pathname);
//		try {
//			InputStream in = new FileInputStream(file);
//			for (int i = 0; i < height / size; i++) {
//				for (int j = 0; j < width / size; j++){
//					try {
//						a=in.read();
//						
//						System.out.print(a-48);
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//				}
//				System.out.print("\n");
//			}
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		   
		
		for (int i = 0; i < height / size; i++)
			for (int j = 0; j < width / size; j++)
				sz[i][j] = 0;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		kk=0;
		int a;
		for(int m=0;m<10;m++)
		{
			al.c=Integer.toString(m);
			String pathname,filename;
			//ÿ�����ֶ���һ��
			for(int n=1;n<15;n++)
			{
				kk=0;
				filename=Integer.toString(n);
				pathname="D:\\java_study\\180717��дʶ��\\src\\exersize_data\\"+al.c+filename+".txt";
				File file = new File(pathname);
				try {
					InputStream in = new FileInputStream(file);
					for (int i = 0; i < height / size; i++) {
						for (int j = 0; j < width / size; j++){
							try {
								a=in.read();
								//�����ֵ
								kk+=Math.abs(sz[i][j]-a+48);
//								System.out.print(a-48);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
//						System.out.print("\n");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				k[count++]=kk;
				hash.put(kk, m);
			}
			
		}
		//kk����Сֵ
		min=1000;
		for(int l=0;l<count;l++)
		{
			if(k[l]!=0&&k[l]<min)
				min=k[l];
		}
		System.out.print("\n"+hash.get(min));
		//ʶ���������
		shuzi=Integer.toString(hash.get(min));
		
		LcalShow.setText(al.num+shuzi);
		al.num=LcalShow.getText();
		al.pd=0;
		count=0;

	}
	

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}