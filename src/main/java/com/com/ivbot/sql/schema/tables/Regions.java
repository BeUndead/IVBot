/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.RegionsRecord;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Regions extends TableImpl<RegionsRecord> {

    /**
     * The reference instance of {@code regions}
     */
    public static final Regions REGIONS = new Regions();
    private static final long serialVersionUID = 1206645154;
    /**
     * The column {@code regions.id}.
     */
    public final TableField<RegionsRecord, Integer> ID =
            createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code regions.identifier}.
     */
    public final TableField<RegionsRecord, String> IDENTIFIER =
            createField("identifier", org.jooq.impl.SQLDataType.VARCHAR.length(79).nullable(false), this, "");

    /**
     * Create a {@code regions} table reference
     */
    public Regions() {
        this("regions", null);
    }

    private Regions(String alias, Table<RegionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Regions(String alias, Table<RegionsRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code regions} table reference
     */
    public Regions(String alias) {
        this(alias, REGIONS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RegionsRecord> getPrimaryKey() {
        return Keys.PK_REGIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RegionsRecord>> getKeys() {
        return Arrays.<UniqueKey<RegionsRecord>>asList(Keys.PK_REGIONS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Regions as(String alias) {
        return new Regions(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RegionsRecord> getRecordType() {
        return RegionsRecord.class;
    }

    /**
     * Rename this table
     */
    public Regions rename(String name) {
        return new Regions(name, null);
    }
}