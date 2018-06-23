package bai3_bai4;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Player {
	private int Xplayer, Yplayer;
	BufferedImage playerImage;
	public Player(int xplayer, int yplayer, BufferedImage image) {
		this.playerImage= image;
		Xplayer = xplayer;
		Yplayer = yplayer;
	}
	
	public void setXplayer(int xplayer)	{
		Xplayer= xplayer;
	}
	
	public void setYplayer(int yplayer) {
		Yplayer = yplayer;
	}

	public int getXplayer() {
		return Xplayer;
	}

	public int getYplayer() {
		return Yplayer;
	}
	
	public void render(Graphics graphics) {
		graphics.drawImage(this.playerImage, Xplayer, Yplayer, 20, 20, null);
	}
}
