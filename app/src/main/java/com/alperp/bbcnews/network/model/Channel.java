package com.alperp.bbcnews.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "channel")
public class Channel implements Parcelable {

    @Element(name = "title", data = true)
    private String title;

    @Element(name = "description", data = true)
    private String description;

    @Element(name = "link")
    private String link;

    @Element(name = "generator")
    private String generator;

    @Element(name = "copyright", data = true)
    private String copyright;

    @Element(name = "language", data = true)
    private String language;

    @Element(name = "ttl")
    private int ttl;

    @ElementList
    private ArrayList<Item> items;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.link);
        dest.writeString(this.generator);
        dest.writeString(this.copyright);
        dest.writeString(this.language);
        dest.writeInt(this.ttl);
        dest.writeTypedList(this.items);
    }

    protected Channel(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.link = in.readString();
        this.generator = in.readString();
        this.copyright = in.readString();
        this.language = in.readString();
        this.ttl = in.readInt();
        this.items = in.createTypedArrayList(Item.CREATOR);
    }

    public static final Creator<Channel> CREATOR = new Creator<Channel>() {
        @Override
        public Channel createFromParcel(Parcel source) {
            return new Channel(source);
        }

        @Override
        public Channel[] newArray(int size) {
            return new Channel[size];
        }
    };

    public String getCopyright() {
        return copyright;
    }

    public String getGenerator() {
        return generator;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getLanguage() {
        return language;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public int getTtl() {
        return ttl;
    }

    public String getDescription() {
        return description;
    }

}
