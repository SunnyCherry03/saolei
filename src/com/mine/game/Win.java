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
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//���ֹرշ�ʽ �㴰��Ĺرռ���ʱ�� �����κ�����
		setModal(true);//�����л����� 
		JLabel jl1 = new JLabel("�������̽ӽ��ڱ���");//��ǩ
		JLabel jl2 = new JLabel("�������롰���ҵ����ҡ�Ȼ��ȷ��");
		final JTextField jtPass = new JTextField (10);
		JButton jbLogin = new JButton("ȷ��");
		jbLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = jtPass.getText();
				if(pass.equals("���ҵ�����")){
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
