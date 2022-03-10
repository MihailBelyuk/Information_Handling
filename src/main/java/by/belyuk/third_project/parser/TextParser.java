package by.belyuk.third_project.parser;

import by.belyuk.third_project.entity.Component;
import by.belyuk.third_project.entity.TextElementType;
import by.belyuk.third_project.exception.CustomException;

public abstract class TextParser {
  protected TextParser nextParser;

  abstract void parse(String text, Component component) throws CustomException;
}
