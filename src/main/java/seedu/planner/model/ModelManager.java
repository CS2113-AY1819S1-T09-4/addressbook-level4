package seedu.planner.model;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.logic.commands.AddLimitCommand.MESSAGE_BASIC_EARNED;
import static seedu.planner.logic.commands.AddLimitCommand.MESSAGE_BASIC_SPEND;
import static seedu.planner.logic.commands.AddLimitCommand.MESSAGE_DOUBLE_DATE;
import static seedu.planner.logic.commands.AddLimitCommand.MESSAGE_EXCEED;
import static seedu.planner.logic.commands.AddLimitCommand.MESSAGE_MONTHLY;
import static seedu.planner.logic.commands.AddLimitCommand.MESSAGE_NOT_EXCEED;
import static seedu.planner.logic.commands.AddLimitCommand.MESSAGE_SINGLE_DATE;

import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.planner.commons.core.ComponentManager;
import seedu.planner.commons.core.EventsCenter;
import seedu.planner.commons.core.LogsCenter;
import seedu.planner.commons.events.model.FinancialPlannerChangedEvent;
import seedu.planner.commons.events.model.LimitListChangedEvent;
import seedu.planner.commons.events.model.TagMapChangedEvent;
import seedu.planner.commons.events.ui.UpdateWelcomePanelEvent;
import seedu.planner.commons.util.DateUtil;
import seedu.planner.model.record.Date;
import seedu.planner.model.record.DateIsWithinIntervalPredicate;
import seedu.planner.model.record.Limit;
import seedu.planner.model.record.Record;
import seedu.planner.model.summary.CategoryStatisticsList;

/**
 * Represents the in-memory model of the financial planner data.
 */
public class ModelManager extends ComponentManager implements Model {
    public static final Date DATE_SPECIAL_FOR_MONTHLY = new Date("01-01-9999");
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);
    private static final int STARTING_ELEMENT = 0;

    private final VersionedFinancialPlanner versionedFinancialPlanner;
    private final FilteredList<Record> filteredRecords;
    private final FilteredList<Limit> limits;
    private final FilteredList<Record> recordsInCurrentMonth;

    /**
     * Initializes a ModelManager with the given financialPlanner and userPrefs.
     */
    public ModelManager(ReadOnlyFinancialPlanner financialPlanner, UserPrefs userPrefs) {
        super();
        requireAllNonNull(financialPlanner, userPrefs);

        logger.fine("Initializing with financial planner: " + financialPlanner
                + " and user prefs " + userPrefs);

        versionedFinancialPlanner = new VersionedFinancialPlanner(financialPlanner);
        filteredRecords = new FilteredList<>(versionedFinancialPlanner.getRecordList());
        limits = new FilteredList<>(versionedFinancialPlanner.getLimitList());
        recordsInCurrentMonth = new FilteredList<>(versionedFinancialPlanner.getRecordList(),
                new DateIsWithinIntervalPredicate(DateUtil.generateFirstOfMonth(getCurrentMonth()),
                        DateUtil.generateLastOfMonth(getCurrentMonth())));
        recordsInCurrentMonth.addListener((ListChangeListener<Record>) c -> {
            while (c.next()) {
                if (c.wasPermutated()) {
                    return;
                }
                Month currentMonth = getCurrentMonth();
                Predicate<Record> newPredicate = new DateIsWithinIntervalPredicate(
                        DateUtil.generateFirstOfMonth(currentMonth),
                        DateUtil.generateLastOfMonth(currentMonth));
                if (!newPredicate.equals(recordsInCurrentMonth.getPredicate())) {
                    recordsInCurrentMonth.setPredicate(newPredicate);
                }
                CategoryStatisticsList statsList = new CategoryStatisticsList(recordsInCurrentMonth);
                EventsCenter.getInstance().post(new UpdateWelcomePanelEvent(statsList.getReadOnlyStatsList(),
                        currentMonth.toString()));
            }
        });
        EventsCenter.getInstance().registerHandler(this);
    }

    public ModelManager() {
        this(new FinancialPlanner(), new UserPrefs());
    }

    //TODO: refactor into date util
    public Month getCurrentMonth() {
        Date currentDate = DateUtil.getDateToday();
        return new Month(currentDate.getMonth(), currentDate.getYear());
    }

    @Override
    public void resetData(ReadOnlyFinancialPlanner newData) {
        versionedFinancialPlanner.resetData(newData);
        indicateFinancialPlannerChanged();
        indicateTagMapChanged();
    }

    @Override
    public ReadOnlyFinancialPlanner getFinancialPlanner() {
        return versionedFinancialPlanner;
    }

    public ObservableList<Record> getRecordsThisMonth() {
        return recordsInCurrentMonth;
    }

    //=========== Event management methods =========================================================

    /** Raises an event to indicate the model has changed */
    private void indicateFinancialPlannerChanged() {
        raise(new FinancialPlannerChangedEvent(versionedFinancialPlanner));
        autoLimitCheck();
    }

    /** Raises an event to indicate the limit list has changed */
    private void indicateLimitListChanged() {
        raise(new LimitListChangedEvent(versionedFinancialPlanner));
    }

    /** Raises an event to indicate the limit list has changed */
    private void indicateTagMapChanged() {
        raise(new TagMapChangedEvent(versionedFinancialPlanner));
    }

    //=========== Financial planner standard operations ============================================

    @Override
    public boolean hasRecord(Record record) {
        requireNonNull(record);
        return versionedFinancialPlanner.hasRecord(record);
    }

    @Override
    public void deleteRecord(Record target) {
        requireNonNull(target);
        versionedFinancialPlanner.removeRecord(target);
        versionedFinancialPlanner.removeRecordFromTagMap(target);
        indicateFinancialPlannerChanged();
        indicateTagMapChanged();
    }

    @Override
    public void deleteListRecord(List<Record> records) {
        requireNonNull(records);
        versionedFinancialPlanner.removeListRecord(records);
        indicateFinancialPlannerChanged();
    }

    @Override
    public void addRecord(Record record) {
        requireNonNull(record);
        versionedFinancialPlanner.addRecord(record);
        versionedFinancialPlanner.addRecordToTagMap(record);
        updateFilteredRecordList(PREDICATE_SHOW_ALL_RECORDS);
        indicateFinancialPlannerChanged();
        indicateTagMapChanged();
    }

    @Override
    public void addListUniqueRecord(List<Record> records) {
        requireNonNull(records);
        for (Record record : records) {
            if (hasRecord(record)) {
                continue;
            }
            versionedFinancialPlanner.addRecord(record);
            versionedFinancialPlanner.addRecordToTagMap(record);
        }
        updateFilteredRecordList(PREDICATE_SHOW_ALL_RECORDS);
        indicateFinancialPlannerChanged();
        indicateTagMapChanged();
    }

    @Override
    public void updateRecord(Record target, Record editedRecord) {
        requireAllNonNull(target, editedRecord);
        versionedFinancialPlanner.updateRecord(target, editedRecord);
        versionedFinancialPlanner.updateRecordInTagMap(target, editedRecord);
        indicateFinancialPlannerChanged();
        indicateTagMapChanged();
    }
    //@@Author OscarZeng
    //=========== Limit related methods =====================================================
    @Override
    public boolean hasSameDateLimit(Limit limitIn) {
        requireNonNull(limitIn);
        return versionedFinancialPlanner.hasSameDateLimit(limitIn);
    }
    @Override
    public void deleteLimit(Limit target) {
        requireNonNull(target);
        versionedFinancialPlanner.removeLimit(target);
        indicateLimitListChanged();
    }

    @Override
    public void addLimit(Limit limitIn) {
        requireNonNull(limitIn);
        versionedFinancialPlanner.addLimit(limitIn);
        indicateLimitListChanged();
    }
    @Override
    public boolean isExceededLimit (Limit limitIn) {
        requireNonNull(limitIn);
        if (limitIn.getDateEnd().equals(DATE_SPECIAL_FOR_MONTHLY)) {
            limitIn = generateThisMonthLimit(limitIn);
        }
        requireNonNull(limitIn);
        return (versionedFinancialPlanner.isExceededLimit(limitIn));
    }
    @Override
    public void updateLimit(Limit target, Limit editedLimit) {
        requireAllNonNull(target, editedLimit);
        versionedFinancialPlanner.updateLimit(target, editedLimit);
        indicateLimitListChanged();
    }

    @Override
    public Limit getSameDatesLimit (Date dateStart, Date dateEnd) {
        requireAllNonNull(dateStart, dateEnd);
        return versionedFinancialPlanner.getSameDatesLimit(dateStart, dateEnd);
    }
    @Override
    public Double getTotalSpend (Limit limitIn) {
        requireNonNull(limitIn);
        if (limitIn.getDateEnd().equals(DATE_SPECIAL_FOR_MONTHLY)) {
            limitIn = generateThisMonthLimit(limitIn);
        }
        requireNonNull(limitIn);
        return versionedFinancialPlanner.getTotalSpend(limitIn);
    }
    @Override
    public String autoLimitCheck () {
        String output = "";
        int count = 1;
        for (Limit i: limits) {
            if (isExceededLimit(i) && i.getDateEnd().equals(DATE_SPECIAL_FOR_MONTHLY)) {
                output += "\n" + String.format("%d.", count++) + generateLimitOutput(true, getTotalSpend(i), i);
            }
        }
        for (Limit i: limits) {
            if (isExceededLimit(i) && !i.getDateEnd().equals(DATE_SPECIAL_FOR_MONTHLY)) {
                output += "\n" + String.format("%d.", count++) + generateLimitOutput(true, getTotalSpend(i), i);
            }
        }
        return output;
    }

    @Override
    public String manualLimitCheck () {
        String output = "";
        int count = 1;
        for (Limit i: limits) {
            if (i.getDateEnd().equals(DATE_SPECIAL_FOR_MONTHLY)) {
                output += "\n" + "Monthly Limit:\n"
                        + generateLimitOutput(isExceededLimit(i), getTotalSpend(i), i);
            }
        }
        output += "Normal limits:";
        for (Limit i: limits) {
            if (i.getDateEnd().equals(DATE_SPECIAL_FOR_MONTHLY)) {
                continue;
            }
            output += "\n" + String.format("%d.", count++)
                    + generateLimitOutput(isExceededLimit(i), getTotalSpend(i), i);
        }
        return output;
    }

    /**
     * This function is to generate the limit for this month when the according to the
     * monthly limit.
     * @param limitIn
     * @return
     */
    public Limit generateThisMonthLimit (Limit limitIn) {
        requireNonNull(limitIn);
        Date today = DateUtil.getDateToday();
        Month thisMonth = new Month(today.getMonth(), today.getYear());
        Date dateStart = DateUtil.generateFirstOfMonth(thisMonth);
        Date dateEnd = DateUtil.generateLastOfMonth(thisMonth);
        Limit thisMonthLimit = new Limit(dateStart, dateEnd, limitIn.getLimitMoneyFlow());

        return thisMonthLimit;
    }
    /**
     * This function is to generate the limit output.
     * @param isExceeded
     * @param limit
     * @return
     */
    public String generateLimitOutput (boolean isExceeded, Double totalMoney, Limit limit) {
        String output;
        Date dateStart;
        Date dateEnd;
        dateStart = limit.getDateStart();
        dateEnd = limit.getDateEnd();
        if (dateStart.equals(DATE_SPECIAL_FOR_MONTHLY)) {
            output = String.format(MESSAGE_MONTHLY, DateUtil.getDateToday().getMonth());
        } else if (dateEnd.equals(dateStart)) {
            output = String.format(MESSAGE_SINGLE_DATE, dateStart);
        } else {
            output = String.format(MESSAGE_DOUBLE_DATE, dateStart, dateEnd);
        }

        if (totalMoney >= 0) {
            output += String.format(MESSAGE_BASIC_EARNED,
                    -1 * limit.getLimitMoneyFlow().toDouble(), totalMoney)
                    + MESSAGE_NOT_EXCEED;
        } else if (isExceeded) {
            output += String.format(MESSAGE_BASIC_SPEND,
                    -1 * limit.getLimitMoneyFlow().toDouble(), -1 * totalMoney)
                    + MESSAGE_EXCEED;
        } else {
            output += String.format(MESSAGE_BASIC_SPEND,
                    -1 * limit.getLimitMoneyFlow().toDouble(), -1 * totalMoney)
                    + MESSAGE_NOT_EXCEED;
        }
        return output;
    }


    //=========== Filtered Record List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Record} backed by the internal list of
     * {@code versionedFinancialPlanner}
     */
    @Override
    public ObservableList<Record> getFilteredRecordList() {
        return FXCollections.unmodifiableObservableList(filteredRecords);
    }

    //show all the records
    @Override
    public ObservableList<Limit> getLimitList() {
        return FXCollections.unmodifiableObservableList(limits);
    }

    @Override
    public void updateFilteredRecordList(Predicate<Record> predicate) {
        requireNonNull(predicate);
        filteredRecords.setPredicate(predicate);
    }

    //=========== Modifying Record List Accessors =============================================================

    @Override
    public void sortFilteredRecordList(String category, Boolean ascending) {
        requireAllNonNull(category, ascending);
        versionedFinancialPlanner.sortRecords(category, ascending);
    }

    //=========== Undo/Redo =================================================================================

    @Override
    public boolean canUndoFinancialPlanner() {
        return versionedFinancialPlanner.canUndo();
    }

    @Override
    public boolean canRedoFinancialPlanner() {
        return versionedFinancialPlanner.canRedo();
    }

    @Override
    public void undoFinancialPlanner() {
        versionedFinancialPlanner.undo();
        indicateFinancialPlannerChanged();
        indicateLimitListChanged();
        indicateTagMapChanged();
    }

    @Override
    public void redoFinancialPlanner() {
        versionedFinancialPlanner.redo();
        indicateFinancialPlannerChanged();
        indicateLimitListChanged();
        indicateTagMapChanged();
    }

    @Override
    public void commitFinancialPlanner() {
        versionedFinancialPlanner.commit();
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return versionedFinancialPlanner.equals(other.versionedFinancialPlanner)
                && filteredRecords.equals(other.filteredRecords);
    }
}
