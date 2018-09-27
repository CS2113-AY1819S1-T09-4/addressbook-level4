package seedu.address.model.record;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Record's income in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidIncome(String)}
 */
<<<<<<< HEAD
public class Income {
    
    public static final String MESSAGE_INCOME_CONSTRAINTS = "Income should consist of only digits and/or decimal points ('.')."
            + "It must be of the following form <number>.<number>:\n"
            + "1. <number> cannot start from '0' unless it has only 1 digit. There must be at least 1 digit in this field.\n"
            + "2. At most 1 decimal point can be present. Decimal point is optional."
            + "If decimal point is present, it must have at least 1 digit after it";

    /*
     *  Income must follow the format as stated above.
     */
    // TODO: REFACTOR THIS TO MAKE IT LESS COMPLICATED
    private static final String INCOME_WHOLE_NUMBER_ZERO_REGEX = "0";
    private static final String INCOME_WHOLE_NUMBER_NONZERO_REGEX = "[1-9]{1}\\d*";
    private static final String INCOME_DECIMAL_PART_REGEX = ".\\d+";
    // INCOME_VALIDATION_REGEX = "^(0|[1-9]{1}\d*)($|.\d+)"
    public static final String INCOME_VALIDATION_REGEX = "^" + "(" + INCOME_WHOLE_NUMBER_ZERO_REGEX + "|"
            + INCOME_WHOLE_NUMBER_NONZERO_REGEX + ")" + "(" + "$" + "|" + INCOME_DECIMAL_PART_REGEX + ")";

    public final String value;
=======
public class Income extends MoneyFlow {

    public static final String MESSAGE_INCOME_CONSTRAINTS =
            "Any form of income should consist of '+', "
                    + "followed by a sequence of characters consisting of only digits and/or decimal points ('.')."
                    + "It must be of the following form <number>.<number>:\n"
                    + "1. <number> cannot start from '0' unless it has only 1 digit. "
                    + "There must be at least 1 digit in this field.\n"
                    + "2. At most 1 decimal point can be present. Decimal point is optional."
                    + "If decimal point is present, it must have at least 1 digit after it";

    private static final String INCOME_SIGN_REGEX = "[\\+]";
    private static final String INCOME_VALIDATION_REGEX = "^" + INCOME_SIGN_REGEX
            + "(" + UNSIGNED_MONEYFLOW_VALIDATION_REGEX + ")";
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

    /**
     * Constructs an {@code Income}.
     *
<<<<<<< HEAD
     * @param income A valid income address.
     */
    public Income(String income) {
        requireNonNull(income);
        checkArgument(isValidIncome(income), MESSAGE_INCOME_CONSTRAINTS);
        value = income;
    }

    /**
     * Returns if a given string is a valid income.
=======
     * @param income A valid income.
     */
    public Income(String income) {
        super(income);
        requireNonNull(income);
        checkArgument(isValidIncome(income), MESSAGE_INCOME_CONSTRAINTS);
    }

    /**
     * Returns true if a given string is a valid income.
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
     */
    public static boolean isValidIncome(String test) {
        return test.matches(INCOME_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Income // instanceof handles nulls
                && value.equals(((Income) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
