/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.StatHintsRecord;
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
public class StatHints extends TableImpl<StatHintsRecord> {

    /**
     * The reference instance of {@code stat_hints}
     */
    public static final StatHints STAT_HINTS = new StatHints();
    private static final long serialVersionUID = 726272100;
    /**
     * The column {@code stat_hints.id}.
     */
    public final TableField<StatHintsRecord, Integer> ID =
            createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code stat_hints.stat_id}.
     */
    public final TableField<StatHintsRecord, Integer> STAT_ID =
            createField("stat_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code stat_hints.gene_mod_5}.
     */
    public final TableField<StatHintsRecord, Integer> GENE_MOD_5 =
            createField("gene_mod_5", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a {@code stat_hints} table reference
     */
    public StatHints() {
        this("stat_hints", null);
    }

    private StatHints(String alias, Table<StatHintsRecord> aliased) {
        this(alias, aliased, null);
    }

    private StatHints(String alias, Table<StatHintsRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code stat_hints} table reference
     */
    public StatHints(String alias) {
        this(alias, STAT_HINTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StatHintsRecord> getPrimaryKey() {
        return Keys.PK_STAT_HINTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StatHintsRecord>> getKeys() {
        return Arrays.<UniqueKey<StatHintsRecord>>asList(Keys.PK_STAT_HINTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<StatHintsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<StatHintsRecord, ?>>asList(Keys.FK_STAT_HINTS_STATS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatHints as(String alias) {
        return new StatHints(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StatHintsRecord> getRecordType() {
        return StatHintsRecord.class;
    }

    /**
     * Rename this table
     */
    public StatHints rename(String name) {
        return new StatHints(name, null);
    }
}