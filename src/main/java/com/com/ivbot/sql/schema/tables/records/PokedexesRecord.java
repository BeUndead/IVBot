/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.Pokedexes;
import org.jooq.Field;
import org.jooq.Record1;
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
public class PokedexesRecord extends UpdatableRecordImpl<PokedexesRecord>
        implements Record4<Integer, Integer, String, Boolean> {

    private static final long serialVersionUID = -2063049890;

    /**
     * Create a detached PokedexesRecord
     */
    public PokedexesRecord() {
        super(Pokedexes.POKEDEXES);
    }

    /**
     * Create a detached, initialised PokedexesRecord
     */
    public PokedexesRecord(Integer id, Integer regionId, String identifier, Boolean isMainSeries) {
        super(Pokedexes.POKEDEXES);

        setValue(0, id);
        setValue(1, regionId);
        setValue(2, identifier);
        setValue(3, isMainSeries);
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
    public Row4<Integer, Integer, String, Boolean> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String, Boolean> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Pokedexes.POKEDEXES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Pokedexes.POKEDEXES.REGION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Pokedexes.POKEDEXES.IDENTIFIER;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field4() {
        return Pokedexes.POKEDEXES.IS_MAIN_SERIES;
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * Getter for {@code pokedexes.id}.
     */
    public Integer getId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code pokedexes.id}.
     */
    public void setId(Integer value) {
        setValue(0, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getRegionId();
    }

    /**
     * Getter for {@code pokedexes.region_id}.
     */
    public Integer getRegionId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code pokedexes.region_id}.
     */
    public void setRegionId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getIdentifier();
    }

    /**
     * Getter for {@code pokedexes.identifier}.
     */
    public String getIdentifier() {
        return (String) getValue(2);
    }

    /**
     * Setter for {@code pokedexes.identifier}.
     */
    public void setIdentifier(String value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value4() {
        return getIsMainSeries();
    }

    /**
     * Getter for {@code pokedexes.is_main_series}.
     */
    public Boolean getIsMainSeries() {
        return (Boolean) getValue(3);
    }

    /**
     * Setter for {@code pokedexes.is_main_series}.
     */
    public void setIsMainSeries(Boolean value) {
        setValue(3, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokedexesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokedexesRecord value2(Integer value) {
        setRegionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokedexesRecord value3(String value) {
        setIdentifier(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PokedexesRecord value4(Boolean value) {
        setIsMainSeries(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokedexesRecord values(Integer value1, Integer value2, String value3, Boolean value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }
}
