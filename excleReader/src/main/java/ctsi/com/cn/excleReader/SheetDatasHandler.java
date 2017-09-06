package ctsi.com.cn.excleReader;

import java.util.ArrayList;
import java.util.List;

public class SheetDatasHandler extends RowMapper {
	private int bufRowSize, curSheetIndex = -1;
	private List<List<List<Object>>> sheetDatas = new ArrayList<List<List<Object>>>();
	private List<List<Object>> sheetData;

	public List<List<List<Object>>> getSheetDatas() {
		return sheetDatas;
	}

	public List<List<Object>> getSheetData(int sheetIndex) {
		return sheetDatas.get(sheetIndex);
	}

	SheetDatasHandler(int bufRowSize) {
		this.bufRowSize = bufRowSize;
	}

	@Override
	public void mapRows(int sheetIndex, int rowIndex, List<Object> row) {
		if (curSheetIndex != sheetIndex) {
			sheetData = new ArrayList<List<Object>>(sheetIndex == 0 ? bufRowSize : sheetData.size() / 2);
			sheetDatas.add(sheetData);
			curSheetIndex = sheetIndex;
		}

		sheetData.add(row);
	}
}
