package seedu.address.storage;

import static org.junit.Assert.assertEquals;
import static seedu.address.storage.XmlAdaptedRecord.MISSING_FIELD_MESSAGE_FORMAT;
<<<<<<< HEAD
import static seedu.address.testutil.TypicalRecords.BENSON;
=======
import static seedu.address.testutil.TypicalRecords.CAIFAN;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import seedu.address.commons.exceptions.IllegalValueException;
<<<<<<< HEAD
import seedu.address.model.record.Expense;
import seedu.address.model.record.Income;
import seedu.address.model.record.Name;
import seedu.address.model.record.Date;
=======
import seedu.address.model.record.Date;
import seedu.address.model.record.Income;
import seedu.address.model.record.MoneyFlow;
import seedu.address.model.record.Name;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import seedu.address.testutil.Assert;

public class XmlAdaptedRecordTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_DATE = "+651234";
<<<<<<< HEAD
    private static final String INVALID_EXPENSE = " ";
    private static final String INVALID_INCOME = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_DATE = BENSON.getDate().toString();
    private static final String VALID_INCOME = BENSON.getIncome().toString();
    private static final String VALID_EXPENSE = BENSON.getExpense().toString();
    private static final List<XmlAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
=======
    private static final String INVALID_MONEYFLOW = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = CAIFAN.getName().toString();
    private static final String VALID_DATE = CAIFAN.getDate().toString();
    private static final String VALID_MONEYFLOW = CAIFAN.getMoneyFlow().toString();
    private static final List<XmlAdaptedTag> VALID_TAGS = CAIFAN.getTags().stream()
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
            .map(XmlAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validRecordDetails_returnsRecord() throws Exception {
<<<<<<< HEAD
        XmlAdaptedRecord record = new XmlAdaptedRecord(BENSON);
        assertEquals(BENSON, record.toModelType());
=======
        XmlAdaptedRecord record = new XmlAdaptedRecord(CAIFAN);
        assertEquals(CAIFAN, record.toModelType());
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        XmlAdaptedRecord record =
<<<<<<< HEAD
                new XmlAdaptedRecord(INVALID_NAME, VALID_DATE, VALID_INCOME, VALID_EXPENSE, VALID_TAGS);
=======
                new XmlAdaptedRecord(INVALID_NAME, VALID_DATE, VALID_MONEYFLOW, VALID_TAGS);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        String expectedMessage = Name.MESSAGE_NAME_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, record::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
<<<<<<< HEAD
        XmlAdaptedRecord record = new XmlAdaptedRecord(null, VALID_DATE, VALID_INCOME, VALID_EXPENSE, VALID_TAGS);
=======
        XmlAdaptedRecord record = new XmlAdaptedRecord(null, VALID_DATE, VALID_MONEYFLOW, VALID_TAGS);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, record::toModelType);
    }

    @Test
    public void toModelType_invalidDate_throwsIllegalValueException() {
        XmlAdaptedRecord record =
<<<<<<< HEAD
                new XmlAdaptedRecord(VALID_NAME, INVALID_DATE, VALID_INCOME, VALID_EXPENSE, VALID_TAGS);
=======
                new XmlAdaptedRecord(VALID_NAME, INVALID_DATE, VALID_MONEYFLOW, VALID_TAGS);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        String expectedMessage = Date.MESSAGE_DATE_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, record::toModelType);
    }

    @Test
    public void toModelType_nullDate_throwsIllegalValueException() {
<<<<<<< HEAD
        XmlAdaptedRecord record = new XmlAdaptedRecord(VALID_NAME, null, VALID_INCOME, VALID_EXPENSE, VALID_TAGS);
=======
        XmlAdaptedRecord record = new XmlAdaptedRecord(VALID_NAME, null, VALID_MONEYFLOW, VALID_TAGS);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, record::toModelType);
    }

    @Test
<<<<<<< HEAD
    public void toModelType_invalidIncome_throwsIllegalValueException() {
        XmlAdaptedRecord record =
                new XmlAdaptedRecord(VALID_NAME, VALID_DATE, INVALID_INCOME, VALID_EXPENSE, VALID_TAGS);
        String expectedMessage = Income.MESSAGE_INCOME_CONSTRAINTS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, record::toModelType);
    }

    @Test
    public void toModelType_nullIncome_throwsIllegalValueException() {
        XmlAdaptedRecord record = new XmlAdaptedRecord(VALID_NAME, VALID_DATE, null, VALID_EXPENSE, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Income.class.getSimpleName());
        Assert.assertThrows(IllegalValueException.class, expectedMessage, record::toModelType);
    }

    @Test
    public void toModelType_invalidExpense_throwsIllegalValueException() {
        XmlAdaptedRecord record =
                new XmlAdaptedRecord(VALID_NAME, VALID_DATE, VALID_INCOME, INVALID_EXPENSE, VALID_TAGS);
        String expectedMessage = Expense.MESSAGE_EXPENSE_CONSTRAINTS;
=======
    public void toModelType_invalidMoneyFlow_throwsIllegalValueException() {
        XmlAdaptedRecord record =
                new XmlAdaptedRecord(VALID_NAME, VALID_DATE, INVALID_MONEYFLOW, VALID_TAGS);
        String expectedMessage = Income.MESSAGE_MONEY_FLOW_CONSTRAINTS;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        Assert.assertThrows(IllegalValueException.class, expectedMessage, record::toModelType);
    }

    @Test
<<<<<<< HEAD
    public void toModelType_nullExpense_throwsIllegalValueException() {
        XmlAdaptedRecord record = new XmlAdaptedRecord(VALID_NAME, VALID_DATE, VALID_INCOME, null, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Expense.class.getSimpleName());
=======
    public void toModelType_nullMoneyFlow_throwsIllegalValueException() {
        XmlAdaptedRecord record = new XmlAdaptedRecord(VALID_NAME, VALID_DATE, null, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, MoneyFlow.class.getSimpleName());
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        Assert.assertThrows(IllegalValueException.class, expectedMessage, record::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<XmlAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new XmlAdaptedTag(INVALID_TAG));
<<<<<<< HEAD
        XmlAdaptedRecord record =
                new XmlAdaptedRecord(VALID_NAME, VALID_DATE, VALID_INCOME, VALID_EXPENSE, invalidTags);
=======
        XmlAdaptedRecord record = new XmlAdaptedRecord(VALID_NAME, VALID_DATE, VALID_MONEYFLOW, invalidTags);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        Assert.assertThrows(IllegalValueException.class, record::toModelType);
    }

}
