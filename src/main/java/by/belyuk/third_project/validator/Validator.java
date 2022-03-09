package by.belyuk.third_project.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Validator {
    private static final Logger logger = LogManager.getLogger();
    private static final Validator validator = new Validator();

    private Validator(){}

    public static Validator getInstance(){
        return validator;
    }

    public boolean validateFilePath(String filePath) {
        boolean isValid = false;
        if (filePath != null) {
            File file = new File(filePath);
            if (file.exists() && file.length() > 0) {
                isValid = true;
                logger.log(Level.INFO, "File path is valid.");
            }
        }
        return isValid;
    }
}
