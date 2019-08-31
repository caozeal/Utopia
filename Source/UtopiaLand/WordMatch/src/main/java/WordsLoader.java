import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * <p>创建时间：2019/8/21 18:36
 * <p>PACKAGE_NAME
 *
 * @author caozhiyong
 * @version 1.0
 */
public class WordsLoader {

    private List<String> words = new ArrayList<>();

    public static WordsLoader getInstance(){
        WordsLoader wordsLoader = new WordsLoader();
        wordsLoader.load();
        return wordsLoader;
    }

    private void load(){
//        File file = new File("classes/UKACD.txt");
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        try {
            words = FileUtils.readLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WordsLoader.getInstance();
    }
}
