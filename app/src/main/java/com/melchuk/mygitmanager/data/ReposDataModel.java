package com.melchuk.mygitmanager.data;

import com.melchuk.mygitmanager.data.model.RepositoryModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReposDataModel {

    public static final List<RepositoryModel> ITEMS = new ArrayList<RepositoryModel>();

    public static final Map<String, RepositoryModel> ITEM_MAP = new HashMap<String, RepositoryModel>();

    private static final int COUNT = 25;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createRepositoryItem(i));
        }
    }

    private static void addItem(RepositoryModel item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static RepositoryModel createRepositoryItem(int position) {
        return new RepositoryModel(String.valueOf(position), "RepositoryModel/" + position, makeDetails(position));
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
