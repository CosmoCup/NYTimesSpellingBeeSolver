import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFinder {

    String[] ALL_WORDS = new String[466550];
    ArrayList<String> words = new ArrayList<String>();
    char[] letters = new char[7];

    public WordFinder(char[] letters) {
        this.letters = letters;

        int count = 0;
        try {
            File file = new File("lexicon.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                ALL_WORDS[count] = scanner.nextLine().toLowerCase();
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("!! Could not find file !!");
            new ErrorWindow("Could not find words file");
        }

        FindPassingWords();

    }

    void FindPassingWords() {

        for (String word : ALL_WORDS) {
            if (word == null) continue;
            if (word.length() <= 3) continue;  

            boolean hasReqLetter = false;
            boolean isValid = true;
            for (char wordChar : word.toCharArray()) {

                boolean isValidLetter = false;
                for (char letter : letters ) {
                    if (letter == wordChar) isValidLetter = true;
                }
                if (!isValidLetter) {
                    isValid = false;
                    break;
                }
                if (wordChar == letters[0]) hasReqLetter = true;
            }

            if (hasReqLetter && isValid) {
                words.add(word);
            }

        }

        new WordsGUI(words);

    }



}
