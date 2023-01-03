package ru.org;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertyValues {
    Optional<Properties> result = Optional.empty();
    InputStream inputStream;

    public Optional<Properties> getPropValues() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "application.yaml";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("файл '" + propFileName + "' не найден в classpath");
            }
            result = Optional.of(prop);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
