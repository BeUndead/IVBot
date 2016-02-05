/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.MoveEffects;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
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
public class MoveEffectsRecord extends UpdatableRecordImpl<MoveEffectsRecord> implements Record1<Integer> {

    private static final long serialVersionUID = 192307982;

    /**
     * Create a detached MoveEffectsRecord
     */
    public MoveEffectsRecord() {
        super(MoveEffects.MOVE_EFFECTS);
    }

    /**
     * Create a detached, initialised MoveEffectsRecord
     */
    public MoveEffectsRecord(Integer id) {
        super(MoveEffects.MOVE_EFFECTS);

        setValue(0, id);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<Integer> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<Integer> valuesRow() {
        return (Row1) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return MoveEffects.MOVE_EFFECTS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * Getter for {@code move_effects.id}.
     */
    public Integer getId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code move_effects.id}.
     */
    public void setId(Integer value) {
        setValue(0, value);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveEffectsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveEffectsRecord values(Integer value1) {
        value1(value1);
        return this;
    }
}
