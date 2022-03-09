package by.belyuk.third_project.reader;

import by.belyuk.third_project.exception.CustomException;

public interface TextReader {
  String read(String filePath) throws CustomException, CustomException;
}
