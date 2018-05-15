package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.pmw.tinylog.Logger;
import homework.model.City;

/**
 * Osztály a kisvárosok generáláshoz.
 * 
 * @author czirjak
 */
public class SmallCity {
	/**
	 * A kis városok tárolásához.
	 */
	private List<City> smallCityList = new ArrayList<City>();

	/**
	 * @return a kisvárosok listája
	 */
	public List<City> getSmallCityList() {
		return smallCityList;
	}

	/**
	 * Konstruktor a kisvárosokhoz.
	 * 
	 * @param canvasW - a felhasznált rajzterület szélessége
	 * @param canvasH - a felhasznált rajzterület magassága
	 * @param pgH - pozicionáláshoz
	 * @param number_of_small_citys - a szükséges kisvárosok darabszáma
	 */
	public SmallCity(double canvasW, double canvasH,double pgH, int number_of_small_citys) {
		Logger.info("Kisváros generálva.");
		double px, py, tmpx, tmpy;
		Random r = new Random();
		City act = new City();
		City prev = new City();

		for (int i = 0; i < number_of_small_citys; i++) {
			City smallCity = new City();
			px = r.nextInt(800) + smallCity.getWidth();
			py = r.nextInt((int) (650 - pgH)) + pgH;
			
			smallCity.setPositionX(px);
			smallCity.setPositionY(py);
			smallCity.setCityID(i);
			smallCity.setNecessaryEnergy(100);

			smallCityList.add(smallCity);
		}

		for (int i = 0; i < smallCityList.size() - 1; i++) {
			for (int j = i + 1; j < smallCityList.size(); j++) {
				act = smallCityList.get(j);
				prev = smallCityList.get(i);
				tmpx = Math.abs(act.getPositionX() - prev.getPositionX());
				tmpy = Math.abs(act.getPositionY() - prev.getPositionY());
				if ((tmpx < 96 && tmpy < 96) || (tmpx < 96) || (tmpy < 96)){
					smallCityList.remove(j);
				}
			}
		}
	}
}
