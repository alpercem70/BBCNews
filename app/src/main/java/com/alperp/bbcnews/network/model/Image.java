package com.alperp.bbcnews.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "image")
public class Image implements Parcelable {

    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "url")
    private String url;

    public Image() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.link);
        dest.writeString(this.url);
    }

    protected Image(Parcel in) {
        this.title = in.readString();
        this.link = in.readString();
        this.url = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
