/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.ItemFlagMapRecord;
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
public class ItemFlagMap extends TableImpl<ItemFlagMapRecord> {

    /**
     * The reference instance of {@code item_flag_map}
     */
    public static final ItemFlagMap ITEM_FLAG_MAP = new ItemFlagMap();
    private static final long serialVersionUID = -607597352;
    /**
     * The column {@code item_flag_map.item_id}.
     */
    public final TableField<ItemFlagMapRecord, Integer> ITEM_ID =
            createField("item_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code item_flag_map.item_flag_id}.
     */
    public final TableField<ItemFlagMapRecord, Integer> ITEM_FLAG_ID =
            createField("item_flag_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a {@code item_flag_map} table reference
     */
    public ItemFlagMap() {
        this("item_flag_map", null);
    }

    private ItemFlagMap(String alias, Table<ItemFlagMapRecord> aliased) {
        this(alias, aliased, null);
    }

    private ItemFlagMap(String alias, Table<ItemFlagMapRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code item_flag_map} table reference
     */
    public ItemFlagMap(String alias) {
        this(alias, ITEM_FLAG_MAP);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ItemFlagMapRecord> getPrimaryKey() {
        return Keys.PK_ITEM_FLAG_MAP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ItemFlagMapRecord>> getKeys() {
        return Arrays.<UniqueKey<ItemFlagMapRecord>>asList(Keys.PK_ITEM_FLAG_MAP);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ItemFlagMapRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ItemFlagMapRecord, ?>>asList(Keys.FK_ITEM_FLAG_MAP_ITEMS_1,
                                                               Keys.FK_ITEM_FLAG_MAP_ITEM_FLAGS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlagMap as(String alias) {
        return new ItemFlagMap(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemFlagMapRecord> getRecordType() {
        return ItemFlagMapRecord.class;
    }

    /**
     * Rename this table
     */
    public ItemFlagMap rename(String name) {
        return new ItemFlagMap(name, null);
    }
}
