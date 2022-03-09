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

public class TextToParagraphParser {
  private static final Logger logger = LogManager.getLogger();
  private static final String PARAGRAPH_REGEXP = "\\s{4}";

  public void parse(String text, TextComposite composite) throws CustomException {
    if (composite == null) {
      logger.log(Level.ERROR, "Component from parameters is null");
      throw new CustomException("Component from parameters is null");
    }
    List<String> paragraphs = List.of(text.strip().split(PARAGRAPH_REGEXP));
    for (String paragraph : paragraphs) {
      Component component = new TextElement(TextElementType.PARAGRAPH,paragraph);
      composite.add(component);
    }
  }
}
