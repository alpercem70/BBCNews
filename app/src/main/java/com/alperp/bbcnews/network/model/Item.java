package com.alperp.bbcnews.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item")
public class Item implements Parcelable {

    @Element(name = "title", data = true)
    private String title;

    @Element(name = "description", data = true)
    private String description;

    @Element(name = "link")
    private String link;

    @Element(name = "pubDate")
    private String pubDate;

    @Element(name = "media:thumbnail")
    private Thumbnail thumbnail;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.link);
        dest.writeString(this.pubDate);
        dest.writeParcelable(this.thumbnail, flags);
    }

    protected Item(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.link = in.readString();
        this.pubDate = in.readString();
        this.thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getTitle() {
        return title;
    }
}
