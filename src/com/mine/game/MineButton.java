package com.mine.game;

import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.Timer;
import java.util.spi.TimeZoneNameProvider;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MineButton extends JButton implements MouseListener{
	private ImageIcon fangkuang = new ImageIcon("Image/button.jpg") ;
	private ImageIcon lei = new ImageIcon("Image/lei.jpg");
	private ImageIcon lei1 = new ImageIcon("Image/lei1.jpg");
	private ImageIcon lei2 = new ImageIcon("Image/lei2.jpg");
	private ImageIcon qi = new ImageIcon("Image/hongqi.jpg");
	private ImageIcon wh = new ImageIcon("Image/wenhao.jpg");
	private ImageIcon cuolei = new ImageIcon("Image/cuolei.jpg");
	static boolean T = true ;
	private static int wenhao = 0;
	private int sd = 0;//剩余的格数
	private int num = 0;//计数方格周围的雷数
	private int row ;
	private int col ;
	private int i ; //排
	private int j ; //列
	private boolean keyong = true ;
	private boolean Alive = true ;
	private static int flagNum ;
	private Insets space = new Insets(0,0,0,0);
	private int rightNum = 0 ;
	private int dif ;
	public void paintNum(int num) {
		if(num==0) {
			this.setEnabled(false);
		}else if(num==1) {
			this.setIcon(new ImageIcon("Image/01.jpg"));
		}else if(num==2) {
			this.setIcon(new ImageIcon("Image/02.jpg"));
		}else if(num==3) {
			this.setIcon(new ImageIcon("Image/03.jpg"));
		}else if(num==4) {
			this.setIcon(new ImageIcon("Image/04.jpg"));
		}else if(num==5) {
			this.setIcon(new ImageIcon("Image/05.jpg"));
		}else if(num==6) {
			this.setIcon(new ImageIcon("Image/06.jpg"));
		}else if(num==7) {
			this.setIcon(new ImageIcon("Image/07.jpg"));
		}else if(num==8) {
			this.setIcon(new ImageIcon("Image/08.jpg"));
		}
		Alive = false ;
		keyong = false ;
	}
	public void f1() {
		if(i>0&&i<row-1&&j>0&&j<col-1) {
			if(MineFrame.button[i+1][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i+1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i+1][j-1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j-1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j-1].getDif()==100) {
				num++;
			}
			paintNum(num);
		}else if(i==0&&j>0&&j<col-1) {
			if(MineFrame.button[i+1][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i+1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i+1][j-1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j-1].getDif()==100) {
				num++;
			}
			paintNum(num);
		}else if(i==row-1&&j>0&&j<col-1) {
			if(MineFrame.button[i][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j-1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j-1].getDif()==100) {
				num++;
			}
			paintNum(num);
		}else if(i>0&&i<row-1&&j==0) {
			if(MineFrame.button[i+1][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i+1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j].getDif()==100) {
				num++;
			}
			paintNum(num);
		}else if(i>0&&i<row-1&&j==col-1) {
			if(MineFrame.button[i+1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i+1][j-1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j-1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j-1].getDif()==100) {
				num++;
			}
			paintNum(num);
		}else if(i==0&&j==0) {
			if(MineFrame.button[i+1][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i+1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j+1].getDif()==100) {
				num++;
			}
			paintNum(num);
		}else if(i==0&&j==col-1) {
			if(MineFrame.button[i+1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i+1][j-1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i][j-1].getDif()==100) {
				num++;
			}
			paintNum(num);
		}else if(i==row-1&&j==0) {
			if(MineFrame.button[i][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j+1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j].getDif()==100) {
				num++;
			}
			paintNum(num);
		}else if(i==row-1&&j==col-1) {
			if(MineFrame.button[i][j-1].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j].getDif()==100) {
				num++;
			}
			if(MineFrame.button[i-1][j-1].getDif()==100) {
				num++;
			}
			paintNum(num);
		}
		if(num==0) {
			if(i<row-1&&i>0&&j<col-1&&j>0) {
				if(MineFrame.button[i][j+1].keyong) {
					MineFrame.button[i][j+1].f1();
				}
				if(MineFrame.button[i][j-1].keyong) {
					MineFrame.button[i][j-1].f1();
				}
				if(MineFrame.button[i+1][j+1].keyong) {
					MineFrame.button[i+1][j+1].f1();
				}
				if(MineFrame.button[i+1][j].keyong) {
					MineFrame.button[i+1][j].f1();
				}
				if(MineFrame.button[i+1][j-1].keyong) {
					MineFrame.button[i+1][j-1].f1();
				}
				if(MineFrame.button[i-1][j+1].keyong) {
					MineFrame.button[i-1][j+1].f1();
				}
				if(MineFrame.button[i-1][j].keyong) {
					MineFrame.button[i-1][j].f1();
				}
				if(MineFrame.button[i-1][j-1].keyong) {
					MineFrame.button[i-1][j-1].f1();
				}
			}else if(i==0&&j<col-1&&j>0) {
				if(MineFrame.button[i][j+1].keyong) {
					MineFrame.button[i][j+1].f1();
				}
				if(MineFrame.button[i][j-1].keyong) {
					MineFrame.button[i][j-1].f1();
				}
				if(MineFrame.button[i+1][j+1].keyong) {
					MineFrame.button[i+1][j+1].f1();
				}
				if(MineFrame.button[i+1][j].keyong) {
					MineFrame.button[i+1][j].f1();
				}
				if(MineFrame.button[i+1][j-1].keyong) {
					MineFrame.button[i+1][j-1].f1();
				}
			}else if(i==row-1&&j<col-1&&j>0) {
				if(MineFrame.button[i][j+1].keyong) {
					MineFrame.button[i][j+1].f1();
				}
				if(MineFrame.button[i][j-1].keyong) {
					MineFrame.button[i][j-1].f1();
				}
				if(MineFrame.button[i-1][j+1].keyong) {
					MineFrame.button[i-1][j+1].f1();
				}
				if(MineFrame.button[i-1][j].keyong) {
					MineFrame.button[i-1][j].f1();
				}
				if(MineFrame.button[i-1][j-1].keyong) {
					MineFrame.button[i-1][j-1].f1();
				}
			}else if(i<row-1&&i>0&&j==0) {
				if(MineFrame.button[i][j+1].keyong) {
					MineFrame.button[i][j+1].f1();
				}
				if(MineFrame.button[i+1][j+1].keyong) {
					MineFrame.button[i+1][j+1].f1();
				}
				if(MineFrame.button[i+1][j].keyong) {
					MineFrame.button[i+1][j].f1();
				}
				if(MineFrame.button[i-1][j+1].keyong) {
					MineFrame.button[i-1][j+1].f1();
				}
				if(MineFrame.button[i-1][j].keyong) {
					MineFrame.button[i-1][j].f1();
				}
			}else if(i<row-1&&i>0&&j==col-1) {
				if(MineFrame.button[i][j-1].keyong) {
					MineFrame.button[i][j-1].f1();
				}
				if(MineFrame.button[i+1][j].keyong) {
					MineFrame.button[i+1][j].f1();
				}
				if(MineFrame.button[i+1][j-1].keyong) {
					MineFrame.button[i+1][j-1].f1();
				}
				if(MineFrame.button[i-1][j].keyong) {
					MineFrame.button[i-1][j].f1();
				}
				if(MineFrame.button[i-1][j-1].keyong) {
					MineFrame.button[i-1][j-1].f1();
				}
			}else if(i==0&&j==0) {
				if(MineFrame.button[i][j+1].keyong) {
					MineFrame.button[i][j+1].f1();
				}
				if(MineFrame.button[i+1][j+1].keyong) {
					MineFrame.button[i+1][j+1].f1();
				}
				if(MineFrame.button[i+1][j].keyong) {
					MineFrame.button[i+1][j].f1();
				}
			}else if(i==0&&j==col-1) {
				if(MineFrame.button[i][j-1].keyong) {
					MineFrame.button[i][j-1].f1();
				}
				if(MineFrame.button[i+1][j].keyong) {
					MineFrame.button[i+1][j].f1();
				}
				if(MineFrame.button[i+1][j-1].keyong) {
					MineFrame.button[i+1][j-1].f1();
				}
			}else if(i==row-1&&j==0) {
				if(MineFrame.button[i][j+1].keyong) {
					MineFrame.button[i][j+1].f1();
				}
				if(MineFrame.button[i-1][j+1].keyong) {
					MineFrame.button[i-1][j+1].f1();
				}
				if(MineFrame.button[i-1][j].keyong) {
					MineFrame.button[i-1][j].f1();
				}
			}else if(i==row-1&&j==col-1) {
				if(MineFrame.button[i][j-1].keyong) {
					MineFrame.button[i][j-1].f1();
				}
				if(MineFrame.button[i-1][j].keyong) {
					MineFrame.button[i-1][j].f1();
				}
				if(MineFrame.button[i-1][j-1].keyong) {
					MineFrame.button[i-1][j-1].f1();
				}
			}
		}
	}
	public void setIJ(int i , int j ) {
		this.i = i ;
		this.j = j ;
	}
	public void setRC(int row , int col ) {
		this.row = row ;
		this.col = col ;
	}
	
	public void paintFlag() {
		if(flagNum/10==0) {
			MineFrame.jl[1].setIcon(new ImageIcon("Image/0.jpg"));
		}else if(flagNum/10==1) {
			MineFrame.jl[1].setIcon(new ImageIcon("Image/1.jpg"));
		}else if(flagNum/10==2) {
			MineFrame.jl[1].setIcon(new ImageIcon("Image/2.jpg"));
		}else if(flagNum/10==3) {
			MineFrame.jl[1].setIcon(new ImageIcon("Image/3.jpg"));
		}else if(flagNum/10==4) {
			MineFrame.jl[1].setIcon(new ImageIcon("Image/4.jpg"));
		}else if(flagNum/10==5) {
			MineFrame.jl[1].setIcon(new ImageIcon("Image/5.jpg"));
		}else if(flagNum/10==6) {
			MineFrame.jl[1].setIcon(new ImageIcon("Image/6.jpg"));
		}else if(flagNum/10==7) {
			MineFrame.jl[1].setIcon(new ImageIcon("Image/7.jpg"));
		}
		if(flagNum%10==0) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/0.jpg"));
		}else if(flagNum%10==1) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/1.jpg"));
		}else if(flagNum%10==2) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/2.jpg"));
		}else if(flagNum%10==3) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/3.jpg"));
		}else if(flagNum%10==4) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/4.jpg"));
		}else if(flagNum%10==5) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/5.jpg"));
		}else if(flagNum%10==6) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/6.jpg"));
		}else if(flagNum%10==7) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/7.jpg"));
		}else if(flagNum%10==8) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/8.jpg"));
		}else if(flagNum%10==9) {
			MineFrame.jl[2].setIcon(new ImageIcon("Image/9.jpg"));
		}
	}
	public MineButton() {
		this.setIcon(fangkuang);
		this.setMargin(space);
		this.addMouseListener(this);
	}
	public int getFlagNum() {
		return flagNum ;
	}
	public void setFlagNum(int flagNum) {
		this.flagNum = flagNum;
	}
	public void setDif(int dif ) {
		this.dif = dif ;
	}
	public int getDif() {
		return dif ;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Alive) {
			if(rightNum%3==0) {
				setIcon(new ImageIcon("Image/button1.jpg"));
			}
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Alive) {
			if(rightNum%3==0) {
				setIcon(new ImageIcon("Image/button.jpg"));
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Alive) {
			if(e.isMetaDown()) {
				rightNum ++ ;
				if(T) {
					MineFrame.time =new Timer() ;
					MineFrame.time.schedule(new Task(), 0, 1000);
					T = false;
				}
				if(rightNum%3==1) {
					setIcon(qi);
					flagNum--;
					keyong = false ;
					paintFlag();
					st:while(true) {
						if(flagNum==0) {
							for(int i = 0;i<row;i++) { 
								for(int j = 0;j<col;j++) {
									if(MineFrame.button[i][j].keyong) { 
										break st;
									}
								}
							}
							for(int i = 0 ;i<row ;i++ ) {
								for(int j = 0 ;j<col ;j++) {
									if(MineFrame.button[i][j].getDif()==100) {
										MineFrame.button[i][j].setIcon(lei2);
										MineFrame.button[i][j].Alive = false;
										MineFrame.button[i][j].keyong= false;
									}
								}
							}
							if(!T) {
								MineFrame.time.cancel();
								T = true ;
							}
							new Win();
						}
						break;
					}
				}else if(rightNum%3==2) {
					setIcon(wh);
					flagNum++;
					wenhao++;
					paintFlag();
				}else if(rightNum%3==0) {
					setIcon(fangkuang);
					wenhao--;
					keyong = true;				
				}
			}else {
				if(rightNum%3==0) {
					if(dif==100) {
						setIcon(lei1);
						dif=300;
						keyong = false;
						for(int i = 0 ;i<row ;i++) {
							for(int j = 0 ;j<col ;j++) {
								if(MineFrame.button[i][j].getDif()==100) {
									MineFrame.button[i][j].setIcon(lei);
									MineFrame.button[i][j].Alive =false;
									MineFrame.button[i][j].keyong =false;
								}
							}
						}
						for(int i = 0 ;i<row ;i++) {
							for(int j = 0 ;j<col ;j++) {
								if(MineFrame.button[i][j].keyong) {
									MineFrame.button[i][j].setEnabled(false);
									MineFrame.button[i][j].Alive = false;
									MineFrame.button[i][j].keyong = false;
								}
							}
						}
						for(int i = 0 ;i<row ;i++) {
							for(int j = 0 ;j<col ;j++) {
								if(MineFrame.button[i][j].rightNum%3==1) {
									if(MineFrame.button[i][j].getDif()!=100) {
										MineFrame.button[i][j].setIcon(cuolei);
										MineFrame.button[i][j].Alive=false;
									}
								}
							}
						}
						for(int i = 0 ;i<row ;i++) {
							for(int j = 0 ;j<col ;j++) {
								if(MineFrame.button[i][j].rightNum%3==1) {
									if(MineFrame.button[i][j].getDif()==100) {
										MineFrame.button[i][j].setIcon(lei2);
									}
								}
							}
						}
						for(int i = 0 ;i<row ;i++) {
							for(int j = 0 ;j<col ;j++) {
								if(MineFrame.button[i][j].rightNum%3==2&&MineFrame.button[i][j].getDif()!=100) {
									MineFrame.button[i][j].setEnabled(false);
									MineFrame.button[i][j].Alive = false ;
								}
							}
						}
						Alive = false ;
						if(!T) {
							MineFrame.time.cancel();
							T = true ;
						}
						new Lose();
					}
					else {
						if(T) {
							MineFrame.time =new Timer() ;
							MineFrame.time.schedule(new Task(), 0, 1000);
							T = false;
						}
						f1();
						while(wenhao==0) {
							for(int i = 0 ; i<row ;i++) {
								for(int j = 0 ;j<col ; j++) {
									if(MineFrame.button[i][j].keyong){
										sd++;
									}
								}
							}
							if(flagNum!=sd) {
								sd=0;
								break;
							}
							for(int i = 0 ;i<row ;i++ ) {
								for(int j = 0 ;j<col ;j++) {
									if(MineFrame.button[i][j].getDif()==100) {
										MineFrame.button[i][j].setIcon(lei2);
										MineFrame.button[i][j].Alive = false;
										MineFrame.button[i][j].keyong= false;
									}
								}
							}
							if(!T) {
								MineFrame.time.cancel();
								T = true ;
							}
							new Win();
							break;
						}
					}
				}
			}
		}
	}		
}
