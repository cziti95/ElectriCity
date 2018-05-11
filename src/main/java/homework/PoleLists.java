package homework;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import homework.model.ElectricPole;

/**
 * Segédosztály a villanyoszlopok adatbázisba történő mentéséhez.
 * 
 * @author czirjak
 *
 */
@XmlRootElement(name = "poles")
public class PoleLists {

	/**
	 * Kis oszlopok tárolásához.
	 */
	private List<ElectricPole> smallElectricPoleList = new ArrayList<ElectricPole>();
	/**
	 * Nagy oszlopok tárolásához.
	 */
	private List<ElectricPole> bigElectricPoleList = new ArrayList<ElectricPole>();

	/**
	 * @return a kis villanyoszlopok listája
	 */
	public List<ElectricPole> getSmallElectricPoleList() {
		return smallElectricPoleList;
	}

	/**
	 * @param smallElectricPoleList - beállítja a kis villanyoszlopok listáját
	 */
	@XmlElement(name = "smallPole")
	public void setSmallElectricPoleList(List<ElectricPole> smallElectricPoleList) {
		this.smallElectricPoleList = smallElectricPoleList;
	}

	/**
	 * @return a nagy villanyoszlopok listája
	 */
	public List<ElectricPole> getBigElectricPoleList() {
		return bigElectricPoleList;
	}

	/**
	 * @param bigElectricPoleList - beállítja a nagy villanyoszlopok listáját
	 */
	@XmlElement(name = "bigPole")
	public void setBigElectricPoleList(List<ElectricPole> bigElectricPoleList) {
		this.bigElectricPoleList = bigElectricPoleList;
	}

}
