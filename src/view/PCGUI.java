package view;

import model.ConsT;
import model.ITally;
import model.LengthRestrictedDocument;
import model.ProsT;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.SimpleTimeZone;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static javax.swing.BorderFactory.createEtchedBorder;
import static javax.swing.BorderFactory.createTitledBorder;

public class PCGUI extends JFrame implements IPCGUI, ActionListener, ItemListener, ListSelectionListener {

    private JFrame mainFrame;

    private JPanel mainPanel;
    private JPanel proConPanel;
    private JPanel proPanel;
    private JPanel conPanel;
    private JPanel functionsPanel;
    private JPanel rateProPanel;
    private JPanel rateConPanel;

    private JScrollPane mainScrollPane;
    private JScrollPane proScrollPane;
    private JScrollPane conScrollPane;

    private JTextField enterPro;
    private JTextField enterCon;
    private JTextField titleArea;

    private JList<String> listOfProSelect;
    private JList<String> listOfConSelect;

    private DefaultListModel<String> dataListOfPros;
    private DefaultListModel<String> dataListOfCons;
    private ArrayList<ITally> prosString;
    private ArrayList<ITally> consString;

    private JButton changePC;
    private JButton deletePC;
    private JButton oneProButton;
    private JButton twoProButton;
    private JButton threeProButton;
    private JButton oneConButton;
    private JButton twoConButton;
    private JButton threeConButton;

    private int proSelectedInd;
    private int conSelectedInd;

    String windowTitle = "Pros and Cons - ";
    String fileTitle = "Untitled";
    int newId = 0;
    int newIdCon = 0;

    int width = 800;
    int height = 600;

    int proConCol = width / 26;
    int proConRow = height / 26;

    /**
     * Generates the display for the Pro-Con calculator.
     */
    public void display() {

        setTitle(windowTitle + fileTitle);
        PCGUI.setDefaultLookAndFeelDecorated(false);

        mainFrame = new JFrame();

        proSelectedInd = 0;
        conSelectedInd = 0;

        setPreferredSize(new Dimension(width, height));
        mainPanel = new JPanel();
        proConPanel = new JPanel();

        add(mainPanel, BorderLayout.NORTH);

        add(proConPanel, BorderLayout.CENTER);


        // text area of the title panel to title your file, and the save button
        titleArea = new JTextField("Untitled", 50);
        titleArea.setActionCommand("file title");
        titleArea.addActionListener(this);
        titleArea.setBorder(createTitledBorder("Title"));

        JButton saveTitle = new JButton("Save As Title");
        saveTitle.setActionCommand("file title");
        saveTitle.addActionListener(this);
        mainPanel.add(titleArea);
        mainPanel.add(saveTitle);

        // Panel where the PROS of the decision are
        listOfProSelect = new JList<String>();
        prosString = new ArrayList<ITally>();
        dataListOfPros = new DefaultListModel<String>();

        proPanel = new JPanel();
        proPanel.setBorder(createTitledBorder("Pros"));
        proPanel.setLayout(new BoxLayout(proPanel, BoxLayout.Y_AXIS));
        enterPro = new JTextField(proConCol);
        enterPro.setDocument(new LengthRestrictedDocument(proConCol - 5));
        enterPro.addActionListener(this);
        enterPro.setActionCommand("enter new pro");

        // The 1, 2, 3 buttons under the text field
        rateProPanel = new JPanel();
        oneProButton = new JButton("1");
        oneProButton.addActionListener(this);
        oneProButton.setActionCommand("pro value");

        twoProButton = new JButton("2");
        twoProButton.addActionListener(this);
        twoProButton.setActionCommand("pro value");

        threeProButton = new JButton("3");
        threeProButton.addActionListener(this);
        threeProButton.setActionCommand("pro value");

        rateProPanel.add(oneProButton);
        rateProPanel.add(twoProButton);
        rateProPanel.add(threeProButton);

        prosString = new ArrayList<ITally>();
        this.ArrayIntoListModel(prosString, dataListOfPros);
        listOfProSelect = new JList<String>(dataListOfPros);
//        listOfProSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfProSelect.addListSelectionListener(this);

        proPanel.add(enterPro);
        proPanel.add(rateProPanel);
        proPanel.add(listOfProSelect);

        proConPanel.add(proPanel);

        // Panel where the CONS of the decision are
        listOfConSelect = new JList<String>();
        consString = new ArrayList<ITally>();
        dataListOfCons = new DefaultListModel<String>();

        conPanel = new JPanel();
        conPanel.setBorder(createTitledBorder("Cons"));
        conPanel.setLayout(new BoxLayout(conPanel, BoxLayout.Y_AXIS));
        enterCon = new JTextField(proConCol);
        enterCon.setDocument(new LengthRestrictedDocument(proConCol - 5));
        enterCon.addActionListener(this);
        enterCon.setActionCommand("enter new con");

        // The 1, 2, 3 buttons under the text field
        rateConPanel = new JPanel();
        oneConButton = new JButton("1");
        oneConButton.addActionListener(this);
        oneConButton.setActionCommand("con value");

        twoConButton = new JButton("2");
        twoConButton.addActionListener(this);
        twoConButton.setActionCommand("con value");

        threeConButton = new JButton("3");
        threeConButton.addActionListener(this);
        threeConButton.setActionCommand("con value");

        rateConPanel.add(oneConButton);
        rateConPanel.add(twoConButton);
        rateConPanel.add(threeConButton);

        this.ArrayIntoListModel(consString, dataListOfCons);
        listOfConSelect = new JList<String>(dataListOfCons);
//        listOfConSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfConSelect.addListSelectionListener(this);

        conPanel.add(enterCon);
        conPanel.add(rateConPanel);
        conPanel.add(listOfConSelect);

        proConPanel.add(conPanel);

        // Panel where other functions/tools are
        functionsPanel = new JPanel();
        functionsPanel.setBorder(createTitledBorder("Tools"));

        changePC = new JButton("Change Details of Selected Value");
        changePC.addActionListener(this);
        changePC.setActionCommand("change pro con");

        deletePC = new JButton("Delete Selected Value");
        deletePC.addActionListener(this);
        deletePC.setActionCommand("delete pro con");

        JButton addOne = new JButton("+1");
        addOne.addActionListener(this);
        addOne.setActionCommand("add one");

        JButton subOne = new JButton("-1");
        subOne.addActionListener(this);
        subOne.setActionCommand("subtract one");

        functionsPanel.add(addOne);
        functionsPanel.add(subOne);
        functionsPanel.add(changePC);
        functionsPanel.add(deletePC);

        add(functionsPanel, BorderLayout.SOUTH);

        pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "file title":
                fileTitle = titleArea.getText();
                setTitle(windowTitle + fileTitle);
                break;
            case "pro value":
                String proName = enterPro.getText();
                int proVal;
                ITally tempPro;
                if (e.getSource().equals(oneProButton)) {
                    tempPro = new ProsT(proName, 1);
                } else if (e.getSource().equals(twoProButton)) {
                    tempPro = new ProsT(proName, 2);
                } else {
                    tempPro = new ProsT(proName, 3);
                }
                prosString.add(tempPro);
                dataListOfPros.addElement(tempPro.tallyToString(proConCol));
                enterPro.setText("");
                break;
            case "con value":
                String conName = enterCon.getText();
                int conVal;
                ITally tempCon;
                if (e.getSource().equals(oneConButton)) {
                    tempCon = new ConsT(conName, 1);
                } else if (e.getSource().equals(twoConButton)) {
                    tempCon = new ConsT(conName, 2);
                } else {
                    tempCon = new ConsT(conName, 3);
                }
                consString.add(tempCon);
                dataListOfCons.addElement(tempCon.tallyToString(proConCol));
                enterCon.setText("");
                break;
            case "change pro con":
                int selInd;
                boolean isPro;
                if (listOfConSelect.isSelectionEmpty()) {
                    selInd = listOfProSelect.getSelectedIndex();
                    isPro = true;
                } else {
                    selInd = listOfConSelect.getSelectedIndex();
                    isPro = false;
                }
                this.changeProCon(selInd, isPro);
                break;
            case "delete pro con":
                int deleteInd;
                boolean isProDelete;
                ITally deleteTally;
                if (listOfConSelect.isSelectionEmpty()) {
                    deleteInd = listOfProSelect.getSelectedIndex();
                    isProDelete = true;
                    deleteTally = prosString.get(deleteInd);
                } else {
                    deleteInd = listOfConSelect.getSelectedIndex();
                    isProDelete = false;
                    deleteTally = consString.get(deleteInd);
                }
                int deleteListInt = JOptionPane.showConfirmDialog(
                        mainPanel,
                        "Are you sure you want to delete \""
                                + deleteTally.getDesc()
                                + "\"?",
                        "Delete a Pro/Con",
                        JOptionPane.YES_NO_OPTION);
                if(deleteListInt == 0) {
                    if(isProDelete) {
                        prosString.remove(deleteInd);
                        this.ArrayIntoListModel(prosString, dataListOfPros);
                    }
                    else {
                        consString.remove(deleteInd);
                        this.ArrayIntoListModel(consString, dataListOfCons);
                    }
                }
                break;
            case "add one":
                int addInd;
                if (listOfConSelect.isSelectionEmpty()) {
                    addInd = listOfProSelect.getSelectedIndex();
                    prosString.get(addInd).addSubWeight(true);
                    this.ArrayIntoListModel(prosString, dataListOfPros);
                } else {
                    addInd = listOfConSelect.getSelectedIndex();
                    consString.get(addInd).addSubWeight(true);
                    this.ArrayIntoListModel(consString, dataListOfCons);
                }
                break;
            case "subtract one":
                int subInd;
                if (listOfConSelect.isSelectionEmpty()) {
                    subInd = listOfProSelect.getSelectedIndex();
                    prosString.get(subInd).addSubWeight(false);
                    this.ArrayIntoListModel(prosString, dataListOfPros);
                } else {
                    subInd = listOfConSelect.getSelectedIndex();
                    consString.get(subInd).addSubWeight(false);
                    this.ArrayIntoListModel(consString, dataListOfCons);
                }
                break;
        }
    }

    /**
     * Retrieves the value from either the pro or con list depending on
     * which value from which list is selected
     */
    public void changeProCon(int selInd, boolean isPro) {
        ITally selVal;
        String title;
        ArrayList<ITally> listOfChange;
        DefaultListModel<String> stringList;
        if (isPro) {
            title = "Change a Pro";
            listOfChange = prosString;
            selVal = prosString.get(selInd);
            stringList = dataListOfPros;
        } else {
            title = "Change a Con";
            listOfChange = consString;
            selVal = consString.get(selInd);
            stringList = dataListOfCons;
        }
        String[] options = {"Save Changes", "Cancel"};
        String s = (String) JOptionPane.showInputDialog(
                mainPanel,
                "Change \""
                        + selVal.getDesc()
                        + "\" to:",
                "Change a Pro/Con",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                selVal.getDesc());
        ITally currTally = listOfChange.get(selInd);
        if (isPro) {
            ProsT newPros = new ProsT(s, currTally.getWeight());
            stringList.set(selInd, newPros.tallyToString(proConCol));
            listOfChange.set(selInd, newPros);
        } else {
            ConsT newCons = new ConsT(s, currTally.getWeight());
            stringList.set(selInd, newCons.tallyToString(proConCol));
            listOfChange.set(selInd, newCons);
        }
    }

    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations
     * that need to occur when an item is selected (or deselected).
     *
     * @param e the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    /**
     * Called whenever the value of the selection changes.
     *
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    private void ArrayIntoListModel(ArrayList<ITally> listOfITally, DefaultListModel<String> listOfString) {
        if (listOfITally == null || listOfString == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        listOfString.clear();
        String temp = "";
        for (ITally tempTally : listOfITally) {
            String currName = tempTally.getDesc();
            int currVal = tempTally.getWeight();
            String dots = "";
            int numDots = proConCol - currName.length() - Integer.toString(currVal).length();
            int j = 0;
            while (j < numDots) {
                dots = dots + ".";
                j++;
            }
            temp = currName + dots + Integer.toString(currVal);
            listOfString.addElement(temp);
        }
    }
}

