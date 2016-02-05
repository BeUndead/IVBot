/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.PokemonEggGroupsRecord;
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
public class PokemonEggGroups extends TableImpl<PokemonEggGroupsRecord> {

    /**
     * The reference instance of {@code pokemon_egg_groups}
     */
    public static final PokemonEggGroups POKEMON_EGG_GROUPS = new PokemonEggGroups();
    private static final long serialVersionUID = -1701589521;
    /**
     * The column {@code pokemon_egg_groups.species_id}.
     */
    public final TableField<PokemonEggGroupsRecord, Integer> SPECIES_ID =
            createField("species_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code pokemon_egg_groups.egg_group_id}.
     */
    public final TableField<PokemonEggGroupsRecord, Integer> EGG_GROUP_ID =
            createField("egg_group_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a {@code pokemon_egg_groups} table reference
     */
    public PokemonEggGroups() {
        this("pokemon_egg_groups", null);
    }

    private PokemonEggGroups(String alias, Table<PokemonEggGroupsRecord> aliased) {
        this(alias, aliased, null);
    }

    private PokemonEggGroups(String alias, Table<PokemonEggGroupsRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code pokemon_egg_groups} table reference
     */
    public PokemonEggGroups(String alias) {
        this(alias, POKEMON_EGG_GROUPS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PokemonEggGroupsRecord> getPrimaryKey() {
        return Keys.PK_POKEMON_EGG_GROUPS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PokemonEggGroupsRecord>> getKeys() {
        return Arrays.<UniqueKey<PokemonEggGroupsRecord>>asList(Keys.PK_POKEMON_EGG_GROUPS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PokemonEggGroupsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PokemonEggGroupsRecord, ?>>asList(Keys.FK_POKEMON_EGG_GROUPS_POKEMON_SPECIES_1,
                                                                    Keys.FK_POKEMON_EGG_GROUPS_EGG_GROUPS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEggGroups as(String alias) {
        return new PokemonEggGroups(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PokemonEggGroupsRecord> getRecordType() {
        return PokemonEggGroupsRecord.class;
    }

    /**
     * Rename this table
     */
    public PokemonEggGroups rename(String name) {
        return new PokemonEggGroups(name, null);
    }
}