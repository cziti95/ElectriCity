package homework.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *Osztály a játékbeli városok implementálásához.
 */
public class City {

	/**
	 * Az áram nélküli városok képe.
	 */
	private Image imageOff;
	/**
	 * Az árammal rendelkező városok képe.
	 */
	private Image imageOn;
	/**
	 * A város pozíciója az X tengelyen.
	 */
	private double positionX;
	/**
	 * A város pozíciója az Y tengelyen.
	 */
	private double positionY;
	/**
	 * A város szélessége.
	 */
	private double width;
	/**
	 * A város magassága.
	 */
	private double height;
	/**
	 * A városhoz szükséges energia mennyiség.
	 */
	private double necessaryEnergy;
	/**
	 * A város ID-ja.
	 */
	private int CityID;

	/**
	 * A <code>City</code> objektum létrehozása.
	 */
	public City() {
		super();
	}

	/**
	 * @param i - a város felvillanyozott képének beállítása.
	 */
	public void setImageOn(Image i){
	    imageOn = i;
	    width = i.getWidth();
	    height = i.getHeight();
	}

	/**
	 * @param filename - a szükséges kép fájlneve.
	 */
	public void setImageOn(String filename){
	    Image i = new Image(filename);
	    setImageOn(i);
	}

	/**
	 * @param i - a város áram nélküli képének beállítása.
	 */
	public void setImageOff(Image i){
	    imageOff = i;
	    width = i.getWidth();
	    height = i.getHeight();
	}

	/**
	 * @param filename - a szükséges kép fájlneve.
	 */
	public void setImageOff(String filename){
	    Image i = new Image(filename);
	    setImageOff(i);
	}

	/**
	 * @return - a város X tengelyen lévő pozícióját.
	 */
	public double getPositionX() {
		return positionX;
	}

	/**
	 * @param positionX - beállítja a város pozícióját az X tengelyen.
	 */
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	/**
	 *
	 * @return - a város Y tengelyen lévő pozícióját.
	 */
	public double getPositionY() {
		return positionY;
	}

	/**
	 *
	 * @param positionY - beállítja a város pozícióját az Y tengelyen.
	 */
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	/**
	 *
	 * @return - a város szélességét.
	 */
	public double getWidth() {
		return width;
	}

	/**
	 *
	 * @param width- beállítja a város szélességét.
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 *
	 * @return - a város magasságát.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 *
	 * @param height - beállítja a város magasságát.
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 *
	 * @return - a szükséges energiát.
	 */
	public double getNecessaryEnergy() {
		return necessaryEnergy;
	}

	/**
	 *
	 * @param necessaryEnergy - beállítja a szükséges energia szintet.
	 */
	public void setNecessaryEnergy(double necessaryEnergy) {
		this.necessaryEnergy = necessaryEnergy;
	}

	/**
	 *
	 * @return - a város ID-ját.
	 */
	public int getCityID() {
		return CityID;
	}

	/**
	 *
	 * @param cityID - beállítja a város ID-ját.
	 */
	public void setCityID(int cityID) {
		CityID = cityID;
	}

	/**
	 *
	 * @return - a város adatainak összesége.
	 */
	@Override
	public String toString() {
		return "City [imageOff=" + imageOff + ", imageOn=" + imageOn + ", positionX=" + positionX + ", positionY="
				+ positionY + ", width=" + width + ", height=" + height + ", necessaryEnergy=" + necessaryEnergy
				+ ", CityID=" + CityID + "]";
	}

	/**
	 *  Kirajzolja a kikapcsolt várost.
	 * @param gc - a "rajzterület"
	 */
	public void renderOffImage(GraphicsContext gc){
		gc.drawImage(imageOff, positionX, positionY);
	}

	/**
	 *  Kirajzolja a felvillanyozott várost.
	 * @param gc - a "rajzterület"
	 */
	public void renderOnImage(GraphicsContext gc){
		gc.drawImage(imageOn, positionX, positionY);
	}
		
}
