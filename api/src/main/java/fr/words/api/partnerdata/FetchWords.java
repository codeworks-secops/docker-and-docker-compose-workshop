package fr.words.api.partnerdata;

public interface FetchWords {

    String randomWord(String table);

    void loadDriver() throws ClassNotFoundException;
}
