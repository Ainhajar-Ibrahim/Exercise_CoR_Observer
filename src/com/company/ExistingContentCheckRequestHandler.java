package com.company;

public class ExistingContentCheckRequestHandler extends RequestHandler {
    @Override
    public void handleRequest(WebRequest request) {
        String path = request.getPath();
        if (path.equals("/dashboard") || path.equals("/home")) {
            if (this.successor != null) {
                this.successor.handleRequest(request);
            }
        } else {
            System.out.println("Status 404 : Page missing");
        }
    }
}
