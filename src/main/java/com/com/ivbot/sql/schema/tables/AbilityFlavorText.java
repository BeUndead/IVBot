/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.AbilityFlavorTextRecord;
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
public class AbilityFlavorText extends TableImpl<AbilityFlavorTextRecord> {

    /**
     * The reference instance of {@code ability_flavor_text}
     */
    public static final AbilityFlavorText ABILITY_FLAVOR_TEXT = new AbilityFlavorText();
    private static final long serialVersionUID = -500892984;
    /**
     * The column {@code ability_flavor_text.ability_id}.
     */
    public final TableField<AbilityFlavorTextRecord, Integer> ABILITY_ID =
            createField("ability_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code ability_flavor_text.version_group_id}.
     */
    public final TableField<AbilityFlavorTextRecord, Integer> VERSION_GROUP_ID =
            createField("version_group_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code ability_flavor_text.language_id}.
     */
    public final TableField<AbilityFlavorTextRecord, Integer> LANGUAGE_ID =
            createField("language_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code ability_flavor_text.flavor_text}.
     */
    public final TableField<AbilityFlavorTextRecord, String> FLAVOR_TEXT =
            createField("flavor_text", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a {@code ability_flavor_text} table reference
     */
    public AbilityFlavorText() {
        this("ability_flavor_text", null);
    }

    private AbilityFlavorText(String alias, Table<AbilityFlavorTextRecord> aliased) {
        this(alias, aliased, null);
    }

    private AbilityFlavorText(String alias, Table<AbilityFlavorTextRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code ability_flavor_text} table reference
     */
    public AbilityFlavorText(String alias) {
        this(alias, ABILITY_FLAVOR_TEXT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AbilityFlavorTextRecord> getPrimaryKey() {
        return Keys.PK_ABILITY_FLAVOR_TEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AbilityFlavorTextRecord>> getKeys() {
        return Arrays.<UniqueKey<AbilityFlavorTextRecord>>asList(Keys.PK_ABILITY_FLAVOR_TEXT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<AbilityFlavorTextRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AbilityFlavorTextRecord, ?>>asList(Keys.FK_ABILITY_FLAVOR_TEXT_ABILITIES_1,
                                                                     Keys.FK_ABILITY_FLAVOR_TEXT_VERSION_GROUPS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbilityFlavorText as(String alias) {
        return new AbilityFlavorText(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AbilityFlavorTextRecord> getRecordType() {
        return AbilityFlavorTextRecord.class;
    }

    /**
     * Rename this table
     */
    public AbilityFlavorText rename(String name) {
        return new AbilityFlavorText(name, null);
    }
}