package seedu.planner.logic.commands;

import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import seedu.planner.commons.core.EventsCenter;
import seedu.planner.commons.events.ui.ShowPieChartStatsEvent;
import seedu.planner.logic.CommandHistory;
import seedu.planner.model.Model;
import seedu.planner.model.record.Date;
import seedu.planner.model.record.DateIsWithinIntervalPredicate;
import seedu.planner.model.record.Record;
import seedu.planner.model.summary.CategoryStatisticsList;
//@@author tenvinc
/**
 * Shows the statistics of the current summary
 */
public class StatisticCommand extends Command {

    public static final String COMMAND_WORD = "stats";

    public static final String MESSAGE_USAGE = "Provides a statistic based on the summary table displayed.";

    public static final String MESSAGE_SUCCESS = "Stats generated!";

    private final Predicate<Record> predicate;

    public StatisticCommand(Date startDate, Date endDate) {
        requireAllNonNull(startDate, endDate);
        predicate = new DateIsWithinIntervalPredicate(startDate, endDate);
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        ObservableList<Record> recordList = model.getFinancialPlanner().getRecordList();
        List<Record> filteredList = filterRecordListByPredicate(recordList, predicate);
        CategoryStatisticsList categoryStats = new CategoryStatisticsList(filteredList);
        EventsCenter.getInstance().post(new ShowPieChartStatsEvent(categoryStats.getReadOnlyStatsList()));
        return new CommandResult(MESSAGE_SUCCESS);
    }

    public List<Record> filterRecordListByPredicate(List<Record> recordList, Predicate<Record> predicate) {
        return recordList.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StatisticCommand // instanceof handles nulls
                && predicate.equals(((StatisticCommand) other).predicate));
    }
}
