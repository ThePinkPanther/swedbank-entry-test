package com.swedbank.entry_test.util;

import com.swedbank.entry_test.util.data.DecathlonResultEntry;
import com.swedbank.entry_test.util.data.Position;

import java.util.*;

/**
 * @author ben
 * @version 1.0
 */
public class DecathlonEntryOrganiser {

    private final DecathlonPointsCounter counter;

    public DecathlonEntryOrganiser(DecathlonPointsCounter counter) {
        this.counter = counter;
    }

    /**
     * Counts points and position for each entry, and then returns them ordered by points
     *
     * @param entries entries to organise
     */
    public Collection<DecathlonResultEntry> organise(Collection<DecathlonResultEntry> entries) {

        // A tree set to order the entries in descending order
        final TreeSet<DecathlonResultEntry> entriesTree = new TreeSet<>(
                (Comparator<DecathlonResultEntry>) (a, b) -> {
                    int res = b.getPoints().compareTo(a.getPoints());
                    if (res == 0) {
                        return -1;
                    }
                    return res;
                }
        );

        // Maps points to positions
        final TreeMap<Integer, Collection<Position>> sharingPlaces = new TreeMap<>(
                (a,b) -> b.compareTo(a)
        );

        //Count points for entries
        for (DecathlonResultEntry entry : entries) {
            Integer points = counter.countPoints(entry);
            entry.setPoints(points);
            Position position = new Position();
            entry.setPosition(position);
            // Add entry to a tree
            entriesTree.add(entry);

            // Update sharing places
            if (sharingPlaces.containsKey(points)) {
                sharingPlaces.get(points).add(position);
            } else {
                sharingPlaces.put(points, new LinkedList<>(Arrays.asList(position)));
            }
        }

        // Write position data
        int place = 1;
        for (Collection<Position> positions : sharingPlaces.values()) {
            int count = positions.size();
            for (Position position : positions) {
                position.setFrom(place);
                position.setTo(place+count-1);
            }
            place+= count;
        }

        return entriesTree;
    }

}
