package seedu.planner.model.record;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.model.record.exceptions.LimitNotFoundException;
import seedu.planner.model.record.exceptions.RedundantLimitDatesException;

import static java.util.Objects.requireNonNull;

/**
 * The DateBasedLimitList is mainly used for store and manage all the limit of the program.
 * The List is comparing base on the two limit components of limit :dateStart and dateEnd.
 * Once these two dates are confirmed, the user will be able to remove or modify the certain limit.
 * Since during the same dates period, having two different limit money is meaningless.
 */
public class DateBasedLimitList { //implements Iterable<Limit> {

    private final ObservableList<Limit> internalList = FXCollections.observableArrayList();

    /**
     * This function will check whether there is already a limit between the same dates
     * return true if that period of dates already has limit.
     * @param toCheck
     * @return
     */
    public boolean hasSameDatesLimit(Limit toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameLimitDates);
    }

    /**
     * add in a new limit data type to the list.
     * @param limitIn
     */
    public void add(Limit limitIn) {
        requireNonNull(limitIn);
        if (hasSameDatesLimit(limitIn)) {
            throw new RedundantLimitDatesException();
        }
        internalList.add(limitIn);
    }

    /**
     * To remove a limit from the list.
     * @param toRemove
     */
    public void remove(Limit toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new LimitNotFoundException();
        }
    }

    /**
     * returns the newly updated limit list
     * @return
     */
    public ObservableList<Limit> asUnmodifiableObservableList() {
        return FXCollections.unmodifiableObservableList(internalList);
    }
}