package basics.filehandling;

public class Theory {
}

//    What You’ve Already Learned: Character-Based File I/O
//        Feature	Description
//        File type	Text files (e.g., .txt, .csv, .log)
//        Java classes used	FileReader, BufferedReader, FileWriter, BufferedWriter, Files.readAllLines()
//        Data unit	Characters (char)
//        Encoding	Automatically handles text encoding (like UTF-8)
//        Use cases	Reading/writing text, config files, logs



//What’s New: Binary File I/O
//        Feature	Description
//        File type	Binary files (e.g., .jpg, .pdf, .zip, .exe, .class)
//        Java classes used	FileInputStream, BufferedInputStream, FileOutputStream, BufferedOutputStream, Files.copy()
//        Data unit	Bytes (byte)
//        Encoding	No encoding/decoding — reads raw binary
//        Use cases	Copying files, saving images, reading PDFs, custom binary protocols


//    When to Use What?
//        Situation	Use This I/O
//        Reading a configuration .txt file	Character I/O
//        Copying an image, PDF, or .class file	Binary I/O
//        Parsing CSV line by line	Character I/O
//        Sending/receiving raw file over network	Binary I/O