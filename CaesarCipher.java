import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the text to encrypt or decrypt:");
            String text = scanner.nextLine();

            System.out.println("Enter 'e' to encrypt or 'd' to decrypt:");
            char choice = scanner.next().charAt(0);

            System.out.println("Enter the key (number of shifts):");
            int key = scanner.nextInt();

            System.out.println("Enter 'l' for left shift or 'r' for right shift:");
            char direction = scanner.next().charAt(0);

            if (choice == 'e') {
                String result = encrypt(text, key, direction);
                System.out.println("Encrypted text: " + result);
            } else if (choice == 'd') {
                String result = decrypt(text, key, direction);
                System.out.println("Decrypted text: " + result);
            } else {
                System.out.println("Invalid choice. Please enter 'e' or 'd'.");
            }
        }
    }

    public static String encrypt(String text, int key, char direction) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                if (direction == 'r')
                    ch = (char) (((ch - 'a' + key) % 26) + 'a');
                else if (direction == 'l')
                    ch = (char) (((ch - 'a' - key + 26) % 26) + 'a');
                else {
                    System.out.println("Invalid direction. Please enter 'l' or 'r'.");
                    return "";
                }
                encryptedText.append(ch);
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text, int key, char direction) {
        return encrypt(text, key, (direction == 'l') ? 'r' : 'l');
    }
}
