import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
  
  private Scanner scan;
  
  public Parser() {
    scan = new Scanner(System.in);
    scan.useDelimiter("");
  }
  
  public Parser(File in) throws FileNotFoundException {
    scan = new Scanner(in);
    scan.useDelimiter("");
  }
  
  public String nextSymbol() {
    StringBuilder symbol = new StringBuilder();
    String token = nextChar();
    boolean inQuote = false;
    boolean inParen = false;
    
    // End of input
    if (token == null) {
      return null;
    }
    
    // If the first token is a space, ignore it and go to the next symbol
    if (token.equals(" ")) {
      return nextSymbol();
    }
    
    loop:
    while (token != null) {
      // Break on spaces unless inside quotes or parentheses
      if (!inQuote && !inParen && token.equals(" ")) {
        break;
      }
      
      switch (token) {
      case "/": if (nextChar().equals("*"))
                  findSymbol("*/"); 
                return nextSymbol();
      case "'": inQuote = !inQuote; break;
      case "(": inParen = true; break;
      case ")": inParen = false; break;
      case ";": break loop;
      case ",": if (!inParen && !inQuote) break;
      default: symbol.append(token);
      }
      
      token = nextChar();
    }
    
    System.out.print("[" + symbol.toString() + "]");
    return symbol.toString();
  }
  
  private String nextChar() {
    if (!scan.hasNext()) {
       //System.out.println();
      return null;
    }
    
    String next = scan.next();
    if (next.equals("\n") || next.equals("\r")) {
      return "";
    }
    
    //System.out.print(next);
    return next;
  }
  
  private boolean findSymbol(String symbol) {
    String next;
    do {
      next = nextSymbol();
      if (next.equals("")) {
        return false;
      }
    } while (!symbol.equals(next));
    return true;
  }

}
