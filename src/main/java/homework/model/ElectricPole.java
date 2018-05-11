package homework.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Osztály a játékbeli villanyoszlopok létrehozásához.
 */
public class ElectricPole {

	/**
	 * Az alap képe a villanyoszlopnak.
	 */
	private Image image;
	/**
	 * A túltöltött képe a villanyoszlopnak.
	 */
	private Image imageOverloaded;
	/**
	 * Az X pozíciója.
	 */
	private double positionX;
	/**
	 * Az Y pozíciója.
	 */
	private double positionY;
	/**
	 * A szélessége.
	 */
	private double width;
	/**
	 * A hosszúsága.
	 */
	private double height;
	/**
	 * Az átvivő képessége.
	 */
	private double carryingCapacity;
	/**
	 * Túltöltött -e ?
	 */
	private boolean overloaded;
	/**
	 * Az ID-ja.
	 */
	private int PoleID;

	/**
	 * Az <code>ElectricPole</code> objektum létrehozása.
	 */
	public ElectricPole() {
		super();
	}

	/**
	 * @param i - alap kép beállítása
	 */
	public void setImage(Image i){
	    image = i;
	    width = i.getWidth();
	    height = i.getHeight();
	}

	/**
	 *
	 * @param filename - a beállítandó kép fájlneve
	 */
	public void setImage(String filename){
	    Image i = new Image(filename);
	    setImage(i);
	}

	/**
	 *
	 * @param i - a túltöltött oszlop képe
	 */
	public void setImageOverloaded(Image i){
	    imageOverloaded = i;
	    width = i.getWidth();
	    height = i.getHeight();
	}

	/**
	 *
	 * @param filename - a túltöltött oszlop képének a fájlneve
	 */
	public void setImageOverloaded(String filename){
	    Image i = new Image(filename);
	    setImageOverloaded(i);
	}

	/**
	 *
	 * @return az oszlop túltöltődett-e?
	 */
	public boolean isOverloaded() {
		return overloaded;
	}

	/**
	 *
	 * @param overloaded - ha kell a túltöltöttség beállítása.
	 */
	public void setOverloaded(boolean overloaded) {
		this.overloaded = overloaded;
	}

	/**
	 *
	 * @return - az oszlop X pozíciója.
	 */
	public double getPositionX() {
		return positionX;
	}

	/**
	 *
	 * @param positionX - az oszlop X pozíciójának beállítása.
	 */
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	/**
	 *
	 * @return - az oszlop Y pozíciója.
	 */
	public double getPositionY() {
		return positionY;
	}

	/**
	 *
	 * @param positionY - az oszlop Y pozíciójának beállítsa.
	 */
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	/**
	 *
	 * @return - az oszlop szélessége.
	 */
	public double getWidth() {
		return width;
	}

	/**
	 *
	 * @param width - az oszlop szélességének beállítása.
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 *
	 * @return - az oszlop magassága.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height - az oszlop magasságának beállítása
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return - az oszlop által átvihető energia mennyiség
	 */
	public double getCarryingCapacity() {
		return carryingCapacity;
	}

	/**
	 *
	 * @param carryingCapacity - az átvihető energia mennyiség beállítása.
	 */
	public void setCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	/**
	 *
	 * @return - az oszlop ID-ja
	 */
	public int getPoleID() {
		return PoleID;
	}

	/**
	 *
	 * @param smallPoleID - oszlop ID-jának beállítása
	 */
	public void setPoleID(int smallPoleID) {
		PoleID = smallPoleID;
	}

	/**
	 *
	 * @return - az oszlop tulajdonságainak összesége
	 */
	@Override
	public String toString() {
		return "SmallElectricPole [image=" + image + ", imageOverloaded=" + imageOverloaded + ", positionX=" + positionX
				+ ", positionY=" + positionY + ", width=" + width + ", height=" + height + ", carryingCapacity="
				+ carryingCapacity + ", SmallPoleID=" + PoleID + "]";
	}

	/**
	 *  A normál állapotban lévő oszlop kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void render(GraphicsContext gc){
		gc.drawImage(image, positionX, positionY);
	}

	/**
	 *  A túltöltött állapotban lévő oszlop kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void renderOverloaded(GraphicsContext gc){
		gc.drawImage(imageOverloaded, positionX, positionY);
	}
	

}
