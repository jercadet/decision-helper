package model;

/**
 * A Pro of a decision. Reffered to as {@code Pro} in Javadoc.
 */
public class ProsT implements ITally {

    private String desc;
    private int weight;

    /**
     * Creates a pro of a decision.
     *
     * @param desc   The short description of the pro of the decision.
     * @param weight The current importance of this pro. This number can only be 1, 2, or 3. 3 being
     *               the greatest level of importance, 1 being least level of importance.
     */
    public ProsT(String desc, int weight) {
        if (desc == null || desc.isBlank()) {
            throw new IllegalArgumentException("Description of a pro must not be an empty string.");
        }
        // check if there is no letter/character in the description
        this.desc = desc;
        if (weight < 1 | weight > 3) {
            throw new IllegalArgumentException("Weight of a pro must be 1, 2, or 3");
        }
        this.weight = weight;
    }

    /**
     * Gives the description of the {@code Pro}.
     *
     * @return The description of this model.Tally.
     */
    @Override
    public String getDesc() {
        return this.desc;
    }

    /**
     * Gives the current weight of the {@code Pro}.
     *
     * @return The weight of this Pro.
     */
    @Override
    public int getWeight() {
        return this.weight;
    }

    /**
     * Adds or subtracts 1 to the current weight. If the weight is 1 and the user tries to subtract 1,
     * it won't subtract. If the weight is 3 and user tries to add 1, it won't add
     *
     * @param op If false, method will subtract 1 from this {@code Tally} weight. If true, method will add
     *           1 to this {@code Tally} weight
     */
    @Override
    public void addSubWeight(boolean op) {
        if ((this.weight > 2 && op) || this.weight < 2 && !op) {
            return;
        }
        if (op) {
            this.weight++;
        } else {
            this.weight--;
        }
    }

  /**
   * Creates a {@code String} from an {@code ITally} (a pro, con, or tally) so it can be displayed in the GUI
   *
   * @param col The maximum length the {@code ITally can fill} as a string
   */
    @Override
    public String tallyToString(int col) {
        StringBuilder dots = new StringBuilder();
        for (int p = 0; p < col - this.desc.length() - 1; p++) {
            dots.append(".");
        }
        return this.desc + dots + Integer.toString(this.weight);
    }
}