package com.alperp.bbcnews.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss")
public class Rss implements Parcelable {

    @Element(name = "channel")
    private Channel channel;

    @Attribute(name = "version")
    private String version;

    public Rss() {}

    public Channel getChannel() {
        return channel;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.channel, flags);
        dest.writeString(this.version);
    }

    protected Rss(Parcel in) {
        this.channel = in.readParcelable(Channel.class.getClassLoader());
        this.version = in.readString();
    }

    public static final Creator<Rss> CREATOR = new Creator<Rss>() {
        @Override
        public Rss createFromParcel(Parcel source) {
            return new Rss(source);
        }

        @Override
        public Rss[] newArray(int size) {
            return new Rss[size];
        }
    };
}
