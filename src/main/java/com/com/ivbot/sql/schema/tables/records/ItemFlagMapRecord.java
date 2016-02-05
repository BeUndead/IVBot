/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.ItemFlagMap;
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
public class ItemFlagMapRecord extends UpdatableRecordImpl<ItemFlagMapRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = -1258532196;

    /**
     * Create a detached ItemFlagMapRecord
     */
    public ItemFlagMapRecord() {
        super(ItemFlagMap.ITEM_FLAG_MAP);
    }

    /**
     * Create a detached, initialised ItemFlagMapRecord
     */
    public ItemFlagMapRecord(Integer itemId, Integer itemFlagId) {
        super(ItemFlagMap.ITEM_FLAG_MAP);

        setValue(0, itemId);
        setValue(1, itemFlagId);
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
        return ItemFlagMap.ITEM_FLAG_MAP.ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ItemFlagMap.ITEM_FLAG_MAP.ITEM_FLAG_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getItemId();
    }

    /**
     * Getter for {@code item_flag_map.item_id}.
     */
    public Integer getItemId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code item_flag_map.item_id}.
     */
    public void setItemId(Integer value) {
        setValue(0, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getItemFlagId();
    }

    /**
     * Getter for {@code item_flag_map.item_flag_id}.
     */
    public Integer getItemFlagId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code item_flag_map.item_flag_id}.
     */
    public void setItemFlagId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlagMapRecord value1(Integer value) {
        setItemId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlagMapRecord value2(Integer value) {
        setItemFlagId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlagMapRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}