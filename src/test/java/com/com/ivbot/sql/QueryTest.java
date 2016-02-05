package com.com.ivbot.sql;

import com.com.ivbot.sql.query.*;
import com.com.ivbot.sql.schema.tables.records.TypeEfficacyRecord;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for the queries of the {@code pokedb.sqlite}.
 */
public class QueryTest extends SQLTestBase {

    /**
     * Tests the fetched base stats match the expected values.
     *
     * @throws Exception
     */
    @Test
    public void testBaseStatsQuery() throws Exception {
        int[] baseStats = BaseStatsQuery.getBaseStatsFromPokemonId(Integer.valueOf(25));

        int[] expectedBaseStats = new int[] {35, 55, 40, 50, 50, 90};
        assertEquals("The baseStats array was of an unexpected length", 6, baseStats.length);

        for (int statId = 0; statId < 6; statId++) {
            assertEquals(String.format("Stat for " +
                                       "statId %d was" +
                                       " not as " +
                                       "expected", statId), expectedBaseStats[statId], baseStats[statId]);
        }
    }

    /**
     * Directly tests the {@code PokemonSpeciesQuery#getPokemonSpeciesIdFromQuery(String)} method, supplying a correctly
     * spelt {@code PokemonSpeciesName}.
     *
     * @throws Exception
     */
    @Test
    public void testPokemonSpeciesQuery() throws Exception {
        String query = "?stats deoxys";
        Integer speciesId = PokemonSpeciesQuery.getPokemonSpeciesIdFromQuery(query);

        assertEquals("The found PokemonSpeciesId was not as expected", Integer.valueOf(386), speciesId);
    }

    /**
     * Directly tests the {@code PokemonSpeciesQuery#getPokemonSpeciesIdFromQuery(String)} method, supplying an alias
     * from the {@code Aliases} table.
     *
     * @throws Exception
     */
    @Test
    public void testPokemonSpeciesQueryWithAlias() throws Exception {
        String query = "?stats skarm";
        Integer speciesId = PokemonSpeciesQuery.getPokemonSpeciesIdFromQuery(query);

        assertEquals("The found PokemonSpeciesId was not as expected", Integer.valueOf(227), speciesId);
    }

    /**
     * Tests that the capitalisation of the query does not effect the extraction of a {@code PokemonSpeciesId} from a
     * {@code String} containing the name (with random capitalisation).
     *
     * @throws Exception
     */
    @Test
    public void testPokemonSpeciesQueryIgnoresCapitalisation() throws Exception {
        String query = "?stats aLaKAzaM";
        Integer speciesId = PokemonSpeciesQuery.getPokemonSpeciesIdFromQuery(query);

        assertEquals("The found PokemonSpeciesId was not as expected", Integer.valueOf(65), speciesId);
    }

    /**
     * Directly tests the {@code PokemonSpeciesQuery#getPokemonSpeciesNameFromPokemonSpeciesId(Integer)} method.
     *
     * @throws Exception
     */
    @Test
    public void testPokemonSpeciesNameFromPokemonSpeciesId() throws Exception {
        Integer pokemonSpeciesId = Integer.valueOf(151);
        String pokemonSpeciesName = PokemonSpeciesQuery.getPokemonSpeciesNameFromPokemonSpeciesId(pokemonSpeciesId);

        assertEquals("The found PokemonSpeciesName was not as expected", "Mew", pokemonSpeciesName);
    }

    /**
     * Tests that a {@code PokemonSpeciesNotRecognisedException} is thrown for a query with an invalid {@code
     * PokemonSpeciesName} within.
     *
     * @throws Exception
     */
    @Test (expected = PokemonSpeciesNotRecognisedException.class)
    public void testPokemonSpeciesNotRecognisedExceptionIsThrownForInvalidQuery() throws Exception {
        String query = "?stats pangolin";
        Integer pokemonSpeciesId = PokemonSpeciesQuery.getPokemonSpeciesIdFromQuery(query);

        fail("The PokemonSpeciesNotRecognisedException was not thrown");
    }

    /**
     * Directly tests that a {@code NatureId} was correctly located from within a given input {@code String}.
     *
     * @throws Exception
     */
    @Test
    public void testGetNatureIdFromNatureNameInQuery() throws Exception {
        String query = "?nature timid";
        Integer natureId = NatureQuery.getNatureIdFromQuery(query);

        assertEquals("The found NatureId was not as expected", Integer.valueOf(5), natureId);
    }

    /**
     * Directly tests that a {@code NatureName} can be correctly found from the specified {@code natureId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetNatureNameFromNatureId() throws Exception {
        Integer natureId = Integer.valueOf(20); // Naive
        String natureName = NatureQuery.getNatureNameFromNatureId(natureId);

        assertEquals("The found NatureName was not as expected", "Naive", natureName);
    }

    /**
     * Directly tests that an {@code AbilityId} can be correctly identified in the given {@code query}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAbilityIdInQuery() throws Exception {
        String query = "?ability Static";
        Integer abilityId = AbilitiesQuery.getAbilityIdFromQuery(query);

        assertEquals("The found AbilityId was not as expected", Integer.valueOf(9), abilityId);
    }

    /**
     * Directly tests that an {@code AbilityName} can be found for the specified {@code AbilityId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAbilityNameFromAbilityId() throws Exception {
        Integer abilityId = Integer.valueOf(174);
        String abilityName = AbilitiesQuery.getAbilityNameFromAbilityId(abilityId);

        assertEquals("The found AbilityName was as expected", "Refrigerate", abilityName);
    }

    /**
     * Directly tests than a {@code MoveId} can be correctly identified in the given {@code query}.
     *
     * @throws Exception
     */
    @Test
    public void testGetMoveIdFromQuery() throws Exception {
        String query = "?move double-edge";
        Integer moveId = MoveQuery.getMoveIdFromQuery(query);

        assertEquals("The found MoveId was not as expected", Integer.valueOf(38), moveId);
    }

    /**
     * Directly tests that a {@code MoveName} can be found for the specified {@code MoveId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetMoveNameFromMoveId() throws Exception {
        Integer moveId = Integer.valueOf(355);
        String moveName = MoveQuery.getMoveNameFromMoveId(moveId);

        assertEquals("The found MoveName was not as expected", "Roost", moveName);
    }

    /**
     * Directly tests that a {@code TypeId} can be correctly identified in the given {@code query}.
     *
     * @throws Exception
     */
    @Test
    public void testGetTypeIdFromQuery() throws Exception {
        String query = "?type fire";
        Integer typeId = TypeQuery.getTypeIdFromQuery(query);

        assertEquals("The found TypeId was not as expected", Integer.valueOf(10), typeId);
    }

    /**
     * Directly tests that a {@code TypeName} can be found for the specified {@code TypeId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetTypeNameFromTypeId() throws Exception {
        Integer typeId = Integer.valueOf(15);
        String typeName = TypeQuery.getTypeNameFromTypeId(typeId);

        assertEquals("The found TypeName was not as expected", "Ice", typeName);
    }

    /**
     * Directly tests that an {@code ItemId} can be correctly identified in the given {@code query}.
     *
     * @throws Exception
     */
    @Test
    public void testGetItemIdFromQuery() throws Exception {
        String query = "?item destiny knot";
        Integer itemId = ItemQuery.getItemIdFromQuery(query);

        assertEquals("The found ItemId was not as expected", Integer.valueOf(257), itemId);
    }

    /**
     * Directly tests that a {@code ItemName} can be found for the specified {@code ItemId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetItemNameFromItemId() throws Exception {
        Integer itemId = Integer.valueOf(93);
        String itemName = ItemQuery.getItemNameFromItemId(itemId);

        assertEquals("The found ItemId was not as expected", "Heart Scale", itemName);
    }

    /**
     * Directly tests the {@code #getIVsFromQuery(String)} method of {@code IVsQuery}.
     *
     * @throws Exception
     */
    @Test
    public void testGetIVsFromQuery() throws Exception {
        String query = "?stats charmeleon 21.20.19.18.17.16 timid";
        int[] ivs = IVsQuery.getIVsFromQuery(query);

        assertEquals("The ivs array was of an unexpected length", 6, ivs.length);
        assertEquals("The HP IV was not as expected", 21, ivs[0]);
        assertEquals("The Att IV was not as expected", 20, ivs[1]);
        assertEquals("The Def IV was not as expected", 19, ivs[2]);
        assertEquals("The SpA IV was not as expected", 18, ivs[3]);
        assertEquals("The SpD IV was not as expected", 17, ivs[4]);
        assertEquals("The Spe IV was not as expected", 16, ivs[5]);
    }

    /**
     * Tests that an {@code IVsNotRecognisedException} is thrown if {@code IVs} are requested from a {@code String}
     * which doesn't contain them.
     *
     * @throws Exception
     */
    @Test (expected = IVsNotRecognisedException.class)
    public void testIVsNotRecognisedExceptionThrownForIVLackingQuery() throws Exception {
        String query = "?stats blissey bold";
        int[] ivs = IVsQuery.getIVsFromQuery(query);

        fail("No IVsNotRecognisedException was thrown");
    }

    /**
     * Directly tests the {@code #getEVsFromQuery(String)} method of {@code EVsQuery}.
     *
     * @throws Exception
     */
    @Test
    public void testGetEVsFromQuery() throws Exception {
        String query = "?stats abra 252.120.40.0.16.28 timid";
        int[] evs = EVsQuery.getEVsFromQuery(query);

        assertEquals("The evs array was of an unexpected length", 6, evs.length);
        assertEquals("The HP EV was not as expected", 252, evs[0]);
        assertEquals("The Att EV was not as expected", 120, evs[1]);
        assertEquals("The Def EV was not as expected", 40, evs[2]);
        assertEquals("The SpA EV was not as expected", 0, evs[3]);
        assertEquals("The SpD EV was not as expected", 16, evs[4]);
        assertEquals("The Spe EV was not as expected", 28, evs[5]);
    }

    /**
     * Tests that an {@code EVsNotRecognisedException} is thrown if {@code EVs} are requested when they are invalid.
     *
     * @throws Exception
     */
    @Test (expected = EVsNotRecognisedException.class)
    public void testEVsNotRecognisedExceptionThrownForEVsOverThreshold() throws Exception {
        String query = "?stats metagross 252.252.0.0.0.8";
        int[] evs = EVsQuery.getEVsFromQuery(query);

        fail("No EVsNotRecognisedException was thrown");
    }

    /**
     * Directly tests the extraction of a {@code Level} from a {@code query} with {@code LevelQuery}.
     *
     * @throws Exception
     */
    @Test
    public void testGetLevelFromQuery() throws Exception {
        String query = "?stats bulbasaur lv. 46 timid";
        int level = LevelQuery.getLevelFromQuery(query);

        assertEquals("The found level was not as expected", 46, level);
    }

    /**
     * Directly tests the extraction of {@code Stats} from a {@code query} with {@code StatsQuery}.
     *
     * @throws Exception
     */
    @Test
    public void testGetStatsFromQuery() throws Exception {
        String query = "?ivs diancie 117.110.166.105.169.58";
        int[] stats = StatsQuery.getStatsFromQuery(query);

        assertEquals("The stats array was of an unexpected length", 6, stats.length);
        assertEquals("The HP stat was not as expected", 117, stats[0]);
        assertEquals("The Att stat was not as expected", 110, stats[1]);
        assertEquals("The Def stat was not as expected", 166, stats[2]);
        assertEquals("The SpA stat was not as expected", 105, stats[3]);
        assertEquals("The SpD stat was not as expected", 169, stats[4]);
        assertEquals("The Spe stat was not as expected", 58, stats[5]);
    }

    /**
     * Directly tests the {@code PokemonQuery#getPokemonIdsFromPokemonSpeciesId(Integer)} method retrieves the correct
     * {@code List} of {@code PokemonIds}.
     *
     * @throws Exception
     */
    @Test
    public void testGetPokemonIdsFromPokemonSpeciesId() throws Exception {
        Integer pokemonSpeciesId = Integer.valueOf(150);
        List<Integer> pokemonIds = PokemonQuery.getPokemonIdsFromPokemonSpeciesId(pokemonSpeciesId);

        assertEquals("There was an unexpected number of PokemonIds found", 3, pokemonIds.size());

        List<Integer> expectedPokemonIds = new ArrayList<>();
        expectedPokemonIds.add(Integer.valueOf(150));
        expectedPokemonIds.add(Integer.valueOf(10043));
        expectedPokemonIds.add(Integer.valueOf(10044));

        assertTrue("There was an unexpected PokemonId found", expectedPokemonIds.containsAll(pokemonIds));
    }

    /**
     * Tests getting the {@code PokemonFormNames} from a given {@code PokemonSpeciesId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetPokemonFormNamesFromPokemonSpeciesId() throws Exception {
        Integer pokemonSpeciesId = Integer.valueOf(6);
        Integer[] pokemonFormIds = PokemonFormsQuery.getPokemonFormIdsFromPokemonSpeciesId(pokemonSpeciesId);
        String[] pokemonFormNames = PokemonFormsQuery.getPokemonFormNamesFromPokemonFormIds(pokemonFormIds);

        assertEquals("Unexpected number of PokemonFormNames", 3, pokemonFormNames.length);

        String[] expectedPokemonFormNames = new String[] {
                "", "Mega X", "Mega Y"};
        for (int i = 0; i < pokemonFormNames.length; i++) {
            assertEquals(String.format("Form Name %d " +
                                       "was not as " +
                                       "expected", i), expectedPokemonFormNames[i], pokemonFormNames[i]);
        }
    }

    /**
     * Directly tests that the correct {@code TypeId}(s) are retrieved when queries for a specified {@code PokemonId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetPokemonTypeIdsFromPokemonId() throws Exception {
        Integer pokemonId = Integer.valueOf(422);
        Integer[] pokemonTypeIds = PokemonTypeQuery.getTypeIdsFromPokemonId(pokemonId);

        assertEquals("Unexpected number of PokemonTypeIds", 2, pokemonTypeIds.length);

        Integer[] expectedTypeIds = new Integer[] {Integer.valueOf(11), Integer.valueOf(0)};
        for (int i = 0; i < pokemonTypeIds.length; i++) {
            assertEquals(String.format("The TypeId for slot %d " +
                                       "was not as " +
                                       "expected", i), expectedTypeIds[i], pokemonTypeIds[i]);
        }
    }

    /**
     * Directly tests that {@code TypeName}s are correctly retrieved for a specified {@code pokemonId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetPokemonTypeNamesFromPokemonId() throws Exception {
        Integer pokemonId = Integer.valueOf(318);
        String[] pokemonTypeNames = PokemonTypeQuery.getTypeNamesFromPokemonId(pokemonId);

        assertEquals("Unexpected number of PokemonTypeNames", 2, pokemonTypeNames.length);

        String[] expectedTypeNames = new String[] {"Water", "Dark"};
        for (int i = 0; i < pokemonTypeNames.length; i++) {
            assertEquals(String.format("The TypeName in slot %d was not as " + "expected", i), expectedTypeNames[i],
                         pokemonTypeNames[i]);
        }
    }

    /**
     * Directly tests that the correct {@code AbilityId}s are retrieved for the specified {@code PokemonId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAbilityIdsFromPokemonId() throws Exception {
        Integer pokemonId = Integer.valueOf(575);
        Integer[] abilityIds = PokemonAbilitiesQuery.getPokemonAbilityIdsFromPokemonId(pokemonId);

        assertEquals("An unexpected number of AbilityIds were found", 3, abilityIds.length);

        Integer[] expectedAbilityIds = new Integer[] {
                Integer.valueOf(119), Integer.valueOf(172), Integer.valueOf(23)};
        for (int i = 0; i < abilityIds.length; i++) {
            assertEquals(String.format("Ability %d was not as expected", i), expectedAbilityIds[i], abilityIds[i]);
        }
    }

    /**
     * Directly tests that the correct {@code AbilityName}s are retrieved for a given {@code PokemonId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAbilityNamesFromPokemonId() throws Exception {
        Integer pokemonId = Integer.valueOf(614);
        String[] abilityNames = PokemonAbilitiesQuery.getPokemonAbilityNamesFromPokemonId(pokemonId);

        assertEquals("An unexpected number of AbilityNames were found", 3, abilityNames.length);

        String[] expectedAbilityNames = new String[] {
                "Snow Cloak", "", "Swift Swim"};
        for (int i = 0; i < abilityNames.length; i++) {
            assertEquals(String.format("Ability %d was not as expected", i), expectedAbilityNames[i], abilityNames[i]);
        }
    }

    /**
     * Directly tests the {@code PokemonFormsQuery#getPokemonFormIdFromQuery(String)} method appropriately finds the
     * {@code PokemonFormId} from the given {@code query}.
     *
     * @throws Exception
     */
    @Test
    public void testGetPokemonFormIdFromQuery() throws Exception {
        String query = "?stats mega absol";
        Integer pokemonFormId = PokemonFormsQuery.getPokemonFormIdFromQuery(query);

        assertEquals("PokemonFormId was not as expected", Integer.valueOf(10157), pokemonFormId);
    }

    /**
     * Directly tests that the full {@code PokemonName} of a {@code Pokemon} specified by the given {@code PokemonId} is
     * retrieved.
     *
     * @throws Exception
     */
    @Test
    public void testGetPokemonNameFromPokemonFormId() throws Exception {
        Integer pokemonFormId = Integer.valueOf(10153);
        String pokemonName = PokemonFormsQuery.getPokemonNameFromPokemonFormId(pokemonFormId);

        assertEquals("The PokemonName was not as expected", "Mega Aggron", pokemonName);
    }

    /**
     * Tests that the correct <i>decreased</i> and <i>increased</i> {@code StatId}s are given for the specified {@code
     * NatureId}.
     *
     * @throws Exception
     */
    @Test
    public void testGetNatureModifiersFromNatureId() throws Exception {
        Integer natureId = Integer.valueOf(14); // Careful
        int[] natureModifiers = NatureQuery.getNatureModifiersFromNatureId(natureId.intValue());

        assertEquals("The NatureModifiers were of unexpected length", 2, natureModifiers.length);

        int[] expectedModifiers = new int[] {3, 4};

        assertEquals("The decreased stat was not as expected", expectedModifiers[0], natureModifiers[0]);
        assertEquals("The increased stat was not as expected", expectedModifiers[1], natureModifiers[1]);
    }

    /**
     * Tests that {@code IVs} are <i>not</i> recognised if the query uses multiple different separators to delimit the
     * {@code IVs} within.
     *
     * @throws Exception
     */
    @Test (expected = IVsNotRecognisedException.class)
    public void testThatIVsAreNotRecognisedWhenDifferentSeparatorsAreUsedInSameQuery() throws Exception {
        String query = "?stats wormadam timid lv. 100 31.30.29/28/27/26";

        IVsQuery.getIVsFromQuery(query);
    }

    /**
     * Tests that {@code EVs} are <i>not</i> recognised if the query uses multiple different separators to delimit the
     * {@code IVs} within.
     *
     * @throws Exception
     */
    @Test (expected = EVsNotRecognisedException.class)
    public void testThatEVsAreNotRecognisedWhenDifferentSeparatorsAreUsedInSameQuery() throws Exception {
        String query = "?stats volcanion lv. 75 252/252.0.0.6/0"; // Assumes result after removing IVs from query.

        EVsQuery.getEVsFromQuery(query);
    }

    /**
     * Tests that {@code Stats} are <i>not</i> recognised if the query uses multiple different separators to delimit the
     * {@code Stats} within.
     *
     * @throws Exception
     */
    @Test (expected = StatsNotRecognisedException.class)
    public void testThatStatsAreNotRecognisedWhenDifferentSeparatorsAreUsedInSameQuery() throws Exception {
        String query = "?ivs Mega Absol lv. 11 38.38/20.31.16/30"; // Assumes result after removing IVs from query.

        StatsQuery.getStatsFromQuery(query);
    }

    /**
     * Tests that the {@code TypeEfficacy} for two known {@code Types} is returned as expected.
     *
     * @throws Exception
     */
    @Test
    public void testThatTypeEfficacyIsAsExpected() throws Exception {
        Integer fireTypeId = 10;
        Integer waterTypeId = 11;

        List<TypeEfficacyRecord> efficacies = TypeEfficacyQuery.getTypeEfficaciesForAttackingTypeId(fireTypeId);
        Integer fireOnWaterEfficacy = efficacies.get(waterTypeId - 1).getDamageFactor();
        assertEquals("Efficacy not as expected", Integer.valueOf(50), fireOnWaterEfficacy);

        efficacies = TypeEfficacyQuery.getTypeEfficaciesForTargetTypeId(fireTypeId);
        Integer waterOnFireEfficacy = efficacies.get(waterTypeId - 1).getDamageFactor();
        assertEquals("Efficacy not as expected", Integer.valueOf(200), waterOnFireEfficacy);
    }
}
