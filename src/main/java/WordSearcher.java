import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordSearcher {

    String[] wordList;

    public WordSearcher(String searchFile){

        try {
            FileReader fileReader = new FileReader(searchFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            this.wordList = bufferedReader.readLine().split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] getWordList() {
        return wordList;
    }
}
