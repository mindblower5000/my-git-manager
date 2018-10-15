package com.melchuk.mygitmanager.data;

import com.melchuk.mygitmanager.data.model.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ReposDataModel {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Repository> ITEMS = new ArrayList<Repository>();

    /**
     * A map of repos by ID.
     */
    public static final Map<String, Repository> ITEM_MAP = new HashMap<String, Repository>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createRepositoryItem(i));
        }
    }

    private static void addItem(Repository item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Repository createRepositoryItem(int position) {
        return new Repository(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }


}
