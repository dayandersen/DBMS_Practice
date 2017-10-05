import java.util.LinkedList;

/**
 * Created by ander612 on 10/4/17.
 */
public class SurlyDB {
  LinkedList<Relation> relationList = new LinkedList<Relation>();
  public SurlyDB() {
  }

  public Relation addRelation (Relation newRelation) {
    relationList.add(newRelation);
    return newRelation;
  }
}
