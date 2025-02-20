package ch.heig.dai.lab.fileio.michaelstrefeler;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodingSelector {

    /**
     * Get the encoding of a file based on its extension.
     * The following extensions are recognized:
     *   - .utf8:    UTF-8
     *   - .txt:     US-ASCII
     *   - .utf16be: UTF-16BE
     *   - .utf16le: UTF-16LE
     * 
     * @param file the file to get the encoding from
     * @return the encoding of the file, or null if the extension is not recognized
     */
    public Charset getEncoding(File file) {
        String filename = file.getName();
        String extension = "";

        int i = filename.lastIndexOf('.');
        if (i > 0) {
            extension = filename.substring(i+1);
        }
        return switch (extension) {
            case "utf8" -> StandardCharsets.UTF_8;
            case "txt" -> StandardCharsets.US_ASCII;
            case "utf16be" -> StandardCharsets.UTF_16BE;
            case "utf16le" -> StandardCharsets.UTF_16LE;
            default -> null;
        };
    }
}