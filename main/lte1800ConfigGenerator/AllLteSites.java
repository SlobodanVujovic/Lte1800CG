package lte1800ConfigGenerator;

import java.util.List;
import java.util.Map;
import java.util.LinkedList;

public class AllLteSites {
	List<LteSite> listOfAllSites = new LinkedList<>();
	InputReader inputReader = new InputReader();

	public void createListOfAllSites() {
		inputReader.readTransmissionFile(listOfAllSites);
		inputReader.readConfigFile(listOfAllSites);
		inputReader.readRadioFileForCellInfo(listOfAllSites);
		inputReader.readRadioFileForNeighbours(listOfAllSites);
		for (LteSite lteSite : listOfAllSites) {
			lteSite.createUniqueGsmNeighbours();
			for (Map.Entry<String, LteCell> cellEntry : lteSite.lteCells.entrySet()) {
				LteCell lteCell = cellEntry.getValue();
				lteCell.createUniqueGsmNeighboursPerCell();
				lteCell.createUniqueBcchOfNeighboursPerCell();
			}
		}
	}
}
