import java.util.LinkedList;

/**
 * Created by ander612 on 10/4/17.
 */
public class Tuple {
  LinkedList<Attribute> attributeList = new LinkedList<Attribute>();
  Integer tupleNum;

  public Tuple() {}

  public Tuple(Integer tupleNum) {
    this.tupleNum =  tupleNum;
  }

  public Attribute addAttribute(Attribute newAttribute) {
    attributeList.add(newAttribute);
    return newAttribute;
  }

  public Integer assignTupleNum(Integer tupleNum) {
    this.tupleNum = tupleNum;
    return tupleNum;
  }

}
