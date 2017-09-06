package ctsi.com.cn.fileReader;

import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest  extends XxlsAbstract{

	@Override
	public void optRows(int sheetIndex, int curRow, List<String> rowlist) throws SQLException {
		// TODO Auto-generated method stub
		 for (int i = 0; i < rowlist.size(); i++) {  
	            System.out.print("'" + rowlist.get(i) + "',");  
	        }  
	        System.out.println();  
	}
	
	 public static void main(String[] args) throws Exception {  
		 AppTest app = new AppTest();  
//	      app.processOneSheet("/home/frank/下载/共享文件/集团网运员工账号信息_20161205_liuxun.xlsx",2);  
	      app.processAllSheets("/home/frank/下载/共享文件/物理设备信息.xlsx");  
	    }  

}
