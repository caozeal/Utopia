package com.caozeal.match;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.apache.commons.io.IOUtils;

/**
 * <p>创建时间：2019/8/21 18:36
 * <p>PACKAGE_NAME
 *
 * @author caozhiyong
 * @version 1.0
 */
@Getter
public class WordsLoader {

    private List<String> words = new ArrayList<>();

    public static WordsLoader getInstance(){
        WordsLoader wordsLoader = new WordsLoader();
        wordsLoader.load();
        return wordsLoader;
    }

    private void load(){
        try(InputStream is = WordsLoader.class.getResourceAsStream("../../../UKACD.txt")) {
            words.addAll(IOUtils.readLines(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
