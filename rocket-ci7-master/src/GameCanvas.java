import javax.imageio.ImageIO;
import javax.swing.*;
import bai2.BackBuffered;
//

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {


    BufferedImage enemyImage= loadImage("resources/images/circle.png");
    BufferedImage playerImage= loadImage("resources/images/circle.png");
    BufferedImage takeBackBuffered= new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
    Graphics graphics;

    int countStar = 0;

    List<Star> stars= new ArrayList<>();

    private Random random = new Random();
    
    Player player= new Player(512, 300, playerImage);
    
    Enemy enemy= new Enemy(100, 200, enemyImage);
    
    BackBuffered backBuffered= new BackBuffered(takeBackBuffered);

    public GameCanvas() {
        this.setSize(1024, 600);

        this.graphics= this.backBuffered.getBackBuffered().getGraphics();
        
        this.setVisible(true);
    }

    public void renderAll() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);

        this.stars.forEach(star -> star.render(graphics)); 
        this.player.render(graphics);
        this.enemy.render(graphics);
        
        this.repaint();
    }
    
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered.getBackBuffered(), 0, 0, null);
    }
    
    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.enemy.runEnemy();
    }

    private void createStar() {
        if (this.countStar == 30) {
            Star star = new Star(
                    1024,
                    this.random.nextInt(600),
                    this.loadImage("resources/images/star.png"),
                    -this.random.nextInt(3) + 1,
                    0
            );

            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }


    }
    
    public void setPlayer(String direction)	{
    	switch(direction)	{
    	case "LEFT": this.player.setXplayer(this.player.getXplayer()-8);
    	break;
    	case "RIGHT": this.player.setXplayer(this.player.getXplayer()+8);
    	break;
    	case "UP": this.player.setYplayer(this.player.getYplayer()-8);
    	break;
    	default: this.player.setYplayer(this.player.getYplayer()+8);
    	break;
    	}
    }
    
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
