package com.caozeal.practice.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

import static com.caozeal.practice.word.MergeDocUtils.appendBody;

/**
 * <p>创建时间：2019/10/23 14:13
 * <p>com.caozeal.practice.word
 *
 * @author caozhiyong
 * @version 1.0
 */
public class MergeDocByFJ {

    public static void main (String[] args) throws Exception {
        File f = new File("G:\\新建文件夹\\新建文件夹");
        File[] fs = f.listFiles();
        String[] paths = new String[fs.length];
        for (int i = 0; i < fs.length; i++) {
            paths[i] = fs[i].getAbsolutePath();
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        long start = System.currentTimeMillis();
        OutputStream dest = new FileOutputStream("dest.docx");
        MergeTwoDoc mergeTwoDoc = new MergeTwoDoc(Arrays.asList(paths));
        XWPFDocument document = forkJoinPool.invoke(mergeTwoDoc);
        document.write(dest);
        dest.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void sss(CTBody src, String path) throws Exception {
        OPCPackage srcPackage = null;
        try(InputStream in = new FileInputStream(path)) {
            srcPackage = OPCPackage.open(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        XWPFDocument src2Document = new XWPFDocument(srcPackage);
        CTBody src2Body = src2Document.getDocument().getBody();
        appendBody(src, src2Body);
    }

    private static class MergeTwoDoc extends RecursiveTask<XWPFDocument>{

        final List<String> paths;

        public MergeTwoDoc(List<String> paths) {
            this.paths = paths;
        }

        @Override protected XWPFDocument compute() {
            if(paths.size() == 0){
                return null;
            }
            if(paths.size() == 1){
                try(InputStream in1 = new FileInputStream(paths.get(0))) {
                    OPCPackage src1Package = OPCPackage.open(in1);
                    return new XWPFDocument(src1Package);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            MergeTwoDoc mergeTwoDoc = new MergeTwoDoc(paths.subList(0, paths.size()/2));
            mergeTwoDoc.fork();
            MergeTwoDoc mergeTwoDoc1 = new MergeTwoDoc(paths.subList(paths.size()/2, paths.size()));
            XWPFDocument document = mergeTwoDoc1.compute();
            XWPFDocument preDoc = mergeTwoDoc.join();
            if(preDoc == null){
                return document;
            }
            if(document == null){
                return preDoc;
            }
            XWPFParagraph p = preDoc.createParagraph();
            //设置分页符
            p.setPageBreak(true);
            try {
                appendBody(preDoc.getDocument().getBody(), document.getDocument().getBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return preDoc;
        }
    }
}
