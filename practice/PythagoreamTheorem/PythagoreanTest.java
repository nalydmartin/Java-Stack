public class PythagoreanTest {
    public static void main(String[] args) {
        int legA = 2;
        int legB = 2;
        Pythagorean iD = new Pythagorean();
        double calculateHypotenuse = iD.calculateHypotenuse(legA, legB);
        System.out.println(calculateHypotenuse);
    }
}