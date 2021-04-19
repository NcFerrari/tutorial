package streamapi;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class CteniSouboru {

    public static void main(String[] args) {
        try {
            final Path path = Paths.get("src/streamapi/Vlastenectví.txt");
            final Stream<String> lines = Files.lines(path);
            lines.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("*************************");
        try {
            final Path path = Paths.get("src/streamapi");
            final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            directoryStream.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
