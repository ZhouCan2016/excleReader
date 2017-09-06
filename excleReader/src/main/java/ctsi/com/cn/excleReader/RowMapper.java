package ctsi.com.cn.excleReader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public abstract class RowMapper extends DefaultHandler {
	
	enum xssfDataType {  
        BOOL, ERROR, FORMULA, INLINESTR, SSTINDEX, NUMBER,  
    }  
	
	private SharedStringsTable sharedStringsTable;  
	private xssfDataType nextDataType = xssfDataType.NUMBER;    
//    private Map<Integer, String> strMap;
    private boolean valueFlag;
	private StringBuilder value;
	 private StylesTable stylesTable;  
	
	 private short formatIndex;  
     private String formatString;  
     private DataFormatter formatter =  new DataFormatter();  ;  
     
    private int sheetIndex = -1;  
    private List<Object> rowlist = new ArrayList<Object>();  
    private int curRow = 0;     //当前行  
    private int curCol = 0;     //当前列索引  
    private int preCol = 0;     //上一列列索引  
    private int titleRow = 0;   //标题行，一般情况下为0  
    private int rowsize = 0;    //列数  

    public void setSharedStringsTable(SharedStringsTable sharedStringsTable) {
		this.sharedStringsTable = sharedStringsTable;
//		strMap = new HashMap<Integer, String>(sharedStringsTable.getCount());
	}
    
	public void setStylesTable(StylesTable stylesTable) {
		this.stylesTable = stylesTable;
	}

	public int getSheetIndex() {
		return sheetIndex;
	}

	public void setSheetIndex(int sheetIndex) {
		this.sheetIndex = sheetIndex;
	}

	public void setCurRow(int curRow) {
		this.curRow = curRow;
	}

	private Object convertCellValue() {
		String tmp = value.toString();
		Object result = tmp;
		switch (nextDataType) {
		case BOOL:
			char first = value.charAt(0);
			result = first == '0' ? "FALSE" : "TRUE";
			break;
		case ERROR:
			result = "ERROR:" + value.toString();
			break;
		case FORMULA:
			// A formula could result in a string value,
			// so always add double-quote characters.
			result =  value.toString();
			break;
		case INLINESTR:
			// TODO: have seen an example of this, so it's untested.
			XSSFRichTextString rtsi = new XSSFRichTextString(value.toString());
			result = rtsi.toString();
			break;
		case SSTINDEX:
			String sstIndex = value.toString();
			try {
				int idx = Integer.parseInt(sstIndex);
				XSSFRichTextString rtss = new XSSFRichTextString(sharedStringsTable.getEntryAt(idx));
				result = rtss.toString();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
			break;
		case NUMBER:
			String n = value.toString();
			// 判断是否是日期格式
			if (HSSFDateUtil.isADateFormat(this.formatIndex, n)) {
				Double d = Double.parseDouble(n);
				Date date = HSSFDateUtil.getJavaDate(d);
				result = formateDateToString(date);
			} else if (this.formatString != null)
				result = formatter.formatRawCellContents(Double.parseDouble(n), this.formatIndex, this.formatString);
			else
				result = n;
			break;
		default:
			result = "(TODO: Unexpected type: " + nextDataType + ")";
			break;
		}
		return result;
	}
    public void startElement(String uri, String localName, String name,  Attributes attributes) throws SAXException {
    	if ("inlineStr".equals(name) || "v".equals(name)) {  
    		valueFlag = true;  
            // Clear contents cache  
            value.setLength(0);  
        } 
        // c => 单元格  
        if (name.equals("c")) {  
            // 如果下一个元素是 SST 的索引，则将nextIsString标记为true  
        	String rowStr = attributes.getValue("r");  
            int firstDigit = -1;  
            for (int c = 0; c < rowStr.length(); ++c) {  
                if (Character.isDigit(rowStr.charAt(c))) {  
                    firstDigit = c;  
                    break;  
                }  
            }
            curCol = this.getRowIndex(rowStr.substring(0, firstDigit));  
            // Set up defaults.  
            this.nextDataType = xssfDataType.NUMBER;  
            this.formatIndex = -1;  
            this.formatString = null;  
            String cellType = attributes.getValue("t");  
            String cellStyleStr = attributes.getValue("s");  
            if ("b".equals(cellType))  
                nextDataType = xssfDataType.BOOL;  
            else if ("e".equals(cellType))  
                nextDataType = xssfDataType.ERROR;  
            else if ("inlineStr".equals(cellType))  
                nextDataType = xssfDataType.INLINESTR;  
            else if ("s".equals(cellType))  
                nextDataType = xssfDataType.SSTINDEX;  
            else if ("str".equals(cellType))  
                nextDataType = xssfDataType.FORMULA; 
            else if (cellStyleStr != null) {  
                // It's a number, but almost certainly one  
                // with a special style or format  
                int styleIndex = Integer.parseInt(cellStyleStr);  
                XSSFCellStyle style = stylesTable.getStyleAt(styleIndex);  
                this.formatIndex = style.getDataFormat();  
                this.formatString = style.getDataFormatString();  
                if (this.formatString == null)  
                    this.formatString = BuiltinFormats.getBuiltinFormat(this.formatIndex);  
            }  
            if (cellType != null ) {  
            	valueFlag = true;  
            } else {  
            	valueFlag = false;  
            }  
        }  
        // 置空  
        value = new StringBuilder();
    }  
  
    public void endElement(String uri, String localName, String name)throws SAXException {  
        // 根据SST的索引值的到单元格的真正要存储的字符串  
        // 这时convertCellValue(),characters()方法可能会被调用多次  
        // v => 单元格的值，如果单元格是字符串则v标签的值为该字符串在SST中的索引  
        // 将单元格内容加入rowlist中，在这之前先去掉字符串前后的空白符  
        if (name.equals("v")) {  
            String value = convertCellValue().toString().trim(); 
            value = value.equals("")?" ":value;  
            int cols = curCol-preCol;  
            if (cols>1){  
                for (int i = 0;i < cols-1;i++){  
                    rowlist.add(preCol,"");  
                }  
            }  
            preCol = curCol;  
            rowlist.add(curCol-1, value);  
        }else {  
            //如果标签名称为 row ，这说明已到行尾，调用 mapRows() 方法  
            if (name.equals("row")) {  
                int tmpCols = rowlist.size();  
                if(curRow>this.titleRow && tmpCols<this.rowsize){  
                    for (int i = 0;i < this.rowsize-tmpCols;i++){  
                        rowlist.add(rowlist.size(), "");  
                    }  
                }  
                mapRows(sheetIndex,curRow,rowlist);  
                if(curRow==this.titleRow){  
                    this.rowsize = rowlist.size();  
                }  
                rowlist.clear();  
                curRow++;  
                curCol = 0;  
                preCol = 0;  
            }  
        }  
    }  
  
    @Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (valueFlag)
			value.append(ch, start, length);
	}  
      
    //得到列索引，每一列c元素的r属性构成为字母加数字的形式，字母组合为列索引，数字组合为行索引，  
    //如AB45,表示为第（A-A+1）*26+（B-A+1）*26列，45行  
    public int getRowIndex(String rowStr){  
        rowStr = rowStr.replaceAll("[^A-Z]", "");  
        byte[] rowAbc = rowStr.getBytes();  
        int len = rowAbc.length;  
        float num = 0;  
        for (int i=0;i<len;i++){  
            num += (rowAbc[i]-'A'+1)*Math.pow(26,len-i-1 );  
        }  
        return (int) num;  
    }  
  
    private String formateDateToString(Date date) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化日期  
        return sdf.format(date);  

    }  
    public int getTitleRow() {  
        return titleRow;  
    }  
  
    public void setTitleRow(int titleRow) {  
        this.titleRow = titleRow;  
    }  

	public abstract void mapRows(int sheetIndex, int rowIndex, List<Object> row);
}
