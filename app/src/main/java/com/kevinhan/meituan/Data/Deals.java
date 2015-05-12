package com.kevinhan.meituan.Data;

/**
 * Created by Kevin Han on 2015/5/12.
 */
public class Deals {
/*    "deals": [
    {
        "id": "1-11784051",
            "description": "锅源!仅售118元，价值128元畅吃套餐，不限时段通用，新鲜海鲜，首次开团，限量抢购！起源于日本，专注于做日式火锅、刺身、寿司的日本料理店，期待您光临！",
            "url": "http://lite.m.dianping.com/lDrQ05Y2ym"
    },
    {
        "id": "1-11784576",
            "description": "锅源!仅售168元，价值178元刺身畅吃套餐，不限时段通用，新鲜海鲜，首次开团，限量抢购！起源于日本，专注于做日式火锅、刺身、寿司的日本料理店，期待您光临！",
            "url": "http://lite.m.dianping.com/AhLt27+ULo"
    }
    ]*/
    private String id;
    private String description;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
