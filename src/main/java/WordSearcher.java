import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordSearcher {

    private String[] wordList;
    private String[] wordSearch;

    public WordSearcher(String searchFile){

        try {
            FileReader fileReader = new FileReader(searchFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            this.wordList = bufferedReader.readLine().split(",");
            String firstRow = bufferedReader.readLine().replace(",","").replace("/r","").replace("\n","");
            this.wordSearch = new String[firstRow.length()];
            this.wordSearch[0] = firstRow;

            for(int row = 1; row < this.wordSearch.length; row++)
                this.wordSearch[row] = bufferedReader.readLine().replace(",","").replace("/r","").replace("\n","");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] getWordList() {
        return wordList;
    }

    public String[] getWordSearch() {
        return this.wordSearch;
    }
}
