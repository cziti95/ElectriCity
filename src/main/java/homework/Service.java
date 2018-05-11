package homework;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Segédosztály a játék kezdeti értékeinek beállításához.
 * 
 * @author czirjak
 *
 */   
public class Service {
	/**
	 * Egy Initialization osztály példányának létrehozása.
	 */
	private Initialization init = new Initialization();

	/**
	 * A gamecontroller beli init osztály referenciája önmagára.
         * 
	 * @param init - a GameControllerben használt inicializációs példány
	 */
	public void setInit(Initialization init) {
		this.init = init;
	}

	/**
	 * A szükséges energia mennyiség.
	 */
	private double necessaryAmountofEnergy;
	/**
	 * Jelenlegi maximum energia.
	 */
	private double actualAmountofEnergy;
	/**
	 * Jelenleg felhasznált energia.
	 */
	private double actualAmountofUsedEnergy = 0;
	/**
	 * Városok száma.
	 */
	private int numberofCitys;
	/**
	 * Működő városok száma.
	 */
	private int numberofLightenedCitys;
	/**
	 * Nagy oszlopok száma.
	 */
	private int numberofBigPoles;
	/**
	 * Kis oszlopok száma.
	 */
	private int numberofSmallPoles;

	/**
	 * Beállítja a nagy villanyoszlopok számát.
         * 
	 * @param numberofBigPoles - a nagy villanyoszlopok száma
	 */
	public void setNumberofBigPoles(int numberofBigPoles) {
		this.numberofBigPoles = numberofBigPoles;
	}

	/**
	 * Beállítja a kis villanyoszlopok számát.
         * 
	 * @param numberofSmallPoles - a kis villanyoszlopok száma
	 */
	public void setNumberofSmallPoles(int numberofSmallPoles) {
		this.numberofSmallPoles = numberofSmallPoles;
	}
        
	/**
	 * 
	 * @return a szükséges energia mennyiség
	 */
	public double getNecessaryAmountofEnergy() {
		return necessaryAmountofEnergy;
	}
        
	/**
	 * 
	 * @return a rendelkezésre álló energia mennyiség
	 */
	public double getActualAmountofEnergy() {
		return actualAmountofEnergy;
	}
        
	/**
	 * 
	 * @return az aktuálisan felhasznált energia mennyiség
	 */
	public double getActualAmountofUsedEnergy() {
		return actualAmountofUsedEnergy;
	}
        
	/**
	 * 
	 * @return a városok száma
	 */
	public int getNumberofCitys() {
		return numberofCitys;
	}
        
	/**
	 * 
	 * @return a kivilágított városok száma
	 */
	public int getNumberofLightenedCitys() {
		return numberofLightenedCitys;
	}
        
	/**
	 * 
	 * @return a nagy villanyoszlopok száma
	 */
	public int getNumberofBigPoles() {
		return numberofBigPoles;
	}
        
	/**
	 * 
	 * @return a kis villanyoszlopok száma
	 */
	public int getNumberofSmallPoles() {
		return numberofSmallPoles;
	}

	/**
	 *  Beállítja az aktuálisan rendelkezésre álló energia szintet.
	 */
	public void setActualAmountOfEnergy() {

		if (!init.getGeneratorList().isEmpty())
			this.actualAmountofEnergy = init.getPowerGenerator().getMaxEnegryGenerate()
					+ init.getGeneratorList().size() * init.getGeneratorList().get(0).getPlusEnergy();
		else
			this.actualAmountofEnergy = init.getPowerGenerator().getMaxEnegryGenerate();

	}

	/**
	 * Beállítja az összes város darabszámát.
	 */
	public void CalcNumberofCitys() {

		this.numberofCitys = init.getBigCityList().size() + init.getSmallCityList().size();
	}

	/**
	 * Beállítja a felhasználható villanysoszlopok darabszámát.
         * 
	 * @param loadedSmall - a mentésből visszatöltött kis villanyoszlopok száma
         * @param loadedBig - a mentésből visszatöltött nagy villanyoszlopok száma
	 */
	public void setNumberofPoles(int loadedSmall, int loadedBig) {

		numberofSmallPoles = init.getSmallCityList().size() * 15 - loadedSmall;
		numberofBigPoles = init.getBigCityList().size() * 15 + init.getSmallCityList().size() - loadedBig;
	}

	/**
	 * Beállítja az aktuálisan felhasznált energimennyiséget.
	 */
	public void setActualAmountOfUsedEnergy() {
		double usedBySmall = 0;
		double usedByBig = 0;

		if (!init.getSmallLightenedCitys().isEmpty())
			usedBySmall = init.getSmallLightenedCitys().size()
					* init.getSmallLightenedCitys().get(0).getNecessaryEnergy();

		if (!init.getBigLightenedCitys().isEmpty())
			usedByBig = init.getBigLightenedCitys().size() * init.getBigLightenedCitys().get(0).getNecessaryEnergy();

		this.actualAmountofUsedEnergy = usedBySmall + usedByBig;
	}

	/**
	 * Beállítja a szükséges energiamennyiséget.
	 */
	public void setNecessaryAmountofEnergy() {
		double necBig = 0;
		double necSmall = 0;

		if (!init.getBigCityList().isEmpty())
			necBig = init.getBigCityList().size() * init.getBigCityList().get(0).getNecessaryEnergy();

		if (!init.getSmallCityList().isEmpty())
			necSmall = init.getSmallCityList().size() * init.getSmallCityList().get(0).getNecessaryEnergy();

		this.necessaryAmountofEnergy = necBig + necSmall;
	}

	/**
	 *  Kiszámolja összesen hány működő város van.
	 */
	public void CalculateNumberofLightenedCitys() {
		int big = 0;
		int small = 0;

		if (!init.getBigLightenedCitys().isEmpty())
			big = init.getBigLightenedCitys().size();

		if (!init.getSmallLightenedCitys().isEmpty())
			small = init.getSmallLightenedCitys().size();

		this.numberofLightenedCitys = big + small;
	}

	/**
	 * Kiírja a képernyőre az aktuális információkat.
         * 
	 * @param gc - az aktuális graphicscontext
	 */
	public void showInfo(GraphicsContext gc) {
		setNecessaryAmountofEnergy();

		String actEnergy = ("MAX ENERGIA: " + actualAmountofEnergy);
		String necEnergy = ("SZÜKSÉGES ENERGIA: " + necessaryAmountofEnergy);
		String usedEnergy = ("FELHASZNÁLT ENERGIA: " + actualAmountofUsedEnergy);
		String numCitys = ("VÁROSOK SZÁMA: " + numberofCitys);
		String lightenedCitys = ("MŰKÖDŐ VÁROSOK SZÁMA: " + numberofLightenedCitys);
		String smallPolesnumber = ("MEGMARADT KIS OSZLOPOK SZÁMA: " + numberofSmallPoles);
		String bigPolesnumber = ("MEGMARADT NAGY OSZLOPOK SZÁMA: " + numberofBigPoles);

		gc.fillText(actEnergy, 10, 12);
		gc.strokeText(actEnergy, 10, 12);

		gc.fillText(necEnergy, 10, 32);
		gc.strokeText(necEnergy, 10, 32);

		gc.fillText(usedEnergy, 10, 52);
		gc.strokeText(usedEnergy, 10, 52);

		gc.fillText(numCitys, 250, 12);
		gc.strokeText(numCitys, 250, 12);

		gc.fillText(lightenedCitys, 250, 32);
		gc.strokeText(lightenedCitys, 250, 32);

		gc.fillText(smallPolesnumber, 590, 37);
		gc.strokeText(smallPolesnumber, 590, 37);

		gc.fillText(bigPolesnumber, 590, 57);
		gc.strokeText(bigPolesnumber, 590, 57);

	}

	/**
	 * Kiírja a képernyőre, hogy "GAME OVER", ha a játék "vereséggel" végződik.
     * 
	 * @param gc - az aktuális graphicscontext
	 */
	public void writeGameOver(GraphicsContext gc) {
		String gameover = ("GAME OVER");

		gc.setFill(Color.RED);
		gc.setStroke(Color.RED);

		gc.fillText(gameover, 600, 20);
		gc.strokeText(gameover, 600, 20);
	}

}