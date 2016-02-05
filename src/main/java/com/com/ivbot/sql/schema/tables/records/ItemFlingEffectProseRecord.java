/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.ItemFlingEffectProse;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class ItemFlingEffectProseRecord extends UpdatableRecordImpl<ItemFlingEffectProseRecord>
        implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = 172577876;

    /**
     * Create a detached ItemFlingEffectProseRecord
     */
    public ItemFlingEffectProseRecord() {
        super(ItemFlingEffectProse.ITEM_FLING_EFFECT_PROSE);
    }

    /**
     * Create a detached, initialised ItemFlingEffectProseRecord
     */
    public ItemFlingEffectProseRecord(Integer itemFlingEffectId, Integer localLanguageId, String effect) {
        super(ItemFlingEffectProse.ITEM_FLING_EFFECT_PROSE);

        setValue(0, itemFlingEffectId);
        setValue(1, localLanguageId);
        setValue(2, effect);
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
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ItemFlingEffectProse.ITEM_FLING_EFFECT_PROSE.ITEM_FLING_EFFECT_ID;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ItemFlingEffectProse.ITEM_FLING_EFFECT_PROSE.LOCAL_LANGUAGE_ID;
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return ItemFlingEffectProse.ITEM_FLING_EFFECT_PROSE.EFFECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getItemFlingEffectId();
    }

    /**
     * Getter for {@code item_fling_effect_prose.item_fling_effect_id}.
     */
    public Integer getItemFlingEffectId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code item_fling_effect_prose.item_fling_effect_id}.
     */
    public void setItemFlingEffectId(Integer value) {
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
     * Getter for {@code item_fling_effect_prose.local_language_id}.
     */
    public Integer getLocalLanguageId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code item_fling_effect_prose.local_language_id}.
     */
    public void setLocalLanguageId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getEffect();
    }

    /**
     * Getter for {@code item_fling_effect_prose.effect}.
     */
    public String getEffect() {
        return (String) getValue(2);
    }

    /**
     * Setter for {@code item_fling_effect_prose.effect}.
     */
    public void setEffect(String value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlingEffectProseRecord value1(Integer value) {
        setItemFlingEffectId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlingEffectProseRecord value2(Integer value) {
        setLocalLanguageId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlingEffectProseRecord value3(String value) {
        setEffect(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlingEffectProseRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }
}