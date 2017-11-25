import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordSearchTests {

    @Test
    public void WordListReadInProperly(){
        WordSearcher wordSearcher = new WordSearcher("StarTrekWordSearch.txt");
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

    @Test
    public void FirstLineOfWordSearchReadInProperly(){
        WordSearcher wordSearcher = new WordSearcher("StarTrekWordSearch.txt");

        assertEquals("UMKHULKINVJOCWE", wordSearcher.getWordSearch()[0]);
    }

    @Test
    public void LastLineOfWordSearchReadInProperly(){
        WordSearcher wordSearcher = new WordSearcher("StarTrekWordSearch.txt");

        assertEquals("KYLBQQPMDFCKEAB", wordSearcher.getWordSearch()[14]);
    }

    @Test
    public void MiddleLineOfWordSearchReadInProperly(){
        WordSearcher wordSearcher = new WordSearcher("StarTrekWordSearch.txt");

        assertEquals("BLQSLNEEEVULFMZ", wordSearcher.getWordSearch()[6]);
    }

    @Test
    public void SearchAcrossTheXAxis(){
        WordSearcher wordSearcher = new WordSearcher("StarTrekWordSearch.txt");
        wordSearcher.searchHorizontal();
        assertEquals("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)", wordSearcher.getCoordinateList());
    }

    @Test
    public void SearchAcrossTheYAxis(){
        WordSearcher wordSearcher = new WordSearcher("StarTrekWordSearch.txt");
        wordSearcher.searchVertical();
        assertEquals("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)", wordSearcher.getCoordinateList());
    }
}
