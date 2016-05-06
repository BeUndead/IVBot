package com.com.ivbot.sql.generation;

import org.jooq.util.GenerationTool;

/**
 * Run this class with the command-line argument {@code generation-config.xml} to generate the schema classes used for
 * the {@code SQLite} {@link java.sql.Connection Connection} used.
 */
public class SchemaGenerator extends GenerationTool {

    /**
     * Runs the {@link GenerationTool#main} method, which generates the required {@code com.com.ivbot.sql.schema}
     * classes.
     *
     * @param args Command line arguments, unused.
     * @throws Exception If {@code GenerationTool#main} throws an {@link Exception}.
     */
    public static void main(String[] args) throws Exception {
        GenerationTool.main(new String[] {"generation-config.xml"});
    }
}
