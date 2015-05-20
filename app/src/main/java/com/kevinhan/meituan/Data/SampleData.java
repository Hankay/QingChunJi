package com.kevinhan.meituan.Data;

/**
 * Created by Kevin han on 2015/5/6.
 */
import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static final int SAMPLE_DATA_ITEM_COUNT = 13;

    public static ArrayList<String> generateSampleData() {
        final ArrayList<String> data = new ArrayList<String>(SAMPLE_DATA_ITEM_COUNT);

        /*for (int i = 0; i < SAMPLE_DATA_ITEM_COUNT; i++) {
            data.add("SAMPLE #");
        }*/
        data.add("美食");
        data.add("电影");
        data.add("休闲娱乐");
        data.add("酒店");
        data.add("景点");
        data.add("丽人");
        data.add("结婚");
        data.add("亲子");
        data.add("购物");
        data.add("运动健身");
        data.add("生活服务");
        data.add("家装");
        data.add("爱车");

        return data;
    }

}
