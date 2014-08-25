package com.mine.game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Help extends JFrame implements WindowListener{
	private static Help h = null;
	public static Help getHelp() {
		if(h == null){
			h = new Help();
		}
		return h ;
	}
	private Help() {
		this.setTitle("帮助");
		int size = 16;
		setLayout(new FlowLayout());
		JLabel jl1 = new JLabel("此游戏编者：            姬成");
		jl1.setFont(new Font("Serif",Font.PLAIN,size));
		JLabel jl2 = new JLabel("游戏规则参照windows扫雷游戏");
		jl2.setFont(new Font("Serif",Font.PLAIN,size));
		JLabel jl3 = new JLabel("感谢大家对我的支持");
		jl3.setFont(new Font("Serif",Font.PLAIN,size));
		setResizable(false);
		add(jl1,BorderLayout.NORTH);
		add(jl2,BorderLayout.CENTER);
		add(jl3,BorderLayout.SOUTH);
		this.addWindowListener(this);
		this.setSize(250, 200);
		this.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		h = null;
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}
}