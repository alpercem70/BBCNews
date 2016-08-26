package com.alperp.bbcnews.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "guid")
public class Guid implements Parcelable {

    private String content;

    @Attribute(name = "isPermaLink")
    private String isPermaLink;

    public Guid() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
        dest.writeString(this.isPermaLink);
    }

    protected Guid(Parcel in) {
        this.content = in.readString();
        this.isPermaLink = in.readString();
    }

    public static final Creator<Guid> CREATOR = new Creator<Guid>() {
        @Override
        public Guid createFromParcel(Parcel source) {
            return new Guid(source);
        }

        @Override
        public Guid[] newArray(int size) {
            return new Guid[size];
        }
    };

    public String getIsPermaLink() {
        return isPermaLink;
    }

    public String getContent() {
        return content;
    }
}
