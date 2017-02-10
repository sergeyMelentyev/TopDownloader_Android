package com.example.melentyev.sergey.topdownloader_android;

class ApplicationData {
    private String appName;
    private String appImage;
    private String appSummary;
    private String appCategory;

    public ApplicationData(String appCategory, String appImage, String appName, String appSummary) {
        this.appCategory = appCategory;
        this.appImage = appImage;
        this.appName = appName;
        this.appSummary = appSummary;
    }

    public String getAppCategory() {
        return appCategory;
    }

    public String getAppImage() {
        return appImage;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppSummary() {
        return appSummary;
    }

    @Override
    public String toString() {
        return this.appName + " " + this.appCategory;
    }
}
