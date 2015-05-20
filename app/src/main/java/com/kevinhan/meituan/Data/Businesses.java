package com.kevinhan.meituan.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Han on 2015/5/12.
 */
public class Businesses{
/*
"businesses": [
        {
        "business_id": 5989801,
        "name": "锅源(这是一条测试商户数据，仅用于测试开发，开发完成后请申请正式数据...)",
        "branch_name": "光启城店",
        "address": "徐汇区宜山路425号光启城购物中心4楼",
        "telephone": "021-61735362",
        "city": "上海",
        "regions": [
        "徐汇区",
        "光启城"
        ],
        "categories": [
        "日式自助"
        ],
        "latitude": 31.183044,
        "longitude": 121.4271,
        "avg_rating": 0,
        "rating_img_url": "http://i3.dpfile.com/s/i/app/api/32_0star.png",
        "rating_s_img_url": "http://i3.dpfile.com/s/i/app/api/16_0star.png",
        "product_grade": 0,
        "decoration_grade": 0,
        "service_grade": 0,
        "product_score": 0,
        "decoration_score": 0,
        "service_score": 0,
        "avg_price": 0,
        "review_count": 0,
        "review_list_url": "http://m.dianping.com/shop/5989801/review_all?utm_source=open",
        "distance": 69,
        "business_url": "http://lite.m.dianping.com/uU2bngm3L6",
        "photo_url": "http://i2.dpfile.com/pc/f247006fad22e87d72c79284b1cab738(700x700)/thumb.jpg",
        "s_photo_url": "http://i3.dpfile.com/pc/f247006fad22e87d72c79284b1cab738(278x200)/thumb.jpg",
        "photo_count": 2501,
        "photo_list_url": "http://m.dianping.com/shop/5989801/photos?utm_source=open",
        "has_coupon": 0,
        "coupon_id": 0,
        "coupon_description": "",
        "coupon_url": "",
        "has_deal": 1,
        "deal_count": 2,
        "deals": [
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
        ],
        "has_online_reservation": 1,
        "online_reservation_url": "http://dpurl.cn/p/4f4mBVmVNe"
        },
*/


    private String business_id;
    private String name;
    private String branch_name;
    private String address;
    private String telephone;
    private String city;
    private List<String> regions = new ArrayList<String>();
    private List<String> categories = new ArrayList<String>();
    private long latitude;
    private long longitude;
    private int avg_rating;
    private String rating_img_url;
    private String rating_s_img_url;
    private int product_grade;
    private int decoration_grade;
    private int service_grade;
    private int product_score;
    private int decoration_score;
    private int service_score;
    private int avg_price;
    private int review_count;
    private String review_list_url;
    private int distance;
    private String business_url;
    private String photo_url;
    private String s_photo_url;
    private int photo_count;
    private String photo_list_url;
    private int has_coupon;
    private int coupon_id;
    private String coupon_description;
    private String coupon_url;
    private int has_deal;
    private int deal_count;
    private List<Deals> dealses = new ArrayList<Deals>();
    private int has_online_reservation;
    private String online_reservation_url;

    public Businesses(){}

    public Businesses(String business_id,String name,String branch_name,String address,String telephone,
                      String city,List<String> regions,List<String> categories,long latitude,long longitude,
                      int avg_rating,String rating_img_url,String rating_s_img_url,int product_grade,
                      int decoration_grade,int service_grade,int product_score,int decoration_score,
                      int service_score,int avg_price,int review_count,String review_list_url,int distance,
                      String business_url,String photo_url,String s_photo_url,int photo_count,String photo_list_url,
                      int has_coupon,int coupon_id,String coupon_description,String coupon_url,int has_deal,
                      int deal_count,List<Deals> dealses,int has_online_reservation,String online_reservation_url){

        this.business_id = business_id;
        this.name = name;
        this.branch_name = branch_name;
        this.address = address;
        this.telephone = telephone;
        this.city = city;
        this.regions = regions;
        this.categories = categories;
        this.latitude = latitude;
        this.longitude = longitude;
        this.avg_rating = avg_rating;
        this.rating_img_url = rating_img_url;
        this.rating_s_img_url = rating_s_img_url;
        this.product_grade = product_grade;
        this.decoration_grade = decoration_grade;
        this.service_grade = service_grade;
        this.product_score = product_score;
        this.decoration_score = decoration_score;
        this.service_score = service_score;
        this.avg_price = avg_price;
        this.review_count = review_count;
        this.review_list_url = review_list_url;
        this.distance = distance;
        this.business_url = business_url;
        this.photo_url = photo_url;
        this.s_photo_url = s_photo_url;
        this.photo_count = photo_count;
        this.photo_list_url = photo_list_url;
        this.has_coupon = has_coupon;
        this.coupon_id = coupon_id;
        this.coupon_description = coupon_description;
        this.coupon_url = coupon_url;
        this.has_deal = has_deal;
        this.deal_count = deal_count;
        this.dealses = dealses;
        this.has_online_reservation = has_online_reservation;
        this.online_reservation_url = online_reservation_url;

    }


    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public int getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(int avg_rating) {
        this.avg_rating = avg_rating;
    }

    public String getRating_img_url() {
        return rating_img_url;
    }

    public void setRating_img_url(String rating_img_url) {
        this.rating_img_url = rating_img_url;
    }

    public String getRating_s_img_url() {
        return rating_s_img_url;
    }

    public void setRating_s_img_url(String rating_s_img_url) {
        this.rating_s_img_url = rating_s_img_url;
    }

    public int getProduct_grade() {
        return product_grade;
    }

    public void setProduct_grade(int product_grade) {
        this.product_grade = product_grade;
    }

    public int getDecoration_grade() {
        return decoration_grade;
    }

    public void setDecoration_grade(int decoration_grade) {
        this.decoration_grade = decoration_grade;
    }

    public int getService_grade() {
        return service_grade;
    }

    public void setService_grade(int service_grade) {
        this.service_grade = service_grade;
    }

    public int getProduct_score() {
        return product_score;
    }

    public void setProduct_score(int product_score) {
        this.product_score = product_score;
    }

    public int getDecoration_score() {
        return decoration_score;
    }

    public void setDecoration_score(int decoration_score) {
        this.decoration_score = decoration_score;
    }

    public int getService_score() {
        return service_score;
    }

    public void setService_score(int service_score) {
        this.service_score = service_score;
    }

    public int getAvg_price() {
        return avg_price;
    }

    public void setAvg_price(int avg_price) {
        this.avg_price = avg_price;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public String getReview_list_url() {
        return review_list_url;
    }

    public void setReview_list_url(String review_list_url) {
        this.review_list_url = review_list_url;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getBusiness_url() {
        return business_url;
    }

    public void setBusiness_url(String business_url) {
        this.business_url = business_url;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getS_photo_url() {
        return s_photo_url;
    }

    public void setS_photo_url(String s_photo_url) {
        this.s_photo_url = s_photo_url;
    }

    public int getPhoto_count() {
        return photo_count;
    }

    public void setPhoto_count(int photo_count) {
        this.photo_count = photo_count;
    }

    public String getPhoto_list_url() {
        return photo_list_url;
    }

    public void setPhoto_list_url(String photo_list_url) {
        this.photo_list_url = photo_list_url;
    }

    public int getHas_coupon() {
        return has_coupon;
    }

    public void setHas_coupon(int has_coupon) {
        this.has_coupon = has_coupon;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_description() {
        return coupon_description;
    }

    public void setCoupon_description(String coupon_description) {
        this.coupon_description = coupon_description;
    }

    public String getCoupon_url() {
        return coupon_url;
    }

    public void setCoupon_url(String coupon_url) {
        this.coupon_url = coupon_url;
    }

    public int getHas_deal() {
        return has_deal;
    }

    public void setHas_deal(int has_deal) {
        this.has_deal = has_deal;
    }

    public int getDeal_count() {
        return deal_count;
    }

    public void setDeal_count(int deal_count) {
        this.deal_count = deal_count;
    }

    public List<Deals> getDealses() {
        return dealses;
    }

    public void setDealses(List<Deals> dealses) {
        this.dealses = dealses;
    }

    public int getHas_online_reservation() {
        return has_online_reservation;
    }

    public void setHas_online_reservation(int has_online_reservation) {
        this.has_online_reservation = has_online_reservation;
    }

    public String getOnline_reservation_url() {
        return online_reservation_url;
    }

    public void setOnline_reservation_url(String online_reservation_url) {
        this.online_reservation_url = online_reservation_url;
    }
}
