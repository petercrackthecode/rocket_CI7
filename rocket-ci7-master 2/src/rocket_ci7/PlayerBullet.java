package rocket_ci7;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet {
	public Vector2D velocity= new Vector2D();
	public BufferedImage image;
	public Vector2D position= new Vector2D();
	
	public PlayerBullet(Vector2D velocity, Vector2D position, BufferedImage image)	{
		this.velocity= velocity;
		this.image= image;
		this.position= position;
	}
	
	public void run()	{
		this.position.addUp(this.velocity);
	}
	
	public void render(Graphics graphics)	{
		graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 5, 5, null);
	}
	
}
