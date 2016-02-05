package com.com.ivbot.sql.query;

import java.util.ArrayList;
import java.util.List;

import static com.com.ivbot.sql.schema.Tables.TYPE_NAMES;

/**
 * Handles queries relating to the {@link com.com.ivbot.sql.schema.tables.Types} table.
 */
public class TypeQuery extends Query {

    /**
     * Retrieves the {@code TypeId} of the Type in {@code input} (if one can be found).
     *
     * @param input The {@code String} in which the {@code TypeName} should be found.
     *
     * @return The {@code TypeId} of the Type found in {@code input}.
     *
     * @throws TypeNotRecognisedException If there is no recognised {@code TypeName} found in {@code input}.
     */
    public static Integer getTypeIdFromQuery(String input) throws TypeNotRecognisedException {

        try {
            return findIdFromQuery(input, TYPE_NAMES.TYPE_ID, TYPE_NAMES.NAME, TYPE_NAMES);
        } catch (NotRecognisedException nre) {
            throw new TypeNotRecognisedException(input);
        }
    }

    /**
     * Retrieves the {@code List} of {@code TypeName}s from the given {@code List} of {@code TypeId}s.
     *
     * @param typeIds The {@code List} of {@code TypeId}s of which to retrieve the corresponding {@code TypeName}s.
     *
     * @return The {@code List} of {@code TypeName}s which correspond to each of the given {@code TypeId}s.
     *
     * @throws TypeIdNotFoundException If any of the {@code TypeId}s in the given {@code List} cannot be found.
     */
    public static List<String> getTypeNamesFromTypeIds(List<Integer> typeIds) throws TypeIdNotFoundException {

        List<String> typeNames = new ArrayList<>(typeIds.size());

        for (Integer typeId : typeIds) {
            typeNames.add(getTypeNameFromTypeId(typeId));
        }

        return typeNames;
    }

    /**
     * Retrieves the {@code TypeName} of the Type specified by the given {@code typeId}.
     *
     * @param typeId The {@code TypeId} of the Type whos {@code TypeName} is to be retrieved.
     *
     * @return The {@code TypeName} of the Type specified by the given {@code typeId}.
     *
     * @throws TypeIdNotFoundException If the provided {@code typeId} was not found.
     */
    public static String getTypeNameFromTypeId(Integer typeId) throws TypeIdNotFoundException {

        if (typeId.equals(Integer.valueOf(0))) {
            return "";
        }
        try {
            return findNameFromId(typeId, TYPE_NAMES.TYPE_ID, TYPE_NAMES.NAME, TYPE_NAMES);
        } catch (NotFoundException nfe) {
            throw new TypeIdNotFoundException(typeId);
        }
    }

    /**
     * Retrieves an {@code Array} of the {@code TypeName}s from the given {@code Array} of {@code TypeId}s.
     *
     * @param typeIds The array of {@code TypeId}s of which to find the corresponding {@code TypeName}s.
     *
     * @return An {@code Array} of the {@code TypeName}s from the given {@code Array} of {@code TypeId}s.
     *
     * @throws TypeIdNotFoundException If <i>any</i> of the {@code TypeId}s in the given {@code Array} do not exist in
     *                                 the {@code pokedb.sqlite} database.
     */
    public static String[] getTypeNamesFromTypeIds(Integer[] typeIds) throws TypeIdNotFoundException {

        String[] typeNames = new String[typeIds.length];

        for (int i = 0; i < typeIds.length; i++) {
            if (typeIds[i] == 0) {
                typeNames[i] = "";
            } else {
                typeNames[i] = getTypeNameFromTypeId(typeIds[i]);
            }
        }

        return typeNames;
    }

}
