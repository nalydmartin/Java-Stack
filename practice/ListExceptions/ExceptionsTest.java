
public class ExceptionsTest {

    public static void main(String[] args) {

        Exceptions thing = new Exceptions();

        try {
            thing.exception();
            System.out.println("Thing is now an int!");
        } catch (notAnInt){
            System.out.println("This cannot be an int you twit.");
        }
        
    }
}