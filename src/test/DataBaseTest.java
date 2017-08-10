package test;

import org.junit.Test;

import dataBase.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class DataBaseTest {

/*	@Test
	public void testSearchingSingleById() {
		Zmogus zmogus = new Zmogus(100, "Tom", "Daniel");
		ZmogusDao zmogusDao = new ZmogusDao();
		zmogusDao.addZmogus(zmogus);
		Zmogus zmogus2= zmogusDao.getZmogusById(100);
		assertZmogusEqual(zmogus, zmogus2);
		zmogusDao.deleteZmogus(100);
	} */
	
/*	@Test
	public void testSearchingSingleZmogusByName() {
		Zmogus zmogus = new Zmogus(100, "Tom", "Daniel");
		ZmogusDao zmogusDao = new ZmogusDao();
		zmogusDao.addZmogus(zmogus);
		List<Zmogus> zmogus2 = zmogusDao.getZmogusByVardas("Tom");
		assertZmogusEqual(zmogus, zmogus2.get(0));
		zmogusDao.deleteZmogus(100);
	} */
	
/*	@Test
	public void testSearchingSingleZmogusByName() {
		Zmogus zmogus = new Zmogus(100, "Tom", "Daniel");
		ZmogusDao zmogusDao = new ZmogusDao();
		zmogusDao.addZmogus(zmogus);
		List<Zmogus> zmogus2 = zmogusDao.getZmogusByVardas("Tom");
		assertEquals(1, zmogus2.size());    // patikrina tik objekto dydi
		zmogusDao.deleteZmogus(100);
	} */
	
	private void assertZmogusEqual(Zmogus zmogus1, Zmogus zmogus2){
		assertEquals(zmogus1.getId(), zmogus2.getId());
		assertEquals(zmogus1.getVardas(), zmogus2.getVardas());
		assertEquals(zmogus1.getPavarde(), zmogus2.getPavarde());
	}

}
