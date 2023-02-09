package test.util;

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author by Lixq
 * @Classname ExeclUtil
 * @Description TODO
 * @Date 2022/12/17 15:19
 */
public class ExeclUtil {

    public static void main(String[] args) throws Exception {
        String[] headers = new String[] {"序号","变更日期","客户姓名","身份证号码","变更类型","原卡","新卡","信息备注"};
        List<List<Object>> dataList = new ArrayList<>();
        File file = new File("H:/test/test.xlsx");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0 ; i < 3 ; i++) {
            List<Object> data = new ArrayList<>();
            data.add(i+1);
            data.add(sdf.format(new Date()));
            data.add("姓名"+i);
            data.add("身份证号码" + i);
            data.add("手机号"+i);
            data.add("原卡"+i);
            data.add("新卡"+i);
            if (i == 1) {
                data.add("");
            } else {
                data.add("备注"+i);
            }
            dataList.add(data);
        }
        export("用户数据", headers, dataList ,file);

        //加载测试文档
        Workbook wb = new Workbook();
        wb.loadFromFile("H:/test/test.xlsx");

        //使用密码加密工作簿
        wb.protect("123456");

        //保存文档
        wb.saveToFile("H:/test/test.xlsx", ExcelVersion.Version2016);
        wb.dispose();
        System.out.println("加密文件生成完成");

    }

    public static void export(String sheetName , String[] headers , List<List<Object>> dataList
            , File execlFile) throws Exception {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        createSheet(sheetName, headers, dataList, workbook);
        workbook.write(new FileOutputStream(execlFile));
        // 删除临时文件
//        workbook.dispose();
    }

    /**
     * description: 创建sheet表格
     * @param sheetName  表sheet 名字
     * @param headers  表头
     * @param dataList 表数据
     * @param wb
     * @return void
     * @version v1.0
     * @author w
     * @date 2020年3月30日 下午2:33:39
     */
    public static void createSheet(String sheetName , String[] headers , List<List<Object>> dataList , SXSSFWorkbook wb) {
        SXSSFSheet sheet = wb.createSheet(sheetName);
        // 设置表头和单元格格式
        CellStyle headStyle = setHeaderStyle(wb);
        CellStyle bodyStyle = setBodyStyle(wb);
        // 创建表头和单元格数据
        createHeader(headers, sheet, headStyle);
        createBody(dataList, sheet, bodyStyle);
    }

    /**
     * description: 设置表头样式
     * @param wb
     * @return
     * @return HSSFCellStyle
     * @version v1.0
     * @author w
     * @date 2020年3月30日 下午2:38:39
     */
    private static CellStyle setHeaderStyle(SXSSFWorkbook wb) {
        // 设置表格单元格格式
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.LEFT);

        // 设置字体格式
        Font font = wb.createFont();
        font.setFontName("微软雅黑");
        // 字体是否加粗
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    /**
     * description: 设置单元格内容样式
     * @param wb
     * @return HSSFCellStyle
     * @version v1.0
     * @author w
     * @date 2020年3月30日 下午2:42:39
     */
    private static CellStyle setBodyStyle(SXSSFWorkbook wb) {
        // 设置表格单元格格式
        CellStyle style = wb.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

        // 设置字体格式
        Font font = wb.createFont();
        font.setFontName("微软雅黑");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        return style;
    }

    /**
     * description: 创建表头
     * @param headers
     * @param sheet
     * @param headStyle
     * @return void
     * @version v1.0
     * @author w
     * @date 2020年3月30日 下午3:03
     */
    private static void createHeader(String[] headers, SXSSFSheet sheet, CellStyle headStyle) {
        SXSSFRow row = sheet.createRow(0);
        row.setHeightInPoints(16F);
        for (int i = 0; i < headers.length; i++) {
            // 创建单元格
            SXSSFCell cell = row.createCell(i);
            cell.setCellStyle(headStyle);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            sheet.trackAllColumnsForAutoSizing();
            sheet.autoSizeColumn(i);
        }
    }/**
     * description: 表格中填充数据
     * @param dataList
     * @param sheet
     * @param bodyStyle
     * @return void
     * @version v1.0
     * @author w
     * @date  2020年3月30日 下午3:13
     */
    private static void createBody(List<List<Object>> dataList, SXSSFSheet sheet, CellStyle bodyStyle) {
        for (int i = 0; i < dataList.size(); i++) {
            // 从第二行开始，第一行做表头
            SXSSFRow row = sheet.createRow(i+1);
            List<Object> rowList = dataList.get(i);
            for (int j = 0; j < rowList.size(); j++) {
                SXSSFCell cell = row.createCell(j);
                cell.setCellStyle(bodyStyle);
                XSSFRichTextString text = new XSSFRichTextString(rowList.get(j).toString());
                cell.setCellValue(text);
                sheet.trackAllColumnsForAutoSizing();
                sheet.autoSizeColumn(i);
            }
        }
    }

}
