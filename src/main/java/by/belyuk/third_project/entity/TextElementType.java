package by.belyuk.third_project.entity;

public enum TextElementType {
  TEXT("", ""),
  PARAGRAPH("\t", "\n"),
  SENTENCE("", ""), // предложение
  WORD("", ""),
  LETTER("", " "),
  DIGIT("", ""),
  PUNCTUATION_MARK("", "");

  private final String prefix;
  private final String postfix;

  private TextElementType(String prefix, String postfix) {
    this.prefix = prefix;
    this.postfix = postfix;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getPostfix() {
    return postfix;
  }
}
