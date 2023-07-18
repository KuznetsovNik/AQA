package common.utils;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

@Slf4j
public class AllureUtils {

    private AllureUtils() {
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachPng(String description, byte[] bytes) {
        return bytes;
    }

    @Attachment(value = "Logs", type = "text/html")
    public static byte[] attachFile(File file) {
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            log.error("Failed to load log file: ", e);
        }

        return new byte[0];
    }
}