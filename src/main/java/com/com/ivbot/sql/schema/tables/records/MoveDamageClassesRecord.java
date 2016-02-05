/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.MoveDamageClasses;
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
public class MoveDamageClassesRecord extends UpdatableRecordImpl<MoveDamageClassesRecord>
        implements Record2<Integer, String> {

    private static final long serialVersionUID = 492759747;

    /**
     * Create a detached MoveDamageClassesRecord
     */
    public MoveDamageClassesRecord() {
        super(MoveDamageClasses.MOVE_DAMAGE_CLASSES);
    }

    /**
     * Create a detached, initialised MoveDamageClassesRecord
     */
    public MoveDamageClassesRecord(Integer id, String identifier) {
        super(MoveDamageClasses.MOVE_DAMAGE_CLASSES);

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
        return MoveDamageClasses.MOVE_DAMAGE_CLASSES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return MoveDamageClasses.MOVE_DAMAGE_CLASSES.IDENTIFIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * Getter for {@code move_damage_classes.id}.
     */
    public Integer getId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code move_damage_classes.id}.
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
     * Getter for {@code move_damage_classes.identifier}.
     */
    public String getIdentifier() {
        return (String) getValue(1);
    }

    /**
     * Setter for {@code move_damage_classes.identifier}.
     */
    public void setIdentifier(String value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveDamageClassesRecord value1(Integer value) {
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
    public MoveDamageClassesRecord value2(String value) {
        setIdentifier(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveDamageClassesRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}