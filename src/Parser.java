import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class Parser {

  private Scanner fileScan;
  private Scanner cmdScan;
  private Queue<String> queue;
  
  private boolean inComment;
  
  public Parser(File in) throws FileNotFoundException {
    fileScan = new Scanner(in);
    fileScan.useDelimiter(";");
    queue = new LinkedList<String>();
  }
  
  private Scanner initCmdScanner(String cmd) {
    cmdScan = new Scanner(cmd);
    cmdScan.useDelimiter(" ");
    return cmdScan;
  }
  
  /* Checks for the end of the command before returning the symbol.
   * If at the end, we'll want to enqueue a semicolon to be returned next. */
  private String returnSymbol(String symbol) {
    if (!symbol.equals(";") && !cmdScan.hasNext() && queue.isEmpty()) {
      queue.add(";");
    }
    return symbol;
  }
  
  public String nextSymbol() {
    /* Return items from the queue before continuing to parse */
    if (queue.size() > 0) {
      return returnSymbol(queue.remove());
    }
    
    /* Handle edge cases (first and last calls) */
    if (cmdScan == null || !cmdScan.hasNext()) {
      if (fileScan.hasNext()) {
        // Start parsing the next command
        cmdScan = initCmdScanner(fileScan.next());
      } else {
        // End of input
        return null; 
      }
    }
    
    /* Get the next raw symbol */
    String symbol = cmdScan.next();
    
    /* Remove newlines & carriage returns */
    symbol = symbol.replaceAll("\n|\r|,", "");
    
    /* Skip blanks */
    if (symbol.equals("")) {
      return nextSymbol();
    }
    
    /* Ignore comments */
    if (symbol.equals("/*")) {
      inComment = true;
    }
    if (inComment) {
      if (symbol.equals("*/")) {
        inComment = false;
      }
      return nextSymbol();
    }

    /* Handle single-quotes */
    if (symbol.startsWith("'")) {
      cmdScan.useDelimiter("'");
      try {
        // Capture the entire quotation
        String quote = symbol + cmdScan.next() + "'";
        
        // Consume the closing quote
        cmdScan.skip("'");
        
        cmdScan.useDelimiter(" ");
        return returnSymbol(quote);
        
      } catch (NoSuchElementException e) {
        return "Error: mismatched quote";
      }
    }
    
    /* Handle parentheses */
    if (symbol.length() > 1 && symbol.startsWith("(")) {
      queue.add(symbol.substring(1));
      return returnSymbol("(");
    } else if (symbol.length() > 1 && symbol.endsWith(")")) {
      queue.add(")");
      return returnSymbol(symbol.substring(0, symbol.length()-1));
    }
    
    return returnSymbol(symbol);
  }
}
