package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final Pattern ADDRESS_FORMAT =
            Pattern.compile("(?<block>[^/]+)"
                    + ", (?<street>[^/]+)"
                    + ", (?<unit>[^/]+)");


    public final String value;
    public final Block myBlock;
    public final Street myStreet;
    public final Unit myUnit;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();

        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
           throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        Matcher matcher = ADDRESS_FORMAT.matcher(trimmedAddress);
        matcher.matches();

        myBlock = new Block(matcher.group("block"));
        myStreet = new Street(matcher.group("street"));
        myUnit = new Unit(matcher.group("unit"));

        value = trimmedAddress;

    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

/**
 * Represents a Person's block in his address
 */
class Block{

    private String value;

    public Block (String blockName){
        value = blockName;
    }

    public String getBlock(){
        return value;
    }


}

/**
 * Represents a Person's street in his address
 */
class Street{
    private String value;

    public Street (String streetName){
        value = streetName;
    }

    public String getStreet(){
        return value;
    }

}

/**
 * Represents a Person's unit in his address
 */
class Unit{
    private String value;

    public Unit (String unitName){
        value = unitName;
    }

    public String getUnit(){
        return value;
    }

}

/**
 * Represents a Person's Postal Code in his address
 */
class PostalCode{

    private String value;

    public PostalCode (String postalCodeName){
        value = postalCodeName;
    }

    public String getPostalCode(){
        return value;
    }

}


