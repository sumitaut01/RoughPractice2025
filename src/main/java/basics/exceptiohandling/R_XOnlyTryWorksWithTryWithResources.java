package basics.exceptiohandling;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class R_XOnlyTryWorksWithTryWithResources {
    //Notice below
    public static void main(String[] args) throws IOException {
try(Reader r=new FileReader(""))
{
    //some logic
}
}
}
