package lte1800ConfigGenerator;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LteSiteTest {
	private AllLteSites allLteSites;
	private List<LteSite> listOfAllSites;

	@Before
	public void setUp() {
		allLteSites = new AllLteSites();
		allLteSites.inputReader.setRadioInput("C:\\CG input test\\Radio test.xlsx");
		allLteSites.inputReader.setTransmissionInput("C:\\CG input test\\Transmission test.xlsx");
		allLteSites.inputReader.setConfigInput("C:\\CG input test\\Config input test.xlsx");
		listOfAllSites = allLteSites.listOfAllSites;

		allLteSites.createListOfAllSites();
	}

	@Test
	public void testCreateUniqueGsmNeighbours() {
		LteSite lteSite0 = listOfAllSites.get(0);
		LteSite lteSite1 = listOfAllSites.get(1);
		LteSite lteSite2 = listOfAllSites.get(2);

		assertEquals(33, lteSite0.uniqueGsmNeighbours.size());
		assertEquals(23, lteSite1.uniqueGsmNeighbours.size());
		assertEquals(30, lteSite2.uniqueGsmNeighbours.size());
	}

	@Test
	public void testCreateUniqueBcchOfNeighbours() {
		LteSite lteSite0 = listOfAllSites.get(0);
		LteSite lteSite1 = listOfAllSites.get(1);
		LteSite lteSite2 = listOfAllSites.get(2);
		LteSite lteSite3 = listOfAllSites.get(5);
		
		assertEquals(15, lteSite0.lteCells.get("2").uniqueBcchOfNeighboursPerCell.size());
		assertEquals(19, lteSite1.lteCells.get("1").uniqueBcchOfNeighboursPerCell.size());
		assertEquals(17, lteSite2.lteCells.get("3").uniqueBcchOfNeighboursPerCell.size());
		assertEquals(17, lteSite3.lteCells.get("13").uniqueBcchOfNeighboursPerCell.size());
	}
}
