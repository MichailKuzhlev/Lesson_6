package com.michailkuzhlev.lesson_6;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {
  private int index;

    public Notes(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static Creator<Notes> getCREATOR() {
        return CREATOR;
    }

    protected Notes(Parcel in) {
        index = in.readInt();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(index);
    }
}
