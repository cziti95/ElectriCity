package homework;

import java.util.List;

import homework.model.ElectricPole;
import homework.model.PowerGenerator;
import javafx.scene.canvas.Canvas;

/**
 * Osztály a nagy villanyoszlopok generáláshoz.
 * 
 * @author czirjak
 *
 */
public class BigElectricPole {

	/**
	 * Lista a nagy villanyoszlopok tárolására.
	 */
	private ElectricPole bigElectricPole = new ElectricPole();

	/**
	 * Visszaad egy létrehozott nagy villanyoszlopot.
	 * 
	 * @return egy létrehozott nagy villanyoszlop
	 */
	public ElectricPole getBigElectricPole() {
		return bigElectricPole;
	}

	/**
	 * Konstruktor a nagy villanyoszlopokhoz.
	 * @param canvasW - a felhasznált rajzterület
	 * @param powerGenerator - a felhasznált áramfejlesztő
	 * @param id - a villanyoszlop azonosítója
	 * @param direction - a villanyoszlopot milyen irányba kell elhelyezni az előzőhöz képest
	 * @param bigElectricPoleList - a nagy villanyoszlopok listája 
	 */
	public BigElectricPole(double canvasW, PowerGenerator powerGenerator, int id, int direction,
			List<ElectricPole> bigElectricPoleList) {
		super();

		ElectricPole previouslyPole = new ElectricPole();

		bigElectricPole.setImage("big_electric_pole.png");
		bigElectricPole.setCarryingCapacity(200);
		bigElectricPole.setPoleID(id);
		if (bigElectricPoleList.size() < 1) {
			if (direction == 0) {
				bigElectricPole.setPositionX((canvasW / 2) + (powerGenerator.getWidth() / 3)
						+ id * (bigElectricPole.getWidth() / 1.5));
				bigElectricPole.setPositionY(powerGenerator.getHeight() - bigElectricPole.getHeight());
			}
			if (direction == 1) {
				bigElectricPole.setPositionX((canvasW / 2) - powerGenerator.getWidth() / 3);
				bigElectricPole.setPositionY(powerGenerator.getHeight() + id * bigElectricPole.getHeight());
			}
		}
		if (bigElectricPoleList.size() >= 1) {
			previouslyPole = bigElectricPoleList.get(bigElectricPoleList.size() - 1);
			if (direction == 0) {
				bigElectricPole.setPositionX(previouslyPole.getPositionX() + bigElectricPole.getWidth() / 2);
				bigElectricPole.setPositionY(previouslyPole.getPositionY());
			}
			if (direction == 1) {
				bigElectricPole.setPositionX(previouslyPole.getPositionX());
				bigElectricPole.setPositionY(previouslyPole.getPositionY() + bigElectricPole.getHeight());
			}
			if (direction == 2) {
				bigElectricPole.setPositionX(previouslyPole.getPositionX() - bigElectricPole.getWidth() / 2);
				bigElectricPole.setPositionY(previouslyPole.getPositionY());
			}
			if (direction == 3) {
				bigElectricPole.setPositionX(previouslyPole.getPositionX());
				bigElectricPole.setPositionY(previouslyPole.getPositionY() - bigElectricPole.getHeight());
			}

		}

	}

}
