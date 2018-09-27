package seedu.address.model.record;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
<<<<<<< HEAD
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INCOME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.TypicalRecords.ALICE;
import static seedu.address.testutil.TypicalRecords.BOB;
=======
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MONEYFLOW_EXPENSE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.TypicalRecords.BOB;
import static seedu.address.testutil.TypicalRecords.INDO;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.testutil.RecordBuilder;

public class RecordTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Record record = new RecordBuilder().build();
        thrown.expect(UnsupportedOperationException.class);
        record.getTags().remove(0);
    }

    @Test
    public void isSameRecord() {
        // same object -> returns true
<<<<<<< HEAD
        assertTrue(ALICE.isSameRecord(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameRecord(null));

        // different day parameter and income -> returns false
        Record editedAlice = new RecordBuilder(ALICE).withDate(VALID_DATE_BOB).withIncome(VALID_INCOME_BOB).build();
        assertFalse(ALICE.isSameRecord(editedAlice));

        // different name -> returns false
        editedAlice = new RecordBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSameRecord(editedAlice));

        // same name, same day parameter, different attributes -> returns true
        editedAlice = new RecordBuilder(ALICE).withIncome(VALID_INCOME_BOB).withExpense(VALID_EXPENSE_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameRecord(editedAlice));

        // same name, same income, different attributes -> returns true
        editedAlice = new RecordBuilder(ALICE).withDate(VALID_DATE_BOB).withExpense(VALID_EXPENSE_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameRecord(editedAlice));

        // same name, same day parameter, same income, different attributes -> returns true
        editedAlice = new RecordBuilder(ALICE).withExpense(VALID_EXPENSE_BOB).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameRecord(editedAlice));
=======
        assertTrue(INDO.isSameRecord(INDO));

        // null -> returns false
        assertFalse(INDO.isSameRecord(null));

        // different date parameter and income -> returns false
        Record editedIndo = new RecordBuilder(INDO).withDate(VALID_DATE_BOB)
                .withMoneyFlow(VALID_MONEYFLOW_EXPENSE_BOB).build();
        assertFalse(INDO.isSameRecord(editedIndo));

        // different name -> returns false
        editedIndo = new RecordBuilder(INDO).withName(VALID_NAME_BOB).build();
        assertFalse(INDO.isSameRecord(editedIndo));

        // same name, same date parameter, different attributes -> returns true
        editedIndo = new RecordBuilder(INDO).withMoneyFlow(VALID_MONEYFLOW_EXPENSE_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(INDO.isSameRecord(editedIndo));

        // same name, same money flow, different attributes -> returns true
        editedIndo = new RecordBuilder(INDO).withDate(VALID_DATE_BOB).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(INDO.isSameRecord(editedIndo));

        // same name, same date parameter, same money flow parameter, different attributes -> returns true
        editedIndo = new RecordBuilder(INDO).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(INDO.isSameRecord(editedIndo));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    @Test
    public void equals() {
        // same values -> returns true
<<<<<<< HEAD
        Record aliceCopy = new RecordBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different record -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Record editedAlice = new RecordBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different day parameter -> returns false
        editedAlice = new RecordBuilder(ALICE).withDate(VALID_DATE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different income -> returns false
        editedAlice = new RecordBuilder(ALICE).withIncome(VALID_INCOME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different expense -> returns false
        editedAlice = new RecordBuilder(ALICE).withExpense(VALID_EXPENSE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new RecordBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(ALICE.equals(editedAlice));
=======
        Record aliceCopy = new RecordBuilder(INDO).build();
        assertTrue(INDO.equals(aliceCopy));

        // same object -> returns true
        assertTrue(INDO.equals(INDO));

        // null -> returns false
        assertFalse(INDO.equals(null));

        // different type -> returns false
        assertFalse(INDO.equals(5));

        // different record -> returns false
        assertFalse(INDO.equals(BOB));

        // different name -> returns false
        Record editedAlice = new RecordBuilder(INDO).withName(VALID_NAME_BOB).build();
        assertFalse(INDO.equals(editedAlice));

        // different day parameter -> returns false
        editedAlice = new RecordBuilder(INDO).withDate(VALID_DATE_BOB).build();
        assertFalse(INDO.equals(editedAlice));

        // different money flow -> returns false
        editedAlice = new RecordBuilder(INDO).withMoneyFlow(VALID_MONEYFLOW_EXPENSE_BOB).build();
        assertFalse(INDO.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new RecordBuilder(INDO).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(INDO.equals(editedAlice));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }
}
