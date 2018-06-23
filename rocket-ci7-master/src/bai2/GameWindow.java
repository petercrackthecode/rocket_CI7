package bai2;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas= new GameCanvas();
    long lastTime = 0;
    
    public GameWindow() {
        this.setSize(1024, 600);

        this.add(gameCanvas);

        this.event();

        this.setVisible(true);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setPlayerXY("LEFT");
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                	setPlayerXY("RIGHT");
                }
                if (e.getKeyCode() == KeyEvent.VK_UP)	{
                	setPlayerXY("UP");
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN)	{
                	setPlayerXY("DOWN");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
  
            }
        });
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }


    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }
    
    public void setPlayerXY(String direction)	{
    	switch(direction)	{
    	case "LEFT": this.gameCanvas.setPlayer("LEFT");
    	break;
    	case "RIGHT": this.gameCanvas.setPlayer("RIGHT");
    	break;
    	case "UP": this.gameCanvas.setPlayer("UP");
    	break;
    	default: this.gameCanvas.setPlayer("DOWN");
    	break;
    	}
    }
}
