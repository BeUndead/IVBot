/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.EggGroups;
import org.jooq.Field;
import org.jooq.Record1;
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
public class EggGroupsRecord extends UpdatableRecordImpl<EggGroupsRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = -301921257;

    /**
     * Create a detached EggGroupsRecord
     */
    public EggGroupsRecord() {
        super(EggGroups.EGG_GROUPS);
    }

    /**
     * Create a detached, initialised EggGroupsRecord
     */
    public EggGroupsRecord(Integer id, String identifier) {
        super(EggGroups.EGG_GROUPS);

        setValue(0, id);
        setValue(1, identifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> valuesRow() {
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
        return EggGroups.EGG_GROUPS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return EggGroups.EGG_GROUPS.IDENTIFIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * Getter for {@code egg_groups.id}.
     */
    public Integer getId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code egg_groups.id}.
     */
    public void setId(Integer value) {
        setValue(0, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getIdentifier();
    }

    /**
     * Getter for {@code egg_groups.identifier}.
     */
    public String getIdentifier() {
        return (String) getValue(1);
    }

    /**
     * Setter for {@code egg_groups.identifier}.
     */
    public void setIdentifier(String value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EggGroupsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EggGroupsRecord value2(String value) {
        setIdentifier(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EggGroupsRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}
