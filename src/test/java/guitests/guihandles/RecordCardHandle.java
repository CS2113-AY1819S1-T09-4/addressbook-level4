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
    private static final String EXPENSE_FIELD_ID = "#expense";
    private static final String DATE_FIELD_ID = "#date";
    private static final String INCOME_FIELD_ID = "#income";
    private static final String TAGS_FIELD_ID = "#tags";

    private final Label idLabel;
    private final Label nameLabel;
    private final Label expenseLabel;
    private final Label dateLabel;
    private final Label incomeLabel;
    private final List<Label> tagLabels;

    public RecordCardHandle(Node cardNode) {
        super(cardNode);

        idLabel = getChildNode(ID_FIELD_ID);
        nameLabel = getChildNode(NAME_FIELD_ID);
        expenseLabel = getChildNode(EXPENSE_FIELD_ID);
        dateLabel = getChildNode(DATE_FIELD_ID);
        incomeLabel = getChildNode(INCOME_FIELD_ID);

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

    public String getExpense() {
        return expenseLabel.getText();
    }

    public String getDate() {
        return dateLabel.getText();
    }

    public String getIncome() {
        return incomeLabel.getText();
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
                && getExpense().equals(record.getExpense().value)
                && getDate().equals(record.getDate().value)
                && getIncome().equals(record.getIncome().value)
                && ImmutableMultiset.copyOf(getTags()).equals(ImmutableMultiset.copyOf(record.getTags().stream()
                        .map(tag -> tag.tagName)
                        .collect(Collectors.toList())));
    }
}
