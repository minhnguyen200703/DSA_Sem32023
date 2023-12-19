public class SecretKey {
    // Array to store the secret key characters
    private char[] secretKey;

    // Constructor to initialize the secret key
    public SecretKey(String key) {
        // Initialize the secretKey array to hold 12 characters
        secretKey = new char[12];

        // Check if the provided key is valid; if so, assign it to secretKey array
        if (isValidKey(key)) {
            secretKey = key.toCharArray();
        } else {
            // If the key is not valid, initialize an empty array for secretKey
            throw new IllegalArgumentException("Invalid key length or characters, please check the Key once again, \n ensures that the key is exactly 12 digits and made from M, O, C, H, or A.");

        }
    }



    // Method to retrieve the secret key
    public char[] getSecretKey() {
        return secretKey;
    }

    // Method to check if the provided key is valid
    private boolean isValidKey(String key) {
        // Check if the key length is not equal to 12
        if (key.length() != 12) {
            return false;
        }

        // Check each character in the key to ensure it belongs to the set 'M', 'O', 'C', 'H', 'A'
        for (char c : key.toCharArray()) {
            if (c != 'M' && c != 'O' && c != 'C' && c != 'H' && c != 'A') {
                return false;
            }
        }
        return true; // Return true if the key meets the criteria
    }

    // Method to compare a guessed key with the secret key and count matching characters
    public int guess(char[] guessedKey) {
        // Check if the guessed key length is not equal to 12
        if (guessedKey.length != 12) {
            return -1; // Return -1 for an invalid guessed key length
        }

        int count = 0;
        // Compare each character of the guessed key with the corresponding character in the secret key
        for (int i = 0; i < 12; i++) {
            if (guessedKey[i] == secretKey[i]) {
                count++; // Increment count for each matching character
            }
        }
        return count; // Return the count of matching characters between the keys
    }
}
