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

public class SentenceParser extends TextParser {
  private static final Logger logger = LogManager.getLogger();
  private static final String SENTENCE_REGEXP = "([A-Z]|[А-ЯЁ]).+?(\\.|\\!|\\?|\\u2026)";
  public SentenceParser(){
    this.nextParser = new WordParser();
  }
@Override
  public void parse(String text, Component component) throws CustomException {
    if (component == null) {
      logger.log(Level.ERROR, "Component from parameters is null");
      throw new CustomException("Component from parameters is null");
    }
    Pattern pattern = Pattern.compile(SENTENCE_REGEXP);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      String sentence = matcher.group();
      if (!sentence.isEmpty()) {
        Component sentenceComponent = new TextComposite(TextElementType.SENTENCE);
        component.add(sentenceComponent);
        nextParser.parse(sentence,sentenceComponent);
      }
    }
  }
}
