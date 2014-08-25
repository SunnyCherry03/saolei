package com.mine.game;

import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Task extends TimerTask{
	int i = 0;//个位
	int j = 0;//十位
	int z = 0;//百位
	@Override
	public void run() {
		// TODO Auto-generated method stub
		paint(i,2);
		paint(j,1);
		paint(z,0);
		i++ ;
		if(i==10) {
			j++;
			i=0;
		}
		if(j==10) {
			z++;
			j=0;
		}
		
	}
	public void paint(int x,int c) {
		if(x%10==0) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/0.jpg"));
		}else if(x%10==1) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/1.jpg"));
		}else if(x%10==2) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/2.jpg"));
		}else if(x%10==3) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/3.jpg"));
		}else if(x%10==4) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/4.jpg"));
		}else if(x%10==5) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/5.jpg"));
		}else if(x%10==6) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/6.jpg"));
		}else if(x%10==7) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/7.jpg"));
		}else if(x%10==8) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/8.jpg"));
		}else if(x%10==9) {
			MineFrame.js[c].setIcon(new ImageIcon("Image/9.jpg"));
		}
	}
}
