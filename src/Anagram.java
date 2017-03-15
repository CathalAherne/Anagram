import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Cathal on 23/02/2017.
 */
public class Anagram {
    private File file;
    private FileReader fr;
    private BufferedReader brForOriginWords;
    private BufferedReader brForComparisonWords;
    private HashMap<Integer,Integer> anagramsFoundPositions= new HashMap();

    public Anagram() throws IOException {
        file = new File("wordlist.txt");
        fr = new FileReader(file);
        brForOriginWords = new BufferedReader(fr);
        String originWord = brForOriginWords.readLine();
        while (originWord != null) {
            brForComparisonWords = new BufferedReader(fr);
            HashMap<Character,Integer> volumeOfEachLetter= new HashMap();
            for(int i = 0;i <= originWord.length();i++){
                if(volumeOfEachLetter.containsKey(originWord.charAt(i))){
                    int newValue = volumeOfEachLetter.get(originWord.charAt(i)) + 1;
                    volumeOfEachLetter.put(originWord.charAt(i), newValue);
                }else{
                    volumeOfEachLetter.put(originWord.charAt(i), 1);
                }
            }
            String comparisonWord = brForComparisonWords.readLine();
            while (comparisonWord != null) {
                if(originWord.length() == comparisonWord.length()){
                    boolean allMatchedSoFar = true;
                    int position = 0;
                    while(allMatchedSoFar && position != (originWord.length() - 1)){
                        //for(int i = 0;i <= originWord.length();i++){
                        HashMap<Character,Integer> volumeOfEachLetter2= new HashMap();
                        if(volumeOfEachLetter2.containsKey(comparisonWord.charAt(position))){
                            int newValue = volumeOfEachLetter2.get(comparisonWord.charAt(position)) + 1;
                            volumeOfEachLetter2.put(comparisonWord.charAt(position), newValue);
                        }else{
                            volumeOfEachLetter2.put(comparisonWord.charAt(position), 1);
                        }
                        if(volumeOfEachLetter.containsKey(comparisonWord.charAt(position))) {
                            if (volumeOfEachLetter.get(comparisonWord.charAt(position)) ==
                                    volumeOfEachLetter2.get(comparisonWord.charAt(position))) {
                                position += 1;
                            }
                            else{
                                allMatchedSoFar = false;
                            }
                        }
                        else{
                            allMatchedSoFar = false;
                        }

                    }
                    if(allMatchedSoFar){
                        //ADD COMPARISON WORD TO LIST HERE
                        //NEED TO DYNAMICALLY CREATE LISTS TOO... LIST OF LISTS
                    }
                }
                comparisonWord = brForComparisonWords.readLine();
            }

        }

    }

    public static void main(String[] args) throws IOException {
        Anagram instance = new Anagram();
    }
}
