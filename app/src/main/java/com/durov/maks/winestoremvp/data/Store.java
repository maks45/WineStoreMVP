package com.durov.maks.winestoremvp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@Entity(indices = {@Index(value = {"id"}, unique = true)})
public class Store implements Parcelable {

    //constants for database
    public static final String ID = "id";
    public static final String IS_DEAD = "is_dead";
    public static final String NAME = "name";
    public static final String TAGS = "tags";
    public static final String ADRESS_LINE_1 = "address_line_1";
    public static final String ADRESS_LINE_2 = "address_line_2";
    public static final String CITY = "city";
    public static final String POSTAL_CODE = "postal_code";
    public static final String TELEPHONE = "telephone";
    public static final String FAX = "fax";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String PRODUCTS_COUNT = "products_count";
    public static final String HAS_PARKING = "has_parking";
    public static final String HAS_PRODUCT_CONSULTANT = "has_product_consultant";
    public static final String HAS_TASTING_BAR = "has_tasting_bar";
    public static final String HAS_TRANSIT_ACCES = "has_transit_access";
    public static final String UPDATED_AT = "updated_at";
    public static final String SUNDAY_OPEN = "sunday_open";
    public static final String SUNDAY_CLOSE = "sunday_close";
    public static final String MONDAY_OPEN = "monday_open";
    public static final String MONDAY_CLOSE = "monday_close";
    public static final String TUESDAY_OPEN = "tuesday_open";
    public static final String TUESDAY_CLOSE = "tuesday_close";
    public static final String WEDNESDAY_OPEN = "wednesday_open";
    public static final String WEDNESDAY_CLOSE = "wednesday_close";
    public static final String THURSDAY_OPEN = "thursday_open";
    public static final String THURSDAY_CLOSE = "thursday_close";
    public static final String FRIDAY_OPEN = "friday_open";
    public static final String FRIDAY_CLOSE = "friday_close";
    public static final String SATURDAY_OPEN = "saturday_open";
    public static final String SATURDAY_CLOSE = "saturday_close";



    //@ColumnInfo(name = "id")
    @PrimaryKey
    @SerializedName("id")
    private int id;
    @SerializedName("is_dead")
    private boolean isDead;
    @SerializedName("name")
    private String name;
    @SerializedName("tags")
    private String tags;
    @SerializedName("address_line_1")
    private String addressLine1;
    @SerializedName("address_line_2")
    private String addressLine2;
    @SerializedName("city")
    @ColumnInfo(name = "city")
    private String city;
    @SerializedName("postal_code")
    private String postalCode;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("fax")
    private String fax;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("products_count")
    private int productsCount;
    @SerializedName("has_parking")
    private boolean hasParking;
    @SerializedName("has_product_consultant")
    private boolean hasProductConsultant;
    @SerializedName("has_tasting_bar")
    private boolean hasTestingBar;
    @SerializedName("has_transit_access")
    private  boolean hasTransitAccess;
    @SerializedName("sunday_open")
    private  int sundayOpen;
    @SerializedName("sunday_close")
    private  int sundayClose;
    @SerializedName("tuesday_open")
    private  int tuesdayOpen;
    @SerializedName("tuesday_close")
    private  int tuesdayClose;
    @SerializedName("wednesday_open")
    private  int wednesdayOpen;
    @SerializedName("wednesday_close")
    private int wednesdayClose;
    @SerializedName("thursday_open")
    private  int thursdayOpen;
    @SerializedName("thursday_close")
    private  int thursdayClose;
    @SerializedName("friday_open")
    private  int fridayOpen;
    @SerializedName("friday_close")
    private  int fridayClose;
    @SerializedName("saturday_open")
    private  int saturdayOpen;
    @SerializedName("saturday_close")
    private  int saturdayClose;
    @SerializedName("monday_open")
    private  int mondayOpen;
    @SerializedName("monday_close")
    private  int mondayClose;
    @SerializedName("updated_at")
    private  String updatedAt;

    @Ignore
    public Store() {
    }


    public Store(int id, boolean isDead, String name, String tags, String addressLine1, String addressLine2, String city, String postalCode, String telephone, String fax, double latitude, double longitude, int productsCount, boolean hasParking, boolean hasProductConsultant, boolean hasTestingBar, boolean hasTransitAccess, int sundayOpen, int sundayClose, int tuesdayOpen, int tuesdayClose, int wednesdayOpen, int wednesdayClose, int thursdayOpen, int thursdayClose, int fridayOpen, int fridayClose, int saturdayOpen, int saturdayClose, int mondayOpen, int mondayClose, String updatedAt){
        this.id = id;
        this.isDead = isDead;
        this.name = name;
        this.tags = tags;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
        this.fax = fax;
        this.latitude = latitude;
        this.longitude = longitude;
        this.productsCount = productsCount;
        this.hasParking = hasParking;
        this.hasProductConsultant = hasProductConsultant;
        this.hasTestingBar = hasTestingBar;
        this.hasTransitAccess = hasTransitAccess;
        this.sundayOpen = sundayOpen;
        this.sundayClose = sundayClose;
        this.tuesdayOpen = tuesdayOpen;
        this.tuesdayClose = tuesdayClose;
        this.wednesdayOpen = wednesdayOpen;
        this.wednesdayClose = wednesdayClose;
        this.thursdayOpen = thursdayOpen;
        this.thursdayClose = thursdayClose;
        this.fridayOpen = fridayOpen;
        this.fridayClose = fridayClose;
        this.saturdayOpen = saturdayOpen;
        this.saturdayClose = saturdayClose;
        this.mondayOpen = mondayOpen;
        this.mondayClose = mondayClose;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean isHasProductConsultant() {
        return hasProductConsultant;
    }

    public void setHasProductConsultant(boolean hasProductConsultant) {
        this.hasProductConsultant = hasProductConsultant;
    }

    public boolean isHasTestingBar() {
        return hasTestingBar;
    }

    public void setHasTestingBar(boolean hasTestingBar) {
        this.hasTestingBar = hasTestingBar;
    }

    public boolean isHasTransitAccess() {
        return hasTransitAccess;
    }

    public void setHasTransitAccess(boolean hasTransitAccess) {
        this.hasTransitAccess = hasTransitAccess;
    }

    public int getSundayOpen() {
        return sundayOpen;
    }

    public void setSundayOpen(int sundayOpen) {
        this.sundayOpen = sundayOpen;
    }

    public int getSundayClose() {
        return sundayClose;
    }

    public void setSundayClose(int sundayClose) {
        this.sundayClose = sundayClose;
    }

    public int getTuesdayOpen() {
        return tuesdayOpen;
    }

    public void setTuesdayOpen(int tuesdayOpen) {
        this.tuesdayOpen = tuesdayOpen;
    }

    public int getTuesdayClose() {
        return tuesdayClose;
    }

    public void setTuesdayClose(int tuesdayClose) {
        this.tuesdayClose = tuesdayClose;
    }

    public int getWednesdayOpen() {
        return wednesdayOpen;
    }

    public void setWednesdayOpen(int wednesdayOpen) {
        this.wednesdayOpen = wednesdayOpen;
    }

    public int getWednesdayClose() {
        return wednesdayClose;
    }

    public void setWednesdayClose(int wednesdayClose) {
        this.wednesdayClose = wednesdayClose;
    }

    public int getThursdayOpen() {
        return thursdayOpen;
    }

    public void setThursdayOpen(int thursdayOpen) {
        this.thursdayOpen = thursdayOpen;
    }

    public int getThursdayClose() {
        return thursdayClose;
    }

    public void setThursdayClose(int thursdayClose) {
        this.thursdayClose = thursdayClose;
    }

    public int getFridayOpen() {
        return fridayOpen;
    }

    public void setFridayOpen(int fridayOpen) {
        this.fridayOpen = fridayOpen;
    }

    public int getFridayClose() {
        return fridayClose;
    }

    public void setFridayClose(int fridayClose) {
        this.fridayClose = fridayClose;
    }

    public int getSaturdayOpen() {
        return saturdayOpen;
    }

    public void setSaturdayOpen(int saturdayOpen) {
        this.saturdayOpen = saturdayOpen;
    }

    public int getSaturdayClose() {
        return saturdayClose;
    }

    public void setSaturdayClose(int saturdayClose) {
        this.saturdayClose = saturdayClose;
    }

    public int getMondayOpen() {
        return mondayOpen;
    }

    public void setMondayOpen(int mondayOpen) {
        this.mondayOpen = mondayOpen;
    }

    public int getMondayClose() {
        return mondayClose;
    }

    public void setMondayClose(int mondayClose) {
        this.mondayClose = mondayClose;
    }

    public String getFullAdress(){
        if(addressLine2!=null){
            return addressLine1+"\n"+addressLine2;
        }
        return addressLine1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeByte(this.isDead ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
        dest.writeString(this.tags);
        dest.writeString(this.addressLine1);
        dest.writeString(this.addressLine2);
        dest.writeString(this.city);
        dest.writeString(this.postalCode);
        dest.writeString(this.telephone);
        dest.writeString(this.fax);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeInt(this.productsCount);
        dest.writeByte(this.hasParking ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasProductConsultant ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasTestingBar ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasTransitAccess ? (byte) 1 : (byte) 0);
        dest.writeInt(this.sundayOpen);
        dest.writeInt(this.sundayClose);
        dest.writeInt(this.tuesdayOpen);
        dest.writeInt(this.tuesdayClose);
        dest.writeInt(this.wednesdayOpen);
        dest.writeInt(this.wednesdayClose);
        dest.writeInt(this.thursdayOpen);
        dest.writeInt(this.thursdayClose);
        dest.writeInt(this.fridayOpen);
        dest.writeInt(this.fridayClose);
        dest.writeInt(this.saturdayOpen);
        dest.writeInt(this.saturdayClose);
        dest.writeInt(this.mondayOpen);
        dest.writeInt(this.mondayClose);
        dest.writeString(this.updatedAt);
    }

    protected Store(Parcel in) {
        this.id = in.readInt();
        this.isDead = in.readByte() != 0;
        this.name = in.readString();
        this.tags = in.readString();
        this.addressLine1 = in.readString();
        this.addressLine2 = in.readString();
        this.city = in.readString();
        this.postalCode = in.readString();
        this.telephone = in.readString();
        this.fax = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.productsCount = in.readInt();
        this.hasParking = in.readByte() != 0;
        this.hasProductConsultant = in.readByte() != 0;
        this.hasTestingBar = in.readByte() != 0;
        this.hasTransitAccess = in.readByte() != 0;
        this.sundayOpen = in.readInt();
        this.sundayClose = in.readInt();
        this.tuesdayOpen = in.readInt();
        this.tuesdayClose = in.readInt();
        this.wednesdayOpen = in.readInt();
        this.wednesdayClose = in.readInt();
        this.thursdayOpen = in.readInt();
        this.thursdayClose = in.readInt();
        this.fridayOpen = in.readInt();
        this.fridayClose = in.readInt();
        this.saturdayOpen = in.readInt();
        this.saturdayClose = in.readInt();
        this.mondayOpen = in.readInt();
        this.mondayClose = in.readInt();
        this.updatedAt = in.readString();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel source) {
            return new Store(source);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };
}
