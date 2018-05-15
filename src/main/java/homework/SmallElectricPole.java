package homework;

import java.util.List;
import homework.model.ElectricPole;
import homework.model.PowerGenerator;
import javafx.scene.canvas.Canvas;
import org.pmw.tinylog.Logger;

/**
 * Osztály a kis villanyoszlopok generálásához.
 * 
 * @author czirjak
 *
 */
public class SmallElectricPole {

	/**
	 * A kis villanyoszlopok tárolásához.
	 */
	private ElectricPole smallElectricPole = new ElectricPole();

	/**
	 * @return egy létrehozott kis villanyoszlop
	 */
	public ElectricPole getSmallElectricPole() {
		return smallElectricPole;
	}

	/**
	 * Konstruktor a kis villanyoszlopokhoz.
	 * 
	 * @param canvas - a felhasznált rajzterület
	 * @param powerGenerator - a felhasznált áramfejlesztő
	 * @param id - a villanyoszlop azonosítója
	 * @param direction - a villanyoszlopot milyen irányba kell elhelyezni az előzőhöz képest
	 * @param smallElectricPoleList - a kis villanyoszlopok listája
	 */
	public SmallElectricPole(Canvas canvas, PowerGenerator powerGenerator, int id, int direction,
			List<ElectricPole> smallElectricPoleList) {
		super();
		Logger.info("Kis villanyoszlop generálva.");
		ElectricPole previouslyPole = new ElectricPole();

		smallElectricPole.setImage("small_electric _pole.png");
		smallElectricPole.setImageOverloaded("small_electric_pole_overloaded.png");
		smallElectricPole.setCarryingCapacity(100);
		smallElectricPole.setPoleID(id);

		if (smallElectricPoleList.size() < 1) {
			if (direction == 0) {
				smallElectricPole.setPositionX((canvas.getWidth() / 2) + (powerGenerator.getWidth() / 3)
						+ id * (smallElectricPole.getWidth() / 2));
				smallElectricPole.setPositionY(powerGenerator.getHeight() - smallElectricPole.getHeight());
			}
			if (direction == 1) {
				smallElectricPole.setPositionX((canvas.getWidth() / 2) - powerGenerator.getWidth() / 3);
				smallElectricPole.setPositionY(powerGenerator.getHeight() + id * smallElectricPole.getHeight());
			}
		}

		if (smallElectricPoleList.size() >= 1) {
			previouslyPole = smallElectricPoleList.get(smallElectricPoleList.size() - 1);
			if (direction == 0) {
				smallElectricPole.setPositionX(previouslyPole.getPositionX() + smallElectricPole.getWidth() / 2);
				smallElectricPole.setPositionY(previouslyPole.getPositionY());
			}
			if (direction == 1) {
				smallElectricPole.setPositionX(previouslyPole.getPositionX());
				smallElectricPole.setPositionY(previouslyPole.getPositionY() + smallElectricPole.getHeight());
			}
			if (direction == 2) {
				smallElectricPole.setPositionX(previouslyPole.getPositionX() - smallElectricPole.getWidth() / 2);
				smallElectricPole.setPositionY(previouslyPole.getPositionY());
			}
			if (direction == 3) {
				smallElectricPole.setPositionX(previouslyPole.getPositionX());
				smallElectricPole.setPositionY(previouslyPole.getPositionY() - smallElectricPole.getHeight());
			}
		}
	}

}
