package model;

/**
 * Interface for a model.Tally class. This class will be the skeleton for units of the program that will
 * contain a tally score, whether it's a pro/cons list or just a tally.
 */
public interface ITally {

    /**
     * Gives the description of the {@code model.Tally}.
     */
    String getDesc();

    /**
     * Gives the current weight of the {@code model.Tally}.
     */
    int getWeight();

    /**
     * Adds or subtracts 1 to the current weight. If the weight is 1 and the user tries to subtract 1,
     * it won't subtract. If the weight is 3 and user tries to add 1, it won't add
     *
     * @param op If false, method will subtract 1 from this {@code Tally} weight. If true, method will add
     *           1 to this {@code Tally} weight
     */
    void addSubWeight(boolean op);

    /**
     * Creates a {@code String} from an {@code ITally} (a pro, con, or tally) so it can be displayed in the GUI
     *
     * @param col The maximum length the {@code ITally can fill} as a string
     */
    String tallyToString(int col);

}
