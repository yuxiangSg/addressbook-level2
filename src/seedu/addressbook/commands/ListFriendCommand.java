package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.ArrayList;
import java.util.List;

public class ListFriendCommand extends Command {
    public static final String COMMAND_WORD = "listFriend";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book with Tag<friend> as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    public static final String FRIEND_TAG = "friend";


    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithFriendTag();
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose tags contain friend.
     *
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithFriendTag(){
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();

        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final UniqueTagList tags = person.getTags();
            if (tags.contains(FRIEND_TAG)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }
}
