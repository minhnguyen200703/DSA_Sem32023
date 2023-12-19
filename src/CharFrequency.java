public class CharFrequency {
    // Array to store frequencies of characters 'M', 'O', 'C', 'H', 'A'
    private int[] frequencies = new int[5];

    // Constructor that counts frequencies based on the provided SecretKey
    public CharFrequency(SecretKey secretKey) {
        countFrequencies(secretKey);
    }

    // Method to count frequencies of characters in the SecretKey
    private void countFrequencies(SecretKey secretKey) {
        char[] key = secretKey.getSecretKey();
        for (char c : key) {
            // Increment the frequency count based on the character encountered
            switch (c) {
                case 'M':
                    frequencies[0]++;
                    break;
                case 'O':
                    frequencies[1]++;
                    break;
                case 'C':
                    frequencies[2]++;
                    break;
                case 'H':
                    frequencies[3]++;
                    break;
                case 'A':
                    frequencies[4]++;
                    break;
            }
        }
    }

    // Method to get the frequency count of a specific character
    public int getFrequency(char c) {
        switch (c) {
            case 'M':
                return frequencies[0];
            case 'O':
                return frequencies[1];
            case 'C':
                return frequencies[2];
            case 'H':
                return frequencies[3];
            case 'A':
                return frequencies[4];
            default:
                return -1; // Return -1 for characters not in 'M', 'O', 'C', 'H', 'A'
        }
    }

    // Method to decrease the frequency count of a specific character by 1
    public void decreaseFrequency(char c) {
        switch (c) {
            case 'M':
                frequencies[0]--;
                break;
            case 'O':
                frequencies[1]--;
                break;
            case 'C':
                frequencies[2]--;
                break;
            case 'H':
                frequencies[3]--;
                break;
            case 'A':
                frequencies[4]--;
                break;
        }
    }

    // Method to set the frequency count of a specific character to 0
    public void deleteFrequency(char c) {
        switch (c) {
            case 'M':
                frequencies[0] = 0;
                break;
            case 'O':
                frequencies[1] = 0;
                break;
            case 'C':
                frequencies[2] = 0;
                break;
            case 'H':
                frequencies[3] = 0;
                break;
            case 'A':
                frequencies[4] = 0;
                break;
        }
    }
}
