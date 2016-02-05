/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables;

import com.com.ivbot.sql.schema.DefaultSchema;
import com.com.ivbot.sql.schema.Keys;
import com.com.ivbot.sql.schema.tables.records.ItemCategoryProseRecord;
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
public class ItemCategoryProse extends TableImpl<ItemCategoryProseRecord> {

    /**
     * The reference instance of {@code item_category_prose}
     */
    public static final ItemCategoryProse ITEM_CATEGORY_PROSE = new ItemCategoryProse();
    private static final long serialVersionUID = -680708696;
    /**
     * The column {@code item_category_prose.item_category_id}.
     */
    public final TableField<ItemCategoryProseRecord, Integer> ITEM_CATEGORY_ID =
            createField("item_category_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code item_category_prose.local_language_id}.
     */
    public final TableField<ItemCategoryProseRecord, Integer> LOCAL_LANGUAGE_ID =
            createField("local_language_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column {@code item_category_prose.name}.
     */
    public final TableField<ItemCategoryProseRecord, String> NAME =
            createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(79).nullable(false), this, "");

    /**
     * Create a {@code item_category_prose} table reference
     */
    public ItemCategoryProse() {
        this("item_category_prose", null);
    }

    private ItemCategoryProse(String alias, Table<ItemCategoryProseRecord> aliased) {
        this(alias, aliased, null);
    }

    private ItemCategoryProse(String alias, Table<ItemCategoryProseRecord> aliased, Field<?>[] parameters) {
        super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
    }

    /**
     * Create an aliased {@code item_category_prose} table reference
     */
    public ItemCategoryProse(String alias) {
        this(alias, ITEM_CATEGORY_PROSE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ItemCategoryProseRecord> getPrimaryKey() {
        return Keys.PK_ITEM_CATEGORY_PROSE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ItemCategoryProseRecord>> getKeys() {
        return Arrays.<UniqueKey<ItemCategoryProseRecord>>asList(Keys.PK_ITEM_CATEGORY_PROSE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ItemCategoryProseRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ItemCategoryProseRecord, ?>>asList(Keys.FK_ITEM_CATEGORY_PROSE_ITEM_CATEGORIES_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemCategoryProse as(String alias) {
        return new ItemCategoryProse(alias, this);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemCategoryProseRecord> getRecordType() {
        return ItemCategoryProseRecord.class;
    }

    /**
     * Rename this table
     */
    public ItemCategoryProse rename(String name) {
        return new ItemCategoryProse(name, null);
    }
}