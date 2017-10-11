import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ander612 on 10/4/17.
 */
public class Main {
  
  public static void main(String args[]) throws IOException {
    SurlyDB surlyDB = new SurlyDB();
    File surlyDBCommands = new File(args[0]);
    
    Parser parser;
    try {
      parser = new Parser(surlyDBCommands);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    }
    
    String symbol = parser.nextSymbol();
    while (symbol != null) {
      System.out.print("[" + symbol + "]");
      if (symbol.equals(";")) {
        System.out.println();
      }
      symbol = parser.nextSymbol();
    }
  }
}
