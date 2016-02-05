/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.ItemProse;
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
public class ItemProseRecord extends UpdatableRecordImpl<ItemProseRecord>
        implements Record4<Integer, Integer, String, String> {

    private static final long serialVersionUID = -674207214;

    /**
     * Create a detached ItemProseRecord
     */
    public ItemProseRecord() {
        super(ItemProse.ITEM_PROSE);
    }

    /**
     * Create a detached, initialised ItemProseRecord
     */
    public ItemProseRecord(Integer itemId, Integer localLanguageId, String shortEffect, String effect) {
        super(ItemProse.ITEM_PROSE);

        setValue(0, itemId);
        setValue(1, localLanguageId);
        setValue(2, shortEffect);
        setValue(3, effect);
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
        return ItemProse.ITEM_PROSE.ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ItemProse.ITEM_PROSE.LOCAL_LANGUAGE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return ItemProse.ITEM_PROSE.SHORT_EFFECT;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return ItemProse.ITEM_PROSE.EFFECT;
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getItemId();
    }

    /**
     * Getter for {@code item_prose.item_id}.
     */
    public Integer getItemId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code item_prose.item_id}.
     */
    public void setItemId(Integer value) {
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
     * Getter for {@code item_prose.local_language_id}.
     */
    public Integer getLocalLanguageId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code item_prose.local_language_id}.
     */
    public void setLocalLanguageId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getShortEffect();
    }

    /**
     * Getter for {@code item_prose.short_effect}.
     */
    public String getShortEffect() {
        return (String) getValue(2);
    }

    /**
     * Setter for {@code item_prose.short_effect}.
     */
    public void setShortEffect(String value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEffect();
    }

    /**
     * Getter for {@code item_prose.effect}.
     */
    public String getEffect() {
        return (String) getValue(3);
    }

    /**
     * Setter for {@code item_prose.effect}.
     */
    public void setEffect(String value) {
        setValue(3, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemProseRecord value1(Integer value) {
        setItemId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemProseRecord value2(Integer value) {
        setLocalLanguageId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemProseRecord value3(String value) {
        setShortEffect(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemProseRecord value4(String value) {
        setEffect(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemProseRecord values(Integer value1, Integer value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }
}
