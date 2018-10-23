import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * HI
 * 
 * @author garnacpj
 *
 */
@SuppressWarnings("serial")
public class PlayerComponent extends JComponent {
	private Player player;
	private JFrame frame;

	public PlayerComponent(Player player, JFrame frame) {
		this.player = player;
		this.frame = frame;
		
		KeyListener key = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				player.handleKeyPress(arg0.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		};
		frame.addKeyListener(key);
		
		Timer repaintTimer = new Timer(1000/30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.handleKeyPress(0);
				repaint();
			}
			
		});
		repaintTimer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		player.drawOn(g2);
	}
	
	
}
