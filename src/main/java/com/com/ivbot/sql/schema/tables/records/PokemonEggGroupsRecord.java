/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.PokemonEggGroups;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class PokemonEggGroupsRecord extends UpdatableRecordImpl<PokemonEggGroupsRecord>
        implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 341860554;

    /**
     * Create a detached PokemonEggGroupsRecord
     */
    public PokemonEggGroupsRecord() {
        super(PokemonEggGroups.POKEMON_EGG_GROUPS);
    }

    /**
     * Create a detached, initialised PokemonEggGroupsRecord
     */
    public PokemonEggGroupsRecord(Integer speciesId, Integer eggGroupId) {
        super(PokemonEggGroups.POKEMON_EGG_GROUPS);

        setValue(0, speciesId);
        setValue(1, eggGroupId);
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
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return PokemonEggGroups.POKEMON_EGG_GROUPS.SPECIES_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return PokemonEggGroups.POKEMON_EGG_GROUPS.EGG_GROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getSpeciesId();
    }

    /**
     * Getter for {@code pokemon_egg_groups.species_id}.
     */
    public Integer getSpeciesId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code pokemon_egg_groups.species_id}.
     */
    public void setSpeciesId(Integer value) {
        setValue(0, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getEggGroupId();
    }

    /**
     * Getter for {@code pokemon_egg_groups.egg_group_id}.
     */
    public Integer getEggGroupId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code pokemon_egg_groups.egg_group_id}.
     */
    public void setEggGroupId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEggGroupsRecord value1(Integer value) {
        setSpeciesId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEggGroupsRecord value2(Integer value) {
        setEggGroupId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEggGroupsRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}
