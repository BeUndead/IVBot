/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.PokemonFormNamesRecord;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;

/**
 * This class is generated by jOOQ.
 */
@Generated (
        value = {
                "http://www.jooq.org", "jOOQ version:3.6.2"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings ({"all", "unchecked", "rawtypes"})
public class PokemonFormNames extends TableImpl<PokemonFormNamesRecord> {

    /**
     * The reference instance of {@code pokemon_form_names}
     */
    public static final PokemonFormNames POKEMON_FORM_NAMES = new PokemonFormNames();
    private static final long serialVersionUID = 12833258;
    /**
     * The column {@code pokemon_form_names.pokemon_form_id}.
     */
    public final TableField<PokemonFormNamesRecord, Integer> POKEMON_FORM_ID =
            createField("pokemon_form_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code pokemon_form_names.local_language_id}.
     */
    public final TableField<PokemonFormNamesRecord, Integer> LOCAL_LANGUAGE_ID =
            createField("local_language_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code pokemon_form_names.form_name}.
     */
    public final TableField<PokemonFormNamesRecord, String> FORM_NAME =
            createField("form_name", org.jooq.impl.SQLDataType.VARCHAR.length(79), this, "");
    /**
     * The column {@code pokemon_form_names.pokemon_name}.
     */
    public final TableField<PokemonFormNamesRecord, String> POKEMON_NAME =
            createField("pokemon_name", org.jooq.impl.SQLDataType.VARCHAR.length(79), this, "");

    /**
     * Create a {@code pokemon_form_names} table reference
     */
    public PokemonFormNames() {
        this("pokemon_form_names", null);
    }

    private PokemonFormNames(String alias, Table<PokemonFormNamesRecord> aliased) {
        this(alias, aliased, null);
    }

    private PokemonFormNames(String alias, Table<PokemonFormNamesRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code pokemon_form_names} table reference
     */
    public PokemonFormNames(String alias) {
        this(alias, POKEMON_FORM_NAMES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PokemonFormNamesRecord> getPrimaryKey() {
        return Keys.PK_POKEMON_FORM_NAMES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PokemonFormNamesRecord>> getKeys() {
        return Arrays.<UniqueKey<PokemonFormNamesRecord>>asList(Keys.PK_POKEMON_FORM_NAMES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PokemonFormNamesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PokemonFormNamesRecord, ?>>asList(Keys.FK_POKEMON_FORM_NAMES_POKEMON_FORMS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonFormNames as(String alias) {
        return new PokemonFormNames(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PokemonFormNamesRecord> getRecordType() {
        return PokemonFormNamesRecord.class;
    }

    /**
     * Rename this table
     */
    public PokemonFormNames rename(String name) {
        return new PokemonFormNames(name, null);
    }
}