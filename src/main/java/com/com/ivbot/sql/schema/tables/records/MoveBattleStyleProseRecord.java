/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.MoveBattleStyleProse;
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
public class MoveBattleStyleProseRecord extends UpdatableRecordImpl<MoveBattleStyleProseRecord>
        implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = 671401766;

    /**
     * Create a detached MoveBattleStyleProseRecord
     */
    public MoveBattleStyleProseRecord() {
        super(MoveBattleStyleProse.MOVE_BATTLE_STYLE_PROSE);
    }

    /**
     * Create a detached, initialised MoveBattleStyleProseRecord
     */
    public MoveBattleStyleProseRecord(Integer moveBattleStyleId, Integer localLanguageId, String name) {
        super(MoveBattleStyleProse.MOVE_BATTLE_STYLE_PROSE);

        setValue(0, moveBattleStyleId);
        setValue(1, localLanguageId);
        setValue(2, name);
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
        return MoveBattleStyleProse.MOVE_BATTLE_STYLE_PROSE.MOVE_BATTLE_STYLE_ID;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return MoveBattleStyleProse.MOVE_BATTLE_STYLE_PROSE.LOCAL_LANGUAGE_ID;
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return MoveBattleStyleProse.MOVE_BATTLE_STYLE_PROSE.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getMoveBattleStyleId();
    }

    /**
     * Getter for {@code move_battle_style_prose.move_battle_style_id}.
     */
    public Integer getMoveBattleStyleId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code move_battle_style_prose.move_battle_style_id}.
     */
    public void setMoveBattleStyleId(Integer value) {
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
     * Getter for {@code move_battle_style_prose.local_language_id}.
     */
    public Integer getLocalLanguageId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code move_battle_style_prose.local_language_id}.
     */
    public void setLocalLanguageId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * Getter for {@code move_battle_style_prose.name}.
     */
    public String getName() {
        return (String) getValue(2);
    }

    /**
     * Setter for {@code move_battle_style_prose.name}.
     */
    public void setName(String value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveBattleStyleProseRecord value1(Integer value) {
        setMoveBattleStyleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveBattleStyleProseRecord value2(Integer value) {
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
    public MoveBattleStyleProseRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveBattleStyleProseRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }
}