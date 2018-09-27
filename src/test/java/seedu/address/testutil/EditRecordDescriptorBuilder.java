package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditRecordDescriptor;
<<<<<<< HEAD
=======
import seedu.address.model.record.Date;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import seedu.address.model.record.Expense;
import seedu.address.model.record.Income;
import seedu.address.model.record.Name;
import seedu.address.model.record.Record;
<<<<<<< HEAD
import seedu.address.model.record.Date;
=======
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditRecordDescriptor objects.
 */
public class EditRecordDescriptorBuilder {

    private EditCommand.EditRecordDescriptor descriptor;

    public EditRecordDescriptorBuilder() {
        descriptor = new EditRecordDescriptor();
    }

    public EditRecordDescriptorBuilder(EditRecordDescriptor descriptor) {
        this.descriptor = new EditRecordDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditRecordDescriptor} with fields containing {@code record}'s details
     */
    public EditRecordDescriptorBuilder(Record record) {
        descriptor = new EditCommand.EditRecordDescriptor();
        descriptor.setName(record.getName());
        descriptor.setDate(record.getDate());
<<<<<<< HEAD
        descriptor.setIncome(record.getIncome());
        descriptor.setExpense(record.getExpense());
=======
        descriptor.setMoneyFlow(record.getMoneyFlow());
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        descriptor.setTags(record.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditRecordDescriptor} that we are building.
     */
    public EditRecordDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code date} of the {@code EditRecordDescriptor} that we are building.
     */
    public EditRecordDescriptorBuilder withDate(String date) {
        descriptor.setDate(new Date(date));
        return this;
    }

    /**
<<<<<<< HEAD
     * Sets the {@code Income} of the {@code EditRecordDescriptor} that we are building.
     */
    public EditRecordDescriptorBuilder withIncome(String email) {
        descriptor.setIncome(new Income(email));
        return this;
    }

    /**
     * Sets the {@code Expense} of the {@code EditRecordDescriptor} that we are building.
     */
    public EditRecordDescriptorBuilder withExpense(String expense) {
        descriptor.setExpense(new Expense(expense));
=======
     * Sets the {@code MoneyFlow} of the {@code EditRecordDescriptor} that we are building.
     */
    public EditRecordDescriptorBuilder withMoneyFlow(String moneyFlow) {
        if (Expense.isValidExpense(moneyFlow)) {
            descriptor.setMoneyFlow(new Expense(moneyFlow));
        }
        if (Income.isValidIncome(moneyFlow)) {
            descriptor.setMoneyFlow(new Income(moneyFlow));
        }
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditRecordDescriptor}
     * that we are building.
     */
    public EditRecordDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditCommand.EditRecordDescriptor build() {
        return descriptor;
    }
}
