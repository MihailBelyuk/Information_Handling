package by.belyuk.third_project.reader.impl;

import by.belyuk.third_project.exception.CustomException;
import by.belyuk.third_project.reader.TextReader;
import by.belyuk.third_project.validator.Validator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReaderImpl implements TextReader {
  private static final Logger logger = LogManager.getLogger();
  private static final TextReaderImpl reader = new TextReaderImpl();

  private TextReaderImpl() {}

  public static TextReaderImpl getInstance() {
    return reader;
  }

  @Override
  public String read(String filePath) throws CustomException {
    String text;
    Validator validator = Validator.getInstance();
    String informationFromFile;
    if (!validator.validateFilePath(filePath)) {
      logger.log(Level.ERROR, "File trying to access is empty or null.");
      throw new CustomException("File trying to access is empty or null.");
    }
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      StringBuilder stringBuilder = new StringBuilder();
      while ((informationFromFile = bufferedReader.readLine()) != null) {
        stringBuilder.append(informationFromFile);
        stringBuilder.append("\n");
      }
      text = stringBuilder.toString();
    } catch (FileNotFoundException e) {
      logger.log(Level.ERROR, "File attempting to read is missing.");
      throw new CustomException("File attempting to read is missing.");
    } catch (IOException e) {
      logger.log(Level.ERROR, "File can't be read." + filePath, e);
      throw new CustomException("File can't be read", e);
    }
    return text;
  }
}
