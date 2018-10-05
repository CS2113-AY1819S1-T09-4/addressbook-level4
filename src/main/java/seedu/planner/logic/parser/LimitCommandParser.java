package seedu.planner.logic.parser;

import java.util.stream.Stream;

import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_MONEYFLOW;

import seedu.planner.logic.commands.LimitCommand;

import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.record.Date;
import seedu.planner.model.record.Limit;

import seedu.planner.model.record.MoneyFlow;



    /*
    * The Parser will parse those values in one format Limit and return back to LimitCommand.
    * */
    public class LimitCommandParser implements Parser<LimitCommand> {
    /**
     * Parses the information required for the limit command.
     * and returns a limit object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */

    @Override
    public LimitCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DATE, PREFIX_MONEYFLOW);

        if (!arePrefixesPresent(argMultimap, PREFIX_DATE, PREFIX_MONEYFLOW)||
                 !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, LimitCommand.MESSAGE_USAGE));
        }

        MoneyFlow money = ParserUtil.parseMoneyFlow(argMultimap.getValue(PREFIX_MONEYFLOW).get());
        Date date1 = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());
        Date date2 = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());
        Limit limit = new Limit(date1, date2, money);


        return new LimitCommand(limit);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
