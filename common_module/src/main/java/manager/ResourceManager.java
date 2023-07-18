package manager;

import org.json.JSONArray;
import util.JsonFileReader;

/**
 * Менеджер ресурсов (хранит данные файлов из ресурсного пакета)
 */

public class ResourceManager {
    public static final JSONArray FIRSTNAMES = new JSONArray().putAll(JsonFileReader.readJsonFile("common_module/src/main/resources/firstnames.json"));
    public static final JSONArray SURNAMES = new JSONArray().putAll(JsonFileReader.readJsonFile("common_module/src/main/resources/surnames.json"));
}
