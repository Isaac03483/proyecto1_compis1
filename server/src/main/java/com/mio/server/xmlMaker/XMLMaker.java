package com.mio.server.xmlMaker;

import com.mio.server.compiler.parser.JsonParserSym;
import com.mio.server.compiler.parser.XMLParserSym;
import com.mio.server.models.*;
import com.mio.server.models.WorldError;

import java.util.ArrayList;
import java.util.List;

import static com.mio.server.xmlMaker.XMLTag.*;

public class XMLMaker {

    private static XMLMaker maker;

    private XMLMaker() {

    }

    public static XMLMaker getInstance() {
        if (maker == null) {
            maker = new XMLMaker();
        }
        return maker;
    }

    public String worldsToXML(List<World> worlds) {
        StringBuilder content = new StringBuilder();
        content.append(HEADER).append("\n").append(WORLDS_A).append("\n");
        worlds.forEach(world ->
                content.append("\t" + WORLD_A + "\n\t\t" + NAME_A)
                        .append(world.getName()).append(NAME_C)
                        .append("\n\t\t")
                        .append(ROWS_A).append(world.getRows().intValue()).append(ROWS_C)
                        .append("\n\t\t").
                        append(COLS_A).append(world.getCols().intValue()).append(COLS_C)
                        .append("\n\t\t")
                        .append(configToXML(world.getWorldConfig()))
                        .append("\n")
                        .append(boardToXML(world.getBoard()))
                        .append("\n").append(boxesToXML(world.getBoxes()))
                        .append("\n").append(targetsToXML(world.getTargets()))
                        .append("\n\t\t")
                        .append(PLAYER_A).append(pointToXML(world.getPlayer())).append(PLAYER_C)
                        .append("\n\t")
                        .append(WORLD_C).append("\n")
        );

        content.append(WORLDS_C);

        return content.toString();
    }

    public String worldToXML(World world) {
        return HEADER + "\n" +
                WORLD_A + "\n\t" +
                NAME_A + world.getName() + NAME_C + "\n\t" +
                ROWS_A + world.getRows().intValue() + ROWS_C + "\n\t" +
                COLS_A + world.getCols().intValue() + COLS_C + "\n\t\t" +
                configToXML(world.getWorldConfig()) +"\n\t" +
                boardToXML(world.getBoard()) + "\n\t" +
                boxesToXML(world.getBoxes()) + "\n\t" +
                targetsToXML(world.getTargets())+ "\n\t\t" +
                PLAYER_A+ pointToXML(world.getPlayer())+PLAYER_C +
                "\n" + WORLD_C;
    }

    private String pointToXML(Point point) {
        return "\n\t\t\t" + PX_A + point.getPosX().intValue() + PX_C + "\n\t\t\t" +
                PY_A + point.getPosY().intValue() + PY_C + "\n\t\t";
    }

    private String boardToXML(List<Board> boards) {
        StringBuilder content = new StringBuilder();
        boards.forEach(board ->
                content.append("\t\t").append(BOARD_A)
                        .append(pointToXML(board.getPoint()))
                        .append("\t").append(TYPE_A)
                        .append(board.getType())
                        .append(TYPE_C).append("\n\t\t")
                        .append(BOARD_C).append("\n")
        );
        return content.toString();
    }

    private String boxesToXML(List<Point> boxes) {
        StringBuilder content = new StringBuilder();
        boxes.forEach(box ->
                content.append("\t\t").append(BOXES_A)
                        .append(pointToXML(box))
                        .append(BOXES_C).append("\n"));
        return content.toString();
    }

    private String targetsToXML(List<Point> targets) {
        StringBuilder content = new StringBuilder();
        targets.forEach(target ->
                content.append("\t\t").append(TARGETS_A)
                        .append(pointToXML(target))
                        .append(TARGETS_C).append("\n")
        );
        return content.toString();
    }

    private String configToXML(WorldConfig config) {
        return CONFIG_A + "\n\t\t\t"
                + BC_A + config.getBoxColor() + BC_C + "\n\t\t\t"
                + BOTC_A + config.getBoxOnTargetColor() + BOTC_C + "\n\t\t\t"
                + TC_A + config.getTargetColor() + TC_C + "\n\t\t\t"
                + BRC_A + config.getBrickColor() + BRC_C + "\n\t\t\t"
                + HC_A + config.getHallColor() + HC_C + "\n\t\t\t"
                + UC_A + config.getUndefinedColor() + UC_C + "\n\t\t\t"
                + PC_A + config.getPlayerColor() + PC_C + "\n\t\t"
                + CONFIG_C + "\n";
    }

    public String errorsToXML(List<WorldError> errors) {
        StringBuilder content = new StringBuilder();
        content.append(HEADER).append("\n").append(ERRORS_A).append("\n\t");
        errors.forEach(error ->
                content.append(errorToXML(error))
        );
        content.append(ERRORS_C);
        return content.toString();
    }

    private String errorToXML(WorldError error) {
        return ERROR_A + "\n\t\t" +
                LEXEME_A + error.value() + LEXEME_C + "\n\t\t" +
                LINE_A + error.line() + LINE_C + "\n\t\t" +
                COLUMN_A + error.column() + COLUMN_C + "\n\t\t" +
                TYPE_A + error.errorType() + TYPE_C + "\n\t\t" +
                DESCRIPTION_A + error.description() + DESCRIPTION_C + "\n\t" +
                ERROR_C+"\n";
    }

    public String worldsNameToXML(List<World> worlds) {
        StringBuilder content = new StringBuilder();
        content.append(HEADER).append("\n").append(WORLDS_A).append("\n");

        worlds.forEach(world -> {
            content.append("\t").append(WORLD_A).append(world.getName()).append(WORLD_C).append("\n");
        });
        content.append(WORLDS_C);

        return content.toString();
    }

}
