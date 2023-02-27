package com.mio.server.xmlMaker;

import com.mio.server.models.Board;
import com.mio.server.models.Point;
import com.mio.server.models.World;
import com.mio.server.models.WorldConfig;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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

    public void fileToString() throws IOException {
        StringBuilder content = new StringBuilder();
        Scanner scanner = new Scanner(getFile());
        while(scanner.hasNextLine()){
            content.append(scanner.nextLine()).append("\n");
        }

        System.out.println(content);

    }

    public void worldsToXML(List<World> worlds) {


    }

    private String writeWorld(World world){
        return null;
    }

    private String writeConfig(WorldConfig worldConfig){
        return null;
    }

    private String writeBoards(List<Board> boards){
        return null;
    }

    private String writeBoxes(List<Point> boxes){
        return null;
    }

    private String writeTargets(List<Point> targets){
        return null;
    }

    private String writePlayer(Point player){
        return null;
    }

    private File getFile() {
        return new File(PATH);
    }


}
