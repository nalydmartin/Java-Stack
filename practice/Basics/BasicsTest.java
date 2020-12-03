public class BasicsTest {

    public static void main(String[] args) {
        Basics basicTest = new Basics();

        basicTest.oneToTwoFiftyFive();

        basicTest.oddOneToTwoFiftyFive();

        basicTest.sum();

        int[] numArray = {1,3,5,7,9,13};
        basicTest.iterateArray(numArray);

        int[] numArray2 = {-3, 5, 7, -10};
        basicTest.findMax(numArray2);

        int[] numArray3 = {3, 5, 7};
        basicTest.findAvg(numArray3);

        basicTest.oddArray();

        int[] numArray4 = {2,4,6,8,9,10};
        int y = 6;
        basicTest.biggerThanY(numArray4, y);

        int[] numArray5 = {2,-4,6,8};
        basicTest.sqrValue(numArray5);

        int[] numArray6 = {-5,3,-7,-9};
        basicTest.elimNegNum(numArray6);

        int[] numArray7 = {1,2,3,5,6};
        basicTest.minMaxAvg(numArray7);

        int[] numArray8 = {2,5,8,9,5,6};
        basicTest.shift(numArray8);

    }
}