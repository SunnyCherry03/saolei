package com.mine.game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Lose extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Lose() {
		setTitle("win");
		setResizable(false);
		setLayout(new FlowLayout());
		setLocation(200, 200);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setModal(true);
		JLabel jl1 = new JLabel("�������̽ӽ���0");
		JLabel jl2 = new JLabel("�������롰�ҵ�ȷ����Ȼ��ȷ��");
		final JTextField jtPass = new JTextField (10);
		JButton jbLogin = new JButton("ȷ��");
		jbLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = jtPass.getText();
				if(pass.equals("�ҵ�ȷ����")){
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
