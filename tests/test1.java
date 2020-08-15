package ciphers;

import java.math.BigInteger;
import java.util.Scanner;






public class AES {
	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter (e) letter for encrpyt or (d) letter for decrypt :");
			char choice = input.nextLine().charAt(0);
			String in;
			switch (choice) {
			case 'E':
			case 'e':
				System.out.println("Choose a plaintext block (128-Bit Integer in base 16):");
				in = input.nextLine();
				BigInteger plaintext = new BigInteger(in, 16);
				System.out.println("Choose a Key (128-Bit Integer in base 16):");
				in = input.nextLine();
				BigInteger encryptionKey = new BigInteger(in, 16);
				System.out.println("The encrypted message is: \n" + encrypt(plaintext, encryptionKey).toString(16));
				break;
			case 'D':
			case 'd':
				System.out.println("Enter your ciphertext block (128-Bit Integer in base 16):");
				in = input.nextLine();
				BigInteger ciphertext = new BigInteger(in, 16);
				System.out.println("Choose a Key (128-Bit Integer in base 16):");
				in = input.nextLine();
				BigInteger decryptionKey = new BigInteger(in, 16);
				System.out.println("The deciphered message is:\n" + decrypt(ciphertext, decryptionKey).toString(16));
				break;
			default:
				System.out.println("** End **");
			}
		}

	}
}








