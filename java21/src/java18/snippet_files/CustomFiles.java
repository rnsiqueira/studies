package java18.snippet_files;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * Class consists of static methods that operate on files.
 */
public class CustomFiles {

    public static void copy(InputStream in, Path target, CopyOption... options)
            throws IOException
    {

        Objects.requireNonNull(in);
        // @start region="copytofile"
        // /* check for REPLACE_EXISTING */
        boolean replaceExisting = false;

        Path path = Path.of("...");
        URI u = URI.create("http://www.example.com/");
        try (InputStream is = u.toURL().openStream()) {
            Files.copy(is,path,StandardCopyOption.REPLACE_EXISTING);
        }
        // @end
     }
}
