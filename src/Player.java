import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.geom.Point2D;

public class Player extends JComponent {
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1000;
	
	
	private Point2D position;
	final int movementSpeed = 1;
	final int WIDTH = 10;
	final int HEIGHT = 10;

	public Player() {
		position = new Point2D.Double(5.0, 995.0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect((int) position.getX() - WIDTH / 2, (int) position.getY() - HEIGHT / 2, WIDTH, HEIGHT);
	}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bubble Bobble");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}

}
