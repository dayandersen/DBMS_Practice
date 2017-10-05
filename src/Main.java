import java.io.File;
import java.io.FileReader;

/**
 * Created by ander612 on 10/4/17.
 */
public class Main {
  public static void main(String args[]) {
    SurlyDB surlyDB = new SurlyDB();
    File surlyDBCommands = new File(args[0]);
    if (surlyDBCommands == null) {
      return;
    }
    FileReader reader = new FileReader(surlyDBCommands);
    Character currentChar = reader.read();
    String currentPhrase = "";
    while (currentChar != null) {
      if (currentChar == ' ') {

      } else if (currentChar == '(') {
        while (currentChar != ')') {

        }
      } else {
        currentPhrase += currentChar;
        if (currentPhrase.equals("RELATION") || currentPhrase.equals("relation")) {
          surlyDB.addRelation(new Relation());
        }
      }
    }
  }
}
