package test.util;

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;

/**
 * @author by Lixq
 * @Classname ExeclEncry
 * @Description TODO
 * @Date 2022/12/17 11:28
 */
public class ExeclEncry {
    public static void main(String[] args) {
        //加载测试文档
        Workbook wb = new Workbook();
        wb.loadFromFile("H:/test/022 辽宁振兴银行应用安全checklist - V2.1.xlsx");

        //使用密码加密工作簿
        wb.protect("123456");

        //保存文档
        wb.saveToFile("H:/test/ProtectWorkbook.xlsx", ExcelVersion.Version2016);
        wb.dispose();

        System.out.println("文件加密成功");
    }
}
