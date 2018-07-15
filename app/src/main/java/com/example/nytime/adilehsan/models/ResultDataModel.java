package com.example.nytime.adilehsan.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ResultDataModel implements Parcelable{
    @SerializedName("byline")
    private String byline;
    @SerializedName("title")
    private String title;
    @SerializedName("published_date")
    private String published_date;
    @SerializedName("source")
    private String source;
    @SerializedName("type")
    private String type;
    @SerializedName("section")
    private String section;
    @SerializedName("views")
    private Integer views;

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }



    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResultDataModel(Parcel parcel){
        byline = parcel.readString();
        title = parcel.readString();
        published_date = parcel.readString();
        views = parcel.readInt();
        source = parcel.readString();
        type = parcel.readString();
        section = parcel.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(byline);
        dest.writeString(title);
        dest.writeString(published_date);
        dest.writeInt(views);
        dest.writeString(source);
        dest.writeString(type);
        dest.writeString(section);

    }
    public static final Parcelable.Creator<ResultDataModel> CREATOR = new Parcelable.Creator<ResultDataModel>(){
        public ResultDataModel createFromParcel(Parcel in) {
            return new ResultDataModel(in);
        }

        public ResultDataModel[] newArray(int size) {
            return new ResultDataModel[size];
        }
    };
}
