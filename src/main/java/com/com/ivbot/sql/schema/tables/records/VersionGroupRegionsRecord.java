/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.VersionGroupRegions;
import org.jooq.Field;
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
public class VersionGroupRegionsRecord extends UpdatableRecordImpl<VersionGroupRegionsRecord>
        implements Record2<Integer, Integer> {

    private static final long serialVersionUID = -535443255;

    /**
     * Create a detached VersionGroupRegionsRecord
     */
    public VersionGroupRegionsRecord() {
        super(VersionGroupRegions.VERSION_GROUP_REGIONS);
    }

    /**
     * Create a detached, initialised VersionGroupRegionsRecord
     */
    public VersionGroupRegionsRecord(Integer versionGroupId, Integer regionId) {
        super(VersionGroupRegions.VERSION_GROUP_REGIONS);

        setValue(0, versionGroupId);
        setValue(1, regionId);
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
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
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
        return VersionGroupRegions.VERSION_GROUP_REGIONS.VERSION_GROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return VersionGroupRegions.VERSION_GROUP_REGIONS.REGION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getVersionGroupId();
    }

    /**
     * Getter for {@code version_group_regions.version_group_id}.
     */
    public Integer getVersionGroupId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code version_group_regions.version_group_id}.
     */
    public void setVersionGroupId(Integer value) {
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
     * Getter for {@code version_group_regions.region_id}.
     */
    public Integer getRegionId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code version_group_regions.region_id}.
     */
    public void setRegionId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VersionGroupRegionsRecord value1(Integer value) {
        setVersionGroupId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public VersionGroupRegionsRecord value2(Integer value) {
        setRegionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VersionGroupRegionsRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}