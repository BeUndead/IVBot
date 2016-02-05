package com.com.ivbot.compute;

import com.com.ivbot.sql.query.TypeEfficacyQuery;
import com.com.ivbot.sql.query.TypeIdNotFoundException;
import com.com.ivbot.sql.schema.tables.records.TypeEfficacyRecord;

import java.util.*;

/**
 * Handles the computation of {@code TypeEfficacy} for multiple {@code Types} simultaneously.
 */
public class TypeEfficacyComputation {

    /**
     * Computes a {@link Map} of {@link Integer Integers} representing the efficacy of the {@code Type} of {@code
     * TypeId} {@code index - 1} against the combination of {@code Types} given. <p> <p> The {@code key} is the {@code
     * TypeId}, and the {@code value} is the {@code TypeEfficacy}. </p>
     *
     * @param type1 The first {@code TypeId} of the defending {@code Pokemon}.
     * @param type2 The ({@link Optional}) second {@code typeId} of the defending {@code Pokemon}.
     *
     * @return A {@code Map} of the {@code TypeEfficacies} of all {@code Types} (referenced by {@code Type Id} = {@code
     * index - 1} in the returned {@code List}) against a {@code Pokemon} of the given {@code Type} combination.
     *
     * @throws TypeIdNotFoundException If either of the {@code TypeIds} is not present in the {@code TypeEfficacy}
     *                                 {@code Table} in the {@code pokedb.sqlite}.
     */
    public static List<Map.Entry<Integer, Integer>> getDamageEfficaciesFromTypes(Integer type1, Optional<Integer> type2)
            throws TypeIdNotFoundException {

        // Get the efficacies of types against type1
        List<TypeEfficacyRecord> type1Efficacies = TypeEfficacyQuery.getTypeEfficaciesForTargetTypeId(type1);

        // If type2 was provided, get the efficacies of types against type2
        Optional<List<TypeEfficacyRecord>> type2Efficacies = Optional.empty();
        if (type2.isPresent()) {
            type2Efficacies = Optional.of(TypeEfficacyQuery.getTypeEfficaciesForTargetTypeId(type2.get()));
        }

        // Add the combination of these efficacies to our return list
        List<Map.Entry<Integer, Integer>> efficacies = new ArrayList<>(18);
        for (int i = 0; i < type1Efficacies.size(); i++) {
            int damage = type1Efficacies.get(i).getDamageFactor();
            if (type2Efficacies.isPresent()) {
                damage *= type2Efficacies.get().get(i).getDamageFactor();
                damage /= 100;
            }
            efficacies.add(new AbstractMap.SimpleEntry<Integer, Integer>((i + 1), damage));
        }

        // And return
        return TypeEfficacyComputation.sortEfficacies(efficacies);
    }

    /**
     * Sorts the given {@link List} of {@code TypeEfficacies} by the {@code DamageFactor}.
     *
     * @param efficacies The {@code TypeEfficacies} to be sorted.
     *
     * @return A sorted {@code List} of {@code TypeEfficacies}.
     *
     * @throws TypeIdNotFoundException If there is an unexpected {@code DamageFactor} present.
     */
    private static List<Map.Entry<Integer, Integer>> sortEfficacies(List<Map.Entry<Integer, Integer>> efficacies)
            throws TypeIdNotFoundException {
        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(efficacies.size());

        List<Map.Entry<Integer, Integer>> all0s = new ArrayList<>(efficacies.size());
        List<Map.Entry<Integer, Integer>> all25s = new ArrayList<>(efficacies.size());
        List<Map.Entry<Integer, Integer>> all50s = new ArrayList<>(efficacies.size());
        List<Map.Entry<Integer, Integer>> all100s = new ArrayList<>(efficacies.size());
        List<Map.Entry<Integer, Integer>> all200s = new ArrayList<>(efficacies.size());
        List<Map.Entry<Integer, Integer>> all400s = new ArrayList<>(efficacies.size());
        for (Map.Entry<Integer, Integer> efficacy : efficacies) {
            switch (efficacy.getValue()) {
                case 0:
                    all0s.add(efficacy);
                    break;
                case 25:
                    all25s.add(efficacy);
                    break;
                case 50:
                    all50s.add(efficacy);
                    break;
                case 100:
                    all100s.add(efficacy);
                    break;
                case 200:
                    all200s.add(efficacy);
                    break;
                case 400:
                    all400s.add(efficacy);
                    break;
                default:
                    throw new TypeIdNotFoundException(efficacy.getKey());
            }
        }

        sorted.addAll(all0s);
        sorted.addAll(all25s);
        sorted.addAll(all50s);
        sorted.addAll(all100s);
        sorted.addAll(all200s);
        sorted.addAll(all400s);

        return sorted;
    }

}
