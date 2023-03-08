package com.mio.server.xmlMaker;

import com.mio.server.builders.BoardBuilder;
import com.mio.server.builders.PointBuilder;
import com.mio.server.builders.WConfigBuilder;
import com.mio.server.builders.WorldBuilder;
import com.mio.server.compiler.parser.JsonParserHandle;
import com.mio.server.compiler.parser.ParserHandle;
import com.mio.server.compiler.parser.XMLParserHandle;
import com.mio.server.compiler.parser.XMLParserSym;
import com.mio.server.models.*;
import com.mio.server.models.Error;
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
                content.append(worldToXML(world))
        );

        content.append(WORLDS_C);
        return content.toString();
    }

    private String worldToXML(World world) {
        return  "\t" + WORLD_A + "\n\t\t" +
                NAME_A + world.getName() + NAME_C + "\n\t\t" +
                ROWS_A + world.getRows() + ROWS_C + "\n\t\t" +
                COLS_A + world.getCols() + COLS_C + "\n\t\t" +
                configToXML(world.getWorldConfig()) + "\n" +
                boardToXML(world.getBoard()) + "\n" +
                boxesToXML(world.getBoxes()) + "\n" +
                targetsToXML(world.getTargets()) + "\n\t\t" +
                PLAYER_A + pointToXML(world.getPlayer()) + PLAYER_C + "\n\t" +
                WORLD_C + "\n";
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

    public String errorsToXML(List<Error> errors){
        StringBuilder content = new StringBuilder();
        content.append(HEADER).append("\n").append(ERRORS_A).append("\n\t");
        errors.forEach(error ->
            content.append(errorToXML(error))
        );
        content.append(ERRORS_C);
        return content.toString();
    }

    private String errorToXML(Error error) {
        return ERROR_A+"\n\t\t"+
                LEXEME_A+error.value()+LEXEME_C+"\n\t\t"+
                LINE_A+error.line()+LINE_C+"\n\t\t"+
                COLUMN_A+error.column()+COLUMN_C+"\n\t\t"+
                TYPE_A+error.errorType()+TYPE_C+"\n\t\t"+
                DESCRIPTION_A+error.description()+DESCRIPTION_C+"\n\t"+
                ERROR_C;
    }


    public static void main(String[] args) {
        /*
        List<World> worlds = Arrays.asList(
                new World(new WorldBuilder().withName("nombre1")
                        .withRows(4.0)
                        .withCols(2.0)
                        .withConfig(new WConfigBuilder().withBoxColor("#ffffff").withBoxOnTargetColor("#f1f2f3")
                                .withTargetColor("#f1f2f3").withBrickColor("#f1f2b3").withHallColor("#f1f2f7")
                                .withUndefinedColor("#f1f223").withPlayerColor("#f1f2f9").build())
                        .withBoard(new BoardBuilder().withType(33).withPoint(new PointBuilder().withPosY(25.0).withPosX(49.0).build()).build())
                        .withBoard(new BoardBuilder().withType(32).withPoint(new PointBuilder().withPosY(7.0).withPosX(6.0).build()).build())
                        .withBox(new PointBuilder().withPosX(54.0).withPosY(9.0).build())
                        .withBox(new PointBuilder().withPosX(14.0).withPosY(1.0).build())
                        .withTarget(new PointBuilder().withPosX(26.0).withPosY(9.0).build())
                        .withTarget(new PointBuilder().withPosX(18.0).withPosY(11.0).build())
                        .withPlayer(new PointBuilder().withPosY(6.0).withPosX(2.0).build())

                ),
                new World(new WorldBuilder().withName("nombre2")
                        .withRows(4.0)
                        .withCols(5.0)
                        .withConfig(new WConfigBuilder().withBoxColor("#f56fff").withBoxOnTargetColor("#f1f2f3")
                                .withTargetColor("#f1f223").withBrickColor("#f1a2b3").withHallColor("#f1e2f7")
                                .withUndefinedColor("#f4f223").withPlayerColor("#b1f2f9").build())
                        .withBoard(new Board(new BoardBuilder().withType(32).withPoint(new Point(new PointBuilder().withPosY(25.0).withPosX(49.0)))))
                        .withBoard(new Board(new BoardBuilder().withType(33).withPoint(new Point(new PointBuilder().withPosY(7.0).withPosX(6.0)))))
                        .withBox(new Point(new PointBuilder().withPosX(14.0).withPosY(9.0)))
                        .withBox(new Point(new PointBuilder().withPosX(134.0).withPosY(81.0)))
                        .withTarget(new Point(new PointBuilder().withPosX(24.0).withPosY(9.0)))
                        .withTarget(new Point(new PointBuilder().withPosX(134.0).withPosY(12.0)))
                        .withPlayer(new Point(new PointBuilder().withPosY(69.0).withPosX(24.0)))

                )
        );

        XMLMaker maker = XMLMaker.getInstance();
        String content = maker.worldsToXML(worlds);*/
        String content = "{\n" +
                "  \"name\": \"nombrePrueba\",\n" +
                "  \"rows\": 4,\n" +
                "  \"cols\": 4,\n" +
                "  \"config\": {\n" +
                "    \"box_color\": \"#ffff00\",\n" +
                "    \"box_on_target_color\": \"#fe0002\",\n" +
                "    \"target_color\": \"#d6fe0a\",\n" +
                "    \"brick_color\": \"#bdbebf\",\n" +
                "    \"hall_color\": \"#0001ff\",\n" +
                "    \"undefined_color\": \"#303030\",\n" +
                "    \"player_color\": \"#ff00f7\"\n" +
                "  },\n" +
                "  \"board\": [\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"2 * 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"9 / 3 * 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 0,\n" +
                "      \"posY\": \"10 / 2 - 1\",\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"2 / 2\",\n" +
                "      \"posY\": 0,\n" +
                "      \"type\": \"BRICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"10 - 3 * 3\",\n" +
                "      \"posY\": \"3 * 2 - 5\",\n" +
                "      \"type\": \"HALL\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 1,\n" +
                "      \"posY\": \"2 * 1\",\n" +
                "      \"type\": \"HALL\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"boxes\": [\n" +
                "    {\n" +
                "      \"posX\": 2,\n" +
                "      \"posY\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": 2,\n" +
                "      \"posY\": \"1 + 1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"targets\": [\n" +
                "    {\n" +
                "      \"posX\": \"4 / 2 + 1\",\n" +
                "      \"posY\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"posX\": \"4 / 2 + 1\",\n" +
                "      \"posY\": \"1 * 1 + 1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"player\": {\n" +
                "    \"posX\": 1,\n" +
                "    \"posY\": \"(5 + 2) / (3 + 4)\"\n" +
                "  }\n" +
                "}";
        JsonParserHandle parserHandle = new JsonParserHandle();
        try {
            World worlds1 = parserHandle.compile(content);
            System.out.println("worlds1 = " + worlds1);
//            worlds1.forEach(System.out::println);
            /*FileMaker fileMaker = FileMaker.getInstance();
            fileMaker.write(maker.worldsToXML(worlds));*/

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
