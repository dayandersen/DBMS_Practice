import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by ander612 on 10/4/17.
 */
public class Relation {
  private String relationName;
  private LinkedList<Tuple> listTuples = new LinkedList<Tuple>();
  private LinkedList<Attribute> listAttributes = new LinkedList<Attribute>();
  private int tupleNum;

  public Relation() {
    this.tupleNum = 0;
  }

  public Relation(String relationName) {
    this.relationName = relationName;
    this.tupleNum = 0;
  }

  public Attribute addAttribute(String attributeType, String attributeName, Integer attributeSize) {
    Attribute newAttribute = new Attribute(attributeType, attributeName, attributeSize);
    listAttributes.add(newAttribute);
    ListIterator<Tuple> tupleListIterator = listTuples.listIterator();
    
    while (tupleListIterator.hasNext()) {
      tupleListIterator.next().addAttribute(newAttribute);
    }
    
    return newAttribute;
  }
  
  public Attribute addAttribute(Attribute newAttribute) {
    listAttributes.add(newAttribute);
    ListIterator<Tuple> tupleListIterator = listTuples.listIterator();
    
    while (tupleListIterator.hasNext()) {
      tupleListIterator.next().addAttribute(newAttribute);
    }
    
    return newAttribute;
  }
  
  public Tuple insertTuple(Tuple newTuple) {
    newTuple.assignTupleNum(tupleNum);
    listTuples.add(newTuple);
    tupleNum++;
    return newTuple;
  }

  public void changeRelationName(String relationName) {
    this.relationName = relationName;
  }
}
