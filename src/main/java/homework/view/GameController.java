package homework.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import homework.CityLists;
import homework.Initialization;
import homework.MainApp;
import homework.PoleLists;
import homework.Service;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * A játék vezérléséért felelős kontroller osztály.
 * 
 * @author czirjak
 *
 */
public class GameController {

	/**
	 * A főalkalmazás.
	 */
	@SuppressWarnings("unused")
	private MainApp mainApp;

	/**
	 * A panel.
	 */
	@FXML
	private AnchorPane anchorPane;

	/**
	 * Inicializációs osztály készítése.
	 */
	public Initialization init = new Initialization();
	/**
	 * Service osztály készítése.
	 */
	public Service service = new Service();
	/**
	 * Városlista osztály készítése.
	 */
	public CityLists cityLists = new CityLists();
	/**
	 * Oszloplista osztály készítése.
	 */
	public PoleLists poleLists = new PoleLists();

	/**
	 * A plusz generátorok letételére szolgáló gomb.
	 */
	private Button generatorButton = new Button("Generátor");
	/**
	 * Kis villanyoszlopokat aktívra állító gomb.
	 */
	private Button smallElectricPoleButton = new Button("Kis villanyoszlop");
	/**
	 * Nagy villanyoszlopkat aktívra állító gomb.
	 */
	private Button bigElectricPoleButton = new Button("Nagy villanyoszlop");
	/**
	 * Mentő gomb.
	 */
	private Button saveButton = new Button("Mentés");
	/**
	 * Betöltő gomb.
	 */
	private Button loadButton = new Button("Betöltés");

	/**
	 * Az alapterület.
	 */
	private Canvas canvas;
	/**
	 * A rajzterület.
	 */
	private GraphicsContext gc;
	/**
	 * Az aktuálisan kiválasztott villanyoszloptípus.
	 */
	private int actualChoise = 1;
	
	/**
	 * A gombok beállításáért felelős metódus.
	 */
	private void setButtons(){
	
		generatorButton.setPrefWidth(140);
		generatorButton.setLayoutX(875);
		generatorButton.setLayoutY(25);
		generatorButton.setOnAction(e -> init.initGenerators());

		smallElectricPoleButton.setPrefWidth(140);
		smallElectricPoleButton.setLayoutX(875);
		smallElectricPoleButton.setLayoutY(65);
		smallElectricPoleButton.setOnAction(e -> setActualChoise(1));
	
		bigElectricPoleButton.setPrefWidth(140);
		bigElectricPoleButton.setLayoutX(875);
		bigElectricPoleButton.setLayoutY(105);
		bigElectricPoleButton.setOnAction(e -> setActualChoise(2));
		
		saveButton.setPrefWidth(140);
		saveButton.setLayoutX(875);
		saveButton.setLayoutY(700);
		saveButton.setOnAction(e -> saveGameStatetoFile());
		
		loadButton.setPrefWidth(140);
		loadButton.setLayoutX(875);
		loadButton.setLayoutY(660);
		loadButton.setOnAction(e -> loadGameStatefromFile());
		
	}
	
	/**
     * Inicializálja a kontroller osztályt.
     */
	@FXML
    private void initialize() {
    }

	/**
	 * Az osztály konstruktora.
	 */
	public GameController() {
		super();
	}
	
	/**
	 * A fő alkalmazás felhívja a referenciát önmagára.
     * 
     * @param mainApp - beállítja a főalkalmazást
     */
    public void setMainApp(MainApp mainApp) {
    	
    	this.mainApp = mainApp;
    }

	/**
	 * Beállítja az éppen aktív villanyoszlop típust.
	 * 
	 * @param actualChoise - az aktív villanyoszlop típus
	 */
	public void setActualChoise(int actualChoise) {
		this.actualChoise = actualChoise;
	}
	
    /**
     * @return az inicializáló osztály
     */
    public Initialization getInit() {
		return init;
	}
    
	/**
	 * A játék vezérlését végző metódus.
	 */
	public void startGame(){
		
    	canvas = new Canvas(1024,768);
    	
    	anchorPane.getChildren().add(canvas);
    	
    	setButtons();
    	
    	service.setInit(init);
    	
    	anchorPane.getChildren().addAll(generatorButton, smallElectricPoleButton, bigElectricPoleButton, saveButton, loadButton);
    	
    	gc = canvas.getGraphicsContext2D();
    
		gc.setFill(Color.YELLOW);
		gc.setStroke(Color.YELLOW);
    	
    	init.initPowerGenerator();
    	
    	Random r = new Random();
    	
    	init.setNumberofSmallCitys(r.nextInt(14) + 1);
    	init.initSmallCitys();
    	
    	init.setNumberofBigCitys(r.nextInt(14) + 1);
    	init.initBigCitys();
    	
    	service.setNumberofPoles(0,0);
    	
    	cityLists.setBigCitys(init.getBigCityList());
    	cityLists.setSmallCitys(init.getSmallCityList());
    		
    	final ArrayList<String> input = new ArrayList<String>();
         
    	 anchorPane.requestFocus();
    	 
         anchorPane.setOnKeyPressed(
           new EventHandler<KeyEvent>(){
           	@Override
               public void handle(KeyEvent e){
                  String code = e.getCode().toString();
                   if ( !input.contains(code) ){
                    	   input.add( code );
                   }
               	}
               });
       
         anchorPane.setOnKeyReleased(
           new EventHandler<KeyEvent>(){
           	@Override
               public void handle(KeyEvent e){
               	String code = e.getCode().toString();
               	input.remove(code);
                   }
               });
      
    			  
    	new AnimationTimer(){
       	 
			@Override
			public void handle(long now) {
				 gc.clearRect(0, 0, 1024, 768);
					
				 try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				 
				 service.setActualAmountOfUsedEnergy();
				 service.setActualAmountOfEnergy();
				 service.CalcNumberofCitys();
				 service.CalculateNumberofLightenedCitys();
				 service.showInfo(gc);
				 
				 if(service.getActualAmountofUsedEnergy() <= service.getActualAmountofEnergy())
					 init.PowerGeneratorView(gc);
				 else{
					 init.PowerGeneratorOverloadedView(gc);
					 service.writeGameOver(gc);
					 this.stop();
				 }
							 
			    init.SmallCitysOffView(gc);
			    init.BigCitysOffView(gc); 
				init.GeneratorsView(gc);
				init.SmallElectricPoleView(gc);
				init.BigElectricPoleView(gc);
				
				if(!init.getSmallElectricPoleList().isEmpty() && !init.getSmallCityList().isEmpty()) {
					init.initSmallCitysOnBySmallElectricPole();
					init.SmallCitysOnView(gc);
				}
				
				if(!init.getBigElectricPoleList().isEmpty() && !init.getSmallCityList().isEmpty()){
					init.initSmallCitysOnByBigElectricPole();
					init.SmallCitysOnView(gc);
				}	
				
				if(!init.getBigElectricPoleList().isEmpty() && !init.getBigCityList().isEmpty()){
					init.initBigCitysOnByBigElectricPole();
					init.BigCitysOnView(gc);
				}
					
				if(input.contains("RIGHT")){
					if(actualChoise == 1){
						if(service.getNumberofSmallPoles() > 0){
							init.initSmallElectricPole(0);
							service.setNumberofSmallPoles(service.getNumberofSmallPoles() - 1);
						}
					}
					else{
						if(service.getNumberofBigPoles() > 0){
							init.initBigElectricPole(0);
							service.setNumberofBigPoles(service.getNumberofBigPoles() - 1);
						}
					}
				}
				if(input.contains("DOWN")){
					if(actualChoise == 1){
						if(service.getNumberofSmallPoles() > 0){
							init.initSmallElectricPole(1);
							service.setNumberofSmallPoles(service.getNumberofSmallPoles() - 1);
						}
				}
					else{
						if(service.getNumberofBigPoles() > 0){
							init.initBigElectricPole(1);
							service.setNumberofBigPoles(service.getNumberofBigPoles() - 1);
						}
				}
				}
				
				if(actualChoise == 1){
					if(!init.getSmallElectricPoleList().isEmpty()){
						if(input.contains("LEFT")){
							if(service.getNumberofSmallPoles() > 0){
								init.initSmallElectricPole(2);
								service.setNumberofSmallPoles(service.getNumberofSmallPoles() - 1);
							}
						}
						
						if(input.contains("UP")){
							if(service.getNumberofSmallPoles() > 0){
								init.initSmallElectricPole(3);
								service.setNumberofSmallPoles(service.getNumberofSmallPoles() - 1);
							}
						}
					}
				}
				else{
					if(!init.getBigElectricPoleList().isEmpty()){
						if(input.contains("LEFT")){
							if(service.getNumberofBigPoles() > 0){
								init.initBigElectricPole(2);
								service.setNumberofBigPoles(service.getNumberofBigPoles() - 1);
							}
						}
						
						if(input.contains("UP")){
							if(service.getNumberofBigPoles() > 0){
								init.initBigElectricPole(3);
								service.setNumberofBigPoles(service.getNumberofBigPoles() - 1);
							}
						}
					}
				}
				
				if(service.getNumberofCitys() == service.getNumberofLightenedCitys()){
					if(service.getActualAmountofUsedEnergy() <= service.getActualAmountofEnergy()){
						String wp = ("SZÉP MUNKA!");
						
						gc.setFill(Color.YELLOW);
						gc.setStroke(Color.YELLOW);
						
						Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 24 );
				    	gc.setFont( theFont );
						
						gc.fillText(wp, 600, 20);
						gc.strokeText(wp, 600, 20);
					
						this.stop();
					}
						
				}
				
				if(!init.getSmallElectricPoleList().isEmpty() && !init.getBigCityList().isEmpty()) {
					init.initBigCitysOnBySmallElectricPole();
					init.BigCitysOnView(gc);
					
					if(init.initBigCitysOnBySmallElectricPole()){
						service.writeGameOver(gc);
						 this.stop();	
					}
						
				}
				
				if(service.getNumberofSmallPoles() <= 0  && service.getNumberofBigPoles() <= 0){
					service.writeGameOver(gc);
					 this.stop();
				}
				
				if(!init.getBigLightenedCitys().isEmpty()){
					cityLists.setBigLightenedCitys(init.getBigLightenedCitys());
				}
				if(!init.getSmallLightenedCitys().isEmpty()){
					cityLists.setSmallLightenedCitys(init.getSmallLightenedCitys());
				}
				
				if(!init.getSmallElectricPoleList().isEmpty()){
					poleLists.setSmallElectricPoleList(init.getSmallElectricPoleList());
				}
				
				if(!init.getBigElectricPoleList().isEmpty()){
					poleLists.setBigElectricPoleList(init.getBigElectricPoleList());
				}
			}	
        }.start(); 
         
    }
	
	/**
	 * A játék aktuális állapotát menti az adatbázisba.
	 */
	public void saveGameStatetoFile(){
				
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File fileforCitys = new File(classLoader.getResource("database/savefile.xml").getFile());
			File fileforPoles = new File(classLoader.getResource("database/savepoles.xml").getFile());
			
			JAXBContext context = JAXBContext.newInstance(CityLists.class);
			Marshaller m = context.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(cityLists, fileforCitys);
			
			context = JAXBContext.newInstance(PoleLists.class);
			m = context.createMarshaller();
			m.marshal(poleLists, fileforPoles);
			
		} catch (JAXBException e2) {
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Hiba");
	        alert.setHeaderText("Nem lehet menteni az adatokat!");

	        alert.showAndWait();
		}
	}
	
	/**
	 * A játék egy előző állapotát tölti vissza az adatbázisból.
	 */
	public void loadGameStatefromFile(){
		
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File fileforCitys = new File(classLoader.getResource("database/savefile.xml").getFile());
			File fileforPoles = new File(classLoader.getResource("database/savepoles.xml").getFile());
			
			JAXBContext context = JAXBContext.newInstance(CityLists.class);
			Unmarshaller um = context.createUnmarshaller();
			CityLists loaderLists = (CityLists) um.unmarshal(fileforCitys);
			
			cityLists.setBigCitys(loaderLists.getBigCitys());
			cityLists.setBigLightenedCitys(loaderLists.getBigLightenedCitys());
			cityLists.setSmallCitys(loaderLists.getSmallCitys());
			cityLists.setSmallLightenedCitys(loaderLists.getSmallLightenedCitys());
			
			cityLists.getBigCitys().forEach(a -> {
				a.setImageOff("big_city_off.png");
				a.setImageOn("big_city_on.png");
			});
			
			cityLists.getSmallCitys().forEach(a -> {
				a.setImageOff("small_city_off.png");
				a.setImageOn("small_city_on.png");
			});
			
			init.setBigCityList(cityLists.getBigCitys());
			init.setBigLightenedCitys(cityLists.getBigLightenedCitys());
			init.setSmallCityList(cityLists.getSmallCitys());
			init.setSmallLightenedCitys(cityLists.getSmallLightenedCitys());
			
			context = JAXBContext.newInstance(PoleLists.class);
			um = context.createUnmarshaller();
			PoleLists loadedLists = (PoleLists) um.unmarshal(fileforPoles);
			
			poleLists.setBigElectricPoleList(loadedLists.getBigElectricPoleList());
			poleLists.setSmallElectricPoleList(loadedLists.getSmallElectricPoleList());
			
			poleLists.getBigElectricPoleList().forEach(a -> a.setImage("big_electric_pole.png"));
			poleLists.getSmallElectricPoleList().forEach(a -> {
				a.setImage("small_electric _pole.png");
				a.setImageOverloaded("small_electric_pole_overloaded.png");
			});
			
			init.setBigElectricPoleList(poleLists.getBigElectricPoleList());
			init.setSmallElectricPoleList(poleLists.getSmallElectricPoleList());
			
			service.setNumberofPoles(poleLists.getSmallElectricPoleList().size(),
					poleLists.getBigElectricPoleList().size());

		} catch (JAXBException e) {
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Hiba");
	        alert.setHeaderText("Nem lehet betölteni az adatokat!");

	        alert.showAndWait();
		}
		
	}
	
}
