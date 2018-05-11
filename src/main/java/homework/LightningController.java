package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import homework.model.City;
import homework.model.ElectricPole;

/**
 * Osztály a kivilágítások kezeléséhez.
 * 
 * @author czirjak
 *
 */
public class LightningController {

	/**
	 * Segédváltozó a kis világító városokhoz.
	 */
	private List<City> smallLightenedCitys_tmp = new ArrayList<City>();
	/**
	 * Segédváltozó a nagy világító városokhoz.
	 */
	private List<City> bigLightenedCitys_tmp = new ArrayList<City>();
	/**
	 * A kis világító városok tárolására.
	 */
	private List<City> smallLightenedCitys = new ArrayList<City>();
	/**
	 * A nagy világító városok tárolására.
	 */
	private List<City> bigLightenedCitys = new ArrayList<City>();

	/**
	 * @return a kivilágított kisvárosok listája
	 */
	public List<City> getSmallLightenedCitys() {
		return smallLightenedCitys;
	}

	/**
	 * @return a kivilágított nagyvárosok listája
	 */
	public List<City> getBigLightenedCitys() {
		return bigLightenedCitys;
	}

	/**
	 * Megtisztítja a paraméterként kapott listát a duplikációktol.
	 * 
	 * @param smallLightenedCitys_tmp - egy segédváltozó
	 * @return a duplikácioktól mentes kisvárosok listája
	 */
	private List<City> CleaningUpsmall(List<City> smallLightenedCitys_tmp) {
		return smallLightenedCitys_tmp.stream().distinct().collect(Collectors.toList());

	}

	/**
	 * Megtisztítja a paraméterként kapott listát a duplikációktol.
	 * 
	 * @param bigLightenedCitys_tmp - egy segédváltozó
	 * @return a duplikácioktól mentes nagyvárosok listája
	 */
	private List<City> CleaningUpbig(List<City> bigLightenedCitys_tmp) {
		return bigLightenedCitys_tmp.stream().distinct().collect(Collectors.toList());
	}

	/**
	 * Vizsgálja, hogy kis villanyoszloppal elértünk-e egy kisvárost.
	 * 
	 * @param smallCityList - a kisvárosok listája
	 * @param smallPoleList - a kis villanyoszlopok listája
	 */
	public void SmallCityReachedwithSmallPole(List<City> smallCityList, List<ElectricPole> smallPoleList) {
		ElectricPole lastsmallPole;

		for (City small : smallCityList)
			for (ElectricPole smallpole : smallPoleList) {
				lastsmallPole = smallpole;
				if ((Math.abs(small.getPositionX() - lastsmallPole.getPositionX()) < lastsmallPole.getWidth()) && (Math
						.abs(small.getPositionY() - lastsmallPole.getPositionY()) < lastsmallPole.getHeight())) {
					smallLightenedCitys_tmp.add(small);
				}
			}

		smallLightenedCitys = CleaningUpsmall(smallLightenedCitys_tmp);
	}

	/**
	 * Vizsgálja, hogy nagy villanyoszloppal elértünk-e egy kisvárost.
	 * 
	 * @param smallCityList - a kisvárosok listája
	 * @param bigPoleList - a nagy villanyoszlopok listája
	 */
	public void SmallCityReachedwithBigPole(List<City> smallCityList, List<ElectricPole> bigPoleList) {
		ElectricPole lastbigPole;

		for (City small : smallCityList)
			for (ElectricPole bigPole : bigPoleList) {
				lastbigPole = bigPole;
				if ((Math.abs(small.getPositionX() - lastbigPole.getPositionX()) < lastbigPole.getWidth())
						&& (Math.abs(small.getPositionY() - lastbigPole.getPositionY()) < lastbigPole.getHeight())) {
					smallLightenedCitys_tmp.add(small);
				}
			}

		smallLightenedCitys = CleaningUpsmall(smallLightenedCitys_tmp);
	}

	/**
	 * Vizsgálja, hogy kis villanyoszloppal elértünk-e egy nagyvárost.
	 * 
	 * @param bigCityList - a nagyvárosok listája
	 * @param smallPoleList - a kis villanyoszlopok listája
	 * @return elértünk-e egy nagyvárost kis villanyoszloppal, ha igen a játéknak vége
	 */
	public int BigCityReachedwithSmallPole(List<City> bigCityList, List<ElectricPole> smallPoleList) {
		ElectricPole lastsmallPole;

		for (City big : bigCityList)
			for (ElectricPole smallPole : smallPoleList) {
				lastsmallPole = smallPole;
				if (((Math.abs(big.getPositionX() - lastsmallPole.getPositionX()) < big.getWidth() / 2)
						|| Math.abs(big.getPositionX() + lastsmallPole.getPositionX()) < big.getWidth() / 2)
						&& ((Math.abs(big.getPositionY() - lastsmallPole.getPositionY()) < big.getHeight() / 2) || (Math
								.abs(big.getPositionY() + lastsmallPole.getPositionY()) < big.getHeight() / 2))) {

					if (!(lastsmallPole.getCarryingCapacity() == big.getNecessaryEnergy())) {
						lastsmallPole.setOverloaded(true);
						return 1;
					}
				}
			}

		bigLightenedCitys = CleaningUpbig(bigLightenedCitys_tmp);

		return 0;
	}

	/**
	 * Vizsgálja, hogy nagy villanyoszloppal elértünk-e egy nagyvárost.
	 * 
	 * @param bigCityList - a nagyvárosok listája
	 * @param bigPoleList - a nagy villanyoszlopok listája
	 */
	public void BigCityReachedwithBigPole(List<City> bigCityList, List<ElectricPole> bigPoleList) {
		ElectricPole lastbigPole;

		for (City big : bigCityList)
			for (ElectricPole bigPole : bigPoleList) {
				lastbigPole = bigPole;
				if ((Math.abs(big.getPositionX() - lastbigPole.getPositionX()) < lastbigPole.getWidth())
						&& (Math.abs(big.getPositionY() - lastbigPole.getPositionY()) < lastbigPole.getHeight())) {
					bigLightenedCitys_tmp.add(big);
				}
			}

		bigLightenedCitys = CleaningUpbig(bigLightenedCitys_tmp);
	}

}
