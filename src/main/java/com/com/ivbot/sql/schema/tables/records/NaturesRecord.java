/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.Natures;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class NaturesRecord extends UpdatableRecordImpl<NaturesRecord>
        implements Record7<Integer, String, Integer, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = 1495243720;

    /**
     * Create a detached NaturesRecord
     */
    public NaturesRecord() {
        super(Natures.NATURES);
    }

    /**
     * Create a detached, initialised NaturesRecord
     */
    public NaturesRecord(Integer id, String identifier, Integer decreasedStatId, Integer increasedStatId,
                         Integer hatesFlavorId, Integer likesFlavorId, Integer gameIndex) {
        super(Natures.NATURES);

        setValue(0, id);
        setValue(1, identifier);
        setValue(2, decreasedStatId);
        setValue(3, increasedStatId);
        setValue(4, hatesFlavorId);
        setValue(5, likesFlavorId);
        setValue(6, gameIndex);
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
    public Row7<Integer, String, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, Integer, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Natures.NATURES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Natures.NATURES.IDENTIFIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Natures.NATURES.DECREASED_STAT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Natures.NATURES.INCREASED_STAT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Natures.NATURES.HATES_FLAVOR_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Natures.NATURES.LIKES_FLAVOR_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Natures.NATURES.GAME_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * Getter for {@code natures.id}.
     */
    public Integer getId() {
        return (Integer) getValue(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Setter for {@code natures.id}.
     */
    public void setId(Integer value) {
        setValue(0, value);
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getIdentifier();
    }

    /**
     * Getter for {@code natures.identifier}.
     */
    public String getIdentifier() {
        return (String) getValue(1);
    }

    /**
     * Setter for {@code natures.identifier}.
     */
    public void setIdentifier(String value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getDecreasedStatId();
    }

    /**
     * Getter for {@code natures.decreased_stat_id}.
     */
    public Integer getDecreasedStatId() {
        return (Integer) getValue(2);
    }

    /**
     * Setter for {@code natures.decreased_stat_id}.
     */
    public void setDecreasedStatId(Integer value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getIncreasedStatId();
    }

    /**
     * Getter for {@code natures.increased_stat_id}.
     */
    public Integer getIncreasedStatId() {
        return (Integer) getValue(3);
    }

    /**
     * Setter for {@code natures.increased_stat_id}.
     */
    public void setIncreasedStatId(Integer value) {
        setValue(3, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getHatesFlavorId();
    }

    /**
     * Getter for {@code natures.hates_flavor_id}.
     */
    public Integer getHatesFlavorId() {
        return (Integer) getValue(4);
    }

    /**
     * Setter for {@code natures.hates_flavor_id}.
     */
    public void setHatesFlavorId(Integer value) {
        setValue(4, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getLikesFlavorId();
    }

    /**
     * Getter for {@code natures.likes_flavor_id}.
     */
    public Integer getLikesFlavorId() {
        return (Integer) getValue(5);
    }

    /**
     * Setter for {@code natures.likes_flavor_id}.
     */
    public void setLikesFlavorId(Integer value) {
        setValue(5, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getGameIndex();
    }

    /**
     * Getter for {@code natures.game_index}.
     */
    public Integer getGameIndex() {
        return (Integer) getValue(6);
    }

    /**
     * Setter for {@code natures.game_index}.
     */
    public void setGameIndex(Integer value) {
        setValue(6, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NaturesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NaturesRecord value2(String value) {
        setIdentifier(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NaturesRecord value3(Integer value) {
        setDecreasedStatId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NaturesRecord value4(Integer value) {
        setIncreasedStatId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NaturesRecord value5(Integer value) {
        setHatesFlavorId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NaturesRecord value6(Integer value) {
        setLikesFlavorId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public NaturesRecord value7(Integer value) {
        setGameIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NaturesRecord values(Integer value1, String value2, Integer value3, Integer value4, Integer value5,
                                Integer value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }
}