import java.awt.*;
import java.util.ArrayList;

public class WordStub {

    private String wordStub;
    private ArrayList<Point> letterCoordinates;

    public WordStub(String wordStub){
        this.wordStub = wordStub;
        this.letterCoordinates = new ArrayList<Point>();
    }

    public void addLetter(char letter, Point coordinates){
        this.wordStub += letter;
        this.letterCoordinates.add(coordinates);
    }

    public ArrayList<Point> getLetterCoordinates(){
        return this.letterCoordinates;
    }

    public String getWordStub(){
        return this.wordStub;
    }

    public void reset(){
        this.wordStub = "";
        this.letterCoordinates = new ArrayList<Point>();
    }

    public boolean checkWordStubAgainstFullWordList(String[] wordList) {
        for(String word : wordList)
            if(word.equalsIgnoreCase(this.wordStub))
                return true;
        return false;
    }

    public boolean checkWordStubAgainstPartialWordList(String[] wordList){
        for(String word : wordList)
            if(word.startsWith(this.wordStub))
                return true;
        return false;
    }

}
