package by.belyuk.third_project.entity;

public class TextElement implements Component {
  private TextElementType textElementType;
  private String textSample;

  public TextElement(TextElementType textElementType,String textSample) {
    this.textElementType = textElementType;
    this.textSample = textSample;
  }

  @Override
  public void add(Component component) {}

  @Override
  public void remove(Component component) {}

  @Override
  public void print() {}

  public TextElementType getTextElementType() {
    return textElementType;
  }

  public void setTextElementType(TextElementType textElementType) {
    this.textElementType = textElementType;
  }


  public void setTextElement(String textSample) {
    this.textSample = textSample;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TextElement that = (TextElement) o;

    if (textElementType != that.textElementType) return false;
    return textSample != null ? textSample.equals(that.textSample) : that.textSample == null;
  }

  @Override
  public int hashCode() {
    int result = textElementType != null ? textElementType.hashCode() : 0;
    result = 31 * result + (textSample != null ? textSample.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("TextElement{");
    sb.append("textElementType=").append(textElementType);
    sb.append(", textSample='").append(textSample).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
