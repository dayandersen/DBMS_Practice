import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ander612 on 10/4/17.
 */
public class Main {
  public void main(String args[]) throws IOException {
    SurlyDB surlyDB = new SurlyDB();
    File surlyDBCommands = new File(args[0]);
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(surlyDBCommands));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int currentChar = reader.read();
    String currentPhrase = "";
    while (currentChar != -1) {
      if (currentChar == ' ') {

      } else if (currentChar == '(') {
        while (currentChar != ')') {

        }
      } else {
        currentPhrase += (char) currentChar;
        if (currentPhrase.equals("RELATION") || currentPhrase.equals("relation")) {
          reader.read();
          reader.read();
          String relationName = findNextWord(reader);
          surlyDB.addRelation(new Relation(relationName));
          parseRelation(reader);
        }
      }
    }
  }

  public String findNextWord(BufferedReader reader) throws IOException {
    int currentChar = reader.read();
    String nextWord = "";
    nextWord += (char) currentChar;
    while (currentChar != ' ' && currentChar != ',' && currentChar != -1) {
      currentChar = reader.read();

    }
    return nextWord;
  }
  public List<Attribute> parseRelation(BufferedReader reader) throws IOException {
    List<Attribute> relationAttributes = new LinkedList<Attribute>();
    String nextWord = "";
    int currentChar = reader.read();
    nextWord += (char) currentChar;
    while (currentChar != -1 && currentChar != ';') {
      if (currentChar == '(') {
        String attributeType = findNextWord(reader);
        String
      }
    }
    return relationAttributes;
  }
}
