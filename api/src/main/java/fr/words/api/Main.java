package fr.words.api;

import com.sun.net.httpserver.HttpServer;
import fr.words.api.constant.WordsTypeEnum;
import fr.words.api.partnerdata.FetchWords;
import fr.words.api.partnerdata.FetchWordsFromPostgres;
import fr.words.api.response.DataHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws Exception {

        FetchWords fetchWords = new FetchWordsFromPostgres();

        fetchWords.loadDriver();

        startAndInitHttpServer(fetchWords, new DataHandler());
    }

    private static void startAndInitHttpServer(FetchWords fetchWords, DataHandler dataHandler) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        createContext(fetchWords, dataHandler, server, WordsTypeEnum.NOUNS.getPath(), WordsTypeEnum.NOUNS.getTable());

        createContext(fetchWords, dataHandler, server, WordsTypeEnum.VERBS.getPath(), WordsTypeEnum.VERBS.getTable());

        createContext(fetchWords, dataHandler, server, WordsTypeEnum.ADJECTIVES.getPath(), WordsTypeEnum.ADJECTIVES.getTable());

        server.start();
    }

    private static void createContext(FetchWords fetchWords, DataHandler dataHandler, HttpServer server, String path, String wordType) {
        server.createContext(path, dataHandler.handler(() -> fetchWords.randomWord(wordType)));
    }

}