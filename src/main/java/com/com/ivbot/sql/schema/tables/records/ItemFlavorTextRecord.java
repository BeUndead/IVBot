/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.ItemFlavorText;
import org.jooq.Field;
import org.jooq.Record3;
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
public class ItemFlavorTextRecord extends UpdatableRecordImpl<ItemFlavorTextRecord>
        implements Record4<Integer, Integer, Integer, String> {

    private static final long serialVersionUID = -1072831799;

    /**
     * Create a detached ItemFlavorTextRecord
     */
    public ItemFlavorTextRecord() {
        super(ItemFlavorText.ITEM_FLAVOR_TEXT);
    }

    /**
     * Create a detached, initialised ItemFlavorTextRecord
     */
    public ItemFlavorTextRecord(Integer itemId, Integer versionGroupId, Integer languageId, String flavorText) {
        super(ItemFlavorText.ITEM_FLAVOR_TEXT);

        setValue(0, itemId);
        setValue(1, versionGroupId);
        setValue(2, languageId);
        setValue(3, flavorText);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record3<Integer, Integer, Integer> key() {
        return (Record3) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ItemFlavorText.ITEM_FLAVOR_TEXT.ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ItemFlavorText.ITEM_FLAVOR_TEXT.VERSION_GROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return ItemFlavorText.ITEM_FLAVOR_TEXT.LANGUAGE_ID;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return ItemFlavorText.ITEM_FLAVOR_TEXT.FLAVOR_TEXT;
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
     * Getter for {@code item_flavor_text.item_id}.
     */
    public Integer getItemId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code item_flavor_text.item_id}.
     */
    public void setItemId(Integer value) {
        setValue(0, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getVersionGroupId();
    }

    /**
     * Getter for {@code item_flavor_text.version_group_id}.
     */
    public Integer getVersionGroupId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code item_flavor_text.version_group_id}.
     */
    public void setVersionGroupId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getLanguageId();
    }

    /**
     * Getter for {@code item_flavor_text.language_id}.
     */
    public Integer getLanguageId() {
        return (Integer) getValue(2);
    }

    /**
     * Setter for {@code item_flavor_text.language_id}.
     */
    public void setLanguageId(Integer value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getFlavorText();
    }

    /**
     * Getter for {@code item_flavor_text.flavor_text}.
     */
    public String getFlavorText() {
        return (String) getValue(3);
    }

    /**
     * Setter for {@code item_flavor_text.flavor_text}.
     */
    public void setFlavorText(String value) {
        setValue(3, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlavorTextRecord value1(Integer value) {
        setItemId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlavorTextRecord value2(Integer value) {
        setVersionGroupId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlavorTextRecord value3(Integer value) {
        setLanguageId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlavorTextRecord value4(String value) {
        setFlavorText(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemFlavorTextRecord values(Integer value1, Integer value2, Integer value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }
}