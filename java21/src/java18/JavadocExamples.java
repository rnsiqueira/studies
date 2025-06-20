package java18;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Path;

/**
 * Example shows pre,code,@code,@snippet tags.
 */
public class JavadocExamples {

    private JavadocExamples(){}

    /**
     * <pre>
     *     Line breaks will be maintained
     *
     *          along with indentation,however, special characters like
     *     '&#64;','&lt;' and '&gt;' need to be escaped if we want to write
     *     &#64;Override,List&lt;String&gt;,Stream&lt;String&gt;
     *
     *     Stream&lt;String&gt; lines = Files.lines(path, StandardCharsets.UTF_8);
     *     Stream&lt;String&gt; words = lines.flatMap(line -> Stream.of(line.split(" +")));
     *
     *     What about <b>this</b> text that needs to be in bold ?
     * </pre>
     */
    public void usingPreHtmlTag(){
    }

    /**
     * <code>
     *     Line breaks will not be maintained
     *
     *          along with indentation,however, special characters like
     *     '&#64;','&lt;' and '&gt;' need to be escaped if we want to write
     *     &#64;Override,List&lt;String&gt;,Stream&lt;String&gt;
     *
     *     Stream&lt;String&gt; lines = Files.lines(path, StandardCharsets.UTF_8);
     *     Stream&lt;String&gt; words = lines.flatMap(line -> Stream.of(line.split(" +")));
     *
     *     What about <b>this</b> text that needs to be in bold ?
     * </code>
     */
    public void usingCodeHtmlTag(){
    }

    /**
     * {@code
     *     Line breaks will not be maintained
     *
     *          along with indentation,however, special characters like
     *     '@','<' and '>' don't need to be escaped if we want to write
     *     @Override,List<String>,Stream<String>
     *
     *     Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
     *     Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
     *
     *     What about <b>this</b> text that needs to be in bold ?
     * }
     */
    public void usingAtCodeTag(){
    }

    /**
     * <pre>{@code
     * Line breaks will be maintained
     *
     *      along with indentation,however,special characters like
     * '@','<' and '>' don't need to be escaped if we want to write
     * @Override,List<String>,Stream<String>
     *
     *      Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
     *      Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
     *
     * What about <b>this</b> text that needs to be in bold ?
     * }</pre>
     */
    public void usingPreAndAtCodeTags(){
    }

    /**
     * Copies all bytes from an input stream to a file
     * {@snippet lang=java :
     *     Path path = ...
     *     URI u = URI.create("http://www.example.com/");
     *     try (InputStream in = u.toURL().openStream()) {
     *         Files.copy(in, path,StandardCopyOption.REPLACE_EXISTING);
     *     }
     *
     *     Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
     *     Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
     * }
     * @param   in
     *          the input stream to read from
     * @param   target
     *          the path to the file
     * @param   options
     *          options specifying how the copy should be done
     * @throws  IOException
     *          if an I/O error occurs when reading or writing
     */
    public void copyUsingSnippetTagInline(InputStream in, Path target, CopyOption... options) throws IOException{
    }


    /**
     * Copies all bytes from an input stream to a file.Shows @replace
     * {@snippet lang=java :
     *   Path path = ...
     *   URI u = URI.create("http://www.example.com/"); // @replace regex='".*"' replacement="..."
     *   try (InputStream in = u.toURL().openStream()) {
     *        Files.copy(in, path,StandardCopyOption.REPLACE_EXISTING);
     *   }
     * }
     * @param   in
     *          the input stream to read from
     * @param   target
     *          the path to the file
     * @param   options
     *          options specifying how the copy should be done
     * @throws  IOException
     *          if an I/O error occurs when reading or writing
     */
    public void copyUsingSnippetTagInlineReplaceText(InputStream in, Path target, CopyOption... options) throws IOException{
    }

    /**
     * Copies all bytes from an input stream to a file.Shows @highlight
     * {@snippet lang=java :
     *     Path path = ...
     *     URI u = URI.create("http://www.example.com/");
     *     try (InputStream in = u.toURL().openStream()) { // @highlight substring="toURL"
     *         Files.copy(in, path,StandardCopyOption.REPLACE_EXISTING);
     *     }
     * }
     * @param   in
     *          the input stream to read from
     * @param   target
     *          the path to the file
     * @param   options
     *          options specifying how the copy should be done
     * @throws  IOException
     *          if an I/O error occurs when reading or writing
     */
    public void copyUsingSnippetTagInlineHighlightText(InputStream in, Path target, CopyOption... options) throws IOException{
    }

    /**
     * Copies all bytes from an input stream to a file.
     * {@snippet class=CustomFiles region="copytofile"}
     * @param   in
     *          the input stream to read from
     * @param   target
     *          the path to the file
     * @param   options
     *          options specifying how the copy should be done
     * @throws  IOException
     *          if an I/O error occurs when reading or writing
     */
    public void copyUsingSnippetTagExternal(InputStream in, Path target, CopyOption... options) throws IOException{
    }

    /**
     * Shows example of including/using properties in documenting API's
     * {@snippet lang=properties :
     *  key1=value1
     *  key2=value2
     *  # @highlight substring="value3" :
     *  key3=value3
     * }
     */
    public void usingSnippetTagProperties(){
    }


    /**
     * Shows example of using an external property file for documenting API's
     * {@snippet file="config.properties"}
     */
    public void usingSnippetTagExternalProperties(){
    }

}