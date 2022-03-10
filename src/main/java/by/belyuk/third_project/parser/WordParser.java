package by.belyuk.third_project.parser;

import by.belyuk.third_project.entity.Component;
import by.belyuk.third_project.entity.TextComposite;
import by.belyuk.third_project.entity.TextElementType;
import by.belyuk.third_project.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends TextParser {
  private static final Logger logger = LogManager.getLogger();
  private static final String WORD_REGEXP = "\\s+\\w+\\s+";

  public WordParser(){
    this.nextParser = new SymbolParser();
  }

  @Override
  public void parse(String text, Component component) throws CustomException {
    if (component == null) {
      logger.log(Level.ERROR, "Component from parameters is null");
      throw new CustomException("Component from parameters is null");
    }
    Pattern pattern = Pattern.compile(WORD_REGEXP);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      String word = matcher.group();
      if (!word.isEmpty()) {
        Component wordComponent = new TextComposite(TextElementType.WORD);
        component.add(wordComponent);
        nextParser.parse(word, wordComponent);
      }
    }
  }
}
