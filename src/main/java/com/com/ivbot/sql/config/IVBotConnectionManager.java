package com.com.ivbot.sql.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;

/**
 * Statically handles the {@link Connection} to the {@code pokedb.sqlite} database.
 */
public class IVBotConnectionManager {

    /**
     * The {@code IVBotSQLConnectionBuilder} from which to build the {@code Connection}.
     */
    private static final IVBotSQLConnectionBuilder connectionBuilder = new IVBotSQLConnectionBuilder();

    /**
     * The {@code Connection} to {@code pokedb.sqlite}.
     */
    private static final Connection connection = connectionBuilder.getConnection();

    /**
     * The {@link DSLContext Context} from which to execute queries to {@code pokedb.sqlite}.
     */
    private static final DSLContext context = DSL.using(connection, SQLDialect.SQLITE);

    /**
     * Returns an instance of a {@code Connection} to the {@code pokedb.sqlite} database.
     *
     * @return a {@code Connection} to {@code pokedb.sqlite}.
     */
    public static final Connection getConnection() {
        return connection;
    }

    /**
     * Returns an instance of a {@code DSLContext} from which to execute queries to the {@code pokedb.sqlite} database.
     *
     * @return a {@code DSLContext} from which to execute queries to {@code pokedb.sqlite}.
     */
    public static final DSLContext getContext() {
        return context;
    }

}
