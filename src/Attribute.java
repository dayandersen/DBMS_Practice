/**
 * Created by ander612 on 10/4/17.
 */
public class Attribute {
  String attributeName;
  String attributeType;
  Integer typeLength;

  public Attribute(String attributeType, String attributeName ,Integer typeLength) {
    this.attributeType = attributeType;
    this.typeLength = typeLength;
    this.attributeName = attributeName;
  }
}
