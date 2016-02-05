/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.PokemonSpeciesFlavorTextRecord;
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
public class PokemonSpeciesFlavorText extends TableImpl<PokemonSpeciesFlavorTextRecord> {

    /**
     * The reference instance of {@code pokemon_species_flavor_text}
     */
    public static final PokemonSpeciesFlavorText POKEMON_SPECIES_FLAVOR_TEXT = new PokemonSpeciesFlavorText();
    private static final long serialVersionUID = 458583464;
    /**
     * The column {@code pokemon_species_flavor_text.species_id}.
     */
    public final TableField<PokemonSpeciesFlavorTextRecord, Integer> SPECIES_ID =
            createField("species_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code pokemon_species_flavor_text.version_id}.
     */
    public final TableField<PokemonSpeciesFlavorTextRecord, Integer> VERSION_ID =
            createField("version_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code pokemon_species_flavor_text.language_id}.
     */
    public final TableField<PokemonSpeciesFlavorTextRecord, Integer> LANGUAGE_ID =
            createField("language_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code pokemon_species_flavor_text.flavor_text}.
     */
    public final TableField<PokemonSpeciesFlavorTextRecord, String> FLAVOR_TEXT =
            createField("flavor_text", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a {@code pokemon_species_flavor_text} table reference
     */
    public PokemonSpeciesFlavorText() {
        this("pokemon_species_flavor_text", null);
    }

    private PokemonSpeciesFlavorText(String alias, Table<PokemonSpeciesFlavorTextRecord> aliased) {
        this(alias, aliased, null);
    }

    private PokemonSpeciesFlavorText(String alias, Table<PokemonSpeciesFlavorTextRecord> aliased,
                                     Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code pokemon_species_flavor_text} table reference
     */
    public PokemonSpeciesFlavorText(String alias) {
        this(alias, POKEMON_SPECIES_FLAVOR_TEXT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PokemonSpeciesFlavorTextRecord> getPrimaryKey() {
        return Keys.PK_POKEMON_SPECIES_FLAVOR_TEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PokemonSpeciesFlavorTextRecord>> getKeys() {
        return Arrays.<UniqueKey<PokemonSpeciesFlavorTextRecord>>asList(Keys.PK_POKEMON_SPECIES_FLAVOR_TEXT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PokemonSpeciesFlavorTextRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PokemonSpeciesFlavorTextRecord, ?>>asList(
                Keys.FK_POKEMON_SPECIES_FLAVOR_TEXT_POKEMON_SPECIES_1, Keys.FK_POKEMON_SPECIES_FLAVOR_TEXT_VERSIONS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonSpeciesFlavorText as(String alias) {
        return new PokemonSpeciesFlavorText(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PokemonSpeciesFlavorTextRecord> getRecordType() {
        return PokemonSpeciesFlavorTextRecord.class;
    }

    /**
     * Rename this table
     */
    public PokemonSpeciesFlavorText rename(String name) {
        return new PokemonSpeciesFlavorText(name, null);
    }
}
