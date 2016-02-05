/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.tables.records.SqliteSequenceRecord;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;

/**
 * This class is generated by jOOQ.
 */
@Generated (
        value = {
                "http://www.jooq.org", "jOOQ version:3.6.2"},
        comments = "This class is generated by jOOQ")
@SuppressWarnings ({"all", "unchecked", "rawtypes"})
public class SqliteSequence extends TableImpl<SqliteSequenceRecord> {

    /**
     * The reference instance of {@code sqlite_sequence}
     */
    public static final SqliteSequence SQLITE_SEQUENCE = new SqliteSequence();
    private static final long serialVersionUID = -1708792492;
    /**
     * The column {@code sqlite_sequence.name}.
     */
    public final TableField<SqliteSequenceRecord, Object> NAME =
            createField("name", org.jooq.impl.DefaultDataType.getDefaultDataType(""), this, "");
    /**
     * The column {@code sqlite_sequence.seq}.
     */
    public final TableField<SqliteSequenceRecord, Object> SEQ =
            createField("seq", org.jooq.impl.DefaultDataType.getDefaultDataType(""), this, "");

    /**
     * Create a {@code sqlite_sequence} table reference
     */
    public SqliteSequence() {
        this("sqlite_sequence", null);
    }

    private SqliteSequence(String alias, Table<SqliteSequenceRecord> aliased) {
        this(alias, aliased, null);
    }

    private SqliteSequence(String alias, Table<SqliteSequenceRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code sqlite_sequence} table reference
     */
    public SqliteSequence(String alias) {
        this(alias, SQLITE_SEQUENCE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqliteSequence as(String alias) {
        return new SqliteSequence(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SqliteSequenceRecord> getRecordType() {
        return SqliteSequenceRecord.class;
    }

    /**
     * Rename this table
     */
    public SqliteSequence rename(String name) {
        return new SqliteSequence(name, null);
    }
}