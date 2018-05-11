package unideb.homework.Electricity;

import homework.BigCity;
import homework.InitGenerator;
import homework.InitPowerGenerator;
import homework.Initialization;
import homework.Service;
import homework.SmallCity;
import junit.framework.TestCase;

public class TestInit extends TestCase {
	
	Initialization init = new Initialization();
	Service serv = new Service();
	SmallCity smallCity = new SmallCity(1024,768,128,5);
	BigCity bigCity = new BigCity(1024,768,128,2);
	InitPowerGenerator pg = new InitPowerGenerator(1024);
	InitGenerator gen = new InitGenerator(1024,pg.getPowerGenerator(),2);
	int tmp;
	
	public void testService(){
		serv.setInit(init);
		
		init.setSmallCityList(smallCity.getSmallCityList());
		assertTrue(init.getSmallCityList().size() <= 5);
		
		init.setBigCityList(bigCity.getBigCityList());
		assertTrue(init.getBigCityList().size() <= 2);
		
		init.getGeneratorList().add(gen.getGenerator());
		init.getGeneratorList().add(gen.getGenerator());
		init.setInitPG(pg);
		
		serv.CalcNumberofCitys();
		serv.setNecessaryAmountofEnergy();
		serv.setActualAmountOfEnergy();
		serv.setActualAmountOfUsedEnergy();
		serv.CalculateNumberofLightenedCitys();
		
		tmp = (int) (init.getPowerGenerator().getMaxEnegryGenerate() + 2*gen.getGenerator().getPlusEnergy());
		assertEquals(tmp, (int)serv.getActualAmountofEnergy());
		
		tmp = (int) (init.getSmallCityList().size()*smallCity.getSmallCityList().get(0).getNecessaryEnergy() + init.getBigCityList().size() * init.getBigCityList().get(0).getNecessaryEnergy());
		assertEquals(tmp, (int)serv.getNecessaryAmountofEnergy());
		
		assertTrue(serv.getNumberofCitys() <= 7);	
	}

}
