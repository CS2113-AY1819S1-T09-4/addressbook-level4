package seedu.address.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_RECORDS;
<<<<<<< HEAD
import static seedu.address.testutil.TypicalRecords.ALICE;
import static seedu.address.testutil.TypicalRecords.BENSON;
=======
import static seedu.address.testutil.TypicalRecords.CAIFAN;
import static seedu.address.testutil.TypicalRecords.INDO;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.model.record.NameContainsKeywordsPredicate;
import seedu.address.testutil.AddressBookBuilder;

public class ModelManagerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ModelManager modelManager = new ModelManager();

    @Test
    public void hasRecord_nullRecord_throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        modelManager.hasRecord(null);
    }

    @Test
    public void hasRecord_recordNotInAddressBook_returnsFalse() {
<<<<<<< HEAD
        assertFalse(modelManager.hasRecord(ALICE));
=======
        assertFalse(modelManager.hasRecord(INDO));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    @Test
    public void hasRecord_recordInAddressBook_returnsTrue() {
<<<<<<< HEAD
        modelManager.addRecord(ALICE);
        assertTrue(modelManager.hasRecord(ALICE));
=======
        modelManager.addRecord(INDO);
        assertTrue(modelManager.hasRecord(INDO));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    @Test
    public void getFilteredRecordList_modifyList_throwsUnsupportedOperationException() {
        thrown.expect(UnsupportedOperationException.class);
        modelManager.getFilteredRecordList().remove(0);
    }

    @Test
    public void equals() {
<<<<<<< HEAD
        AddressBook addressBook = new AddressBookBuilder().withRecord(ALICE).withRecord(BENSON).build();
=======
        AddressBook addressBook = new AddressBookBuilder().withRecord(INDO).withRecord(CAIFAN).build();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        AddressBook differentAddressBook = new AddressBook();
        UserPrefs userPrefs = new UserPrefs();

        // same values -> returns true
        modelManager = new ModelManager(addressBook, userPrefs);
        ModelManager modelManagerCopy = new ModelManager(addressBook, userPrefs);
        assertTrue(modelManager.equals(modelManagerCopy));

        // same object -> returns true
        assertTrue(modelManager.equals(modelManager));

        // null -> returns false
        assertFalse(modelManager.equals(null));

        // different types -> returns false
        assertFalse(modelManager.equals(5));

        // different addressBook -> returns false
        assertFalse(modelManager.equals(new ModelManager(differentAddressBook, userPrefs)));

        // different filteredList -> returns false
<<<<<<< HEAD
        String[] keywords = ALICE.getName().fullName.split("\\s+");
=======
        String[] keywords = INDO.getName().fullName.split("\\s+");
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        modelManager.updateFilteredRecordList(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));
        assertFalse(modelManager.equals(new ModelManager(addressBook, userPrefs)));

        // resets modelManager to initial state for upcoming tests
        modelManager.updateFilteredRecordList(PREDICATE_SHOW_ALL_RECORDS);

        // different userPrefs -> returns true
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setAddressBookFilePath(Paths.get("differentFilePath"));
        assertTrue(modelManager.equals(new ModelManager(addressBook, differentUserPrefs)));
    }
}
