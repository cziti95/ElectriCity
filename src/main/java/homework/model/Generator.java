package homework.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Osztály a játékbeli kisebb generátorok létrehozásához.
 */
public class Generator {
	/**
	 * A generátor képe.
	 */
	private Image image;
	/**
	 * A generátor X pozíciója.
	 */
	private double positionX;
	/**
	 * A generátor Y pozíciója.
	 */
	private double positionY;
	/**
	 * A generátor szélessége.
	 */
	private double width;
	/**
	 * A generátor magassága.
	 */
	private double height;
	/**
	 * A generátor által biztosított plussz energiamennyiség.
	 */
	private double PlusEnergy;
	/**
	 * A generátor ID-ja.
	 */
	private int GeneratorID;

	/**
	 * A <code>Generator</code> objektum létrehozása.
	 */
	public Generator() {
		super();
	}

	/**
	 *
	 * @param i - a generátor képe.
	 */
	public void setImage(Image i){
	    image = i;
	    width = i.getWidth();
	    height = i.getHeight();
	}

	/**
	 *
	 * @param filename - a generátor képének fájlneve.
	 */
	public void setImage(String filename){
	    Image i = new Image(filename);
	    setImage(i);
	}

	/**
	 *
	 * @return - a generátor X pozíciója.
	 */
	public double getPositionX() {
		return positionX;
	}

	/**
	 *
	 * @param positionX - a generátor X pozíciójának beállítása.
	 */
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	/**
	 *
	 * @return - a generátor Y pozíciója.
	 */
	public double getPositionY() {
		return positionY;
	}

	/**
	 *
	 * @param positionY - a generátor Y pozíciójának beállítása.
	 */
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	/**
	 *
	 * @return - a generátor szélessége.
	 */
	public double getWidth() {
		return width;
	}

	/**
	 *
	 * @param width - a generátor szélességének beállítása.
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 *
	 * @return - a generátor magassága.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 *
	 * @param height - a generátor magasságának beállítása.
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 *
	 * @return - a generátor által biztosított plusz energia.
	 */
	public double getPlusEnergy() {
		return PlusEnergy;
	}

	/**
	 *
	 * @param plusEnergy - a generátor által biztosított plusz energia beállítása.
	 */
	public void setPlusEnergy(double plusEnergy) {
		PlusEnergy = plusEnergy;
	}

	/**
	 *
	 * @return - a generátor ID-ja
	 */
	public int getGeneratorID() {
		return GeneratorID;
	}

	/**
	 *
	 * @param generatorID - a generátor ID-jának beállítása.
	 */
	public void setGeneratorID(int generatorID) {
		GeneratorID = generatorID;
	}

	/**
	 *
	 * @return - a generátor tulajdonságainak összesége.
	 */
	@Override
	public String toString() {
		return "Generator [image=" + image + ", positionX=" + positionX + ", positionY=" + positionY + ", width="
				+ width + ", height=" + height + ", MaxPlusEnergy=" + PlusEnergy + ", GeneratorID=" + GeneratorID
				+ "]";
	}

	/**
	 * A generátor kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void render(GraphicsContext gc){
		gc.drawImage(image, positionX, positionY);
	}
	

}
