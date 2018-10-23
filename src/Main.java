import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import util.Random;

/**
 * 
 * The starting point of the Bubble Bobble Game
 * 
 * Created for the CSSE220 Final Project
 * 
 * @author garnacpj
 *HI
 */

public class Main {
	private static final int WIDTH  = 600;
	private static final int HEIGHT = 441;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bubble Bobble");
		Player player = new Player();
		frame.setSize(WIDTH, HEIGHT);
		// Need to draw player component
		
		frame.add(new PlayerComponent(player, frame));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
