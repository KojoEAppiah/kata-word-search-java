import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WordSearchTests {

    @Test
    public void WordListReadInProperly(){
        WordSearcher wordSearcher = new WordSearcher("../../StarTrekWordSearch.txt");
        boolean allWordsFound = true;
        String[] targetWordList = {"BONES","KHAN","KIRK","SCOTTY","SPOCK","SULU","UHURA"};
        String[] wordList = wordSearcher.getWordList();
        for(int index = 0; index < 7; index++) {
            if(!wordList[index].equalsIgnoreCase(targetWordList[index])){
                allWordsFound = false;
            }
        }

        assertTrue(allWordsFound);
    }

}
