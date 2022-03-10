package by.belyuk.third_project.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
  private List<Component> textElements = new ArrayList<>();
  private TextElementType textElementType;

  public TextComposite(TextElementType textElementType) {
    this.textElementType = textElementType;
  }

  @Override
  public void add(Component component) {
    textElements.add(component);
  }

  @Override
  public void remove(Component component) {
    textElements.remove(component);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TextComposite that = (TextComposite) o;

    return textElements != null
        ? textElements.equals(that.textElements)
        : that.textElements == null;
  }

  @Override
  public int hashCode() {
    return textElements != null ? textElements.hashCode() : 0;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    for (Component element : textElements) {
      sb.append(textElementType.getPrefix())
          .append(element.toString())
          .append(textElementType.getPostfix());
    }
    return sb.toString();
  }
}
