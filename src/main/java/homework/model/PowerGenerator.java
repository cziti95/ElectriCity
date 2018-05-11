package homework.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Osztály a játékbeli nagy áramfejlesztő létrehozásához.
 */
public class PowerGenerator {

	/**
	 * Az áramfejlesztő képe.
	 */
	private Image image;
	/**
	 * Az áramfejlesztő túltöltött képe.
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
	 * A magassága.
	 */
	private double height;
	/**
	 * Az általa biztosított maximum energia mennyisége.
	 */
	private double MaxEnegryGenerate;

	/**
	 * A <code>PowerGenerator</code> objektum létrehozása.
	 */
	public PowerGenerator() {
		super();
	}

	/**
	 * Normál képének a beállítása.
	 * @param i - a képe
	 */
	public void setImage(Image i){
	    image = i;
	    width = i.getWidth();
	    height = i.getHeight();
	}

	/**
	 *
	 * @param filename - a képének a fájlneve.
	 */
	public void setImage(String filename){
	    Image i = new Image(filename);
	    setImage(i);
	}

	/**
	 * A túltöltött képének a beállítása.
	 * @param i - a túltöltött képe.
	 */
	public void setImageOverloaded(Image i){
	    imageOverloaded = i;
	    width = i.getWidth();
	    height = i.getHeight();
	}

	/**
	 *
	 * @param filename - a túltöltött képének a fájlneve.
	 */
	public void setImageOverloaded(String filename){
	    Image i = new Image(filename);
	    setImageOverloaded(i);
	}

	/**
	 *
	 * @return - az X pozíciója.
	 */
	public double getPositionX() {
		return positionX;
	}

	/**
	 *
	 * @param positionX - az X pozíciójának beállítása.
	 */
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	/**
	 *
	 * @return - az X pozíciója.
	 */
	public double getPositionY() {
		return positionY;
	}

	/**
	 *
	 * @param positionY - az Y pozíció beállítása.
	 */
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	/**
	 *
	 * @return - a szélessége
	 */
	public double getWidth() {
		return width;
	}

	/**
	 *
	 * @param width - a szélességének a beállítása
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 *
	 * @return - a magassága
	 */
	public double getHeight() {
		return height;
	}

	/**
	 *
	 * @param height - a magasságának a beállítása.
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 *
	 * @return - a biztosított energia mennyisége
	 */
	public double getMaxEnegryGenerate() {
		return MaxEnegryGenerate;
	}

	/**
	 *
	 * @param maxEnegryGenerate - a maximum biztosított energia mennyiségének beállítása.
	 */
	public void setMaxEnegryGenerate(double maxEnegryGenerate) {
		MaxEnegryGenerate = maxEnegryGenerate;
	}

	/**
	 *
	 * @return - az áramfejlesztő tulajdonságainak összesége.
	 */
	@Override
	public String toString() {
		return "PowerGenerator [image=" + image + ", imageOverloaded=" + imageOverloaded + ", positionX=" + positionX
				+ ", positionY=" + positionY + ", width=" + width + ", height=" + height + ", MaxEnegryGenerate="
				+ MaxEnegryGenerate + "]";
	}

	/**
	 * Az áramfejlesztő kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void render(GraphicsContext gc){
		gc.drawImage(image, positionX, positionY);
	}

	/**
	 * A túltöltött áramfejlesztő kirajzolása.
	 * @param gc - a "rajzterület"
	 */
	public void renderOverloaded(GraphicsContext gc){
		gc.drawImage(imageOverloaded, positionX, positionY);
	}

}
