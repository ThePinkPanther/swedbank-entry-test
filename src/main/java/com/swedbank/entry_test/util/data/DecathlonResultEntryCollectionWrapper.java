package com.swedbank.entry_test.util.data;

import javax.xml.bind.annotation.*;
import java.util.Collection;

/**
 * @author ben
 * @version 1.0
 */
@XmlRootElement(name = "decathlonResults")
@XmlAccessorType(XmlAccessType.FIELD)
public class DecathlonResultEntryCollectionWrapper {

    public Collection<DecathlonResultEntry> getEntries() {
        return entries;
    }

    public void setEntries(Collection<DecathlonResultEntry> entries) {
        this.entries = entries;
    }

    public DecathlonResultEntryCollectionWrapper() {
    }

    public DecathlonResultEntryCollectionWrapper(Collection<DecathlonResultEntry> entries) {

        this.entries = entries;
    }

    @XmlElement(name = "decathlonResult")
    private Collection<DecathlonResultEntry> entries;

}
