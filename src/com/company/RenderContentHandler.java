package com.company;

public class RenderContentHandler extends RequestHandler {
    @Override
    public void handleRequest(WebRequest request) {
        String path = request.getPath();
        if (path.equals("/dashboard")) {
            System.out.println("Status 200 : Dashboard content here");
        } else if (path.equals("/home")) {
            System.out.println("Status 200 : Home content here");
        }
    }
}
