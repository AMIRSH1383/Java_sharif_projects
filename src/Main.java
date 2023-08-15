import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        var sortedWords = new Vector<Vector<String>>(0);
        var allWords = new Vector<String>(0);

        allWords = readInput();

        for (String allWord : allWords) {
            boolean hasFamilyBefore = false;
            String sortedWord = sortString(allWord);
            for (Vector<String> strings : sortedWords) {
                if (sortedWord.equals(sortString(strings.get(0))))
                {
                    if(!hasAlreadyHaveThisWord(strings , allWord))
                        strings.add(allWord);
                    hasFamilyBefore = true;
                }
            }
            if (!hasFamilyBefore) {
                Vector<String> words = new Vector<String>(0);
                words.add(allWord);
                sortedWords.add(words);
            }
        }
        for(Vector <String> oneFamilyWords : sortedWords)
        {
            for ( String Word : oneFamilyWords)
            {
                System.out.print("*" + Word +"* ");
            }
            System.out.print("\n");
        }

    }

    public static String sortString(String word)
    {
        char[] newWord = word.toCharArray();
        Arrays.sort(newWord);
        return Arrays.toString(newWord);
    }

    public static Vector<String> readInput()
    {
        Vector<String> separatedWords = new Vector<String>(0);
        Scanner input  = new Scanner(System.in);
        String line = input.nextLine();
        String[] words = line.split("-");
        separatedWords.addAll(Arrays.asList(words));
        return separatedWords;
    }

    public static boolean hasAlreadyHaveThisWord(Vector<String> List , String theWord)
    {
        for(String wordInList : List)
        {
            if(Objects.equals(wordInList, theWord))
                return true;
        }
        return false;
    }
}