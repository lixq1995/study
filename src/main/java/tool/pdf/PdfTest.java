package tool.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PdfTest {

    public static void main(String[] args) throws Exception {
        // 文件拆分
        PdfReader reader = new PdfReader("D:\\tmp\\电子签章功能-振兴银行开放平台技术对接接口文档V1.0.0.pdf");
        int totalPage = reader.getNumberOfPages();
        int pageSize = 10;
        int totalFile = (int)Math.ceil((double) totalPage / pageSize);
        for (int i = 1; i <= totalFile; i++) {
            int start = (i-1) * pageSize +1;
            int end = Math.min(i * pageSize ,totalPage);
            pdfToSub("D:\\tmp\\电子签章功能-振兴银行开放平台技术对接接口文档V1.0.0.pdf","D:\\tmp\\afterChange" + i + ".pdf",start,end);
        }

        List<File> fileList = new ArrayList<>();
        // 文件签章
        for (int i = 1; i <= totalFile; i++) {
            File file = new File("D:\\tmp\\afterChange" + i + ".pdf");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            fileInputStream.close();
            String pdfStr = Base64.getEncoder().encodeToString(bytes);
            file.delete();
            Path write = Files.write(Paths.get("D:\\tmp\\signAfter" + i + ".pdf"), Base64.getMimeDecoder().decode(pdfStr), StandardOpenOption.CREATE);
            fileList.add(new File(write.toString()));

        }
        // 合并
        mergePdf(fileList);
    }

    /**
     * 拆分pdf
     * @param filePath
     * @param newFile
     * @param from
     * @param end
     */
    public static void pdfToSub(String filePath,String newFile, int from, int end) {
        Document document = null;
        PdfCopy copy = null;
        try {
            PdfReader reader = new PdfReader(filePath);
            //总页数
            int n = reader.getNumberOfPages();
            if (end == 0) {
                end = n;
            }
            document = new Document(reader.getPageSize(1));
            copy = new PdfCopy(document, new FileOutputStream(newFile));
            document.open();
            for (int j = from; j <= end; j++) {
                document.newPage();
                PdfImportedPage page = copy.getImportedPage(reader, j);
                copy.addPage(page);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 合并pdf
     * @param pdfFiles
     * @throws Exception
     */
    public static void mergePdf(List<File> pdfFiles) throws Exception {
        Document document = new Document();
        document.setMargins(0, 0, 0, 0);
        OutputStream bos = new FileOutputStream("D:\\tmp\\signAfter.pdf");
        PdfCopy copy = new PdfCopy(document, bos);
        document.open();
        for (File file : pdfFiles) {
            PdfReader reader = new PdfReader(file.getAbsolutePath());
            copy.addDocument(reader);
            copy.freeReader(reader);
            reader.close();
            file.delete();
        }
        document.close();
    }
}
