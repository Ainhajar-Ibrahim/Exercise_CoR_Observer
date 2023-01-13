package com.company;

import java.util.ArrayList;
import java.util.List;

public class WebServer implements WebRequestObservable {

    RequestHandler handler;
    private List<WebRequestObserver> observers = new ArrayList<WebRequestObserver>();

    WebServer(RequestHandler handler) {
        this.handler = handler;
    }

    public String getRequest(WebRequest request) {
        handler.handleRequest(request);
        notifyObservers(request);
        return "";
    }

    @Override
    public void attach(WebRequestObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(WebRequestObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(WebRequest request) {
        for (WebRequestObserver observer : observers) {
            observer.update(request);
        }
    }
}
