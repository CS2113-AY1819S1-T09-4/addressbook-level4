package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/EditRecordDescriptorTest.java
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INCOME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
=======
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MONEYFLOW_EXPENSE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/seedu/address/logic/commands/EditRecordDescriptorTest.java
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import org.junit.Test;

import seedu.address.logic.commands.EditCommand.EditRecordDescriptor;
import seedu.address.testutil.EditRecordDescriptorBuilder;

public class EditRecordDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditRecordDescriptor descriptorWithSameValues = new EditCommand.EditRecordDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/EditRecordDescriptorTest.java
        EditCommand.EditRecordDescriptor editedAmy = new EditRecordDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
=======
        EditCommand.EditRecordDescriptor editedAmy = new EditRecordDescriptorBuilder(DESC_AMY)
                .withName(VALID_NAME_BOB).build();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/seedu/address/logic/commands/EditRecordDescriptorTest.java
        assertFalse(DESC_AMY.equals(editedAmy));

        // different day params -> returns false
        editedAmy = new EditRecordDescriptorBuilder(DESC_AMY).withDate(VALID_DATE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/EditRecordDescriptorTest.java
        // different income -> returns false
        editedAmy = new EditRecordDescriptorBuilder(DESC_AMY).withIncome(VALID_INCOME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different expense -> returns false
        editedAmy = new EditRecordDescriptorBuilder(DESC_AMY).withExpense(VALID_EXPENSE_BOB).build();
=======
        // different money flow -> returns false
        editedAmy = new EditRecordDescriptorBuilder(DESC_AMY).withMoneyFlow(VALID_MONEYFLOW_EXPENSE_BOB).build();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e:src/test/java/seedu/address/logic/commands/EditRecordDescriptorTest.java
        assertFalse(DESC_AMY.equals(editedAmy));

        // different tags -> returns false
        editedAmy = new EditRecordDescriptorBuilder(DESC_AMY).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }
}
