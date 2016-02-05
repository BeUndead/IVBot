package com.com.ivbot.compute;

/**
 * Provides some constants and {@code method}s used in the computation of the {@code Power} and {@code Type} of a given
 * {@code HiddenPower} based on the given {@code IV}s.
 */
class HiddenPowerUtilities {

    /**
     * These represent the unique {@code TypeId} assigned to each {@code Type} in the {@code pokedb.sqlite} database.
     * These are required for conversions between the in-game indices used in the {@code HiddenPower} computation, and
     * those used for reference in the database.
     */
    public static final int NORMAL = 1;
    public static final int FIGHTING = 2;
    public static final int FLYING = 3;
    public static final int POISON = 4;
    public static final int GROUND = 5;
    public static final int ROCK = 6;
    public static final int BUG = 7;
    public static final int GHOST = 8;
    public static final int STEEL = 9;
    public static final int FIRE = 10;
    public static final int WATER = 11;
    public static final int GRASS = 12;
    public static final int ELECTRIC = 13;
    public static final int PSYCHIC = 14;
    public static final int ICE = 15;
    public static final int DRAGON = 16;
    public static final int DARK = 17;
    public static final int FAIRY = 18;

    /**
     * These represent the {@code StatId}s for each of the {@code Stat}s.  These are used as the <i>order</i> of
     * consideration for {@code Stat}s differs in the computation of {@code HiddenPower} to those as usually written by
     * players.
     */
    protected static final int HP = 0;
    protected static final int ATTACK = 1;
    protected static final int DEFENSE = 2;
    protected static final int SPECIAL_ATTACK = 3;
    protected static final int SPECIAL_DEFENSE = 4;
    protected static final int SPEED = 5;

    /**
     * The {@code TypeId}s to which each in-game index corresponds.  This is used to finalise the conversion.
     */
    protected static final int[] DATABASE_TYPE_ID_FROM_HIDDEN_POWER_TYPE = new int[] {
            FIGHTING, FLYING, POISON, GROUND, ROCK, BUG, GHOST, STEEL, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC, ICE,
            DRAGON, DARK};

    /**
     * This is the order that {@code Stat}s are considered in the computation of {@code HiddenPower} values.
     */
    protected static final int[] STAT_ORDER = new int[] {
            HP, ATTACK, DEFENSE, SPEED, SPECIAL_ATTACK, SPECIAL_DEFENSE};

    /**
     * Computes the <i>oddness</i> of the given {@code IV}, used in computation of the {@code Type} of the given {@code
     * HiddenPower}.
     *
     * @param iv The value of the {@code IV} in question.
     *
     * @return {@code 0} if the {@code IV} is <i>even</i>, otherwise {@code 1}.
     */
    protected static int hiddenPowerTypeBit(int iv) {
        return iv & 0b1;
    }

    /**
     * Computes the <i>semi-oddness</i> of the given {@code IV}, used in computation of the {@code Power} of the given
     * {@code HiddenPower}.
     *
     * @param iv The value of the {@code IV} in question.
     *
     * @return {@code 0} if the {@code IV} is {@code 0} or {@code 1} {@code mod 4}, otherwise {@code 1}.
     */
    protected static int hiddenPowerPowerBit(int iv) {
        return (iv >> 1) & 0b1;
    }
}
