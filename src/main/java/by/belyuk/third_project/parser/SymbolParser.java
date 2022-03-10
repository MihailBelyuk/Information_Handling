package by.belyuk.third_project.parser;

import by.belyuk.third_project.entity.Component;
import by.belyuk.third_project.entity.Symbol;
import by.belyuk.third_project.entity.TextElementType;
import by.belyuk.third_project.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser extends TextParser {
  private static final Logger logger = LogManager.getLogger();
  private static final String DIGIT_REGEXP = "\\d";
  private static final String LETTER_REGEXP = "[A-Za-zА-Яа-я]";
  private static final String PUNCTUATION_REGEXP = "\\p{Punct}";

  @Override
  public void parse(String text, Component component) throws CustomException {
    if (component == null) {
      logger.log(Level.ERROR, "Component from parameters is null");
      throw new CustomException("Component from parameters is null");
    }
    String[] symbolArray = text.strip().split("");
    Symbol symbol = null;
    for (String element : symbolArray) {
      if (!element.isBlank()) {
        if (element.matches(DIGIT_REGEXP)) {
          symbol = new Symbol(text.charAt(0));
          symbol.setTextElementType(TextElementType.DIGIT);
          symbol.setSymbol(element.charAt(0));
        } else if (element.matches(LETTER_REGEXP)) {
          symbol = new Symbol(element.charAt(0));
          symbol.setTextElementType(TextElementType.LETTER);
          symbol.setSymbol(element.charAt(0));
        } else if (element.matches(PUNCTUATION_REGEXP)) {
          symbol = new Symbol(element.charAt(0));
          symbol.setTextElementType(TextElementType.PUNCTUATION_MARK);
          symbol.setSymbol(element.charAt(0));

        }
        component.add(symbol);
      }
    }
  }
}
