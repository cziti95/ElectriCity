package homework;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import homework.model.City;

/**
 * Segédosztály a városok adatbázisba történő mentéséhez.
 * 
 * @author czirjak
 *
 */
@XmlRootElement(name = "citys")
public class CityLists {

	/**
	 * Lista a nagyvárosoknak.
	 */
	private List<City> bigCitys = new ArrayList<City>();
	/**
	 * List a kisvárosoknak.
	 */
	private List<City> smallCitys = new ArrayList<City>();
	/**
	 * Lista a nagy működő városoknak.
	 */
	private List<City> bigLightenedCitys = new ArrayList<City>();
	/**
	 * Lista a kis működő városoknak.
	 */
	private List<City> smallLightenedCitys = new ArrayList<City>();

	/**
	 * 
	 * @return a nagyvárosok listája
	 */
	public List<City> getBigCitys() {
		return bigCitys;
	}

	/**
	 * 
	 * @param bigCitys - beállítja a nagyvárosok listáját
	 */
	@XmlElement(name = "bigCity")
	public void setBigCitys(List<City> bigCitys) {
		this.bigCitys = bigCitys;
	}

	/**
	 * @return a kisvárosok listája
	 */
	public List<City> getSmallCitys() {
		return smallCitys;
	}

	/**
	 * @param smallCitys - beállítja a kisvárosok listáját
	 */
	@XmlElement(name = "smallCity")
	public void setSmallCitys(List<City> smallCitys) {
		this.smallCitys = smallCitys;
	}

	/**
	 * @return a működő képes nagyvárosok listája
	 */
	public List<City> getBigLightenedCitys() {
		return bigLightenedCitys;
	}

	/**
	 * @param bigLightenedCitys - beállítja a működő képes nagyvárosok listáját
	 */
	@XmlElement(name = "bigLightenedCity")
	public void setBigLightenedCitys(List<City> bigLightenedCitys) {
		this.bigLightenedCitys = bigLightenedCitys;
	}

	/**
	 * @return a működő képes kisvárosok listája
	 */
	public List<City> getSmallLightenedCitys() {
		return smallLightenedCitys;
	}

	/**
	 * @param smallLightenedCitys - beállítja a működő képes kisvárosok listáját
	 */
	@XmlElement(name = "smallLightenedCity")
	public void setSmallLightenedCitys(List<City> smallLightenedCitys) {
		this.smallLightenedCitys = smallLightenedCitys;
	}

}
