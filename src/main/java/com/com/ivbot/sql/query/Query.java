package com.com.ivbot.sql.query;

import com.com.ivbot.sql.config.IVBotConnectionManager;
import org.jooq.*;

/**
 * Indicates that the class offers access to some form of {@code SQL} query.
 */
abstract class Query {

    /**
     * To be used in queries in instances where INSTR(query, entity) could typically be used, as this has yet to be
     * supported by {@code jOOQ}.
     * <p>
     * {@code %1$s} represents the input and {@code %2$s} represents the containing column.
     */
    protected static final String FIND_IN_INPUT = "LOWER(\"%1$S\") || \" \" LIKE \"%% \" || LOWER(%2$s) || \" %%\"";
    /**
     * The {@code DSLContext} to execute the queries upon the {@code pokedb.sqlite}.
     */
    protected static DSLContext context;

    /**
     * Sets the local {@code DSLContext} using {@code IVBotConnectionManager}'s static instance.
     */
    static {
        context = IVBotConnectionManager.getContext();
    }

    /**
     * Sets the {@code DSLContext} entity for this {@code Query}.
     *
     * @param context The {@code DSLContext} to use.
     */
    static void setContext(DSLContext context) {
        Query.context = context;
    }

    /**
     * Finds the {@code Integer} from {@code idField} which has an associated {@code String} in {@code nameField} which
     * can be found in the {@code input} {@code String}.
     *
     * @param input     The {@code String} in which to attempt to locate a match for a {@code String} in the {@code
     *                  nameField}.
     * @param idField   The {@code SelectField<Integer>} which to return when there is a matching {@code String} in the
     *                  associated {@code nameField} of the {@code Record}.
     * @param nameField The {@code SelectField<String>} in which to search for a match in the {@code input}.
     * @param table     The {@code Table} in which {@code idField} and {@code nameField} can be found.
     *
     * @return The {@code Integer} from the {@code idField} for which the corresponding {@code nameField} for the {@code
     * Record} has the <i>longest</i> match to the given {@code input}
     *
     * @throws NotRecognisedException If there is no matching entry in {@code nameField}, or if all entries are {@code
     *                                null}.
     */
    protected static Integer findIdFromQuery(String input, Field<Integer> idField, Field<String> nameField,
                                             TableLike table) throws NotRecognisedException {

        Result<Record2<Integer, String>> results = context.select(idField, nameField).from(table)
                                                          .where(String.format(FIND_IN_INPUT, input,
                                                                               nameField.getName())).fetch();

        try {
            return findLongestNamedRecordInRecordListIdName(results);
        } catch (NotFoundException nfe) {
            throw new NotRecognisedException(input);
        }
    }

    /**
     * Finds the {@code Record} with the <i>longest</i> (in terms of character length) {@code String} and returns the
     * {@code Integer} associated with that {@code Record}.
     *
     * @param results The {@code Result<Record2<Integer, <String>>}s in which to search for the {@code Record} with the
     *                longest {@code String}.
     *
     * @return The {@code Integer} associated with the {@code Record} with the longest {@code String}.
     *
     * @throws NotFoundException If {@code results} is empty or all {@code String}s in results are {@code null}.
     */
    protected static Integer findLongestNamedRecordInRecordListIdName(Result<Record2<Integer, String>> results)
            throws NotFoundException {

        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        int longestRecordLength = -1;
        int longestLengthRecordIndex = -1;
        for (Record2<Integer, String> record : results) {
            int currentRecordLength = record.value2().length();
            if (currentRecordLength > longestRecordLength) {
                longestRecordLength = currentRecordLength;
                longestLengthRecordIndex = record.value1();
            }
        }

        if (longestLengthRecordIndex != -1) {
            return longestLengthRecordIndex;
        }

        throw new NotFoundException();
    }

    /**
     * Searches through {@code table} to find a {@code Record} where the value of the {@code idField} matches the given
     * {@code id}; and returns the entry from the specified {@code nameField}.
     *
     * @param id        The {@code id} to locate the associated entry from in {@code table}.
     * @param idField   The {@code SelectField<Integer>} in which the {@code id} should be located.
     * @param nameField The {@code SelectField<String>} from which to return the value on matching {@code idField} and
     *                  {@code id}.
     * @param table     The {@code TableLike} in which the {@code idField} and {@code nameField} should be located.
     *
     * @return The entry in {@code table}'s {@code nameField} where the associated {@code idField} matches the given
     * {@code id}.
     *
     * @throws NotFoundException If the given {@code id} cannot be found in the {@code idField} of {@code table}.
     */
    protected static String findNameFromId(Integer id, Field<Integer> idField, Field<String> nameField, TableLike table)
            throws NotFoundException {

        String result = context.select().from(table).where(idField.equal(id)).fetchOne(nameField, String.class);

        if (result != null) {
            return result;
        }

        throw new NotFoundException(id);
    }

}
