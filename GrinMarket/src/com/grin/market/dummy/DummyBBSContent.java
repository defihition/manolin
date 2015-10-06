package com.grin.market.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grin.market.type.BBSEntity;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyBBSContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<BBSEntity> ITEMS = new ArrayList<BBSEntity>();

    /**
     * A map of sample (dummy) items, by ID.
     */
//    public static Map<String, BBSEntity> ITEM_MAP = new HashMap<String, BBSEntity>();

    
//    public BBSEntity(String bbsID, String title, String writer, String body) {
//		super();
//		this.bbsID = bbsID;
//		this.title = title;
//		this.writer = writer;
//		this.body = body;
//	}
    static {
        // Add 3 sample items.
        addItem(new BBSEntity("1", "title1", "writer1", "body1"));
        addItem(new BBSEntity("2", "title2", "writer2", "body2"));
        addItem(new BBSEntity("3", "title3", "writer3", "body3"));
    }

    private static void addItem(BBSEntity item) {
        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
    }
}