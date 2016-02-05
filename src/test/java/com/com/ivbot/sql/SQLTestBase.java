package com.com.ivbot.sql;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TestBase class for all {@code SQL} tests.
 */
public abstract class SQLTestBase {

    /**
     * The URL to {@code pokedb.sqlite}.
     */
    private static final String connectionURL = "jdbc:sqlite:src/main/resources/db/pokedb.sqlite";
    /**
     * The {@code Connection} to the {@code pokedb.sqlite}.
     */
    protected static Connection connection;
    /**
     * The {@code DSLContext} for the {@code connection}, using the {@link SQLDialect#SQLITE SQLite} dialect.
     */
    protected static DSLContext context;

    /**
     * Initialises the {@code connection} and {@code context} for use in {@code SQL} tests.
     */
    @BeforeClass
    public static void setupConnection() {
        try {
            connection = DriverManager.getConnection(connectionURL);
            context = DSL.using(connection, SQLDialect.SQLITE);
        } catch (SQLException e) {
            System.err.format("%s : %s%n", e.getClass().getName(), e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e); // abort for failure
        }
    }

    /**
     * Closes the {@code connection} to {@code pokedb.sqlite}.
     */
    @AfterClass
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.format("%s : %s%n", e.getClass().getName(), e.getMessage());
            e.printStackTrace();
        }
    }

}
