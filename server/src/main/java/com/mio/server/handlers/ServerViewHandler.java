package com.mio.server.handlers;

import com.mio.server.checkers.WorldChecker;
import com.mio.server.dao.WorldDAO;
import com.mio.server.dao.WorldDaoImpl;
import com.mio.server.exceptions.DuplicateWorldException;
import com.mio.server.models.*;
import com.mio.server.views.ServerView;
import com.mio.server.xmlMaker.XMLMaker;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Executors;

public class ServerViewHandler {

    private ServerView serverView;

    public ServerViewHandler(ServerView serverView) {
        this.serverView = serverView;
    }

    public void initSocket(){
        Executors.newFixedThreadPool(1).execute(() -> {
            ServerSocket server;
            Socket socket;
            DataInputStream scanner;
            DataOutputStream printWriter;

            try {
                server = new ServerSocket(50000);
                System.out.println("Servidor iniciado");
                serverView.getInfoLabel().setText("Servidor esperando...");

                while(true){
                    socket = server.accept();
                    printWriter = new DataOutputStream(socket.getOutputStream());
                    scanner = new DataInputStream(socket.getInputStream());

                    String requestInfo = scanner.readUTF();
                    serverView.getInfoLabel().setText("Petición recibida desde: "+socket.getInetAddress().getHostAddress());
                    serverView.getJsonArea().setText("Información recibida del cliente:\n"+requestInfo);
                    Response response = compileRequest(requestInfo);


//                    System.out.println(request.getRequestType()+" "+request.getWorld());

                    serverView.getXmlArea().setText("Información enviada al cliente:\n"+response.getResponse());
                    printWriter.writeUTF(response.getResponse());

                    socket.close();

//                    infoLabel.setText("Servidor esperando...");
//                    jsonArea.setText("");

                    System.out.println("Socket desconectado del servidor");

                }
            } catch (Exception e) {
                System.err.println("Something  went wrong.");
            }
        });
    }



    public Response compileRequest(String requestInfo){
        String responseContent;
        JsonParserHandler jsonParserHandler = new JsonParserHandler();

        try {
            jsonParserHandler.compile(requestInfo);
            Request request = jsonParserHandler.getValue();
            List<WorldError> errors = jsonParserHandler.getErrors();

            if(!errors.isEmpty()){
                responseContent = XMLMaker.getInstance().errorsToXML(errors);
                return new Response(responseContent);
            }
            WorldDAO worldDao = new WorldDaoImpl();

            switch (request.getRequestType()){
                case CREATE -> {
                    WorldChecker checker = new WorldChecker(errors, request.getWorld());
                    checker.checkAll();

                    if(!errors.isEmpty()){
                        responseContent = XMLMaker.getInstance().errorsToXML(errors);
                        return new Response(responseContent);
                    }

                    try {
                        World world = worldDao.create(request.getWorld());
                        responseContent = XMLMaker.getInstance().worldToXML(world);
                        return new Response(responseContent);
                    }catch (IOException e){
                        JOptionPane.showMessageDialog(null, "No se pudo leer el archivo");
                    } catch (DuplicateWorldException e){
                        WorldError error = new WorldError(request.getWorld().getName(), 0,0, ErrorType.SEMANTICO, e.getMessage());
                        errors.add(error);
                        return new Response(XMLMaker.getInstance().errorsToXML(errors));
                    }
                }
                case FIND_ALL -> {
                    List<World> worlds = worldDao.findAll();
                    if(worlds == null || worlds.isEmpty()) {
                        WorldError worldError = new WorldError(null, 0,0, ErrorType.SEMANTICO, "No se ha encontrado ningún mundo");
                        errors.add(worldError);
                        return new Response(XMLMaker.getInstance().errorsToXML(errors));
                    }

                    responseContent = XMLMaker.getInstance().worldsNameToXML(worlds);
                    return new Response(responseContent);
                }
                case FIND_BY_NAME -> {
                    World worldInfo = worldDao.findByName(request.getWorld().getName());

                    if(worldInfo == null){
                        WorldError worldError = new WorldError(null,0,0, ErrorType.SEMANTICO, "No se ha encontrado el mundo");
                        errors.add(worldError);
                        return new Response(XMLMaker.getInstance().errorsToXML(errors));
                    }

                    responseContent = XMLMaker.getInstance().worldToXML(worldInfo);

                    return new Response(responseContent);

                }
            }


        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Imposible analizar la cadena enviada");
            e.printStackTrace();
        }

        return null;
    }


    public ServerView getServerView() {
        return serverView;
    }

    public void setServerView(ServerView serverView) {
        this.serverView = serverView;
    }
}
