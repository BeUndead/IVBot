/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.PokemonSpeciesNames;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;

/**
 * This class is generated by jOOQ.
 */
@Generated (
        value = {
                "http://www.jooq.org", "jOOQ version:3.6.2"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings ({"all", "unchecked", "rawtypes"})
public class PokemonSpeciesNamesRecord extends UpdatableRecordImpl<PokemonSpeciesNamesRecord>
        implements Record4<Integer, Integer, String, String> {

    private static final long serialVersionUID = -209576047;

    /**
     * Create a detached PokemonSpeciesNamesRecord
     */
    public PokemonSpeciesNamesRecord() {
        super(PokemonSpeciesNames.POKEMON_SPECIES_NAMES);
    }

    /**
     * Create a detached, initialised PokemonSpeciesNamesRecord
     */
    public PokemonSpeciesNamesRecord(Integer pokemonSpeciesId, Integer localLanguageId, String name, String genus) {
        super(PokemonSpeciesNames.POKEMON_SPECIES_NAMES);

        setValue(0, pokemonSpeciesId);
        setValue(1, localLanguageId);
        setValue(2, name);
        setValue(3, genus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return PokemonSpeciesNames.POKEMON_SPECIES_NAMES.POKEMON_SPECIES_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return PokemonSpeciesNames.POKEMON_SPECIES_NAMES.LOCAL_LANGUAGE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return PokemonSpeciesNames.POKEMON_SPECIES_NAMES.NAME;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return PokemonSpeciesNames.POKEMON_SPECIES_NAMES.GENUS;
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getPokemonSpeciesId();
    }

    /**
     * Getter for {@code pokemon_species_names.pokemon_species_id}.
     */
    public Integer getPokemonSpeciesId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code pokemon_species_names.pokemon_species_id}.
     */
    public void setPokemonSpeciesId(Integer value) {
        setValue(0, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getLocalLanguageId();
    }

    /**
     * Getter for {@code pokemon_species_names.local_language_id}.
     */
    public Integer getLocalLanguageId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code pokemon_species_names.local_language_id}.
     */
    public void setLocalLanguageId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * Getter for {@code pokemon_species_names.name}.
     */
    public String getName() {
        return (String) getValue(2);
    }

    /**
     * Setter for {@code pokemon_species_names.name}.
     */
    public void setName(String value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getGenus();
    }

    /**
     * Getter for {@code pokemon_species_names.genus}.
     */
    public String getGenus() {
        return (String) getValue(3);
    }

    /**
     * Setter for {@code pokemon_species_names.genus}.
     */
    public void setGenus(String value) {
        setValue(3, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonSpeciesNamesRecord value1(Integer value) {
        setPokemonSpeciesId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonSpeciesNamesRecord value2(Integer value) {
        setLocalLanguageId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonSpeciesNamesRecord value3(String value) {
        setName(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonSpeciesNamesRecord value4(String value) {
        setGenus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonSpeciesNamesRecord values(Integer value1, Integer value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }
}