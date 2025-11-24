package basics.filehandling.filesdotlines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesLinesDemo {


    public static void main(String[] args) throws IOException {

        List<String> lines = Files.lines(Paths.get("src//main//java//basics//filehandling//filesdotlines//data.txt"))
                .collect(Collectors.toList());

        //[this is line 1, this is line 2, this is line 3]

        System.out.println(lines);

    }
}
