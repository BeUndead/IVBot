package com.com.ivbot.sql.config;

import com.com.ivbot.sql.query.QueryManager;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Generates the {@link Connection} {@code Object} used by {@code jOOQ} to handle {@code SQLite} queries to the {@code
 * pokedb.sqlite} database.
 * <p>
 * By default, it reads the configuration from {@code pokedb-sql-config.xml}.
 */
public class IVBotSQLConnectionBuilder {

    /**
     * The filepath to the {@code pokedb-sql-config.xml} {@link File}.
     */
    private static final String DEFAULT_SQL_CONFIGURATION_FILEPATH = "resources/pokedb-sql-config.xml";

    /**
     * The {@code File} of the {@code pokedb-sql-config.xml}.
     */
    private final File configurationFile;

    /**
     * The {@code String} representation of the {@code URL} to the {@code pokedb.sqlite} database.
     */
    private String connectionURL;

    /**
     * The {@code String} representation of the username with which to connect to {@code pokedb.sqlite}.
     */
    private String username;

    /**
     * The {@code String} representation of the password with which to connect to {@code pokedb.sqlite}.
     */
    private String password;

    /**
     * The {@link XMLConfiguration} to parse the {@code pokedb-sql-config.xml} {@code File}.
     */
    private XMLConfiguration xmlConfiguration;

    /**
     * The {@code Connection} to {@code pokedb.sqlite}.
     */
    private Connection connection;

    /**
     * {@code true} if the {@code Connection} is live, otherwise {@code false}.
     */
    private boolean isConnected;

    /**
     * Constructor; uses the {@code DEFAULT_SQL_CONFIGURATION_FILEPATH} as the location of the {@code
     * pokedb-sql-config.xml} {@code File}.
     */
    public IVBotSQLConnectionBuilder() {
        this(DEFAULT_SQL_CONFIGURATION_FILEPATH);
    }

    /**
     * Constructor; reads the information for the {@code Connection} from the {@code pokedb-sql-config.xml} {@code File}
     * located at {@code filePath}.
     *
     * @param filePath the path to the {@code pokedb-sql-config.xml} {@code File}.
     */
    public IVBotSQLConnectionBuilder(String filePath) {
        this.configurationFile = new File(filePath);
        readValuesFromFile();
    }

    private void readValuesFromFile() {
        try {
            Parameters parameters = new Parameters();
            FileBasedConfigurationBuilder<XMLConfiguration> builder =
                    new FileBasedConfigurationBuilder<>(XMLConfiguration.class)
                            .configure(parameters.xml().setFile(configurationFile));

            xmlConfiguration = builder.getConfiguration();
        } catch (ConfigurationException e) {
            System.err.format("%s : %s%n", e.getClass().getName(), e.getMessage());
            throw new RuntimeException(e);
        }

        connectionURL = xmlConfiguration.getString("connection.url");
        username = xmlConfiguration.getString("connection.username");
        password = xmlConfiguration.getString("connection.password");

        try {
            this.attemptConnect();
        } catch (SQLException e) {
            System.err.format("Couldn't establish Connection: %s%n", e.getMessage());
        }

        if (isConnected) {
            QueryManager.setContext(connection);
        }
    }

    /**
     * Attempts to generate the {@code Connection} from the read in values for {@code connectionURL}, {@code username}
     * and {@code password}.
     *
     * @throws SQLException if there is an issue when generating the {@code Connection}.
     */
    public void attemptConnect() throws SQLException {
        isConnected = false;
        connection = DriverManager.getConnection(connectionURL, username, password);
        isConnected = true;
    }

    /**
     * {@code true} if the {@code Connection} is currently live, otherwise {@code false}.
     *
     * @return {@code true} if the {@code Connection} is currently live, otherwise {@code false}.
     */
    public boolean isConnected() {
        return isConnected;
    }

    /**
     * Gives the {@code Connection} to the {@code pokedb.sqlite} database.
     *
     * @return the {@code Connection} to the {@code pokedb.sqlite} database
     */
    public Connection getConnection() {
        if (!isConnected) {
            return null;
        }
        return connection;
    }

}
