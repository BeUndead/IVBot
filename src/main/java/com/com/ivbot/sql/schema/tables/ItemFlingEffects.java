/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.ItemFlingEffectsRecord;
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
public class ItemFlingEffects extends TableImpl<ItemFlingEffectsRecord> {

    /**
     * The reference instance of {@code item_fling_effects}
     */
    public static final ItemFlingEffects ITEM_FLING_EFFECTS = new ItemFlingEffects();
    private static final long serialVersionUID = 1234006089;
    /**
     * The column {@code item_fling_effects.id}.
     */
    public final TableField<ItemFlingEffectsRecord, Integer> ID =
            createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a {@code item_fling_effects} table reference
     */
    public ItemFlingEffects() {
        this("item_fling_effects", null);
    }

    private ItemFlingEffects(String alias, Table<ItemFlingEffectsRecord> aliased) {
        this(alias, aliased, null);
    }

    private ItemFlingEffects(String alias, Table<ItemFlingEffectsRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code item_fling_effects} table reference
     */
    public ItemFlingEffects(String alias) {
        this(alias, ITEM_FLING_EFFECTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ItemFlingEffectsRecord> getPrimaryKey() {
        return Keys.PK_ITEM_FLING_EFFECTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ItemFlingEffectsRecord>> getKeys() {
        return Arrays.<UniqueKey<ItemFlingEffectsRecord>>asList(Keys.PK_ITEM_FLING_EFFECTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlingEffects as(String alias) {
        return new ItemFlingEffects(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemFlingEffectsRecord> getRecordType() {
        return ItemFlingEffectsRecord.class;
    }

    /**
     * Rename this table
     */
    public ItemFlingEffects rename(String name) {
        return new ItemFlingEffects(name, null);
    }
}