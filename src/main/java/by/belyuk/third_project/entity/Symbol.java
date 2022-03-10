package by.belyuk.third_project.entity;

public class Symbol implements Component {
  private TextElementType textElementType;
  private char symbol;

  public Symbol(char symbol) {
    this.symbol = symbol;
  }

  @Override
  public void add(Component component) {}

  @Override
  public void remove(Component component) {}

  public void setTextElementType(TextElementType textElementType) {
    this.textElementType = textElementType;
  }

  public void setSymbol(char symbol) {
    this.symbol = symbol;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Symbol that = (Symbol) o;

    if (symbol != that.symbol) return false;
    return textElementType == that.textElementType;
  }

  @Override
  public int hashCode() {
    int result = textElementType != null ? textElementType.hashCode() : 0;
    result = 31 * result + (int) symbol;
    return result;
  }

  @Override
  public String toString() {
    return String.valueOf(symbol);
  }
}
