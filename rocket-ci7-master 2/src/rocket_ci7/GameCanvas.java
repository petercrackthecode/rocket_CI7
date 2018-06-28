package rocket_ci7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    int countStar = 0;
    int countEnemyBullet= 0;
    int countPlayerBullet= 0;

    List<Star> stars;
    List<EnemyBullet> EnemyBullets= new ArrayList<>();
    List<PlayerBullet> PlayerBullets= new ArrayList<>();

    Background background;

    public Player player = new Player();
    public Enemy enemy = new Enemy();

    private Random random = new Random();


    public GameCanvas() {
        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();
        this.stars = new ArrayList<>();
        this.player.setupPlayer();
        this.enemy.setupEnemy();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.EnemyBullets.forEach(bullet -> bullet.render(graphics));
        this.PlayerBullets.forEach(bullet -> bullet.render(graphics));
        
        this.player.render(this.graphics);
        this.enemy.render(this.graphics);

        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.createEnemyBullet();
        
        this.stars.forEach(star -> star.run());
        this.EnemyBullets.forEach(enemyBullet -> enemyBullet.run());
        this.PlayerBullets.forEach(bullet -> bullet.run());
        
        this.player.run();
        this.enemy.runEnemy(player, enemy);
    }

    public void createPlayerBullet()	{
    	if (this.countPlayerBullet == 2)	{
    		Vector2D velocity= this.player.vertices.get(2).add(9, 9);
    		
    		PlayerBullet playerBullet= new PlayerBullet(
    				velocity,
    				new Vector2D(this.player.position.x, this.player.position.y),
    				this.loadImage("resources/images/circle.png")
    				);
    		
    		this.PlayerBullets.add(playerBullet);
    		this.countPlayerBullet= 0;
    	}
    	else this.countPlayerBullet++;
    }
    
    private void createStar() {
        if (this.countStar == 30) {
            Star star = new Star(
                    new Vector2D(1024, this.random.nextInt(600)),
                    this.loadImage("resources/images/star.png"),
                    new Vector2D(-this.random.nextInt(3)+1, 0)
            );

            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }
    
    private void createEnemyBullet()	{
    	if (this.countEnemyBullet == 20)	{
    		Vector2D velocity= this.player.position
                    .subtract(this.enemy.position)
                    .normalize()
                    .multiply(9.0f);
    		
    		EnemyBullet enemyBullet= new EnemyBullet(
    				velocity,
    				new Vector2D(this.enemy.position.x, this.enemy.position.y),
    				this.loadImage("resources/images/circle.png")
    				);
    		
    		this.EnemyBullets.add(enemyBullet);
    		this.countEnemyBullet= 0;
    	}
    	else this.countEnemyBullet++;
    }
    

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
