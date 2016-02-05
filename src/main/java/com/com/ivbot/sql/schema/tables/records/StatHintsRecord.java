/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.StatHints;
import org.jooq.Field;
import org.jooq.Record1;
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
public class StatHintsRecord extends UpdatableRecordImpl<StatHintsRecord>
        implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 443430627;

    /**
     * Create a detached StatHintsRecord
     */
    public StatHintsRecord() {
        super(StatHints.STAT_HINTS);
    }

    /**
     * Create a detached, initialised StatHintsRecord
     */
    public StatHintsRecord(Integer id, Integer statId, Integer geneMod_5) {
        super(StatHints.STAT_HINTS);

        setValue(0, id);
        setValue(1, statId);
        setValue(2, geneMod_5);
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
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return StatHints.STAT_HINTS.ID;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return StatHints.STAT_HINTS.STAT_ID;
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return StatHints.STAT_HINTS.GENE_MOD_5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * Getter for {@code stat_hints.id}.
     */
    public Integer getId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code stat_hints.id}.
     */
    public void setId(Integer value) {
        setValue(0, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getStatId();
    }

    /**
     * Getter for {@code stat_hints.stat_id}.
     */
    public Integer getStatId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code stat_hints.stat_id}.
     */
    public void setStatId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getGeneMod_5();
    }

    /**
     * Getter for {@code stat_hints.gene_mod_5}.
     */
    public Integer getGeneMod_5() {
        return (Integer) getValue(2);
    }

    /**
     * Setter for {@code stat_hints.gene_mod_5}.
     */
    public void setGeneMod_5(Integer value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatHintsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatHintsRecord value2(Integer value) {
        setStatId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public StatHintsRecord value3(Integer value) {
        setGeneMod_5(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatHintsRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }
}
