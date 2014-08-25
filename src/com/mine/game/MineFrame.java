package com.mine.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MineFrame extends JFrame{
	static Timer time ;
	private JMenuBar caidan ;
	private JMenu xitong;
	private JMenu chakan;
	private JMenuItem chuji;
	private JMenuItem zhongji;
	private JMenuItem gaoji;
	private JMenuItem tuichu;
	private JMenuItem bangzhu;
	private JPanel jPanel1 ; //一个容器
	private JPanel jPanel2 ;
	private int row ;
	private int col ;
	private int lNum ;
	static JButton[] jl = new JButton[3];
	static JButton[] js = new JButton[3];
	static MineButton[][] button;
	private JButton face ;
	private ImageIcon f =new ImageIcon("Image/face.jpg");
	private Insets space = new Insets (0,0,0,0);
	public MineFrame() {
		setTitle("扫雷");
		caidan = new JMenuBar();
		add(caidan,BorderLayout.NORTH);
		xitong = new JMenu("系统");
		chakan = new JMenu("查看");
		caidan.add(xitong);
		caidan.add(chakan);
		chuji = new JMenuItem("初级 ");
		chuji.addActionListener(new ChuJi());
		zhongji = new JMenuItem("中级");
		zhongji.addActionListener(new ZhongJi());
		gaoji = new JMenuItem("高级");
		gaoji.addActionListener(new GaoJi());
		tuichu = new JMenuItem("退出");
		tuichu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		bangzhu = new JMenuItem("帮助");
		bangzhu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Help.getHelp();
			}
		});
		xitong.add(chuji);
		xitong.add(zhongji);
		xitong.add(gaoji);
		xitong.addSeparator();
		xitong.add(tuichu);
		chakan.add(bangzhu);
		jPanel1 = new JPanel();
		this.add(jPanel1,BorderLayout.CENTER);
		for(int i = 0 ; i<3 ; i++ ) {
			jl[i] = new JButton();
			jl[i].setIcon(new ImageIcon("Image/0.jpg"));
			jl[i].setMargin(space);
			jPanel1.add(jl[i]);
		}
		face = new JButton();
		face.setIcon(f);
		face.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!MineButton.T) {
					time.cancel();
					MineButton.T = true;
				}
				js[0].setIcon(new ImageIcon("Image/0.jpg"));
				js[1].setIcon(new ImageIcon("Image/0.jpg"));
				js[2].setIcon(new ImageIcon("Image/0.jpg"));
				remove(jPanel2);
				jPanel2 = new JPanel();
				jPanel2.setLayout(new GridLayout(row,col,0,0));
				button = new MineButton[row][col];
				for(int i = 0 ; i<row ; i++ ) {
					for(int j = 0 ; j< col ;j++ ) {
						button[i][j] = new MineButton();
						button[i][j].setFlagNum(lNum);
						button[i][j].paintFlag();
						button[i][j].setIJ(i, j);
						button[i][j].setRC(row,col);
						jPanel2.add(button[i][j]);
						
					}
				}
				creatLei();
				add(jPanel2,BorderLayout.SOUTH);
				pack();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				face.setIcon(new ImageIcon("Image/face.jpg"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				face.setIcon(new ImageIcon("Image/face1.jpg"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		face.setMargin(space);
		jPanel1.add(face);
		for(int i = 0 ;i<3 ; i++ ) {
			js[i] = new JButton();
			js[i].setIcon(new ImageIcon("Image/0.jpg"));
			js[i].setMargin(space);
			jPanel1.add(js[i]);
		}
		//添加雷盘 。。
		creatPanel();
		setResizable(false);//不可手动调控窗体的大小
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
	}
	public void creatPanel() {
		row = 12 ;
		col = 12 ;
		lNum = 2 ;
		jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(row,col,0,0));
		button = new MineButton[row][col];
		for(int i = 0 ; i<row ; i++ ) {
			for(int j = 0 ; j< col ;j++ ) {
				button[i][j] = new MineButton();
				button[i][j].setFlagNum(lNum);
				button[i][j].paintFlag();
				button[i][j].setIJ(i, j);
				button[i][j].setRC(row,col);
				jPanel2.add(button[i][j]);
				
			}
		}
		creatLei();
		this.add(jPanel2,BorderLayout.SOUTH);
	}
	public void creatLei() {
		for(int i = 0; i <lNum ;i++) {
			while(true) {
				int x =(int)(Math.random()*row) ;
				int y =(int)(Math.random()*col) ;
				if(button[x][y].getDif()!=100) {
					button[x][y].setDif(100);
					break;
				}
			}
		}
	}
	class ChuJi implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!MineButton.T) {
				time.cancel();
				MineButton.T = true;
			}

			js[0].setIcon(new ImageIcon("Image/0.jpg"));
			js[1].setIcon(new ImageIcon("Image/0.jpg"));
			js[2].setIcon(new ImageIcon("Image/0.jpg"));
			remove(jPanel2);
			row = 12 ;
			col = 12 ;
			lNum = 20 ;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridLayout(row,col,0,0));
			button = new MineButton[row][col];
			for(int i = 0 ; i<row ; i++ ) {
				for(int j = 0 ; j< col ;j++ ) {
					button[i][j] = new MineButton();
					button[i][j].setFlagNum(lNum);
					button[i][j].paintFlag();
					button[i][j].setIJ(i, j);
					button[i][j].setRC(row,col);
					jPanel2.add(button[i][j]);
					
				}
			}
			creatLei();
			add(jPanel2,BorderLayout.SOUTH);
			pack();
		}
		
	}
	class ZhongJi implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!MineButton.T) {
				time.cancel();
				MineButton.T = true;
			}

			js[0].setIcon(new ImageIcon("Image/0.jpg"));
			js[1].setIcon(new ImageIcon("Image/0.jpg"));
			js[2].setIcon(new ImageIcon("Image/0.jpg"));
			remove(jPanel2);
			row = 15 ;
			col = 15 ;
			lNum = 40 ;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridLayout(row,col,0,0));
			button = new MineButton[row][col];
			for(int i = 0 ; i<row ; i++ ) {
				for(int j = 0 ; j< col ;j++ ) {
					button[i][j] = new MineButton();
					button[i][j].setFlagNum(lNum);
					button[i][j].paintFlag();
					button[i][j].setIJ(i, j);
					button[i][j].setRC(row,col);
					jPanel2.add(button[i][j]);
					
				}
			}
			creatLei();
			add(jPanel2,BorderLayout.SOUTH);
			pack();
		}
		
	}
	class GaoJi implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!MineButton.T) {
				time.cancel();
				MineButton.T = true;
			}

			js[0].setIcon(new ImageIcon("Image/0.jpg"));
			js[1].setIcon(new ImageIcon("Image/0.jpg"));
			js[2].setIcon(new ImageIcon("Image/0.jpg"));
			remove(jPanel2);
			row = 15 ;
			col = 30 ;
			lNum = 70 ;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridLayout(row,col,0,0));
			button = new MineButton[row][col];
			for(int i = 0 ; i<row ; i++ ) {
				for(int j = 0 ; j< col ;j++ ) {
					button[i][j] = new MineButton();
					button[i][j].setFlagNum(lNum);
					button[i][j].paintFlag();
					button[i][j].setIJ(i, j);
					button[i][j].setRC(row,col);
					jPanel2.add(button[i][j]);
					
				}
			}
			creatLei();
			add(jPanel2,BorderLayout.SOUTH);
			pack();
		}
		
	}
}
