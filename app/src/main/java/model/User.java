package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;


public class User implements Parcelable {

    public static final Map<String, User> userRegistry = new HashMap<>();

    private final String _id;
    private final String _password;
    private final AccountType _type;

    public User(String id, String password, AccountType type) {
        _id = id;
        _password = password;
        _type = type;
        userRegistry.put(_id, this);
    }

    public User(Parcel parcel) {
        _id = parcel.readString();
        _password = parcel.readString();
        _type = (AccountType) parcel.readSerializable();
    }

    public CharSequence getID() {
        return _id;
    }

    public String getPassword() {
        return _password;
    }

    public AccountType getType() {
        return _type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(_id);
        parcel.writeString(_password);
        parcel.writeSerializable(_type);
    }

    private static final Parcelable.Creator<User> CREATOR =
            new Parcelable.Creator<User>() {
                @Override
                public User createFromParcel(Parcel parcel) {
                    return new User(parcel);
                }

                @Override
                public User[] newArray(int size) {
                    return new User[size];
                }
            };
}
