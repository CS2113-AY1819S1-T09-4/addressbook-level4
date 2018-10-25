package seedu.planner.logic.commands;

import org.junit.Test;
import seedu.planner.commons.core.Messages;
import seedu.planner.commons.core.index.Index;
import seedu.planner.logic.CommandHistory;
import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.UserPrefs;
import seedu.planner.model.record.Limit;
import seedu.planner.testutil.LimitBuilder;

import static seedu.planner.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.planner.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.planner.testutil.TypicalRecords.getTypicalFinancialPlanner;

/**
 * To test the functionality of deleteLimitCommand. including multiple tests.
 */
public class DeleteLimitCommandTest {
    private Model model = new ModelManager(getTypicalFinancialPlanner(), new UserPrefs());
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_validLimitList_success() {
        Limit limitToDelete = new LimitBuilder().build();
        model.addLimit(limitToDelete);
        DeleteLimitCommand deleteLimitCommand =
                new DeleteLimitCommand(limitToDelete);

        String expectedMessage =DeleteLimitCommand.MESSAGE_SUCCESS;

        ModelManager expectedModel = new ModelManager(model.getFinancialPlanner(), new UserPrefs());
        expectedModel.deleteLimit(limitToDelete);
        expectedModel.commitFinancialPlanner();

        assertCommandSuccess(deleteLimitCommand, model, commandHistory, expectedMessage, expectedModel);
    }


}