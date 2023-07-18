package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;

import static util.AbsolutePathConstructor.defineAbsolutePath;

/**
 * Утилита для чтения файлов с расширением .json
 */

public class JsonFileReader {

    public static Object readJsonFile(String pathFromRepositoryRoot) {
        String absolutePath = defineAbsolutePath(pathFromRepositoryRoot);
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(Paths.get(absolutePath).toFile(), Object.class);
        } catch (IOException e) {
            System.out.printf("File '%s' read error: %s%n", absolutePath, e);
        }
        return null;
    }
}
