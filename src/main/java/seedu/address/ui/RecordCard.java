package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.record.Record;

/**
 * An UI component that displays information of a {@code Record}.
 */
public class RecordCard extends UiPart<Region> {

    private static final String FXML = "RecordListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Record record;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
<<<<<<< HEAD:src/main/java/seedu/address/ui/RecordCard.java
    private Label date
            ;
    @FXML
    private Label expense;
    @FXML
    private Label income;
    @FXML
    private FlowPane tags;


    // TODO: Currently, hardcoded. Create a class to handle formatting for UI purposes
=======
    private Label date;
    @FXML
    private Label moneyFlow;
    @FXML
    private FlowPane tags;

    // TODO: Refactor this next time
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/main/java/seedu/address/ui/RecordCard.java
    public RecordCard(Record record, int displayedIndex) {
        super(FXML);
        this.record = record;
        id.setText(displayedIndex + ". ");
        name.setText(record.getName().fullName);
<<<<<<< HEAD:src/main/java/seedu/address/ui/RecordCard.java
        date.setText("Date: " + record.getDate().value);
        expense.setText("Expense: " + record.getExpense().value);
        income.setText("Income: " + record.getIncome().value);
=======
        date.setText(record.getDate().value);
        moneyFlow.setText(record.getMoneyFlow().value);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/main/java/seedu/address/ui/RecordCard.java
        record.getTags().forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RecordCard)) {
            return false;
        }

        // state check
        RecordCard card = (RecordCard) other;
        return id.getText().equals(card.id.getText())
                && record.equals(card.record);
    }
}
