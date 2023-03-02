package com.mio.server.xmlMaker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileMaker {

    private final String PATH = "src/main/resources/com/mio/server/xml/worlds.xml";
    private static FileMaker fileMaker;

    private FileMaker(){}

    public static FileMaker getInstance(){
        if(fileMaker == null){
            fileMaker = new FileMaker();
        }
        return fileMaker;
    }

    public String read() throws IOException {
        StringBuilder content = new StringBuilder();
        Scanner scanner = new Scanner(getFile());
        while(scanner.hasNextLine()){
            content.append(scanner.nextLine()).append("\n");
        }
        return content.toString();
    }

    public void write(String content) throws IOException {
        FileWriter writer = new FileWriter(getFile());
        writer.write(content);
        writer.close();
    }

    private File getFile() {
        return new File(PATH);
    }


}
