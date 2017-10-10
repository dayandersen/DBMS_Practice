/**
 * Created by ander612 on 10/4/17.
 */
public class Attribute {
  private String attributeName;
  private String attributeType;
  private Integer typeLength;

  public Attribute(String attributeType, String attributeName ,Integer typeLength) {
    this.attributeType = attributeType;
    this.typeLength = typeLength;
    this.attributeName = attributeName;
  }
}
