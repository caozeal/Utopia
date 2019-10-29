package com.caozeal.practice.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import org.apache.commons.compress.utils.IOUtils;
import org.docx4j.Docx4J;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.WordprocessingML.AlternativeFormatInputPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.CTAltChunk;

/**
 * <p>创建时间：2019/10/23 17:46
 * <p>com.caozeal.practice.word
 *
 * @author caozhiyong
 * @version 1.0
 */
public class MergeDocByDocx4j {

    public static void main(String[] args) throws Docx4JException, IOException {
        String[] paths = {"F:\\github\\Utopia\\谈话通知书（存根）.docx", "F:\\github\\Utopia\\谈话通知书.docx", "F:\\github\\Utopia\\谈话通知书1.docx"};
        mergeDocx(Arrays.asList(paths));
    }

    public static InputStream mergeDocx(final List<String> paths) throws Docx4JException, IOException {

        WordprocessingMLPackage target = null;
        final File generated = File.createTempFile("generated", ".docx");

        int chunkId = 0;
        Iterator<String> it = paths.iterator();
        while (it.hasNext()) {
            String path = it.next();
            try(InputStream is = new FileInputStream(path)){
                if (target == null) {
                        // Copy first (master) document
                        OutputStream os = new FileOutputStream(generated);
                        os.write(IOUtils.toByteArray(is));
                        os.close();

                        target = WordprocessingMLPackage.load(generated);
                    } else {
                        // Attach the others (Alternative input parts)
                        insertDocx(target.getMainDocumentPart(), IOUtils.toByteArray(is), chunkId++);
                    }
            }
        }

        if (target != null) {
            target.save(generated);
            return new FileInputStream(generated);
        } else {
            return null;
        }
    }

    private static void insertDocx(MainDocumentPart main, byte[] bytes, int chunkId) {
        try {
            AlternativeFormatInputPart afiPart = new AlternativeFormatInputPart(
                new PartName("/part" + chunkId + ".docx"));
            // afiPart.setContentType(new ContentType(CONTENT_TYPE));
            afiPart.setBinaryData(bytes);
            Relationship altChunkRel = main.addTargetPart(afiPart);

            CTAltChunk chunk = Context.getWmlObjectFactory().createCTAltChunk();
            chunk.setId(altChunkRel.getId());

            main.addObject(chunk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
