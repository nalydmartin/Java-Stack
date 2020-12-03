import java.util.HashMap;
import java.util.Set;

public class Hash {
    public static void hashMap() {

        HashMap<String, String> tracklist = new HashMap<String, String>();

        tracklist.put("Heaven on Earth, Belinda Carlisle", "Ooh, baby, do you know what that's worth? Ooh, heaven is a place on earth. They say in heaven, love comes first. We'll make heaven a place on earth.");

        tracklist.put("SOS, Rihanna", "S.O.S., please someone help me. It's not healthy for me to feel this. Y.O.U. are making this hard. I can't take it, see it don't feel right. S.O.S. please someone help me.");

        tracklist.put("On a Roll, Ashley O", "Hey, yeah, whoa-ho, I'm on a roll. Ridin' so high, achieving my goals. Hey, yeah, whoa-ho, I'm on a roll. Ridin' so high, achieving my goals.");

        tracklist.put("Trampoline, Kero Kero Bonito", "First you fall down, then you jump back up again. Find your rhythm, momentum is the key. It's so easy, anyone can trampoline. So jump on up and you can see. The whole wide world.");

        String sample = tracklist.get("On a Roll, Ashley O");
        System.out.println("Sample track: " + sample);

        Set<String> tracks = tracklist.keySet();

        for (String songs : tracks) {
            System.out.println(songs + ": " + tracklist.get(songs));
        }

    }
}