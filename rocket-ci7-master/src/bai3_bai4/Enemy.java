package bai3_bai4;
import java.awt.*;
import java.lang.Math;
import java.awt.image.BufferedImage;
public class Enemy {
	private int Xenemy, Yenemy;
	private int speedXEnemy = 2;
    private int speedYEnemy = 2;
	BufferedImage enemyImage;
	
	public Enemy(int xenemy, int yenemy, BufferedImage enemy) {
		Xenemy = xenemy;
		Yenemy = yenemy;
		this.enemyImage= enemy;
	}

	public void setXenemy(int xenemy) {
		Xenemy = xenemy;
	}

	public void setYenemy(int yenemy) {
		Yenemy = yenemy;
	}

	public int getXenemy() {
		return Xenemy;
	}

	public int getYenemy() {
		return Yenemy;
	}
	
	public void runEnemy(int Xplayer, int Yplayer) {
		double range= getRange(Xenemy, Yenemy, Xplayer, Yplayer);
		System.out.println("Xenemy= "+Xenemy+ ", Yenemy= "+Yenemy);
		System.out.println("Xplayer= "+Xplayer+", Yplayer= "+Yplayer);
		System.out.println(range);
		double rangeX= Xplayer-Xenemy, rangeY= Yplayer-Yenemy;
		final int speed= 3;
		
		double moveX= (double)speed*rangeX/range, moveY= (double)speed*rangeY/range;
        
		this.Xenemy += moveX;
        this.Yenemy += moveY;
        
    }
	
	public void render(Graphics graphics) {
		graphics.drawImage(this.enemyImage, Xenemy, Yenemy, 20, 20, null);
	}
	
	public double getRange(int Xenemy, int Yenemy, int Xplayer, int Yplayer)	{
		double saveFirst= (Math.pow(((double) Xplayer-Xenemy), 2)+Math.pow((double) Yplayer-Yenemy, 2));
		//Why using Math.sqrt() in here generate errors, save constantly= 1.0;
		double save= Math.sqrt(saveFirst);
		return save;
	}
}
