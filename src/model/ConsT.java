package model;

/**
   * A Con of a decision. Referred to as {@code Con} in Javadoc.
   */
  public class ConsT implements ITally{

    private String desc;
    private int weight;

    /**
     * Creates a con of a decision. This decision has a short sentence explaining what it is and a weight of how
     * important it is to the user.
     *
     * @param desc The short description of the con of the decision.
     * @param weight The current importance of this con. This number can only be 1, 2, or 3. 3 being
     *               greatest level of importance, 1 being least level of importance.
     */
    public ConsT(String desc, int weight) {
      if (desc == null || desc.isBlank()) {
        throw new IllegalArgumentException("Description of a con must not be an empty string.");
      }
      // check if there is no letter/character in the description
      this.desc = desc;
      if (weight < 1 | weight > 3) {
        throw new IllegalArgumentException("Weight of a con must be 1, 2, or 3");
      }
      this.weight = weight;
    }

    /**
     * Gives the description of the {@code con}.
     *
     * @return The description of this model.Tally.
     */
    @Override
    public String getDesc() {
      return this.desc;
    }

    /**
     * Gives the current weight of the {@code con}.
     *
     * @return The weight of this con.
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
    }
    else {
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