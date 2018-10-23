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
<<<<<<< HEAD
	private static final int HEIGHT = 441;
=======
	private static final int HEIGHT = 440;
	private ArrayList<String> levelNames = new ArrayList<String>();
	
	public Main() {
		this.levelNames = new ArrayList<String>();
	}
	
	public void addLevel(String levelName) {
		this.levelNames.add(levelName);
	}
>>>>>>> branch 'master' of https://github.com/parzival111/BubbleBobble.git

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bubble Bobble");
		Player player = new Player();
		frame.setSize(WIDTH, HEIGHT);
		// Need to draw player component
		
		frame.add(new PlayerComponent(player, frame));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Main main = new Main();
		LevelLoader levelLoader = new LevelLoader();
		main.addLevel("Level1");
		levelLoader.loadLevel(main.levelNames.get(0));
	}
}
