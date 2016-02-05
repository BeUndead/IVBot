/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.MoveMetaCategoryProseRecord;
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
public class MoveMetaCategoryProse extends TableImpl<MoveMetaCategoryProseRecord> {

    /**
     * The reference instance of {@code move_meta_category_prose}
     */
    public static final MoveMetaCategoryProse MOVE_META_CATEGORY_PROSE = new MoveMetaCategoryProse();
    private static final long serialVersionUID = -1597636370;
    /**
     * The column {@code move_meta_category_prose.move_meta_category_id}.
     */
    public final TableField<MoveMetaCategoryProseRecord, Integer> MOVE_META_CATEGORY_ID =
            createField("move_meta_category_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code move_meta_category_prose.local_language_id}.
     */
    public final TableField<MoveMetaCategoryProseRecord, Integer> LOCAL_LANGUAGE_ID =
            createField("local_language_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code move_meta_category_prose.description}.
     */
    public final TableField<MoveMetaCategoryProseRecord, String> DESCRIPTION =
            createField("description", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a {@code move_meta_category_prose} table reference
     */
    public MoveMetaCategoryProse() {
        this("move_meta_category_prose", null);
    }

    private MoveMetaCategoryProse(String alias, Table<MoveMetaCategoryProseRecord> aliased) {
        this(alias, aliased, null);
    }

    private MoveMetaCategoryProse(String alias, Table<MoveMetaCategoryProseRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code move_meta_category_prose} table reference
     */
    public MoveMetaCategoryProse(String alias) {
        this(alias, MOVE_META_CATEGORY_PROSE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MoveMetaCategoryProseRecord> getPrimaryKey() {
        return Keys.PK_MOVE_META_CATEGORY_PROSE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MoveMetaCategoryProseRecord>> getKeys() {
        return Arrays.<UniqueKey<MoveMetaCategoryProseRecord>>asList(Keys.PK_MOVE_META_CATEGORY_PROSE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MoveMetaCategoryProseRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MoveMetaCategoryProseRecord, ?>>asList(
                Keys.FK_MOVE_META_CATEGORY_PROSE_MOVE_META_CATEGORIES_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoveMetaCategoryProse as(String alias) {
        return new MoveMetaCategoryProse(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MoveMetaCategoryProseRecord> getRecordType() {
        return MoveMetaCategoryProseRecord.class;
    }

    /**
     * Rename this table
     */
    public MoveMetaCategoryProse rename(String name) {
        return new MoveMetaCategoryProse(name, null);
    }
}
