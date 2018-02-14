package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ListFriendTest {
    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //tag friend present: matched
        assertListFriendCommandBehavior(Arrays.asList(td.amy));
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertListFriendCommandBehavior(List<ReadOnlyPerson> expectedPersonList) {
        ListFriendCommand command = createListFriendCommand();
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private ListFriendCommand createListFriendCommand() {
        ListFriendCommand command = new ListFriendCommand();
        command.setData(addressBook, Collections.emptyList());
        return command;
    }
}
