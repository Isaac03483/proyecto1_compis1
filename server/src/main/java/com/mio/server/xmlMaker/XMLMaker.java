package com.mio.server.xmlMaker;

import com.mio.server.builders.BoardBuilder;
import com.mio.server.builders.PointBuilder;
import com.mio.server.builders.WConfigBuilder;
import com.mio.server.builders.WorldBuilder;
import com.mio.server.compiler.parser.XMLParserHandle;
import com.mio.server.compiler.parser.XMLParserSym;
import com.mio.server.models.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.mio.server.xmlMaker.XMLTag.*;

public class XMLMaker {

    private static XMLMaker maker;
    private XMLMaker(){

    }

    public static XMLMaker getInstance(){
        if(maker == null){
            maker = new XMLMaker();
        }
        return maker;
    }

    public String worldsToXML(List<World> worlds){
        StringBuilder content = new StringBuilder();
        content.append(HEADER).append("\n").append(WORLDS_A).append("\n");
        worlds.forEach(world ->
                content.append("\t").append(WORLD_A).append("\n\t\t")
                .append(NAME_A).append(world.getName()).append(NAME_C).append("\n\t\t")
                .append(ROWS_A).append(world.getRows()).append(ROWS_C).append("\n\t\t")
                .append(COLS_A).append(world.getCols()).append(COLS_C).append("\n\t\t")
                .append(configToXML(world.getWorldConfig())).append("\n")
                .append(boardToXML(world.getBoard())).append("\n")
                .append(boxesToXML(world.getBoxes())).append("\n")
                .append(targetsToXML(world.getTargets())).append("\n\t\t")
                .append(PLAYER_A).append(pointToXML(world.getPlayer())).append(PLAYER_C).append("\n\t")
                .append(WORLD_C).append("\n")
        );

        content.append(WORLDS_C);
        return content.toString();
    }

    private String pointToXML(Point point) {
        return "\n\t\t\t" + PX_A + point.getPosX() + PX_C + "\n\t\t\t" +
                PY_A+point.getPosY()+PY_C+"\n\t\t";
    }

    private String boardToXML(List<Board> boards){
        StringBuilder content = new StringBuilder();
        boards.forEach(board ->
                content.append("\t\t").append(BOARD_A)
                        .append(pointToXML(board.getPoint()))
                        .append("\t").append(TYPE_A)
                        .append(XMLParserSym.terminalNames[board.getType()])
                        .append(TYPE_C).append("\n\t\t")
                        .append(BOARD_C).append("\n")
        );
        return content.toString();
    }

    private String boxesToXML(List<Point>boxes){
        StringBuilder content = new StringBuilder();
        boxes.forEach(box ->
                content.append("\t\t").append(BOXES_A)
                .append(pointToXML(box))
                .append(BOXES_C).append("\n"));
        return content.toString();
    }

    private String targetsToXML(List<Point> targets){
        StringBuilder content = new StringBuilder();
        targets.forEach(target ->
                content.append("\t\t").append(TARGETS_A)
                .append(pointToXML(target))
                .append(TARGETS_C).append("\n")
        );
        return content.toString();
    }

    private String configToXML(WorldConfig config){
        return CONFIG_A + "\n\t\t\t"
                +BC_A+config.getBoxColor()+BC_C+"\n\t\t\t"
                +BOTC_A+config.getBoxOnTargetColor()+BOTC_C+"\n\t\t\t"
                +TC_A+config.getTargetColor()+TC_C+"\n\t\t\t"
                +BRC_A+config.getBrickColor()+BRC_C+"\n\t\t\t"
                +HC_A+config.getHallColor()+HC_C+"\n\t\t\t"
                +UC_A+config.getUndefinedColor()+UC_C+"\n\t\t\t"
                +PC_A+config.getPlayerColor()+PC_C+"\n\t\t"
                +CONFIG_C+"\n";
    }

/*
    public static void main(String[] args) {
        List<World> worlds = Arrays.asList(
                new World(new WorldBuilder().withName("nombre1")
                        .withRows(4)
                        .withCols(2)
                        .withConfig(new WConfigBuilder().withBoxColor("#ffffff").withBoxOnTargetColor("#f1f2f3")
                                .withTargetColor("#f1f2f3").withBrickColor("#f1f2b3").withHallColor("#f1f2f7")
                                .withUndefinedColor("#f1f223").withPlayerColor("#f1f2f9").build())
                        .withBoard(new BoardBuilder().withType(33).withPoint(new PointBuilder().withPosY(25).withPosX(49).build()).build())
                        .withBoard(new BoardBuilder().withType(32).withPoint(new PointBuilder().withPosY(7).withPosX(6).build()).build())
                        .withBox(new PointBuilder().withPosX(54).withPosY(9).build())
                        .withBox(new PointBuilder().withPosX(14).withPosY(10).build())
                        .withTarget(new PointBuilder().withPosX(26).withPosY(9).build())
                        .withTarget(new PointBuilder().withPosX(18).withPosY(11).build())
                        .withPlayer(new PointBuilder().withPosY(60).withPosX(2).build())

                ),
                new World(new WorldBuilder().withName("nombre2")
                        .withRows(4)
                        .withCols(5)
                        .withConfig(new WConfigBuilder().withBoxColor("#f56fff").withBoxOnTargetColor("#f1f2f3")
                                .withTargetColor("#f1f223").withBrickColor("#f1a2b3").withHallColor("#f1e2f7")
                                .withUndefinedColor("#f4f223").withPlayerColor("#b1f2f9").build())
                        .withBoard(new Board(new BoardBuilder().withType(32).withPoint(new Point(new PointBuilder().withPosY(25).withPosX(49)))))
                        .withBoard(new Board(new BoardBuilder().withType(33).withPoint(new Point(new PointBuilder().withPosY(7).withPosX(6)))))
                        .withBox(new Point(new PointBuilder().withPosX(14).withPosY(9)))
                        .withBox(new Point(new PointBuilder().withPosX(134).withPosY(810)))
                        .withTarget(new Point(new PointBuilder().withPosX(24).withPosY(9)))
                        .withTarget(new Point(new PointBuilder().withPosX(134).withPosY(120)))
                        .withPlayer(new Point(new PointBuilder().withPosY(69).withPosX(24)))

                )
        );

        XMLMaker maker = XMLMaker.getInstance();
        String content = maker.worldsToXML(worlds);
        XMLParserHandle parserHandle = new XMLParserHandle();
        try {
            List<World> worlds1 = parserHandle.compile(content);
//            worlds1.forEach(System.out::println);
            FileMaker fileMaker = FileMaker.getInstance();
            fileMaker.write(maker.worldsToXML(worlds));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }*/

}
