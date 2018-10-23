import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.geom.Point2D;

@SuppressWarnings("serial")
public class Player extends JComponent {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 400;

	private Point2D position;
	private Point2D velocity;
	private ArrayList<Shape> borders;
	final double movementSpeed = 3;
	final int WIDTH = 10;
	final int HEIGHT = 10;

	public Player() {
		position = new Point2D.Double(WIDTH / 2, FRAME_HEIGHT - WIDTH / 2);
		velocity = new Point2D.Double(0, 0);
		borders = new ArrayList<Shape>();
		LevelLoader levelLoader = new LevelLoader();
		levelLoader.loadLevel("Level1");
		borders.addAll(levelLoader.getBorders());
	}

	public void handleKeyPress(int keyPress) {
		switch (keyPress) {
		case 39:
			// Move Right
			System.out.println("Move Right");
			this.updateVelocity(1);
			this.updatePosition();
			break;
		case 37:
			// Move Left
			System.out.println("Move Left");
			this.updateVelocity(-1);
			this.updatePosition();
			break;
		case 38:
			// Jump
			System.out.println("Jump");
			this.jump();
			this.updatePosition();
			break;
		case 0:
			this.updateVelocity(0);
			this.updatePosition();
			break;
		default:
			System.out.println("Handling Key Press " + keyPress);
			this.updateVelocity(0);
			this.updatePosition();
			break;
		}

	}

	public void updateVelocity(int v) {
		double vNew = this.velocity.getX() + v;
		if(vNew > this.movementSpeed) vNew = this.movementSpeed;
		if(vNew < 0-this.movementSpeed) vNew = -this.movementSpeed;
		double vYNew = this.velocity.getY() + 0.5;
		if (this.checkFloor() && this.velocity.getY() > 0) {
			vYNew = 0;
		}
		this.velocity.setLocation(vNew, vYNew);

	}

	public void updatePosition() {
		CheckBoundary();
		this.position.setLocation(this.position.getX() + this.velocity.getX(),
				this.position.getY() + this.velocity.getY());

	}

	public void jump() {
		if (!this.checkFloor()) {
			updateVelocity(0);
		} else {
			this.velocity.setLocation(this.velocity.getX(), -10.0);
		}
	}

	public void CheckBoundary() {
		if (this.position.getX() == FRAME_WIDTH - WIDTH / 2 && this.velocity.getX() > 1) {
			this.velocity.setLocation(0, this.velocity.getY());
		}
		if (this.position.getX() == 0 + WIDTH / 2 && this.velocity.getX() < 1) {
			this.velocity.setLocation(0, this.velocity.getY());
		}
	}

	public boolean checkFloor() {
		return this.position.getY() >= FRAME_HEIGHT - WIDTH / 2;
	}

	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.fillRect((int) this.position.getX()-WIDTH, (int) this.position.getY()-WIDTH, WIDTH, HEIGHT);
	}
	
	public void addBoundary(Shape s) {
		borders.add(s);
	}
}
