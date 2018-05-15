package homework;

import java.util.ArrayList;
import java.util.List;

import homework.model.City;
import homework.model.ElectricPole;
import homework.model.Generator;
import homework.model.PowerGenerator;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Inicializáló osztály a játékhoz.
 */
public class Initialization {

	/**
	 * A rajzterület mérete.
	 */
	private Canvas canvas = new Canvas( 1024, 768 );

	/**
	 * Plusz generátorok száma.
	 */
	private int numberofGenerators = 0;
	/**
	 *  Kisvárosokat száma.
	 */
	private int numberofSmallCitys;
	/**
	 * Nagyvárosok száma.
	 */
	private int numberofBigCitys;
	/**
	 * Kis villanyoszlopok száma.
	 */
	private int numberofSmallElectricPole = 0;
	/**
	 * Nagy villanyoszlopok száma.
	 */
	private int numberofBigElectricPole = 0;

	/**
	 * Beállítja a kezdeti generátorok számát.
	 * @param numberofGenerators - A kezdeti generátorok száma.
	 * @return a kezdeti generátorok számát.
	 */
	public int setNumberofGenerators(int numberofGenerators) {
			numberofGenerators++;
	 return this.numberofGenerators = numberofGenerators;
	}

	/**
	 * @param numberofSmallCitys - Beállítja a kis városok számát.
	 */
	public void setNumberofSmallCitys(int numberofSmallCitys) {
		this.numberofSmallCitys = numberofSmallCitys;
	}

	/**
	 * @param numberofBigCitys - Beállítja a nagy városok számát.
	 */
	public void setNumberofBigCitys(int numberofBigCitys) {
		this.numberofBigCitys = numberofBigCitys;
	}

	/**
	 * A {@code PowerGenerator} inicializálása.
	 */
	private InitPowerGenerator initPG = new InitPowerGenerator(canvas.getWidth());
	/**
	 * Világitás vezérlő.
	 */
	private LightningController lightningController = new LightningController();
	/**
	 * Az {@code PowerGenerator} létrehozása.
	 */
	private PowerGenerator powerGenerator = new PowerGenerator();
	/**
	 * A generátorok tárolására szolgálló lista.
	 */
	private List<Generator> generatorList = new ArrayList<Generator>();
	/**
	 * A kisvárosok tárolására szolgálló lista.
	 */
	private List<City> smallCityList = new ArrayList<City>();
	/**
	 * A nagyvárosok tárolására szolgálló lista.
	 */
	private List<City> bigCityList = new ArrayList<City>();
	/**
	 * A kis villanyoszlopok tárolására szolgálló lista.
	 */
	private List<ElectricPole> smallElectricPoleList = new ArrayList<ElectricPole>();
	/**
	 * A nagy villanyoszlopok tárolására szolgálló lista.
	 */
	private List<ElectricPole> bigElectricPoleList = new ArrayList<ElectricPole>();
	/**
	 * A kis működő városok tárolására szolgálló lista.
	 */
	private List<City> smallLightenedCitys = new ArrayList<City>();
	/**
	 * A nagy működő városok tárolására szolgálló lista.
	 */
	private List<City> bigLightenedCitys = new ArrayList<City>();

	/**
	 *
	 * @return - a nagy áramfejlesztő
	 */
	public PowerGenerator getPowerGenerator() {
		return powerGenerator;
	}

	/**
	 *
	 * @return - power generátort
	 */
	public InitPowerGenerator getInitPG() {
		return initPG;
	}

	/**
	 *
	 * @param initPG - az inicializálandó áramfejlesztő
	 */
	public void setInitPG(InitPowerGenerator initPG) {
		this.initPG = initPG;
	}

	/**
	 *
	 * @return - a plusz generátorok listája
	 */
	public List<Generator> getGeneratorList() {
		return generatorList;
	}

	/**
	 * Beállítja a generátorok listáját.
	 * @param generatorList - a plusz generátorok listája
	 */
	public void setGeneratorList(List<Generator> generatorList) {
		this.generatorList = generatorList;
	}

	/**
	 * Beállítja a kis villanyoszlopok listáját.
	 * @param smallElectricPoleList - a kis villanyoszlopok listája
	 */
	public void setSmallElectricPoleList(List<ElectricPole> smallElectricPoleList) {
		this.smallElectricPoleList = smallElectricPoleList;
	}

	/**
	 * Beállítja a nagy villanyoszlopok listáját.
	 * @param bigElectricPoleList - a nagy villanyoszlopok listája
	 */
	public void setBigElectricPoleList(List<ElectricPole> bigElectricPoleList) {
		this.bigElectricPoleList = bigElectricPoleList;
	}

	/**
	 *
	 * @return - a kisvárosok listája
	 */
	public List<City> getSmallCityList() {
		return smallCityList;
	}

	/**
	 *
	 * @return - a nagyvárosok listája
	 */
	public List<City> getBigCityList() {
		return bigCityList;
	}

	/**
	 *
	 * @return - a kis villanyoszlopok listája
	 */
	public List<ElectricPole> getSmallElectricPoleList() {
		return smallElectricPoleList;
	}

	/**
	 *
	 * @return - a nagy villanyoszlopok listája
	 */
	public List<ElectricPole> getBigElectricPoleList() {
		return bigElectricPoleList;
	}

	/**
	 *
	 * @return - a kis müködő képes városok listája
	 */
	public List<City> getSmallLightenedCitys() {
		return smallLightenedCitys;
	}

	/**
	 *
	 * @return - a nagy müködő képes városok listája
	 */
	public List<City> getBigLightenedCitys() {
		return bigLightenedCitys;
	}

	/**
	 * Beállítja a kis városokat.
	 * @param smallCityList - a kis városok listája
	 */
	public void setSmallCityList(List<City> smallCityList) {
		this.smallCityList = smallCityList;
	}

	/**
	 * Beállítja a nagy városokat.
	 * @param bigCityList - nagyvárosok listája
	 */
	public void setBigCityList(List<City> bigCityList) {
		this.bigCityList = bigCityList;
	}

	/**
	 * Beállítja a kis működő városokat.
	 * @param smallLightenedCitys - kis működő városok listája.
	 */
	public void setSmallLightenedCitys(List<City> smallLightenedCitys) {
		this.smallLightenedCitys = smallLightenedCitys;
	}

	/**
	 * Beállítja a nagy működő városokat.
	 * @param bigLightenedCitys - nagy működő városok listája.
	 */
	public void setBigLightenedCitys(List<City> bigLightenedCitys) {
		this.bigLightenedCitys = bigLightenedCitys;
	}

	/**
	 *Nagy generátor inicializálása, képeinek beállítása.
	 */
	public void initPowerGenerator(){
		initPG.getPowerGenerator().setImage("power_generator.png");
		initPG.getPowerGenerator().setImageOverloaded("power_generator_overloaded.png");
		powerGenerator = initPG.getPowerGenerator();
	}

	/**
	 * Áramfejlesztő kirajzolása.
	 * @param gc - az adott graphicsContext.
	 */
	public void PowerGeneratorView(GraphicsContext gc){
		powerGenerator.render(gc);
	}

	/**
	 * Esetlegesen túltöltött áramfejlesztő kirajzolása.
	 * @param gc - az adott graphicsContext.
	 */
	public void PowerGeneratorOverloadedView(GraphicsContext gc){
		powerGenerator.renderOverloaded(gc);
	}

	/**
	 * Kisebb generátorok inicializálása, képének beállítása.
	 */
	public void initGenerators(){
		if(numberofGenerators <= 7){
			InitGenerator initG = new InitGenerator(canvas.getWidth(),initPG.getPowerGenerator(), numberofGenerators);
			initG.getGenerator().setImage("generator.png");
			generatorList.add(initG.getGenerator());
			setNumberofGenerators(numberofGenerators);
		}
	}

	/**
	 * Ha szükséges, akkor kirajzol plusz generátorokat.
	 * @param gc - az adott graphicsContext.
	 */
	public void GeneratorsView(GraphicsContext gc){
		if(!generatorList.isEmpty())
			generatorList.forEach(a -> a.render(gc));
	}

	/**
	 * Kis városok inicializálása, képeinek beállítása.
	 */
	public void initSmallCitys(){
		SmallCity smallCitys = new SmallCity(canvas.getWidth(),canvas.getHeight(), initPG.getPowerGenerator().getHeight(),numberofSmallCitys);
		smallCitys.getSmallCityList().forEach(a -> {
			a.setImageOn("small_city_on.png");
			a.setImageOff("small_city_off.png");
		});
		smallCityList = smallCitys.getSmallCityList();
	}

	/**
	 * Az áram nélküli városok kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void SmallCitysOffView(GraphicsContext gc){
		if(!smallCityList.isEmpty())
			smallCityList.forEach(a -> a.renderOffImage(gc));
	}

	/**
	 * Kis városok vizsgálat, hogy elért-e már hozzájuk esetleg egy villanyoszlop(kicsi).
	 */
	public void initSmallCitysOnBySmallElectricPole(){
		lightningController.SmallCityReachedwithSmallPole(smallCityList, smallElectricPoleList);
			
		smallLightenedCitys = lightningController.getSmallLightenedCitys();
	}

	/**
	 * Kis városok vizsgálat, hogy elért-e már hozzájuk esetleg egy villanyoszlop(nagy).
	 */
	public void initSmallCitysOnByBigElectricPole(){
		lightningController.SmallCityReachedwithBigPole(smallCityList, bigElectricPoleList);
		
		smallLightenedCitys = lightningController.getSmallLightenedCitys();
	}

	/**
	 * A felvillanyozott kisvárosok kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void SmallCitysOnView(GraphicsContext gc){
		if(!smallLightenedCitys.isEmpty())
				smallLightenedCitys.forEach(a -> a.renderOnImage(gc));
	}

	/**
	 * Nagy városok inicializálása, képeinek beállítása.
	 */
	public void initBigCitys(){
		BigCity bigCitys = new BigCity(canvas.getWidth(), canvas.getHeight(),initPG.getPowerGenerator().getHeight(),numberofBigCitys);
		bigCitys.getBigCityList().forEach(a -> {
			a.setImageOn("big_city_on.png");
			a.setImageOff("big_city_off.png");
		});
		bigCityList = bigCitys.getBigCityList();
	}

	/**
	 *	Az áram nélküli nagyvárosok kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void BigCitysOffView(GraphicsContext gc){
		if(!bigCityList.isEmpty())
			bigCityList.forEach(a -> a.renderOffImage(gc));
	}

	/**
	 ** Nagy városok vizsgálat, hogy elért-e már hozzájuk esetleg egy villanyoszlop(kicsi).
	 * @return - annak a vizsgálatnak az eredménye, hogy nagy városba ütköztünk-e kis oszlopppal.
	 */
	public boolean initBigCitysOnBySmallElectricPole(){
		if(lightningController.BigCityReachedwithSmallPole(bigCityList, smallElectricPoleList) == 1){
			smallElectricPoleList.get(smallElectricPoleList.size() - 1).setOverloaded(true);
			return true;
		}
			
		return false;
	}

	/**
	 ** Nagy városok vizsgálat, hogy elért-e már hozzájuk esetleg egy villanyoszlop(nagy).
	 */
	public void initBigCitysOnByBigElectricPole(){
		lightningController.BigCityReachedwithBigPole(bigCityList, bigElectricPoleList);
			
		bigLightenedCitys = lightningController.getBigLightenedCitys();
	}

	/**
	 * A felvillanyozott nagyvárosok kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void BigCitysOnView(GraphicsContext gc){
		if(!bigLightenedCitys.isEmpty())
			bigLightenedCitys.forEach(a -> a.renderOnImage(gc));
	}

	/**
	 * Kis villanyoszlop letétele.
	 * @param direction - melyik irányba tegye le a villanyoszlopot
	 */
	public void initSmallElectricPole(int direction){
		SmallElectricPole smallPole = new SmallElectricPole(canvas,initPG.getPowerGenerator(), numberofSmallElectricPole, direction, smallElectricPoleList);
		smallElectricPoleList.add(smallPole.getSmallElectricPole());
		numberofSmallElectricPole++;
	}

	/**
	 * Kis villanyoszlopok kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void SmallElectricPoleView(GraphicsContext gc){
		if(!smallElectricPoleList.isEmpty())
			for(ElectricPole overload : smallElectricPoleList)
				if(overload.isOverloaded())
					overload.renderOverloaded(gc);
				else
					overload.render(gc);
	}

	/**
	 * Nagy villanyoszlopok letétele.
	 * @param direction - melyik irányba tegye le a villanyoszlopot
	 */
	public void initBigElectricPole(int direction){
		BigElectricPole bigPole =  new BigElectricPole(canvas.getWidth(),initPG.getPowerGenerator(), numberofBigElectricPole, direction, bigElectricPoleList);
		bigElectricPoleList.add(bigPole.getBigElectricPole());
		numberofBigElectricPole++;
	}

	/**
	 * Nagy villanyoszlopok kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void BigElectricPoleView(GraphicsContext gc){
		if(!bigElectricPoleList.isEmpty())
			bigElectricPoleList.forEach(a -> a.render(gc));
	}
	
}
