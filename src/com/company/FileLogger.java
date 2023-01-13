package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogger implements WebRequestObserver {
    String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
        try {
            Files.deleteIfExists(Paths.get(this.filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void log(String msg) {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(this.filePath, true));
            out.println(msg);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(WebRequest request) {
        String user;
        if (request.getLoggedUser().isAdmin()) {
            user = "admin user";
        } else {
            user = "non admin user";
        }

        String msg = "Request made to " +
                request.getPath() + " by " + user;
        log(msg);
    }
}