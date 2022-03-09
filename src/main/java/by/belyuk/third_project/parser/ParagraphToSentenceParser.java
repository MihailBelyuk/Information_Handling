package by.belyuk.third_project.parser;

import by.belyuk.third_project.entity.Component;
import by.belyuk.third_project.entity.TextComposite;
import by.belyuk.third_project.entity.TextElement;
import by.belyuk.third_project.exception.CustomException;
import by.belyuk.third_project.entity.TextElementType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ParagraphToSentenceParser {
  private static final Logger logger = LogManager.getLogger();
  private static final String SENTENCE_REGEXP = "([A-Z]|[А-ЯЁ]).+?(\\.|\\!|\\?|\\u2026)";


  public void parse(String text, TextComposite composite) throws CustomException {
    if (composite == null) {
      logger.log(Level.ERROR, "Component from parameters is null");
      throw new CustomException("Component from parameters is null");
    }
    List<String> sentences = List.of(text.strip().split(SENTENCE_REGEXP));
    for (String sentence : sentences) {
      Component component = new TextElement(TextElementType.SENTENCE,sentence);
      composite.add(component);
    }
  }
}
