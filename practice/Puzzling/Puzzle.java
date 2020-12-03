import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class Puzzle {

    public static ArrayList<Integer> sumAndGreater(int[] array) {
        int sum = 0;
        ArrayList<Integer> newArr = new ArrayList<Integer>();

        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if (array[i] > 10) {
                newArr.add(array[i]);
            }
        } 
        System.out.println(sum);
        return newArr;
    }

    public static ArrayList<String> nameShuffle(String[] array) {
        ArrayList<String> newArr = new ArrayList<String>();
        List<String> list = Arrays.asList(array);
        Collections.shuffle(list);
        list.toArray(array); 
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (array[i].length() > 5) {
                newArr.add(array[i]);
            }
        }
        return newArr;
    }

    public static void alphabetShuffle(Character[] array) {

        ArrayList<Character> newArr = new ArrayList<Character>();

        List<Character> list = Arrays.asList(array);
        Collections.shuffle(list);
        list.toArray(array);

        
        System.out.println(array[array.length-1]);

        if (array[0] == 'a' || array[0] == 'e' || array[0] == 'i' || array[0] == 'o' || array[0] == 'u') {
            System.out.println(array[0] + ", is a vowel!");
        } else {
            System.out.println(array[0]);
        }
        // for (int i = 0; i < array.length; i++) {
        //     if (i == array.length-1) {
        //         System.out.println(array[i]);
        //     } else if ( i == 0 ) {
        //         if (array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u') {
        //             System.out.println(array[i] + ", is a vowel!");
        //         } 
        //     }
        // }
    }

    public static int[] randoNumba() {

        // Random r = new Random();

        // ArrayList<Integer> randArr1 = new ArrayList<Integer>();

        // for (int i = 0; i < 10; i++) {
        //     randArr1.add(r.nextInt(45)+55);
        // }

        // return randArr1;

        int min = 55;
        int max = 100;

        int[] randArr;
        randArr = new int[10];

        for (int i = 0; i < randArr.length; i++) {

            int randInt = (int)(Math.random() * (max-min + 1) + min);
            
            randArr[i] = randInt;
        }
        return randArr;
    }

    public static ArrayList<Integer> randoNumbaSort() {
        Random r = new Random();
        ArrayList<Integer> sortArr = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            sortArr.add(r.nextInt(45) + 55);
        }

        // List<Integer> list = Arrays.asList(sortArr);
        Collections.sort(sortArr);
        System.out.println(sortArr.get(0));
        System.out.println(sortArr.get(sortArr.size()-1));
        return sortArr;
    }

    public static String randString() {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder str = new StringBuilder();
        Random randStr = new Random();

        for (int i = 0; i < 5; i++) {
            int index = randStr.nextInt(alphabet.length());
            char randChar = alphabet.charAt(index);
            str.append(randChar);
        }

        String randoString = str.toString();
        return randoString;
    }

    public static String[] randomArray() {

        String[] yahoo = new String[10];
        for (int i = 0; i < 10; i++) {
            yahoo[i] = randString();
        }

        return yahoo;
        // String alphabet = "abcdefghijklmnopqrstuvwxyz";
        // StringBuilder str = new StringBuilder(5);
        // Random randStr = new Random();

        // Random r = new Random();
        // ArrayList<String> randStrings = new ArrayList<String>();

        // for (int i = 0; i < 10; i++) {

        //     for(int j = 0; j < 5; j++) {
        //         int index = randStr.nextInt(alphabet.length());
        //         char randChar = alphabet.charAt(index);
        //         str.append(randChar);
                
        //     } 

        //     String randoString = str.toString();
        //     randStrings.add(randoString);
        // }

        // System.out.println(randStrings);

    }

}



