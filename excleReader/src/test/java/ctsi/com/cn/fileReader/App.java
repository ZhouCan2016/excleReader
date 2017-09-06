package ctsi.com.cn.fileReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import ctsi.com.cn.excleReader.RowMapper;
import ctsi.com.cn.excleReader.UtilPoi;

public class App {
	private static int rowCount;

	public static void main(String[] args) throws Exception {
		System.out.println();
		long end, start = System.currentTimeMillis();
		Path file = Paths.get("/home/frank/下载/共享文件/6666666.xlsx");
		UtilPoi.read(file, new RowMapper() {
			@Override
			public void mapRows(int sheetIndex, int curRow, List<Object> rowlist) {
				 for (int i = 0; i < rowlist.size(); i++) {  
			            System.out.print("'" + rowlist.get(i)+ "',");  
			        }  
			        System.out.println();  
				rowCount++;
			}
		});
		end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) / 1000f + "s");
		System.out.println("sheet 大小：" + rowCount);
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println();
//		long end, start = System.currentTimeMillis();
//		// Path file = Paths.get("/home/skzrorg/tmp/2007.xlsx");
//		Path file = Paths.get("/home/frank/下载/共享文件/集团网运员工账号信息_20161205_liuxun.xlsx");
//		SheetDatasHandler handler = UtilPoi.read(file);
//		end = System.currentTimeMillis();
//		System.out.println("耗时：" + (end - start) / 1000f + "s");
//		List<List<Object>> sheet = handler.getSheetData(1);
//		System.out.println("sheet 大小：" + sheet.size());
//		System.out.println("sheet[1]" + sheet.get(1));
//		int i = new Random().nextInt(sheet.size());
//		System.out.println("sheet[" + i + "]" + sheet.get(i));
//		System.out.println("sheet[" + (sheet.size() - 1) + "]" + sheet.get(sheet.size() - 1));
//	}
}
