
package Ahorcado;

import DataStructures.LSEC;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class WordFile {
    
    public static boolean verifyRealWord(String word) throws IOException {
        try (
            BufferedReader in = new BufferedReader(new FileReader("words_es.txt"));
            ){            
            String str;
            while ((str = in.readLine()) != null) {
                if ( str.equals(word))
                    return true;
            }
            in.close();
        } catch (IOException e) {
        }
        return false;
    }
    
    public static LSEC generateInitialWordsList(int number) throws IOException {
        try (
            BufferedReader in = new BufferedReader(new FileReader("playingWords_es.txt"));
            ){
            Random random = new Random();
            LSEC initialWordList = new LSEC();
            int wordCounter = 0;
            String str;
            while ((str = in.readLine()) != null && wordCounter <= number) {
                if ( random.nextBoolean() && random.nextBoolean() ){
                    initialWordList.append(str);
                    wordCounter++;
                }
            }
            in.close();
            return initialWordList;
        } catch (IOException e) {
            return null;
        }
    }
}
