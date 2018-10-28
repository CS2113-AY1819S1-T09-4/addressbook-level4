package seedu.planner.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import seedu.planner.commons.core.LogsCenter;
import seedu.planner.commons.core.Messages;
import seedu.planner.commons.util.ExcelUtil;
import seedu.planner.commons.util.FileUtil;
import seedu.planner.logic.CommandHistory;
import seedu.planner.model.Model;
import seedu.planner.model.record.DateIsWithinIntervalPredicate;
import seedu.planner.model.record.Record;

/**
 * Export the data of the records within specific period.
 */
public class ExportExcelCommand extends Command {
    public static final String COMMAND_WORD = "export_excel";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Export the records data into Excel file within specific period.\n"
            + "The file will be named in format: Financial_Planner_STARTDATE_ENDDATE.\n"
            + "Parameters: START_DATE END_DATE, START_DATE should be equal to or smaller than END_DATE.\n"
            + "Example: " + COMMAND_WORD + " 31-03-1999 31-3-2018\n";

    private final DateIsWithinIntervalPredicate predicate;
    private Logger logger = LogsCenter.getLogger(ExportExcelCommand.class);

    public ExportExcelCommand(DateIsWithinIntervalPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory commandHistory) {
        requireNonNull(this);
        model.updateFilteredRecordList(predicate);
        List<Record> recordList = model.getFilteredRecordList();
        String nameFile = String.format("Financial_Planner_%1$s_%2$s.xlsx",
                predicate.getStartDate().getValue(), predicate.getEndDate().getValue());
        logger.info(nameFile);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(nameFile);
        Map<String, Object[]> mapData = ExcelUtil.exportData(recordList);
        ExcelUtil.writeDataIntoExcelSheet(mapData, sheet);
        FileUtil.writeWorkBookInFileSystem(nameFile, workbook);
        return new CommandResult(String.format(Messages.MESSAGE_EXCEL_FILE_WRITTEN_SUCCESSFULLY, nameFile));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExportExcelCommand // instanceof handles nulls
                && predicate.equals(((ExportExcelCommand) other).predicate)); // state check
    }
}
