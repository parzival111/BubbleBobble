import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LevelLoader {

	private ArrayList<Shape> borders = new ArrayList<Shape>();

	public LevelLoader() {
		ArrayList<Shape> borders = new ArrayList<Shape>();
	}

	public void loadLevel(String levelName) {
		this.borders.clear();
		try {
			FileReader file = new FileReader(levelName);
			Scanner s = new Scanner(file);

			while (s.hasNext()) {
				this.readShape(s);
			}
		} catch (FileNotFoundException e) {
			System.err.println("File " + levelName + " not found.");
		}
	}

	public ArrayList<Shape> getBorders() {
		return borders;
	}

	public void readShape(Scanner s) {
		try {
			String shape = s.nextLine();
			if (shape.equals("Rectangle")) {
				System.out.println("Rectangle detected.");
				int x1 = s.nextInt();
				int y1 = s.nextInt();
				int width = s.nextInt();
				int height = s.nextInt();
				System.out.println(
						"Creating rectangle x1=" + x1 + ", y1=" + y1 + ", width=" + width + ", height=" + height);
				Shape rectangle = new Rectangle2D.Double(x1, y1, width, height);
				this.borders.add(rectangle);
			} else if (shape.equals("Line")) {
				System.out.println("Line detected.");
				int x1 = s.nextInt();
				int y1 = s.nextInt();
				int x2 = s.nextInt();
				int y2 = s.nextInt();
				System.out.println("Creating line x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2);
				Shape line = new Line2D.Double(x1, y1, x2, y2);
				this.borders.add(line);
			}
		} catch (InputMismatchException e) {
			System.err.println("Error reading shape.");
		}
	}
	
	public void drawOn(Graphics2D g) {
		g.setColor(Color.BLACK);
		for(int i=0; i<borders.size()-1; i++) {
			System.out.println("Drawing line" + i);
			g.draw(borders.get(i));
		}
	}

	public static void main(String[] args) {
		LevelLoader levelLoader = new LevelLoader();
		levelLoader.loadLevel("Level1");
	}
}
