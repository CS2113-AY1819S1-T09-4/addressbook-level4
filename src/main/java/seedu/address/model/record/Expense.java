package seedu.address.model.record;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Record's expense in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidExpense(String)}
 */
<<<<<<< HEAD
public class Expense {

    public static final String MESSAGE_EXPENSE_CONSTRAINTS =
            "Expenses should consist of only digits and/or decimal points ('.')."
            + "It must be of the following form <number>.<number>:\n"
            + "1. <number> cannot start from '0' unless it has only 1 digit. There must be at least 1 digit in this field.\n"
            + "2. At most 1 decimal point can be present. Decimal point is optional."
            + "If decimal point is present, it must have at least 1 digit after it";

    /*
     *  Expense must follow the format as stated above.
     */
    // TODO: REFACTOR THIS TO MAKE IT LESS COMPLICATED
    private static final String EXPENSE_WHOLE_NUMBER_ZERO_REGEX = "0";
    private static final String EXPENSE_WHOLE_NUMBER_NONZERO_REGEX = "[1-9]{1}\\d*";
    private static final String EXPENSE_DECIMAL_PART_REGEX = ".\\d+";
    // EXPENSE_VALIDATION_REGEX = "^(0|[1-9]{1}\d*)($|.\d+)"
    public static final String EXPENSE_VALIDATION_REGEX = "^" + "(" + EXPENSE_WHOLE_NUMBER_ZERO_REGEX + "|"
            + EXPENSE_WHOLE_NUMBER_NONZERO_REGEX + ")" + "(" + "$" + "|" + EXPENSE_DECIMAL_PART_REGEX + ")";

    public final String value;
=======
public class Expense extends MoneyFlow {

    public static final String MESSAGE_EXPENSE_CONSTRAINTS =
            "Any form of expense should consist of '-', "
                    + "followed by a sequence of characters consisting of only digits and/or decimal points ('.')."
                    + "It must be of the following form <number>.<number>:\n"
                    + "1. <number> cannot start from '0' unless it has only 1 digit. "
                    + "There must be at least 1 digit in this field.\n"
                    + "2. At most 1 decimal point can be present. Decimal point is optional."
                    + "If decimal point is present, it must have at least 1 digit after it";

    private static final String EXPENSE_SIGN_REGEX = "[-]";
    private static final String EXPENSE_VALIDATION_REGEX = "^" + EXPENSE_SIGN_REGEX
            + "(" + UNSIGNED_MONEYFLOW_VALIDATION_REGEX + ")";

>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

    /**
     * Constructs an {@code Expense}.
     *
     * @param expense A valid expense.
     */
    public Expense(String expense) {
<<<<<<< HEAD
        requireNonNull(expense);
        checkArgument(isValidExpense(expense), MESSAGE_EXPENSE_CONSTRAINTS);
        value = expense;
=======
        super(expense);
        requireNonNull(expense);
        checkArgument(isValidExpense(expense), MESSAGE_EXPENSE_CONSTRAINTS);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    /**
     * Returns true if a given string is a valid expense.
     */
    public static boolean isValidExpense(String test) {
        return test.matches(EXPENSE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Expense // instanceof handles nulls
                && value.equals(((Expense) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
