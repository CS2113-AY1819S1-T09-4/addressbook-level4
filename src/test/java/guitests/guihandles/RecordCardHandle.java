package guitests.guihandles;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMultiset;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.model.record.Record;

/**
 * Provides a handle to a record card in the record list panel.
 */
public class RecordCardHandle extends NodeHandle<Node> {
    private static final String ID_FIELD_ID = "#id";
    private static final String NAME_FIELD_ID = "#name";
<<<<<<< HEAD:src/test/java/guitests/guihandles/RecordCardHandle.java
    private static final String EXPENSE_FIELD_ID = "#expense";
    private static final String DATE_FIELD_ID = "#date";
    private static final String INCOME_FIELD_ID = "#income";
=======
    private static final String MONEYFLOW_FIELD_ID = "#moneyFlow";
    private static final String DATE_FIELD_ID = "#date";
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/guitests/guihandles/RecordCardHandle.java
    private static final String TAGS_FIELD_ID = "#tags";

    private final Label idLabel;
    private final Label nameLabel;
<<<<<<< HEAD:src/test/java/guitests/guihandles/RecordCardHandle.java
    private final Label addressLabel;
    private final Label dateLabel;
    private final Label incomeLabel;
=======
    private final Label moneyFlowLabel;
    private final Label dateLabel;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/guitests/guihandles/RecordCardHandle.java
    private final List<Label> tagLabels;

    public RecordCardHandle(Node cardNode) {
        super(cardNode);

        idLabel = getChildNode(ID_FIELD_ID);
        nameLabel = getChildNode(NAME_FIELD_ID);
<<<<<<< HEAD:src/test/java/guitests/guihandles/RecordCardHandle.java
        addressLabel = getChildNode(EXPENSE_FIELD_ID);
        dateLabel = getChildNode(DATE_FIELD_ID);
        incomeLabel = getChildNode(INCOME_FIELD_ID);
=======
        dateLabel = getChildNode(DATE_FIELD_ID);
        moneyFlowLabel = getChildNode(MONEYFLOW_FIELD_ID);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/guitests/guihandles/RecordCardHandle.java

        Region tagsContainer = getChildNode(TAGS_FIELD_ID);
        tagLabels = tagsContainer
                .getChildrenUnmodifiable()
                .stream()
                .map(Label.class::cast)
                .collect(Collectors.toList());
    }

    public String getId() {
        return idLabel.getText();
    }

    public String getName() {
        return nameLabel.getText();
    }

<<<<<<< HEAD:src/test/java/guitests/guihandles/RecordCardHandle.java
    public String getExpense() {
        return addressLabel.getText();
=======
    public String getMoneyFlow() {
        return moneyFlowLabel.getText();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/guitests/guihandles/RecordCardHandle.java
    }

    public String getDate() {
        return dateLabel.getText();
<<<<<<< HEAD:src/test/java/guitests/guihandles/RecordCardHandle.java
    }

    public String getIncome() {
        return incomeLabel.getText();
=======
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/guitests/guihandles/RecordCardHandle.java
    }

    public List<String> getTags() {
        return tagLabels
                .stream()
                .map(Label::getText)
                .collect(Collectors.toList());
    }

    /**
     * Returns true if this handle contains {@code record}.
     */
    public boolean equals(Record record) {
        return getName().equals(record.getName().fullName)
<<<<<<< HEAD:src/test/java/guitests/guihandles/RecordCardHandle.java
                && getExpense().equals(record.getExpense().value)
                && getDate().equals(record.getDate().value)
                && getIncome().equals(record.getIncome().value)
=======
                && getMoneyFlow().equals(record.getMoneyFlow().value)
                && getDate().equals(record.getDate().value)
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/guitests/guihandles/RecordCardHandle.java
                && ImmutableMultiset.copyOf(getTags()).equals(ImmutableMultiset.copyOf(record.getTags().stream()
                        .map(tag -> tag.tagName)
                        .collect(Collectors.toList())));
    }
}
