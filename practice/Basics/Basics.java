
import java.util.ArrayList;

public class Basics {

    public void oneToTwoFiftyFive() {
        for (int i=1; i <= 255; i++) {
            System.out.println(i);
        }
    }
    
    public void oddOneToTwoFiftyFive() {
        for (int i=1; i <= 255; i+=2) {
            System.out.println(i);
        }
    }

    public void sum() {
        int sum = 0;
        for (int i = 0; i <= 255; i++) {
            System.out.println(i);
            System.out.println(sum += i);
        }
    }

    public void iterateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void findMax(int[] array) {
        int num = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[num] < array[i]) {
                num = i;
            } else {
                continue;
            }
        }
        max = array[num];
        System.out.println(max);
    }

    public void findAvg(int[] array) {
        double avg = 0;

        for(int i = 0; i < array.length; i++) {
            avg += array[i];
        }
        avg /= array.length;
        System.out.println(avg);
    }

    public void oddArray() {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++) {
            if(i % 2 == 0) {
                continue;
            } else {
                newArr.add(i);
            }
        }
        System.out.println(newArr);
    }

    public void biggerThanY(int[] array, int y) {
        int greater = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > y) {
                greater += 1;
            } else {
                continue;
            }
        }
        System.out.println(greater);
    }

    public void sqrValue(int[] array) {
        ArrayList<Integer> arrX = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            arrX.add(array[i] *= array[i]);
        }
        System.out.println(arrX);
    }

    public void elimNegNum(int[] array) {
        ArrayList<Integer> arrX = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                arrX.add(array[i] = 0);
            } else {
                arrX.add(array[i]);
            }
        }
        System.out.println(arrX);
    }

    public void minMaxAvg(int[] array) {
        ArrayList<Integer> arrX = new ArrayList<Integer>();

        //Find maximum value
        int num = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[num] < array[i]) {
                num = i;
            } else {
                continue;
            }
        }
        max = array[num];
        arrX.add(max);

        //Find minimum value
        int minNum = 0;
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[minNum] > array[i]) {
                minNum = i;
            } 
        }
        min = array[minNum];
        arrX.add(min);

        //Find average value
        int avg = 0;

        for(int i = 0; i < array.length; i++) {
            avg += array[i];
        }
        avg /= array.length;
        arrX.add(avg);

        System.out.println(arrX);
    }

    public void shift(int[] array) {
        ArrayList<Integer> arrX = new ArrayList<Integer>();

        int temp = array[0];

        for(int i = 0; i < array.length-1; i++) {
            array[i] = array[i + 1];
            arrX.add(array[i]);
            
        }

        arrX.add(array[array.length - 1] = temp);
        
        System.out.println(arrX);
    }

}

