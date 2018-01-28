import java.util.Scanner;

/**
 * CaeserCipher is a class that can be used to execute the classical ciphering technique
 * used by the Roman emperor Julius Caesar himself. It uses substitution to encode and decode
 * desired messages.
 * 
 * @author Aabid Shamji and Liam Niehus-Staab
 * @since 2018-01-24
 */
public class CaeserCipher {

	/**
     * isLowerAlphabetic tests if a string contains only lower-case letters.
     *
     * @param str - a string that has all its characters evaluated to check that 
     *              each is lower-case and alphabetic.
     * @result status - <true> if str contains only characters that are 
     *                  lower-case letters or is empty. Else, <false>.
     */
    public static boolean isLowerAlphabetic(String str){
        boolean status = true;
        for(int pos = 0; pos < str.length(); pos++){
            char letter = str.charAt(pos);
            if(!(('a' <= letter) && ('z' >= letter))){
                status = false;
            }
        }
        return status;
    }

    /**
     * validEntry checks to see if the given string is invalid (meaning it does
     * not contain only lower-case letters), and then either continues or exits 
     * the program.
     *
     * @param str - a string of characters that is tested using 
     *              isLowerAlphabetic.
     * @return N/A - this function is run for the side effects.
     */
    public static void validEntry(String str){
        if (!isLowerAlphabetic(str)){
            System.out.println("Only lower-case text is valid.");
            System.exit(0);
        }
    }
    
	/**
	 * The encode function uses a key to cipher a message using substitution.
	 * 
	 * @param str - a plaintext string that is to encoded.
	 * @param key - a key that is used to cipher the plaintext string, str.
	 * @return coded - the ciphertext generated by encoding str using key.  
	 */
	public static String encode(String str, int key){
		char[] message = str.toCharArray();
		for (int i = 0; i < str.length(); i++){
			message[i] = (char) ((((int) message[i] + key - 97) % 26) + 97);
		}
		String coded = new String(message);
		return coded;
	}
	
	/**
	 * The decode function uses a key to decipher a message through substitution.
	 * 
	 * @param str - a ciphertext string that is to decoded.
	 * @param key - a key that is used to decipher the ciphertext string, str.
	 * @return coded - the plaintext generated by decoding str using key.  
	 */
	public static String decode(String str, int key){
		char[] message = str.toCharArray();
		for (int i = 0; i < str.length(); i++){
			message[i] = (char) ((((int) message[i] - key - 97 + 26) % 26) + 97);
		}
		String coded = new String(message);
		return coded;
	}
	
	public static void main(String[] args) {
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.print("Would you like to encode or decode a message?");
		Scanner in = new Scanner(System.in);
		String codation = in.nextLine();
		
		if (codation.equals("encode") || codation.equals("decode")) {
			System.out.print("Enter the string to " + codation + ": ");
			Scanner in2 = new Scanner(System.in);
			String message = in2.nextLine();
			validEntry(message);
			
			if(codation.equals("encode")){			
				for (int i = 0; i < 26; i++) {
					System.out.println("n = " + i + ": " + encode(message, i));
				}
			} else if(codation.equals("decode")){
				for (int i = 0; i < 26; i++) {
					System.out.println("n = " + i + ": " + decode(message, i));
				}
			}		
		} else {
			System.out.println("Valid options are \"encode\" or \"decode\"");
		}		
	}
}
