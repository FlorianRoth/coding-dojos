package org.example;

public class GalgenmaennchenApp {
    private final Console console;

    public GalgenmaennchenApp(Console console) {
        this.console = console;
    }

    public static void main(String[] args) {
        new GalgenmaennchenApp(new Console()).startGame();
    }

    public void startGame(){
        console.writeLine("Bitte Wort eingeben");
        var input = console.readLine();
        new Galgenmaennchen(input);
    }
}
