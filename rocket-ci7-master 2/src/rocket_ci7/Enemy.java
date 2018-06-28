package rocket_ci7;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {

    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }
    
    public void setupEnemy() {
        this.position.set(800, 400);
        this.image = this.loadImage("resources/images/circle.png");
    }

    public void run() {
        this.position.addUp(this.velocity);
    }
    
    public void runEnemy(Player player, Enemy enemy) {
        Vector2D velocity = player.position
                .subtract(enemy.position)
                .normalize()
                .multiply(1.5f);
        this.velocity.set(velocity);
        this.run();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, 20, 20, null);
    }
    
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
