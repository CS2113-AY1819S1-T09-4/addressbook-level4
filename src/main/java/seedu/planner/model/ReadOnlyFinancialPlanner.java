package seedu.planner.model;

import java.util.HashMap;

import javafx.collections.ObservableList;
import seedu.planner.model.autocomplete.RecordMap;
import seedu.planner.model.record.DateBasedLimitList;
import seedu.planner.model.record.Limit;
import seedu.planner.model.record.Record;

/**
 * Unmodifiable view of an financial planner
 */
public interface ReadOnlyFinancialPlanner {

    /**
     * Returns an unmodifiable view of the records list.
     * This list will not contain any duplicate records.
     */
    ObservableList<Record> getRecordList();

    ObservableList<Limit> getLimitList();

    RecordMap getRecordMap();

    void setLimitList (DateBasedLimitList limitList);
}
