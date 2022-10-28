package src;

import java.io.*;

public class Main {
  static BufferedReader br;
  static InputStreamReader isr;
  /**
   * isBinMethod - verifies if a string contains binary numbers only
   * 
   * @param bin: is the string that holds the array of characters
   * @return: false if it's not a binary and true if it is
   */
  public static boolean isBinMethod(String bin) {
    for (int i = 0; i < bin.length(); i++) {
      if (bin.charAt(i) != '1' && bin.charAt(i) != '0') {
        System.out.printf("O caracter %c nao é um binário! Tente Novamente.\n", bin.charAt(i));
        return false;
      }
    }
    return true;
  }

  /**
   * binValidator - method to valide a binary sequence
   * 
   * @param msg:  a message to the user
   * @param size: the max size of the char sequence
   * @return: the string in the right way
   * @throws IOException
   */
  public static String binValidator(String msg, int size, BufferedReader b, String error) throws IOException {
    String bin = "";
    while (true) {
      System.out.println(msg);
      bin = b.readLine();
      if (bin.length() <= 0 || bin.length() > 8)
        System.out.println(error);
      else
        break;
    }
    return bin;
  }

  /**
   * main - the entry point of the program
   * 
   * @param args: the arguments of the program
   * @return: nothing
   */
  public static void main(String[] args) throws IOException {
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);

    String bin = "";
    int result = 0;
    boolean isBin = false;
    while (!isBin) {
      bin = binValidator("Introduza uma sequência de binários: ", 8, br,
          "A sequencia de caracteres nao pode ser maior que 8! Tente Novamente!");
      isBin = isBinMethod(bin);
    }

    System.out.println("Binario: " + bin);
    for (int i = 0, j = bin.length() - 1; i < bin.length(); i++, j--) {
      result = result + Integer.parseInt(bin.charAt(i) + "") * (int) Math.pow(2, j);
    }
    System.out.println("Resultado: " + result);
  }

}