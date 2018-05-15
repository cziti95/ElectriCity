package homework;

import homework.model.PowerGenerator;
import javafx.scene.canvas.Canvas;
import org.pmw.tinylog.Logger;
/**
 * Osztály az áramfejlesztő generálásához.
 * 
 * @author czirjak
 *
 */
public class InitPowerGenerator {
	/**
	 * A {@code PowerGenerator} létrehozása.
	 */
	private PowerGenerator powerGenerator = new PowerGenerator();

	/**
	 * @return az áramfejlesztőt 
	 */
	public PowerGenerator getPowerGenerator() {
		return powerGenerator;
	}

	/**
	 * Konstruktor az áramfejlesztőhöz.
	 * 
	 * @param canvas - a felhasznált rajzterület hossza
	 */
	public InitPowerGenerator(double canvas) {
		super();
		Logger.info("Áramfejlesztő legenerálva!");
		this.powerGenerator.setPositionX((canvas / 2) - 64);
		this.powerGenerator.setPositionY(0);
		this.powerGenerator.setMaxEnegryGenerate(700);
	}

}
