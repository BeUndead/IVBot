/**
 * This class is generated by jOOQ
 */
package com.com.ivbot.sql.schema.tables.records;

import com.com.ivbot.sql.schema.tables.PokemonEvolution;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record20;
import org.jooq.Row20;
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
public class PokemonEvolutionRecord extends UpdatableRecordImpl<PokemonEvolutionRecord> implements Record20<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, String, Integer, Integer,
                Integer, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean> {

    private static final long serialVersionUID = -479724352;

    /**
     * Create a detached PokemonEvolutionRecord
     */
    public PokemonEvolutionRecord() {
        super(PokemonEvolution.POKEMON_EVOLUTION);
    }

    /**
     * Create a detached, initialised PokemonEvolutionRecord
     */
    public PokemonEvolutionRecord(Integer id, Integer evolvedSpeciesId, Integer evolutionTriggerId,
                                  Integer triggerItemId, Integer minimumLevel, Integer genderId, Integer locationId,
                                  Integer heldItemId, String timeOfDay, Integer knownMoveId, Integer knownMoveTypeId,
                                  Integer minimumHappiness, Integer minimumBeauty, Integer minimumAffection,
                                  Integer relativePhysicalStats, Integer partySpeciesId, Integer partyTypeId,
                                  Integer tradeSpeciesId, Boolean needsOverworldRain, Boolean turnUpsideDown) {
        super(PokemonEvolution.POKEMON_EVOLUTION);

        setValue(0, id);
        setValue(1, evolvedSpeciesId);
        setValue(2, evolutionTriggerId);
        setValue(3, triggerItemId);
        setValue(4, minimumLevel);
        setValue(5, genderId);
        setValue(6, locationId);
        setValue(7, heldItemId);
        setValue(8, timeOfDay);
        setValue(9, knownMoveId);
        setValue(10, knownMoveTypeId);
        setValue(11, minimumHappiness);
        setValue(12, minimumBeauty);
        setValue(13, minimumAffection);
        setValue(14, relativePhysicalStats);
        setValue(15, partySpeciesId);
        setValue(16, partyTypeId);
        setValue(17, tradeSpeciesId);
        setValue(18, needsOverworldRain);
        setValue(19, turnUpsideDown);
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
    public Row20<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, String, Integer, Integer,
            Integer, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, String, Integer, Integer,
            Integer, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean> valuesRow() {
        return (Row20) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return PokemonEvolution.POKEMON_EVOLUTION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return PokemonEvolution.POKEMON_EVOLUTION.EVOLVED_SPECIES_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return PokemonEvolution.POKEMON_EVOLUTION.EVOLUTION_TRIGGER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return PokemonEvolution.POKEMON_EVOLUTION.TRIGGER_ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return PokemonEvolution.POKEMON_EVOLUTION.MINIMUM_LEVEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return PokemonEvolution.POKEMON_EVOLUTION.GENDER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return PokemonEvolution.POKEMON_EVOLUTION.LOCATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return PokemonEvolution.POKEMON_EVOLUTION.HELD_ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return PokemonEvolution.POKEMON_EVOLUTION.TIME_OF_DAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return PokemonEvolution.POKEMON_EVOLUTION.KNOWN_MOVE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return PokemonEvolution.POKEMON_EVOLUTION.KNOWN_MOVE_TYPE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return PokemonEvolution.POKEMON_EVOLUTION.MINIMUM_HAPPINESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return PokemonEvolution.POKEMON_EVOLUTION.MINIMUM_BEAUTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field14() {
        return PokemonEvolution.POKEMON_EVOLUTION.MINIMUM_AFFECTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field15() {
        return PokemonEvolution.POKEMON_EVOLUTION.RELATIVE_PHYSICAL_STATS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field16() {
        return PokemonEvolution.POKEMON_EVOLUTION.PARTY_SPECIES_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field17() {
        return PokemonEvolution.POKEMON_EVOLUTION.PARTY_TYPE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field18() {
        return PokemonEvolution.POKEMON_EVOLUTION.TRADE_SPECIES_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field19() {
        return PokemonEvolution.POKEMON_EVOLUTION.NEEDS_OVERWORLD_RAIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field20() {
        return PokemonEvolution.POKEMON_EVOLUTION.TURN_UPSIDE_DOWN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * Getter for {@code pokemon_evolution.id}.
     */
    public Integer getId() {
        return (Integer) getValue(0);
    }

    /**
     * Setter for {@code pokemon_evolution.id}.
     */
    public void setId(Integer value) {
        setValue(0, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getEvolvedSpeciesId();
    }

    /**
     * Getter for {@code pokemon_evolution.evolved_species_id}.
     */
    public Integer getEvolvedSpeciesId() {
        return (Integer) getValue(1);
    }

    /**
     * Setter for {@code pokemon_evolution.evolved_species_id}.
     */
    public void setEvolvedSpeciesId(Integer value) {
        setValue(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getEvolutionTriggerId();
    }

    /**
     * Getter for {@code pokemon_evolution.evolution_trigger_id}.
     */
    public Integer getEvolutionTriggerId() {
        return (Integer) getValue(2);
    }

    /**
     * Setter for {@code pokemon_evolution.evolution_trigger_id}.
     */
    public void setEvolutionTriggerId(Integer value) {
        setValue(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getTriggerItemId();
    }

    /**
     * Getter for {@code pokemon_evolution.trigger_item_id}.
     */
    public Integer getTriggerItemId() {
        return (Integer) getValue(3);
    }

    /**
     * Setter for {@code pokemon_evolution.trigger_item_id}.
     */
    public void setTriggerItemId(Integer value) {
        setValue(3, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getMinimumLevel();
    }

    /**
     * Getter for {@code pokemon_evolution.minimum_level}.
     */
    public Integer getMinimumLevel() {
        return (Integer) getValue(4);
    }

    /**
     * Setter for {@code pokemon_evolution.minimum_level}.
     */
    public void setMinimumLevel(Integer value) {
        setValue(4, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getGenderId();
    }

    // -------------------------------------------------------------------------
    // Record20 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for {@code pokemon_evolution.gender_id}.
     */
    public Integer getGenderId() {
        return (Integer) getValue(5);
    }

    /**
     * Setter for {@code pokemon_evolution.gender_id}.
     */
    public void setGenderId(Integer value) {
        setValue(5, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getLocationId();
    }

    /**
     * Getter for {@code pokemon_evolution.location_id}.
     */
    public Integer getLocationId() {
        return (Integer) getValue(6);
    }

    /**
     * Setter for {@code pokemon_evolution.location_id}.
     */
    public void setLocationId(Integer value) {
        setValue(6, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getHeldItemId();
    }

    /**
     * Getter for {@code pokemon_evolution.held_item_id}.
     */
    public Integer getHeldItemId() {
        return (Integer) getValue(7);
    }

    /**
     * Setter for {@code pokemon_evolution.held_item_id}.
     */
    public void setHeldItemId(Integer value) {
        setValue(7, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getTimeOfDay();
    }

    /**
     * Getter for {@code pokemon_evolution.time_of_day}.
     */
    public String getTimeOfDay() {
        return (String) getValue(8);
    }

    /**
     * Setter for {@code pokemon_evolution.time_of_day}.
     */
    public void setTimeOfDay(String value) {
        setValue(8, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getKnownMoveId();
    }

    /**
     * Getter for {@code pokemon_evolution.known_move_id}.
     */
    public Integer getKnownMoveId() {
        return (Integer) getValue(9);
    }

    /**
     * Setter for {@code pokemon_evolution.known_move_id}.
     */
    public void setKnownMoveId(Integer value) {
        setValue(9, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getKnownMoveTypeId();
    }

    /**
     * Getter for {@code pokemon_evolution.known_move_type_id}.
     */
    public Integer getKnownMoveTypeId() {
        return (Integer) getValue(10);
    }

    /**
     * Setter for {@code pokemon_evolution.known_move_type_id}.
     */
    public void setKnownMoveTypeId(Integer value) {
        setValue(10, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getMinimumHappiness();
    }

    /**
     * Getter for {@code pokemon_evolution.minimum_happiness}.
     */
    public Integer getMinimumHappiness() {
        return (Integer) getValue(11);
    }

    /**
     * Setter for {@code pokemon_evolution.minimum_happiness}.
     */
    public void setMinimumHappiness(Integer value) {
        setValue(11, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getMinimumBeauty();
    }

    /**
     * Getter for {@code pokemon_evolution.minimum_beauty}.
     */
    public Integer getMinimumBeauty() {
        return (Integer) getValue(12);
    }

    /**
     * Setter for {@code pokemon_evolution.minimum_beauty}.
     */
    public void setMinimumBeauty(Integer value) {
        setValue(12, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value14() {
        return getMinimumAffection();
    }

    /**
     * Getter for {@code pokemon_evolution.minimum_affection}.
     */
    public Integer getMinimumAffection() {
        return (Integer) getValue(13);
    }

    /**
     * Setter for {@code pokemon_evolution.minimum_affection}.
     */
    public void setMinimumAffection(Integer value) {
        setValue(13, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value15() {
        return getRelativePhysicalStats();
    }

    /**
     * Getter for {@code pokemon_evolution.relative_physical_stats}.
     */
    public Integer getRelativePhysicalStats() {
        return (Integer) getValue(14);
    }

    /**
     * Setter for {@code pokemon_evolution.relative_physical_stats}.
     */
    public void setRelativePhysicalStats(Integer value) {
        setValue(14, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value16() {
        return getPartySpeciesId();
    }

    /**
     * Getter for {@code pokemon_evolution.party_species_id}.
     */
    public Integer getPartySpeciesId() {
        return (Integer) getValue(15);
    }

    /**
     * Setter for {@code pokemon_evolution.party_species_id}.
     */
    public void setPartySpeciesId(Integer value) {
        setValue(15, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value17() {
        return getPartyTypeId();
    }

    /**
     * Getter for {@code pokemon_evolution.party_type_id}.
     */
    public Integer getPartyTypeId() {
        return (Integer) getValue(16);
    }

    /**
     * Setter for {@code pokemon_evolution.party_type_id}.
     */
    public void setPartyTypeId(Integer value) {
        setValue(16, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value18() {
        return getTradeSpeciesId();
    }

    /**
     * Getter for {@code pokemon_evolution.trade_species_id}.
     */
    public Integer getTradeSpeciesId() {
        return (Integer) getValue(17);
    }

    /**
     * Setter for {@code pokemon_evolution.trade_species_id}.
     */
    public void setTradeSpeciesId(Integer value) {
        setValue(17, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value19() {
        return getNeedsOverworldRain();
    }

    /**
     * Getter for {@code pokemon_evolution.needs_overworld_rain}.
     */
    public Boolean getNeedsOverworldRain() {
        return (Boolean) getValue(18);
    }

    /**
     * Setter for {@code pokemon_evolution.needs_overworld_rain}.
     */
    public void setNeedsOverworldRain(Boolean value) {
        setValue(18, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value20() {
        return getTurnUpsideDown();
    }

    /**
     * Getter for {@code pokemon_evolution.turn_upside_down}.
     */
    public Boolean getTurnUpsideDown() {
        return (Boolean) getValue(19);
    }

    /**
     * Setter for {@code pokemon_evolution.turn_upside_down}.
     */
    public void setTurnUpsideDown(Boolean value) {
        setValue(19, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value2(Integer value) {
        setEvolvedSpeciesId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value3(Integer value) {
        setEvolutionTriggerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value4(Integer value) {
        setTriggerItemId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value5(Integer value) {
        setMinimumLevel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value6(Integer value) {
        setGenderId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value7(Integer value) {
        setLocationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value8(Integer value) {
        setHeldItemId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value9(String value) {
        setTimeOfDay(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value10(Integer value) {
        setKnownMoveId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value11(Integer value) {
        setKnownMoveTypeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value12(Integer value) {
        setMinimumHappiness(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value13(Integer value) {
        setMinimumBeauty(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value14(Integer value) {
        setMinimumAffection(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value15(Integer value) {
        setRelativePhysicalStats(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value16(Integer value) {
        setPartySpeciesId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value17(Integer value) {
        setPartyTypeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value18(Integer value) {
        setTradeSpeciesId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value19(Boolean value) {
        setNeedsOverworldRain(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord value20(Boolean value) {
        setTurnUpsideDown(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonEvolutionRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Integer value5,
                                         Integer value6, Integer value7, Integer value8, String value9, Integer value10,
                                         Integer value11, Integer value12, Integer value13, Integer value14,
                                         Integer value15, Integer value16, Integer value17, Integer value18,
                                         Boolean value19, Boolean value20) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        return this;
    }
}