package com.alltoolsinoneapp.model;

/**
 * Created by Kishan Thakkar on 2/1/2020.

 * Kishanpujara127@gmail.com
 */
public class HomeScreenData {
    private int featureIconId;
    private String featureName;

    public HomeScreenData(int featureIconId,String featureName)
    {
        this.featureIconId=featureIconId;
        this.featureName=featureName;
    }

    public int getFeatureIconId() {
        return featureIconId;
    }

    public void setFeatureIconId(int featureIconId) {
        this.featureIconId = featureIconId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
}
