package by.belyuk.third_project.service;

import by.belyuk.third_project.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class VowelCount {
  private static final Logger logger = LogManager.getLogger();
  private static final String VOWEL_REGEX = "[aeiouAEIOUауоыиэяюёеАУОЫИЭЯЮЁЕ]";
  private static final String CONSONANT_REGEX = "[qwrtpsdfghjklzxcvbnm]";// Easy way

  public int countVowels(String text) throws CustomException {
    if(text==null || text.isEmpty()){
      logger.log(Level.ERROR,"Provided text is null or empty.");
      throw new CustomException("Provided text is null or empty.");
    }
    String[] symbols = text.strip().split("");
    List<String> vowelList = new ArrayList<>();
    for (String symbol : symbols) {
      if (symbol.matches(VOWEL_REGEX)) {
        vowelList.add(symbol);
      }
    }
    return vowelList.size();
  }
}
