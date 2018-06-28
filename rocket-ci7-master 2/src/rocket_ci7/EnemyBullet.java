package rocket_ci7;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet {
	public Vector2D velocity= new Vector2D();
	public Vector2D position= new Vector2D();
	public BufferedImage image;
	
	public EnemyBullet(Vector2D velocity, Vector2D position, BufferedImage image)	{
		this.velocity= velocity;
		this.position= position;
		this.image= image;
	}
	
	public EnemyBullet()	{
		
	}
	
	public void run()	{
		this.position.addUp(velocity);
	}
	
	public void render(Graphics graphics)	{
		graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 5, 5, null);
	}
}
