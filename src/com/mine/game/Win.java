package com.mine.game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Win extends JDialog {
	public Win() {
		setTitle("win");
		setResizable(false);
		setLayout(new FlowLayout());
		setLocation(200, 200);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//此种关闭方式 点窗体的关闭键的时候 不作任何事情
		setModal(true);//不可切换窗体 
		JLabel jl1 = new JLabel("您的智商接近于编者");//标签
		JLabel jl2 = new JLabel("请您输入“是我的荣幸”然后确认");
		final JTextField jtPass = new JTextField (10);
		JButton jbLogin = new JButton("确定");
		jbLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = jtPass.getText();
				if(pass.equals("是我的荣幸")){
					dispose();
				}
			}
		});
		this.add(jl1);
		this.add(jl2);
		this.add(jtPass);
		this.add(jbLogin);
		setSize(250,150);
		setVisible(true);
	}
}
