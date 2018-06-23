import java.awt.*;
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
	
	public void runEnemy() {
        this.Xenemy += this.speedXEnemy;
        this.Yenemy += this.speedYEnemy;

        if (this.Xenemy < 0 || this.Xenemy > 1024 - 20)
            this.speedXEnemy = -this.speedXEnemy;

        if (this.Yenemy < 0 || this.Yenemy > 600 - 20)
            this.speedYEnemy = -this.speedYEnemy;
    }
	
	public void render(Graphics graphics) {
		graphics.drawImage(this.enemyImage, Xenemy, Yenemy, 20, 20, null);
	}
	
}
