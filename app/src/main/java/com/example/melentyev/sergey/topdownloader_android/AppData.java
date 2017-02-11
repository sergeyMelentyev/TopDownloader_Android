package com.example.melentyev.sergey.topdownloader_android;

class AppData {
    private String appName;
    private String appImage;
    private String appSummary;
    private String appCategory;

    AppData(String appCategory, String appImage, String appName, String appSummary) {
        this.appCategory = appCategory;
        this.appImage = appImage;
        this.appName = appName;
        this.appSummary = appSummary;
    }

    String getAppCategory() {
        return appCategory;
    }

    String getAppImage() {
        return appImage;
    }

    String getAppName() {
        return appName;
    }

    String getAppSummary() {
        return appSummary;
    }

    @Override
    public String toString() {
        return this.appName + " " + this.appCategory;
    }
}
