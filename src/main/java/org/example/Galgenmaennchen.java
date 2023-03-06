package org.example;

public class Galgenmaennchen {

    private final char[] gesuchtesWort;
    private final char[] ergebnisWort;

    public Galgenmaennchen(String gesuchtesWort) {
        this.gesuchtesWort = gesuchtesWort.toCharArray();
        this.ergebnisWort = "-".repeat(gesuchtesWort.length()).toCharArray();
    }

    public String rateBuchstabe(char buchstabe) {
        for (var i = 0; i < gesuchtesWort.length; i++) {
            if (Character.toLowerCase(gesuchtesWort[i]) == Character.toLowerCase(buchstabe)) {
                ergebnisWort[i] = gesuchtesWort[i];
            }
        }
        return new String(ergebnisWort);
    }

}
