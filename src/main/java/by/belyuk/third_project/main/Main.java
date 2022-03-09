package by.belyuk.third_project.main;

import by.belyuk.third_project.entity.TextComposite;
import by.belyuk.third_project.exception.CustomException;
import by.belyuk.third_project.parser.ParagraphToSentenceParser;
import by.belyuk.third_project.parser.SentenceToWordParser;
import by.belyuk.third_project.parser.TextToParagraphParser;
import by.belyuk.third_project.reader.impl.TextReaderImpl;
import by.belyuk.third_project.entity.TextElementType;

public class Main {
  public static void main(String[] args) {
    TextReaderImpl textReader = TextReaderImpl.getInstance();
    TextComposite textComposite = new TextComposite(TextElementType.PARAGRAPH);
    TextToParagraphParser textToParagraphParser = new TextToParagraphParser();
    ParagraphToSentenceParser paragraphToSentenceParser = new ParagraphToSentenceParser();
      SentenceToWordParser sentenceToWordParser = new SentenceToWordParser();
    try {
     textToParagraphParser.parse(textReader.read("data/text.txt"),textComposite);
     paragraphToSentenceParser.parse(textReader.read("data/text.txt"),textComposite);
     sentenceToWordParser.parse(textReader.read("data/text.txt"),textComposite);
    textComposite.print();

    } catch (CustomException e) {
      e.printStackTrace();
    }

  }
}
