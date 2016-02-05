/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.MoveNamesRecord;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;

/**
 * This class is generated by jOOQ.
 */
@Generated (
        value = {
                "http://www.jooq.org", "jOOQ version:3.6.2"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings ({"all", "unchecked", "rawtypes"})
public class MoveNames extends TableImpl<MoveNamesRecord> {

    /**
     * The reference instance of {@code move_names}
     */
    public static final MoveNames MOVE_NAMES = new MoveNames();
    private static final long serialVersionUID = 1379873542;
    /**
     * The column {@code move_names.move_id}.
     */
    public final TableField<MoveNamesRecord, Integer> MOVE_ID =
            createField("move_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code move_names.local_language_id}.
     */
    public final TableField<MoveNamesRecord, Integer> LOCAL_LANGUAGE_ID =
            createField("local_language_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code move_names.name}.
     */
    public final TableField<MoveNamesRecord, String> NAME =
            createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(79).nullable(false), this, "");

    /**
     * Create a {@code move_names} table reference
     */
    public MoveNames() {
        this("move_names", null);
    }

    private MoveNames(String alias, Table<MoveNamesRecord> aliased) {
        this(alias, aliased, null);
    }

    private MoveNames(String alias, Table<MoveNamesRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code move_names} table reference
     */
    public MoveNames(String alias) {
        this(alias, MOVE_NAMES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MoveNamesRecord> getPrimaryKey() {
        return Keys.PK_MOVE_NAMES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MoveNamesRecord>> getKeys() {
        return Arrays.<UniqueKey<MoveNamesRecord>>asList(Keys.PK_MOVE_NAMES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MoveNamesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MoveNamesRecord, ?>>asList(Keys.FK_MOVE_NAMES_MOVES_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveNames as(String alias) {
        return new MoveNames(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MoveNamesRecord> getRecordType() {
        return MoveNamesRecord.class;
    }

    /**
     * Rename this table
     */
    public MoveNames rename(String name) {
        return new MoveNames(name, null);
    }
}