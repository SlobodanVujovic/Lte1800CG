package lte1800ConfigGenerator;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LteCell {
	Map<String, String> cellInfo;
	Map<String, GsmNeighbour> gsmNeighbours = new LinkedHashMap<>();
	Set<GsmNeighbour> uniqueGsmNeighboursPerCell = new LinkedHashSet<>();
	Set<String> uniqueBcchOfNeighboursPerCell = new LinkedHashSet<>();

	public void createInitialCellInfoMap() {
		cellInfo = new LinkedHashMap<>();
		cellInfo.put("lnCellId", "dummyData");
		cellInfo.put("localCellId", "dummyData");
		cellInfo.put("pci", "dummyData");
		cellInfo.put("tac", "dummyData");
		cellInfo.put("cellName", "dummyData");
		cellInfo.put("rootSeqIndex", "dummyData");
		cellInfo.put("maxPower", "dummyData");
		cellInfo.put("channelBw", "dummyData");
		cellInfo.put("dlEarfcn", "dummyData");
	}

	public void createUniqueGsmNeighboursPerCell() {
		for (Map.Entry<String, GsmNeighbour> neighbourEntry : gsmNeighbours.entrySet()) {
			GsmNeighbour tempGsmNeighbour = neighbourEntry.getValue();
			uniqueGsmNeighboursPerCell.add(tempGsmNeighbour);
		}
	}
	
	public void createUniqueBcchOfNeighboursPerCell() {
		for (Iterator<GsmNeighbour> iterator = uniqueGsmNeighboursPerCell.iterator(); iterator.hasNext();) {
			GsmNeighbour gsmNeighbour = iterator.next();
			uniqueBcchOfNeighboursPerCell.add(gsmNeighbour.bcch);
		}
	}

}
