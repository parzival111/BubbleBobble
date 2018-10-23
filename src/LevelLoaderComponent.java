import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class LevelLoaderComponent extends JComponent {
	
	private LevelLoader levelLoader;
	private JFrame frame;
	
	public LevelLoaderComponent(LevelLoader levelLoader, JFrame frame) {
		this.levelLoader = levelLoader;
		this.frame = frame;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		levelLoader.drawOn(g2);
	}
	
	

}
