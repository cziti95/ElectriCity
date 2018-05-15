package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.pmw.tinylog.Logger;
import homework.model.City;

/**
 * Osztály a nagyvárosok generálásához.
 * 
 * @author czirjak
 */
public class BigCity {

	/**
	 * Lista a nagyvárosok tárolására.
	 */
	private List<City> bigCityList = new ArrayList<City>();

	/**
	 * Visszaadja a generált nagyvárosok listáját.
	 * 
	 * @return a generált nagyvárosok listája
	 */
	public List<City> getBigCityList() {
		return bigCityList;
	}

	
	/**
	 * Konstruktor a nagyvárosokhoz.
	 * 
	 * @param canvasW -  a rajzfelület magassága
	 * @param canvasH - a rajzfelület szélessége
	 * @param pgH - az áramfejlesztő magassága
	 * @param number_of_big_citys - a nagyvárosok száma
	 */
	public BigCity(double canvasW, double canvasH,double pgH, int number_of_big_citys) {
		Logger.info("Nagyváros generálva.");
		double px, py, tmpx,tmpy;
		Random r = new Random();
		City act = new City();
		City prev = new City();

		for (int i = 0; i < number_of_big_citys; i++) {
			City City = new City();
			px = r.nextInt(800) + City.getWidth();
			py = r.nextInt((int) (512 - pgH)) + pgH;

			City.setPositionX(px);
			City.setPositionY(py);
			City.setCityID(i);
			City.setNecessaryEnergy(200);

			bigCityList.add(City);
		}

		for (int i = 0; i < bigCityList.size() - 1; i++) {
			for (int j = i + 1; j < bigCityList.size(); j++) {
				act = bigCityList.get(j);
				prev = bigCityList.get(i);
				tmpx = Math.abs(act.getPositionX() - prev.getPositionX());
				tmpy = Math.abs(act.getPositionY() - prev.getPositionY());
				if ((tmpx < 192 && tmpy < 192) || (tmpx < 192) || (tmpy < 192)){
					bigCityList.remove(j);
				}
			}
		}

	}

}
