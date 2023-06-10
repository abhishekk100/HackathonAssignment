package com.example.coworking.register;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UserData implements Parcelable {
    protected UserData(Parcel in) {
        userName = in.readString();
        mobileNumber = in.readInt();
        emailId = in.readString();
        password = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    @Override
    public String toString() {
        return "UserData{" +
                "userName='" + userName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private  String userName;
    private  int mobileNumber;
    private  String emailId;
    private  String password;

    public UserData(String userName, int mobileNumber, String emailId, String password) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.password = password;
    }

    public UserData(){

                        }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeInt(mobileNumber);
        parcel.writeString(emailId);
        parcel.writeString(password);
    }
}
