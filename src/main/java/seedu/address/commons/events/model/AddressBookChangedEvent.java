package seedu.address.commons.events.model;

import seedu.address.commons.events.BaseEvent;
import seedu.address.model.ReadOnlyAddressBook;

/** Indicates the AddressBook in the model has changed*/
public class AddressBookChangedEvent extends BaseEvent {

    public final ReadOnlyAddressBook data;

    public AddressBookChangedEvent(ReadOnlyAddressBook data) {
        this.data = data;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "number of persons " + data.getRecordList().size();
=======
        return "number of records " + data.getRecordList().size();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }
}
