package unideb.homework.Electricity;

import homework.BigCity;
import homework.CityLists;
import homework.InitGenerator;
import homework.InitPowerGenerator;
import homework.SmallCity;
import junit.framework.TestCase;

public class TestCitysandGenerators extends TestCase {

	int r = (int) (1 + Math.random() * 10);
	
	SmallCity smallCity = new SmallCity(1024,768,128,r);
	BigCity bigCity = new BigCity(1024,768,128,r);
	
	InitPowerGenerator pg = new InitPowerGenerator(1024);
	InitGenerator gen = new InitGenerator(1024,pg.getPowerGenerator(),2);
	
	CityLists cityLists = new CityLists();
	
	public void testBigCitys(){
		
		assertTrue(bigCity.getBigCityList().size() <= r);
		assertEquals(200.0, bigCity.getBigCityList().get(0).getNecessaryEnergy());
		
	}
	
	public void testSmallCitys(){
		
		assertTrue(smallCity.getSmallCityList().size() <= r);
		assertEquals(100.0,smallCity.getSmallCityList().get(0).getNecessaryEnergy());
	}
	
	
	public void testGenerators(){
		
		assertEquals(2,gen.getGenerator().getGeneratorID());
		assertEquals(350.0, gen.getGenerator().getPlusEnergy());
		assertEquals(-64.0,gen.getGenerator().getPositionY());
		assertEquals(384.0, gen.getGenerator().getPositionX());
	}
	
	public void testPowerGenerator(){
		assertEquals(0.0,pg.getPowerGenerator().getPositionY());
		assertEquals(700.0,pg.getPowerGenerator().getMaxEnegryGenerate());
		assertEquals(448.0, pg.getPowerGenerator().getPositionX());
		
	}
	
	public void testCityLists(){
		cityLists.setBigCitys(bigCity.getBigCityList());
		cityLists.setSmallCitys(smallCity.getSmallCityList());
		
		assertEquals(cityLists.getBigCitys(),bigCity.getBigCityList());
		assertEquals(cityLists.getSmallCitys(),smallCity.getSmallCityList());
		
	}
	
	
	
}
