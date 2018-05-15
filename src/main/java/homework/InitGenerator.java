package homework;

import homework.model.Generator;
import homework.model.PowerGenerator;
import javafx.scene.canvas.Canvas;
import org.pmw.tinylog.Logger;
/**
 * Osztály a generátorok generáláshoz.
 * 
 * @author czirjak
 *
 */
public class InitGenerator {

	/**
	 * A {@code Generator} létrehozása.
	 */
	private Generator generator = new Generator();

	/**
	 * @return egy létrehozott generátor
	 */
	public Generator getGenerator() {
		return generator;
	}

	/**
	 * Új generátor létrehozása.
	 * @param canvas - a felhasznált rajzterület
	 * @param powerGenerator - a felhasznált áramfejlesztő
	 * @param id - a generátor azonsítója
	 */
	public InitGenerator(double canvas, PowerGenerator powerGenerator, int id) {
		super();
		Logger.info("Generátor generálva.");
		this.generator.setGeneratorID(id);
		this.generator.setPlusEnergy(350);
		this.generator.setPositionX((canvas / 2) - powerGenerator.getWidth() - id * 64);
		this.generator.setPositionY(powerGenerator.getHeight() - 64);
	}

}
