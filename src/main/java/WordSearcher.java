import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordSearcher {

    private String[] wordList;
    private String[] wordSearch;
    private Map<String, ArrayList<Point>> wordCoordinates;

    public WordSearcher(String searchFile){
        try {
            FileReader fileReader = new FileReader(searchFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            this.wordList = bufferedReader.readLine().split(",");
            this.wordCoordinates = new HashMap<String, ArrayList<Point>>() {
            };

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
        return this.wordList;
    }

    public String[] getWordSearch() {
        return this.wordSearch;
    }

    public void searchHorizontal(){
        WordStub wordStub = new WordStub("");
        String currentRow = "";
        for(int row = 0; row < this.wordSearch.length; row++){
            currentRow = this.wordSearch[row];
            for(int x = 0; x < currentRow.length(); x++){
                wordStub.addLetter(this.wordSearch[row].charAt(x), new Point(x, row));
                if(wordStub.checkWordStubAgainstFullWordList(this.wordList)) {
                    this.wordCoordinates.put(wordStub.getWordStub(), wordStub.getLetterCoordinates());
                    wordStub.reset();
                }
                else if(!wordStub.checkWordStubAgainstPartialWordList(this.wordList))
                    wordStub.reset();
            }
        }
    }

    public String getCoordinateList(){
        String coordinateList = "";
        for(String word : this.wordCoordinates.keySet()){
            coordinateList += word + ": ";
            for(Point point : this.wordCoordinates.get(word)){
                coordinateList += "("+point.x+","+point.y+"),";
            }
            coordinateList = coordinateList.substring(0, coordinateList.length() - 1);
        }

        return coordinateList;
    }
}
