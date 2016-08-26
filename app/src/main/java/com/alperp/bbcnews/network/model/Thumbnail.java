package com.alperp.bbcnews.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "media:thumbnail")
public class Thumbnail implements Parcelable {

    @Attribute(name = "width")
    private long width;

    @Attribute(name = "height")
    private long height;

    @Attribute(name = "url")
    private String url;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.width);
        dest.writeLong(this.height);
        dest.writeString(this.url);
    }

    public Thumbnail() {
    }

    protected Thumbnail(Parcel in) {
        this.width = in.readLong();
        this.height = in.readLong();
        this.url = in.readString();
    }

    public static final Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {
        @Override
        public Thumbnail createFromParcel(Parcel source) {
            return new Thumbnail(source);
        }

        @Override
        public Thumbnail[] newArray(int size) {
            return new Thumbnail[size];
        }
    };

    public long getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public long getWidth() {
        return width;
    }
}
