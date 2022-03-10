package by.belyuk.third_project.parser;

import by.belyuk.third_project.entity.Component;
import by.belyuk.third_project.entity.TextComposite;
import by.belyuk.third_project.entity.TextElementType;
import by.belyuk.third_project.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends TextParser {
  private static final Logger logger = LogManager.getLogger();
  private static final String PARAGRAPH_REGEXP = "\\s{4}";

  public ParagraphParser() {
    this.nextParser = new SentenceParser();
  }

  @Override
  public void parse(String text, Component component) throws CustomException {
    if (component == null) {
      logger.log(Level.ERROR, "Component from parameters is null");
      throw new CustomException("Component from parameters is null");
    }
    String[] paragraphs = text.strip().split(PARAGRAPH_REGEXP);
    for (String paragraph : paragraphs) {
      if (!paragraph.isEmpty()) {
        Component paragraphComponent = new TextComposite(TextElementType.PARAGRAPH);
        component.add(paragraphComponent);
        nextParser.parse(paragraph, paragraphComponent);
      }
    }
  }
}
