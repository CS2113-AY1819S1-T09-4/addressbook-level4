package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
import seedu.address.model.record.Expense;
import seedu.address.model.record.Income;
import seedu.address.model.record.Name;
import seedu.address.model.record.Record;
import seedu.address.model.record.Date;
=======
import seedu.address.model.record.Date;
import seedu.address.model.record.Expense;
import seedu.address.model.record.Income;
import seedu.address.model.record.MoneyFlow;
import seedu.address.model.record.Name;
import seedu.address.model.record.Record;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Record objects.
 */
public class RecordBuilder {

<<<<<<< HEAD
    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_DATE = "01-01-2001";
    public static final String DEFAULT_INCOME = "11.30";
    public static final String DEFAULT_EXPENSE = "10.30";

    private Name name;
    private Date date;
    private Income income;
    private Expense expense;
=======
    public static final String DEFAULT_NAME = "Income";
    public static final String DEFAULT_DATE = "01-01-2001";
    public static final String DEFAULT_MONEYFLOW = "+11.30";

    private Name name;
    private Date date;
    private MoneyFlow moneyFlow;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    private Set<Tag> tags;

    public RecordBuilder() {
        name = new Name(DEFAULT_NAME);
        date = new Date(DEFAULT_DATE);
<<<<<<< HEAD
        income = new Income(DEFAULT_INCOME);
        expense = new Expense(DEFAULT_EXPENSE);
=======
        moneyFlow = new Income(DEFAULT_MONEYFLOW);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        tags = new HashSet<>();
    }

    /**
     * Initializes the RecordBuilder with the data of {@code recordToCopy}.
     */
    public RecordBuilder(Record recordToCopy) {
        name = recordToCopy.getName();
        date = recordToCopy.getDate();
<<<<<<< HEAD
        income = recordToCopy.getIncome();
        expense = recordToCopy.getExpense();
=======
        moneyFlow = recordToCopy.getMoneyFlow();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        tags = new HashSet<>(recordToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Record} that we are building.
     */
    public RecordBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Record} that we are building.
     */
    public RecordBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
<<<<<<< HEAD
     * Sets the {@code Expense} of the {@code Record} that we are building.
     */
    public RecordBuilder withExpense(String expense) {
        this.expense = new Expense(expense);
=======
     * Sets the {@code MoneyFlow} of the {@code Record} that we are building.
     */
    public RecordBuilder withMoneyFlow(String moneyFlow) {
        if (Expense.isValidExpense(moneyFlow)) {
            this.moneyFlow = new Expense(moneyFlow);
        } else if (Income.isValidIncome(moneyFlow)) {
            this.moneyFlow = new Income(moneyFlow);
        }
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        return this;
    }

    /**
     * Sets the {@code date} of the {@code Record} that we are building.
     */
    public RecordBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

<<<<<<< HEAD
    /**
     * Sets the {@code Income} of the {@code Record} that we are building.
     */
    public RecordBuilder withIncome(String income) {
        this.income = new Income(income);
        return this;
    }

    public Record build() {
        return new Record(name, date, income, expense, tags);
=======
    public Record build() {
        return new Record(name, date, moneyFlow, tags);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

}
