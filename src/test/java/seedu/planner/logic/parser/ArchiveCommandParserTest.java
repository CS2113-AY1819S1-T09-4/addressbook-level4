package seedu.planner.logic.parser;

import static seedu.planner.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_DIR;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.planner.model.DirectoryPath.HOME_DIRECTORY_STRING;

import org.junit.jupiter.api.Test;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.ArchiveCommand;
import seedu.planner.model.DirectoryPath;
import seedu.planner.model.record.Date;
import seedu.planner.testutil.TypicalRecords;

public class ArchiveCommandParserTest {
    public static final String WHITE_SPACE = " ";
    private ArchiveCommandParser parser = new ArchiveCommandParser();

    @Test
    public void parse_invalidArgs_throwsParseException() {
        Date startDate = TypicalRecords.TYPICAL_START_DATE;
        Date endDate = TypicalRecords.TYPICAL_END_DATE;
        DirectoryPath directoryPath = DirectoryPath.HOME_DIRECTORY;

        CommandParserTestUtil.assertParseFailure(parser, WHITE_SPACE + PREFIX_DATE + " 3A-3B-19C9    ",
                String.format(Date.MESSAGE_DATE_CONSTRAINTS, ArchiveCommand.MESSAGE_USAGE));

        CommandParserTestUtil.assertParseFailure(parser, WHITE_SPACE + PREFIX_DATE + " 3A-3B-1999 13-4-2020",
                String.format(Date.MESSAGE_DATE_CONSTRAINTS, ArchiveCommand.MESSAGE_USAGE));

        CommandParserTestUtil.assertParseFailure(parser,
                WHITE_SPACE + PREFIX_DATE + " 31-03-1999 31-04-2019 31-12-2020",
                String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT + Messages.MESSAGE_INVALID_DATE_REQUIRED,
                        ArchiveCommand.MESSAGE_USAGE));

        CommandParserTestUtil.assertParseFailure(parser, WHITE_SPACE + PREFIX_DIR + " unrealistic\\directory",
                String.format(Messages.MESSAGE_UNREALISTIC_DIRECTORY, ArchiveCommand.MESSAGE_USAGE));

        CommandParserTestUtil.assertParseFailure(parser, WHITE_SPACE + HOME_DIRECTORY_STRING,
                String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, ArchiveCommand.MESSAGE_USAGE));

        CommandParserTestUtil.assertParseFailure(parser, WHITE_SPACE + startDate.value + " " + endDate.value,
                String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, ArchiveCommand.MESSAGE_USAGE));

        CommandParserTestUtil.assertParseFailure(parser,
                WHITE_SPACE + PREFIX_DATE + endDate.value + " " + startDate.value,
                String.format(Messages.MESSAGE_INVALID_STARTDATE_ENDDATE, ArchiveCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsAchieveExcelCommand() {
        String startDate = TypicalRecords.TYPICAL_START_DATE.getValue();
        String endDate = TypicalRecords.TYPICAL_END_DATE.getValue();
        String directoryPath = HOME_DIRECTORY_STRING;
        //Case 1: return AchieveExcelCommand()
        ArchiveCommand expectedAchieveExcelCommand1 = new ArchiveCommand();
        assertParseSuccess(parser,
                WHITE_SPACE,
                expectedAchieveExcelCommand1);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DIR + WHITE_SPACE,
                expectedAchieveExcelCommand1);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE + WHITE_SPACE,
                expectedAchieveExcelCommand1);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE
                        + WHITE_SPACE + PREFIX_DIR + WHITE_SPACE,
                expectedAchieveExcelCommand1);

        //Case 2: return AchieveExcelCommand(Date startDate, Date endDate)
        ArchiveCommand expectedAchieveExcelCommand2 =
                new ArchiveCommand(TypicalRecords.TYPICAL_START_DATE, TypicalRecords.TYPICAL_END_DATE);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE + startDate
                        + WHITE_SPACE + endDate,
                expectedAchieveExcelCommand2);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE + startDate + WHITE_SPACE + endDate + WHITE_SPACE + PREFIX_DIR,
                expectedAchieveExcelCommand2);

        //Case 3: return AchieveExcelCommand(Date startDate, Date startDate)
        ArchiveCommand expectedAchieveExcelCommand3 =
                new ArchiveCommand(TypicalRecords.TYPICAL_START_DATE, TypicalRecords.TYPICAL_START_DATE);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE + startDate + WHITE_SPACE + startDate,
                expectedAchieveExcelCommand3);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE + startDate,
                expectedAchieveExcelCommand3);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE + startDate + WHITE_SPACE + PREFIX_DIR,
                expectedAchieveExcelCommand3);

        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE + startDate + WHITE_SPACE + startDate + WHITE_SPACE + PREFIX_DIR,
                expectedAchieveExcelCommand3);

        //Case 4: return Achieve Command (Date startDate, Date endDate, String directory)
        ArchiveCommand expectedAchieveExcelComamnd4 = new ArchiveCommand(TypicalRecords.TYPICAL_START_DATE,
                TypicalRecords.TYPICAL_END_DATE, DirectoryPath.HOME_DIRECTORY_STRING);
        assertParseSuccess(parser,
                WHITE_SPACE + PREFIX_DATE + startDate + WHITE_SPACE + endDate + WHITE_SPACE + PREFIX_DIR
                + directoryPath,
                expectedAchieveExcelComamnd4);
    }
}