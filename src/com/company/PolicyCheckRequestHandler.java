package com.company;

public class PolicyCheckRequestHandler extends RequestHandler {

    @Override
    public void handleRequest(WebRequest request) {
        User user = request.getLoggedUser();
        String path = request.getPath();
        if (!user.isAdmin() && path.equals("/dashboard")) {
            System.out.println("Status 403 : user is not authorized to access this content");
        } else {
            if (this.successor != null) {
                this.successor.handleRequest(request);
            }
        }
    }
}
