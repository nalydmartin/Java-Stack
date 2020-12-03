import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleTest {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();


        int[] array = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        newArr = Puzzle.sumAndGreater(array);
        System.out.println(newArr);

        
        String[] array2 = {"Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"};
        ArrayList<String> newArr2 = new ArrayList<String>();
        newArr2 = Puzzle.nameShuffle(array2);
        System.out.println(newArr2);


        Character[] array3 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Puzzle.alphabetShuffle(array3);


        int[] meow = Puzzle.randoNumba();
        System.out.println(Arrays.toString(meow));


        ArrayList<Integer> sortArr = new ArrayList<Integer>();
        sortArr = Puzzle.randoNumbaSort();
        System.out.println(sortArr);


        String dog = Puzzle.randString();
        System.out.println(dog);

        String[] cat = Puzzle.randomArray();
        System.out.println(Arrays.toString(cat));
    }
}