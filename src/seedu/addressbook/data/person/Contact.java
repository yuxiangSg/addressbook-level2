package seedu.addressbook.data.person;

/**
 * Parent Class for Phone,Email and Address.
 */

public class Contact {

    public final String value;
    private boolean isPrivate;

    public Contact(String inputValue, boolean isPrivate){
        value = inputValue.trim();
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
