package model;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The model for the decision screen. Here is where the user can create pros and cons.
 */
public class DecisionBoard implements IDecisionBoard {

  private ArrayList<ProsT> pros;
  private ArrayList<ConsT> cons;

  /**
   * Creates a {@code model.DecisionBoard}.
   *
   * @param pros A list of {@code Pros}.
   * @param cons A list of {@code Cons}.
   */
  public DecisionBoard(ArrayList<ProsT> pros, ArrayList<ConsT> cons) {
    this.pros = pros;
    this.cons = cons;
  }

  private void ArrayIntoListModelPro(ArrayList<ITally> pros, int proConCol, DefaultListModel<String> dataListOfPros) {
    if (pros == null || dataListOfPros == null) {
      throw new IllegalArgumentException("List of names must be the same size as the " +
              "list of values");
    }
    String temp = "";
    for (int i = 0; i < pros.size(); i++) {
      ITally currPro = pros.get(i);
      String currName = currPro.getDesc();
      Integer currVal = currPro.getWeight();
      String dots = "";
      int numDots = proConCol - currName.length() - currVal.toString().length();
      int j = 0;
      while (j < numDots) {
        dots = dots + ".";
        j++;
      }
      temp = currName + dots + currVal.toString();
      dataListOfPros.addElement(temp);
    }
//        return tempList;
  }

}
