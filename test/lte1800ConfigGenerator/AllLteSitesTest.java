package lte1800ConfigGenerator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AllLteSitesTest {
	private AllLteSites allLteSites;

	@Before
	public void setUp() {
		allLteSites = new AllLteSites();
		allLteSites.inputReader.setRadioInput("C:\\CG input test\\Radio test.xlsx");
		allLteSites.inputReader.setTransmissionInput("C:\\CG input test\\Transmission test.xlsx");
		allLteSites.inputReader.setConfigInput("C:\\CG input test\\Config input test.xlsx");
		allLteSites.createListOfAllSites();
	}

	@Test
	public void testCreateListOfAllSites() {
		LteSite lteSite0 = allLteSites.listOfAllSites.get(0);
		LteSite lteSite1 = allLteSites.listOfAllSites.get(1);
		LteSite lteSite2 = allLteSites.listOfAllSites.get(2);
		LteSite lteSite3 = allLteSites.listOfAllSites.get(5);

		assertEquals(6, allLteSites.listOfAllSites.size());
		assertEquals(3, allLteSites.listOfAllSites.get(0).lteCells.size());
		assertEquals(24, allLteSites.listOfAllSites.get(0).lteCells.get("1").gsmNeighbours.size());
		assertEquals("BG0337_02/6",
				allLteSites.listOfAllSites.get(0).lteCells.get("1").gsmNeighbours.get("3371").cellName);
		assertEquals("738", allLteSites.listOfAllSites.get(0).lteCells.get("1").gsmNeighbours.get("3652").bcch);
		assertEquals("714", allLteSites.listOfAllSites.get(2).lteCells.get("3").gsmNeighbours.get("7222").bcch);
		assertEquals(3, allLteSites.listOfAllSites.get(5).lteCells.size());
		assertEquals("11", allLteSites.listOfAllSites.get(5).lteCells.get("11").cellInfo.get("localCellId"));
		assertEquals("198", allLteSites.listOfAllSites.get(5).lteCells.get("11").cellInfo.get("rootSeqIndex"));
		assertEquals(13, allLteSites.listOfAllSites.get(5).lteCells.get("11").gsmNeighbours.size());
		assertEquals("BG0253_01/8",
				allLteSites.listOfAllSites.get(5).lteCells.get("12").gsmNeighbours.get("2533").cellName);
		assertEquals("850", allLteSites.listOfAllSites.get(5).lteCells.get("13").gsmNeighbours.get("2532").bcch);
		
		assertEquals(33, lteSite0.uniqueGsmNeighbours.size());
		assertEquals(23, lteSite1.uniqueGsmNeighbours.size());
		assertEquals(30, lteSite2.uniqueGsmNeighbours.size());
		assertEquals(24, lteSite3.uniqueGsmNeighbours.size());
		
		assertEquals(23, lteSite0.lteCells.get("1").uniqueBcchOfNeighboursPerCell.size());
		assertEquals(13, lteSite1.lteCells.get("3").uniqueBcchOfNeighboursPerCell.size());
		assertEquals(16, lteSite2.lteCells.get("2").uniqueBcchOfNeighboursPerCell.size());
		assertEquals(15, lteSite3.lteCells.get("12").uniqueBcchOfNeighboursPerCell.size());
	}

}
