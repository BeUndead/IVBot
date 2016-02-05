package com.com.ivbot.sql.query;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;

/**
 * Handles {@code Query}s to the {@code pokedb.sqlite}.
 */
public class QueryManager {

    /**
     * The {@link DSLContext} used to execute queries to {@code pokedb.sqlite}.
     */
    private static DSLContext context;

    /**
     * Get the instance of the {@code DSLContext}.
     *
     * @return The instance of the {@code DSLContext} on which to execute queries.
     */
    public static DSLContext getContext() {
        return context;
    }

    /**
     * Sets the {@code DSLContext} using the given {@code Connection}.
     *
     * @param connection The {@code Connection} to {@code pokedb.sqlite}.
     */
    public static void setContext(Connection connection) {
        context = DSL.using(connection, SQLDialect.SQLITE);
        Query.context = context;
    }

}
