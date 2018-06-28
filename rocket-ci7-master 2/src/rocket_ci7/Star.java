package rocket_ci7;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public Vector2D velocity;
    public Vector2D position;
    public BufferedImage image;

    public Star(Vector2D position, BufferedImage image, Vector2D velocity) {
        this.position= position;
        this.image = image;
        this.velocity= velocity;
    }

    public Star() {

    }

    public void run() {
        this.position= this.position.addUp(velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 5, 5, null);
    }
}
