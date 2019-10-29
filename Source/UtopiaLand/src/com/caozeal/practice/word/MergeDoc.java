package com.caozeal.practice.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

import static com.caozeal.practice.word.MergeDocUtils.appendBody;

/**
 * <p>创建时间：2019/10/23 14:13
 * <p>com.caozeal.practice.word
 *
 * @author caozhiyong
 * @version 1.0
 */
public class MergeDoc {

    public static void main (String[] args) throws Exception {
        InputStream in1;
        OPCPackage src1Package;
        File f = new File("G:\\新建文件夹\\新建文件夹");
        File[] fs = f.listFiles();
        String[] paths = new String[fs.length];
        for (int i = 0; i < fs.length; i++) {
            paths[i] = fs[i].getAbsolutePath();
        }

        long start = System.currentTimeMillis();

        OutputStream dest = new FileOutputStream("dest.docx");
        in1 = new FileInputStream(paths[0]);
        src1Package = OPCPackage.open(in1);
        XWPFDocument src1Document = new XWPFDocument(src1Package);
        CTBody src1Body = src1Document.getDocument().getBody();
        for (int i = 1; i < paths.length; i++) {
            XWPFParagraph p = src1Document.createParagraph();
            //设置分页符
            p.setPageBreak(true);
            InputStream appendIs = new FileInputStream(paths[i]);
            OPCPackage opcPackage = OPCPackage.open(appendIs);
            XWPFDocument document = new XWPFDocument(opcPackage);
            CTBody appendBody = document.getDocument().getBody();
            appendBody(src1Body, appendBody);
        }
        src1Document.write(dest);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
