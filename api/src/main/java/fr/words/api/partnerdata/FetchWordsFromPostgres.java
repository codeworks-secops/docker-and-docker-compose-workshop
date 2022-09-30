package fr.words.api.partnerdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

public class FetchWordsFromPostgres implements FetchWords {

    private static final String POSTGRES_HOST_SERVICE = System.getenv("POSTGRES_HOST_SERVICE");

    @Override
    public String randomWord(String table) {
        final String jdbcUrl = "jdbc:postgresql://" + POSTGRES_HOST_SERVICE + ":5432/postgres";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, "postgres", "pass")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet set = statement.executeQuery("SELECT word FROM " + table + " ORDER BY random() LIMIT 1")) {
                    while (set.next()) {
                        return set.getString(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new NoSuchElementException(table);
    }

    @Override
    public void loadDriver() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }
}
