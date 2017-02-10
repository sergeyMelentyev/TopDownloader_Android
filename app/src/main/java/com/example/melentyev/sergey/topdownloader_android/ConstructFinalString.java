package com.example.melentyev.sergey.topdownloader_android;


class ConstructFinalString {
    private String basicRssFeedUrl;
    private String feedType;
    private String feedLimit;
    private String dataFormat;

    public ConstructFinalString(String feedType, String feedLimit) {
        this.basicRssFeedUrl = "https://itunes.apple.com/us/rss/";
        this.feedType = feedType + "/";
        this.feedLimit = "limit=" + feedLimit + "/";
        this.dataFormat = "json";
    }

    String getUrl() {
        return basicRssFeedUrl + feedType + feedLimit + dataFormat;
    }
}