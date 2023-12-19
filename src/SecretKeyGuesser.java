public class SecretKeyGuesser {
    // Array of possible characters in the secret key
    private static char[] CHARS = {'M', 'O', 'C', 'H', 'A'};

    // Method to start the guessing process based on the provided key
    public void start(String key) {
        SecretKey secretKey = new SecretKey(key);
        CharFrequency charFrequency = new CharFrequency(secretKey);
        char[] tempKey = new char[12];

        // Finding the most and least frequent characters in the secret key
        char mostFrequentChar = getMostFrequentChar(charFrequency);
        int mostFrequentCount = charFrequency.getFrequency(mostFrequentChar);

        char leastFrequentChar = getLeastFrequentChar(charFrequency);
        int leastFrequentCount = charFrequency.getFrequency(leastFrequentChar);

        // Initialize tempKey with the most frequent character
        for (int i = 0; i < 12; i++) {
            tempKey[i] = mostFrequentChar;
        }

        // Brute force method to save positions of the least frequent character
        SetADT leastFreq = findPositionLeastFrequentChar(tempKey, mostFrequentChar, leastFrequentChar, mostFrequentCount, leastFrequentCount, secretKey);

        // Brute force method to find correct positions guessed, started with the least frequent character
        SetADT correctPositions = findPositionLeastFrequentChar(tempKey, mostFrequentChar, leastFrequentChar, mostFrequentCount, leastFrequentCount, secretKey);

        charFrequency.deleteFrequency(leastFrequentChar);

        // Reset temp key with the least frequent character
        for (int i = 0; i < 12; i++) {
            tempKey[i] = leastFrequentChar;
        }

        int count = 0;
        int matchCount = secretKey.guess(tempKey);

        // Iterating through each position to make educated guesses
        for (int i = 0; i < 12; i++) {
            if (leastFreq.contains((char) i)) { // Check if the index is the index of the least frequent char, if yes, put in and break the loop
                tempKey[i] = leastFrequentChar;
                count++;
                // Print the guessed key
                System.out.print("Guessing...");
                printCharArray(tempKey);
                System.out.println();
            } else if (!correctPositions.contains((char) i)) { // check if the index appear in the correctPositions or not
                for (char c : CHARS) {
                    if (charFrequency.getFrequency(c) > 0) { //Check if there is any char of that character left in the Frequency List
                        System.out.print("Guessing...");
                        printCharArray(tempKey);
                        System.out.println();
                        tempKey[i] = c;
                        if (secretKey.guess(tempKey) == matchCount + 1) { // If the guess increase by one, that mean the character is correct
                            matchCount++;
                            correctPositions.add((char) i);
                            charFrequency.decreaseFrequency(c);
                            count++;
                            break;
                        }
                        count++;
                    }
                }
            }
        }
        // Print the correct secret key and the number of guesses made
        System.out.println("Correct Secret Key: " + new String(tempKey));
        System.out.println("Number of Guesses: " + count);
    }

    // Method to find the most frequent character in the secret key
    private char getMostFrequentChar(CharFrequency charFrequency) {
        int maxFrequency = Integer.MIN_VALUE;
        char mostFrequentChar = ' ';

        for (char c : CHARS) {
            if (charFrequency.getFrequency(c) > maxFrequency) {
                maxFrequency = charFrequency.getFrequency(c);
                mostFrequentChar = c;
            }
        }

        return mostFrequentChar;
    }

    // Method to print the characters in an array
    public void printCharArray(char[] array) {
        for (char element : array) {
            System.out.print(element + "");
        }
        System.out.println(); // To add a newline after printing all elements
    }

    // Method to find the least frequent character in the secret key
    private char getLeastFrequentChar(CharFrequency charFrequency) {
        int minFrequency = Integer.MAX_VALUE;
        char leastFrequentChar = ' ';

        for (char c : CHARS) {
            if (charFrequency.getFrequency(c) < minFrequency) {
                minFrequency = charFrequency.getFrequency(c);
                leastFrequentChar = c;
            }
        }

        return leastFrequentChar;
    }

    // Method to check if an integer key is present in an integer array
    private boolean contains(int[] arr, int key) {
        for (int i : arr) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }

    // Method to perform a brute force search for correct indices
    public SetADT findPositionLeastFrequentChar(char[] tempKey, char mostFrequentChar, char leastFrequentChar, int totalFrequentMostChar, int totalFrequentLeastChar, SecretKey secretKey) {
        SetADT correctPositions = new SetADT();
        int count = 0;
        int i = 0;
        while (i < 12) {
            tempKey[i] = leastFrequentChar;
            if (secretKey.guess(tempKey) == totalFrequentMostChar + count + 1) {
                count++;
                correctPositions.add((char) i);
            }
            tempKey[i] = mostFrequentChar;

            i++;
        }
        return correctPositions;
    }
}
