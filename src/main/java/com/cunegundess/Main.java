package com.cunegundess;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main.java <username>");
            return;
        }

        String username = args[0];
        GithubAPI.fetchAPI(username);
    }
}

