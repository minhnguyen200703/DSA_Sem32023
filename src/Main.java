
public class Main {
    public static void main(String[] args) {
        String key = "MOCHMCOHMCHA";
        SecretKeyGuesser guesser = new SecretKeyGuesser();
        guesser.start(key);
    }
}