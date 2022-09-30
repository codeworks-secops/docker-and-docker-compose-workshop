package fr.words.api.constant;

public enum WordsTypeEnum {

    NOUNS("/noun", "nouns"),
    VERBS("/verb", "verbs"),
    ADJECTIVES("/adjective", "adjectives");

    private final String path;
    private final String table;

    WordsTypeEnum(String path, String table) {
        this.path = path;
        this.table = table;
    }

    public String getPath() {
        return path;
    }

    public String getTable() {
        return table;
    }
}
