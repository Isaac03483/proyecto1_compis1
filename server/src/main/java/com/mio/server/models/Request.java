package com.mio.server.models;

public class Request {

    private RequestType requestType;
    private World world;

    public Request(RequestType requestType, World world) {
        this.requestType = requestType;
        this.world = world;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
