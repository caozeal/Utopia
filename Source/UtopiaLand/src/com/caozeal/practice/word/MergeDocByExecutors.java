package com.caozeal.practice.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

import static com.caozeal.practice.word.MergeDocUtils.appendBody;

/**
 * <p>创建时间：2019/10/24 15:39
 * <p>com.caozeal.practice.word
 *
 * @author caozhiyong
 * @version 1.0
 */
public class MergeDocByExecutors {

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main (String[] args) throws Exception {
        File f = new File("G:\\新建文件夹\\新建文件夹");
        File[] fs = f.listFiles();
        String[] paths = new String[fs.length];
        for (int i = 0; i < fs.length; i++) {
            paths[i] = fs[i].getAbsolutePath();
        }

        long start = System.currentTimeMillis();

        OutputStream dest = new FileOutputStream("dest.docx");

        List<XWPFDocument> newCtBodies = new ArrayList<>();
        List<Future<XWPFDocument>> futures = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            InputStream in1;
            OPCPackage src1Package;
            in1 = new FileInputStream(paths[i]);
            src1Package = OPCPackage.open(in1);
            XWPFDocument src1Document = new XWPFDocument(src1Package);
            CTBody body = src1Document.getDocument().getBody();
            InputStream appendIs = new FileInputStream(paths[++i]);
            OPCPackage opcPackage = OPCPackage.open(appendIs);
            XWPFDocument document = new XWPFDocument(opcPackage);
            CTBody appendBody = document.getDocument().getBody();
            Future<XWPFDocument> future = executorService.submit(() -> {
                XWPFParagraph p = document.createParagraph();
                //设置分页符
                p.setPageBreak(true);
                appendBody(body, appendBody);
                return src1Document;
            });
            futures.add(future);
        }
        futures.forEach(future -> {
            try {
                newCtBodies.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        XWPFDocument document = mergeDocs(newCtBodies);
        document.write(dest);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        executorService.shutdown();
    }

    private static XWPFDocument mergeDocs(List<XWPFDocument> ctBodies) throws Exception {
        List<XWPFDocument> newCtBodies = new ArrayList<>();
        List<Future<XWPFDocument>> futures = new ArrayList<>();
        boolean oddNumber = false;
        for (int i = 0; i < ctBodies.size(); i++) {
            XWPFDocument document =  ctBodies.get(i);
            CTBody body = document.getDocument().getBody();
            if(++i >= ctBodies.size()){
                oddNumber = true;
                break;
            }
            CTBody appendBody = ctBodies.get(i).getDocument().getBody();
            Future<XWPFDocument> future = executorService.submit(() -> {
                XWPFParagraph p = document.createParagraph();
                //设置分页符
                p.setPageBreak(true);
                appendBody(body, appendBody);
                return document;
            });
            futures.add(future);
        }
        futures.forEach(future -> {
            try {
                newCtBodies.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        if(oddNumber){
            newCtBodies.add(ctBodies.get(ctBodies.size() - 1));
        }
        if(newCtBodies.size() == 1){
            return newCtBodies.get(0);
        }
        return mergeDocs(newCtBodies);
    }


}
