package com.example.carfax.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Cars {

    public static class SearchArea {

        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("zip")
        @Expose
        private String zip;
        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;
        @SerializedName("radius")
        @Expose
        private Double radius;
        @SerializedName("dynamicRadius")
        @Expose
        private Boolean dynamicRadius;
        @SerializedName("dynamicRadii")
        @Expose
        private List<Double> dynamicRadii = null;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Double getRadius() {
            return radius;
        }

        public void setRadius(Double radius) {
            this.radius = radius;
        }

        public Boolean getDynamicRadius() {
            return dynamicRadius;
        }

        public void setDynamicRadius(Boolean dynamicRadius) {
            this.dynamicRadius = dynamicRadius;
        }

        public List<Double> getDynamicRadii() {
            return dynamicRadii;
        }

        public void setDynamicRadii(List<Double> dynamicRadii) {
            this.dynamicRadii = dynamicRadii;
        }

    }

    @Entity(tableName = "example_table")
    public static class Example implements Parcelable {

        @PrimaryKey(autoGenerate = true)
        public int id;

        @Ignore
        @SerializedName("searchArea")
        @Expose
        private SearchArea searchArea;
        @SerializedName("totalListingCount")
        @Expose
        private Integer totalListingCount;
        @SerializedName("enhancedCount")
        @Expose
        private Integer enhancedCount;
        @SerializedName("backfillCount")
        @Expose
        private Integer backfillCount;
        @SerializedName("dealerNewCount")
        @Expose
        private Integer dealerNewCount;
        @SerializedName("dealerUsedCount")
        @Expose
        private Integer dealerUsedCount;
        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("pageSize")
        @Expose
        private Integer pageSize;
        @SerializedName("totalPageCount")
        @Expose
        private Integer totalPageCount;
        @Ignore
        @SerializedName("listings")
        @Expose
        private List<Listing> listings = null;

        protected Example(Parcel in) {
            if (in.readByte() == 0) {
                totalListingCount = null;
            } else {
                totalListingCount = in.readInt();
            }
            if (in.readByte() == 0) {
                enhancedCount = null;
            } else {
                enhancedCount = in.readInt();
            }
            if (in.readByte() == 0) {
                backfillCount = null;
            } else {
                backfillCount = in.readInt();
            }
            if (in.readByte() == 0) {
                dealerNewCount = null;
            } else {
                dealerNewCount = in.readInt();
            }
            if (in.readByte() == 0) {
                dealerUsedCount = null;
            } else {
                dealerUsedCount = in.readInt();
            }
            if (in.readByte() == 0) {
                page = null;
            } else {
                page = in.readInt();
            }
            if (in.readByte() == 0) {
                pageSize = null;
            } else {
                pageSize = in.readInt();
            }
            if (in.readByte() == 0) {
                totalPageCount = null;
            } else {
                totalPageCount = in.readInt();
            }
        }

        public static final Creator<Example> CREATOR = new Creator<Example>() {
            @Override
            public Example createFromParcel(Parcel in) {
                return new Example(in);
            }

            @Override
            public Example[] newArray(int size) {
                return new Example[size];
            }
        };

        public Example() {}

        public SearchArea getSearchArea() {
            return searchArea;
        }

        public void setSearchArea(SearchArea searchArea) {
            this.searchArea = searchArea;
        }

        public Integer getTotalListingCount() {
            return totalListingCount;
        }

        public void setTotalListingCount(Integer totalListingCount) {
            this.totalListingCount = totalListingCount;
        }

        public Integer getEnhancedCount() {
            return enhancedCount;
        }

        public void setEnhancedCount(Integer enhancedCount) {
            this.enhancedCount = enhancedCount;
        }

        public Integer getBackfillCount() {
            return backfillCount;
        }

        public void setBackfillCount(Integer backfillCount) {
            this.backfillCount = backfillCount;
        }

        public Integer getDealerNewCount() {
            return dealerNewCount;
        }

        public void setDealerNewCount(Integer dealerNewCount) {
            this.dealerNewCount = dealerNewCount;
        }

        public Integer getDealerUsedCount() {
            return dealerUsedCount;
        }

        public void setDealerUsedCount(Integer dealerUsedCount) {
            this.dealerUsedCount = dealerUsedCount;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getTotalPageCount() {
            return totalPageCount;
        }

        public void setTotalPageCount(Integer totalPageCount) {
            this.totalPageCount = totalPageCount;
        }

        public List<Listing> getListings() {
            return listings;
        }

        public void setListings(List<Listing> listings) {
            this.listings = listings;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            if (totalListingCount == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(totalListingCount);
            }
            if (enhancedCount == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(enhancedCount);
            }
            if (backfillCount == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(backfillCount);
            }
            if (dealerNewCount == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(dealerNewCount);
            }
            if (dealerUsedCount == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(dealerUsedCount);
            }
            if (page == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(page);
            }
            if (pageSize == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(pageSize);
            }
            if (totalPageCount == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(totalPageCount);
            }
        }

        @Entity(tableName = "Listing_table")
        public static class Listing implements Parcelable{

            @Ignore
            @SerializedName("dealer")
            @Expose
            private Dealer dealer;
            @PrimaryKey
            @NonNull
            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("vin")
            @Expose
            private String vin;
            @SerializedName("year")
            @Expose
            private Integer year;
            @SerializedName("make")
            @Expose
            private String make;
            @SerializedName("model")
            @Expose
            private String model;
            @SerializedName("trim")
            @Expose
            private String trim;
            @SerializedName("subTrim")
            @Expose
            private String subTrim;
            @Ignore
            @SerializedName("topOptions")
            @Expose
            private List<String> topOptions = null;
            @SerializedName("mileage")
            @Expose
            private Integer mileage;
            @SerializedName("listPrice")
            @Expose
            private Double listPrice;
            @SerializedName("currentPrice")
            @Expose
            private Double currentPrice;
            @Ignore
            @SerializedName("monthlyPaymentEstimate")
            @Expose
            private Dealer.MonthlyPaymentEstimate monthlyPaymentEstimate;
            @SerializedName("onePrice")
            @Expose
            private Double onePrice;
            @SerializedName("badge")
            @Expose
            private String badge;
            @SerializedName("exteriorColor")
            @Expose
            private String exteriorColor;
            @SerializedName("interiorColor")
            @Expose
            private String interiorColor;
            @SerializedName("engine")
            @Expose
            private String engine;
            @SerializedName("displacement")
            @Expose
            private String displacement;
            @SerializedName("drivetype")
            @Expose
            private String drivetype;
            @SerializedName("transmission")
            @Expose
            private String transmission;
            @SerializedName("fuel")
            @Expose
            private String fuel;
            @SerializedName("mpgCity")
            @Expose
            private Integer mpgCity;
            @SerializedName("mpgHighway")
            @Expose
            private Integer mpgHighway;
            @SerializedName("bodytype")
            @Expose
            private String bodytype;
            @SerializedName("vehicleCondition")
            @Expose
            private String vehicleCondition;
            @SerializedName("cabType")
            @Expose
            private String cabType;
            @SerializedName("bedLength")
            @Expose
            private String bedLength;
            @SerializedName("followCount")
            @Expose
            private Integer followCount;
            @SerializedName("stockNumber")
            @Expose
            private String stockNumber;
            @SerializedName("imageCount")
            @Expose
            private Integer imageCount;
            @Ignore
            @SerializedName("images")
            @Expose
            private Images images;
            @SerializedName("firstSeen")
            @Expose
            private String firstSeen;
            @SerializedName("oneOwner")
            @Expose
            private Boolean oneOwner;
            @SerializedName("noAccidents")
            @Expose
            private Boolean noAccidents;
            @SerializedName("serviceRecords")
            @Expose
            private Boolean serviceRecords;
            @SerializedName("personalUse")
            @Expose
            private Boolean personalUse;
            @SerializedName("distanceToDealer")
            @Expose
            private Double distanceToDealer;
            @SerializedName("hasViewed")
            @Expose
            private Boolean hasViewed;
            @SerializedName("sentLead")
            @Expose
            private Boolean sentLead;
            @Ignore
            @SerializedName("sentLeadAt")
            @Expose
            private Object sentLeadAt;
            @SerializedName("recordType")
            @Expose
            private String recordType;
            @SerializedName("dealerType")
            @Expose
            private String dealerType;
            @SerializedName("backfill")
            @Expose
            private Boolean backfill;
            @SerializedName("advantage")
            @Expose
            private Boolean advantage;
            @SerializedName("vdpUrl")
            @Expose
            private String vdpUrl;
            @SerializedName("sortScore")
            @Expose
            private Double sortScore;
            @SerializedName("isEnriched")
            @Expose
            private Boolean isEnriched;
            @SerializedName("following")
            @Expose
            private Boolean following;
            @SerializedName("onlineOnly")
            @Expose
            private Boolean onlineOnly;
            @SerializedName("certified")
            @Expose
            private Boolean certified;

            protected Listing(Parcel in) {
                id = in.readString();
                vin = in.readString();
                if (in.readByte() == 0) {
                    year = null;
                } else {
                    year = in.readInt();
                }
                make = in.readString();
                model = in.readString();
                trim = in.readString();
                subTrim = in.readString();
                topOptions = in.createStringArrayList();
                if (in.readByte() == 0) {
                    mileage = null;
                } else {
                    mileage = in.readInt();
                }
                if (in.readByte() == 0) {
                    listPrice = null;
                } else {
                    listPrice = in.readDouble();
                }
                if (in.readByte() == 0) {
                    currentPrice = null;
                } else {
                    currentPrice = in.readDouble();
                }
                if (in.readByte() == 0) {
                    onePrice = null;
                } else {
                    onePrice = in.readDouble();
                }
                badge = in.readString();
                exteriorColor = in.readString();
                interiorColor = in.readString();
                engine = in.readString();
                displacement = in.readString();
                drivetype = in.readString();
                transmission = in.readString();
                fuel = in.readString();
                if (in.readByte() == 0) {
                    mpgCity = null;
                } else {
                    mpgCity = in.readInt();
                }
                if (in.readByte() == 0) {
                    mpgHighway = null;
                } else {
                    mpgHighway = in.readInt();
                }
                bodytype = in.readString();
                vehicleCondition = in.readString();
                cabType = in.readString();
                bedLength = in.readString();
                if (in.readByte() == 0) {
                    followCount = null;
                } else {
                    followCount = in.readInt();
                }
                stockNumber = in.readString();
                if (in.readByte() == 0) {
                    imageCount = null;
                } else {
                    imageCount = in.readInt();
                }
                firstSeen = in.readString();
                byte tmpOneOwner = in.readByte();
                oneOwner = tmpOneOwner == 0 ? null : tmpOneOwner == 1;
                byte tmpNoAccidents = in.readByte();
                noAccidents = tmpNoAccidents == 0 ? null : tmpNoAccidents == 1;
                byte tmpServiceRecords = in.readByte();
                serviceRecords = tmpServiceRecords == 0 ? null : tmpServiceRecords == 1;
                byte tmpPersonalUse = in.readByte();
                personalUse = tmpPersonalUse == 0 ? null : tmpPersonalUse == 1;
                if (in.readByte() == 0) {
                    distanceToDealer = null;
                } else {
                    distanceToDealer = in.readDouble();
                }
                byte tmpHasViewed = in.readByte();
                hasViewed = tmpHasViewed == 0 ? null : tmpHasViewed == 1;
                byte tmpSentLead = in.readByte();
                sentLead = tmpSentLead == 0 ? null : tmpSentLead == 1;
                recordType = in.readString();
                dealerType = in.readString();
                byte tmpBackfill = in.readByte();
                backfill = tmpBackfill == 0 ? null : tmpBackfill == 1;
                byte tmpAdvantage = in.readByte();
                advantage = tmpAdvantage == 0 ? null : tmpAdvantage == 1;
                vdpUrl = in.readString();
                if (in.readByte() == 0) {
                    sortScore = null;
                } else {
                    sortScore = in.readDouble();
                }
                byte tmpIsEnriched = in.readByte();
                isEnriched = tmpIsEnriched == 0 ? null : tmpIsEnriched == 1;
                byte tmpFollowing = in.readByte();
                following = tmpFollowing == 0 ? null : tmpFollowing == 1;
                byte tmpOnlineOnly = in.readByte();
                onlineOnly = tmpOnlineOnly == 0 ? null : tmpOnlineOnly == 1;
                byte tmpCertified = in.readByte();
                certified = tmpCertified == 0 ? null : tmpCertified == 1;
            }

            public static final Creator<Listing> CREATOR = new Creator<Listing>() {
                @Override
                public Listing createFromParcel(Parcel in) {
                    return new Listing(in);
                }

                @Override
                public Listing[] newArray(int size) {
                    return new Listing[size];
                }
            };

            public Listing() {}

            public Dealer getDealer() {
                return dealer;
            }

            public void setDealer(Dealer dealer) {
                this.dealer = dealer;
            }

            @NonNull
            public String getId() {
                if (this.id == null) return "no id";
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getVin() {
                return vin;
            }

            public void setVin(String vin) {
                this.vin = vin;
            }

            public Integer getYear() {
                return year;
            }

            public void setYear(Integer year) {
                this.year = year;
            }

            public String getMake() {
                return make;
            }

            public void setMake(String make) {
                this.make = make;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }

            public String getTrim() {
                return trim;
            }

            public void setTrim(String trim) {
                this.trim = trim;
            }

            public String getSubTrim() {
                return subTrim;
            }

            public void setSubTrim(String subTrim) {
                this.subTrim = subTrim;
            }

            public List<String> getTopOptions() {
                return topOptions;
            }

            public void setTopOptions(List<String> topOptions) {
                this.topOptions = topOptions;
            }

            public Integer getMileage() {
                return mileage;
            }

            public void setMileage(Integer mileage) {
                this.mileage = mileage;
            }

            public Double getListPrice() {
                return listPrice;
            }

            public void setListPrice(Double listPrice) {
                this.listPrice = listPrice;
            }

            public Double getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(Double currentPrice) {
                this.currentPrice = currentPrice;
            }

            public Dealer.MonthlyPaymentEstimate getMonthlyPaymentEstimate() {
                return monthlyPaymentEstimate;
            }

            public void setMonthlyPaymentEstimate(Dealer.MonthlyPaymentEstimate monthlyPaymentEstimate) {
                this.monthlyPaymentEstimate = monthlyPaymentEstimate;
            }

            public Double getOnePrice() {
                return onePrice;
            }

            public void setOnePrice(Double onePrice) {
                this.onePrice = onePrice;
            }

            public String getBadge() {
                return badge;
            }

            public void setBadge(String badge) {
                this.badge = badge;
            }

            public String getExteriorColor() {
                return exteriorColor;
            }

            public void setExteriorColor(String exteriorColor) {
                this.exteriorColor = exteriorColor;
            }

            public String getInteriorColor() {
                return interiorColor;
            }

            public void setInteriorColor(String interiorColor) {
                this.interiorColor = interiorColor;
            }

            public String getEngine() {
                return engine;
            }

            public void setEngine(String engine) {
                this.engine = engine;
            }

            public String getDisplacement() {
                return displacement;
            }

            public void setDisplacement(String displacement) {
                this.displacement = displacement;
            }

            public String getDrivetype() {
                return drivetype;
            }

            public void setDrivetype(String drivetype) {
                this.drivetype = drivetype;
            }

            public String getTransmission() {
                return transmission;
            }

            public void setTransmission(String transmission) {
                this.transmission = transmission;
            }

            public String getFuel() {
                return fuel;
            }

            public void setFuel(String fuel) {
                this.fuel = fuel;
            }

            public Integer getMpgCity() {
                return mpgCity;
            }

            public void setMpgCity(Integer mpgCity) {
                this.mpgCity = mpgCity;
            }

            public Integer getMpgHighway() {
                return mpgHighway;
            }

            public void setMpgHighway(Integer mpgHighway) {
                this.mpgHighway = mpgHighway;
            }

            public String getBodytype() {
                return bodytype;
            }

            public void setBodytype(String bodytype) {
                this.bodytype = bodytype;
            }

            public String getVehicleCondition() {
                return vehicleCondition;
            }

            public void setVehicleCondition(String vehicleCondition) {
                this.vehicleCondition = vehicleCondition;
            }

            public String getCabType() {
                return cabType;
            }

            public void setCabType(String cabType) {
                this.cabType = cabType;
            }

            public String getBedLength() {
                return bedLength;
            }

            public void setBedLength(String bedLength) {
                this.bedLength = bedLength;
            }

            public Integer getFollowCount() {
                return followCount;
            }

            public void setFollowCount(Integer followCount) {
                this.followCount = followCount;
            }

            public String getStockNumber() {
                return stockNumber;
            }

            public void setStockNumber(String stockNumber) {
                this.stockNumber = stockNumber;
            }

            public Integer getImageCount() {
                return imageCount;
            }

            public void setImageCount(Integer imageCount) {
                this.imageCount = imageCount;
            }

            public Images getImages() {
                return images;
            }

            public void setImages(Images images) {
                this.images = images;
            }

            public String getFirstSeen() {
                return firstSeen;
            }

            public void setFirstSeen(String firstSeen) {
                this.firstSeen = firstSeen;
            }

            public Boolean getOneOwner() {
                return oneOwner;
            }

            public void setOneOwner(Boolean oneOwner) {
                this.oneOwner = oneOwner;
            }

            public Boolean getNoAccidents() {
                return noAccidents;
            }

            public void setNoAccidents(Boolean noAccidents) {
                this.noAccidents = noAccidents;
            }

            public Boolean getServiceRecords() {
                return serviceRecords;
            }

            public void setServiceRecords(Boolean serviceRecords) {
                this.serviceRecords = serviceRecords;
            }

            public Boolean getPersonalUse() {
                return personalUse;
            }

            public void setPersonalUse(Boolean personalUse) {
                this.personalUse = personalUse;
            }

            public Double getDistanceToDealer() {
                return distanceToDealer;
            }

            public void setDistanceToDealer(Double distanceToDealer) {
                this.distanceToDealer = distanceToDealer;
            }

            public Boolean getHasViewed() {
                return hasViewed;
            }

            public void setHasViewed(Boolean hasViewed) {
                this.hasViewed = hasViewed;
            }

            public Boolean getSentLead() {
                return sentLead;
            }

            public void setSentLead(Boolean sentLead) {
                this.sentLead = sentLead;
            }

            public Object getSentLeadAt() {
                return sentLeadAt;
            }

            public void setSentLeadAt(Object sentLeadAt) {
                this.sentLeadAt = sentLeadAt;
            }

            public String getRecordType() {
                return recordType;
            }

            public void setRecordType(String recordType) {
                this.recordType = recordType;
            }

            public String getDealerType() {
                return dealerType;
            }

            public void setDealerType(String dealerType) {
                this.dealerType = dealerType;
            }

            public Boolean getBackfill() {
                return backfill;
            }

            public void setBackfill(Boolean backfill) {
                this.backfill = backfill;
            }

            public Boolean getAdvantage() {
                return advantage;
            }

            public void setAdvantage(Boolean advantage) {
                this.advantage = advantage;
            }

            public String getVdpUrl() {
                return vdpUrl;
            }

            public void setVdpUrl(String vdpUrl) {
                this.vdpUrl = vdpUrl;
            }

            public Double getSortScore() {
                return sortScore;
            }

            public void setSortScore(Double sortScore) {
                this.sortScore = sortScore;
            }

            public Boolean getIsEnriched() {
                return isEnriched;
            }

            public void setIsEnriched(Boolean isEnriched) {
                this.isEnriched = isEnriched;
            }

            public Boolean getFollowing() {
                return following;
            }

            public void setFollowing(Boolean following) {
                this.following = following;
            }

            public Boolean getOnlineOnly() {
                return onlineOnly;
            }

            public void setOnlineOnly(Boolean onlineOnly) {
                this.onlineOnly = onlineOnly;
            }

            public Boolean getCertified() {
                return certified;
            }

            public void setCertified(Boolean certified) {
                this.certified = certified;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(id);
                parcel.writeString(vin);
                if (year == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeInt(year);
                }
                parcel.writeString(make);
                parcel.writeString(model);
                parcel.writeString(trim);
                parcel.writeString(subTrim);
                parcel.writeStringList(topOptions);
                if (mileage == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeInt(mileage);
                }
                if (listPrice == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeDouble(listPrice);
                }
                if (currentPrice == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeDouble(currentPrice);
                }
                if (onePrice == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeDouble(onePrice);
                }
                parcel.writeString(badge);
                parcel.writeString(exteriorColor);
                parcel.writeString(interiorColor);
                parcel.writeString(engine);
                parcel.writeString(displacement);
                parcel.writeString(drivetype);
                parcel.writeString(transmission);
                parcel.writeString(fuel);
                if (mpgCity == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeInt(mpgCity);
                }
                if (mpgHighway == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeInt(mpgHighway);
                }
                parcel.writeString(bodytype);
                parcel.writeString(vehicleCondition);
                parcel.writeString(cabType);
                parcel.writeString(bedLength);
                if (followCount == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeInt(followCount);
                }
                parcel.writeString(stockNumber);
                if (imageCount == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeInt(imageCount);
                }
                parcel.writeString(firstSeen);
                parcel.writeByte((byte) (oneOwner == null ? 0 : oneOwner ? 1 : 2));
                parcel.writeByte((byte) (noAccidents == null ? 0 : noAccidents ? 1 : 2));
                parcel.writeByte((byte) (serviceRecords == null ? 0 : serviceRecords ? 1 : 2));
                parcel.writeByte((byte) (personalUse == null ? 0 : personalUse ? 1 : 2));
                if (distanceToDealer == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeDouble(distanceToDealer);
                }
                parcel.writeByte((byte) (hasViewed == null ? 0 : hasViewed ? 1 : 2));
                parcel.writeByte((byte) (sentLead == null ? 0 : sentLead ? 1 : 2));
                parcel.writeString(recordType);
                parcel.writeString(dealerType);
                parcel.writeByte((byte) (backfill == null ? 0 : backfill ? 1 : 2));
                parcel.writeByte((byte) (advantage == null ? 0 : advantage ? 1 : 2));
                parcel.writeString(vdpUrl);
                if (sortScore == null) {
                    parcel.writeByte((byte) 0);
                } else {
                    parcel.writeByte((byte) 1);
                    parcel.writeDouble(sortScore);
                }
                parcel.writeByte((byte) (isEnriched == null ? 0 : isEnriched ? 1 : 2));
                parcel.writeByte((byte) (following == null ? 0 : following ? 1 : 2));
                parcel.writeByte((byte) (onlineOnly == null ? 0 : onlineOnly ? 1 : 2));
                parcel.writeByte((byte) (certified == null ? 0 : certified ? 1 : 2));
            }

            @Entity(tableName = "dealer_table")
            public static class Dealer implements Parcelable {

                @PrimaryKey(autoGenerate = true)
                public int id;

                @NonNull
                @SerializedName("carfaxId")
                @Expose
                private String carfaxId;
                @SerializedName("dealerInventoryUrl")
                @Expose
                private String dealerInventoryUrl;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("address")
                @Expose
                private String address;
                @SerializedName("city")
                @Expose
                private String city;
                @SerializedName("state")
                @Expose
                private String state;
                @SerializedName("zip")
                @Expose
                private String zip;
                @SerializedName("phone")
                @Expose
                private String phone;
                @SerializedName("latitude")
                @Expose
                private String latitude;
                @SerializedName("longitude")
                @Expose
                private String longitude;
                @SerializedName("dealerAverageRating")
                @Expose
                private Double dealerAverageRating;
                @SerializedName("dealerReviewDate")
                @Expose
                private String dealerReviewDate;
                @SerializedName("dealerReviewReviewer")
                @Expose
                private String dealerReviewReviewer;
                @SerializedName("dealerReviewRating")
                @Expose
                private Integer dealerReviewRating;
                @SerializedName("dealerReviewCount")
                @Expose
                private Integer dealerReviewCount;
                @SerializedName("onlineOnly")
                @Expose
                private Boolean onlineOnly;

                protected Dealer(Parcel in) {
                    carfaxId = in.readString();
                    dealerInventoryUrl = in.readString();
                    name = in.readString();
                    address = in.readString();
                    city = in.readString();
                    state = in.readString();
                    zip = in.readString();
                    phone = in.readString();
                    latitude = in.readString();
                    longitude = in.readString();
                    if (in.readByte() == 0) {
                        dealerAverageRating = null;
                    } else {
                        dealerAverageRating = in.readDouble();
                    }
                    dealerReviewDate = in.readString();
                    dealerReviewReviewer = in.readString();
                    if (in.readByte() == 0) {
                        dealerReviewRating = null;
                    } else {
                        dealerReviewRating = in.readInt();
                    }
                    if (in.readByte() == 0) {
                        dealerReviewCount = null;
                    } else {
                        dealerReviewCount = in.readInt();
                    }
                    byte tmpOnlineOnly = in.readByte();
                    onlineOnly = tmpOnlineOnly == 0 ? null : tmpOnlineOnly == 1;
                }

                public static final Creator<Dealer> CREATOR = new Creator<Dealer>() {
                    @Override
                    public Dealer createFromParcel(Parcel in) {
                        return new Dealer(in);
                    }

                    @Override
                    public Dealer[] newArray(int size) {
                        return new Dealer[size];
                    }
                };

                public Dealer() {}

                public String getCarfaxId() {
                    return carfaxId;
                }

                public void setCarfaxId(String carfaxId) {
                    this.carfaxId = carfaxId;
                }

                public String getDealerInventoryUrl() {
                    return dealerInventoryUrl;
                }

                public void setDealerInventoryUrl(String dealerInventoryUrl) {
                    this.dealerInventoryUrl = dealerInventoryUrl;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getZip() {
                    return zip;
                }

                public void setZip(String zip) {
                    this.zip = zip;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                public Double getDealerAverageRating() {
                    return dealerAverageRating;
                }

                public void setDealerAverageRating(Double dealerAverageRating) {
                    this.dealerAverageRating = dealerAverageRating;
                }

                public String getDealerReviewDate() {
                    return dealerReviewDate;
                }

                public void setDealerReviewDate(String dealerReviewDate) {
                    this.dealerReviewDate = dealerReviewDate;
                }

                public String getDealerReviewReviewer() {
                    return dealerReviewReviewer;
                }

                public void setDealerReviewReviewer(String dealerReviewReviewer) {
                    this.dealerReviewReviewer = dealerReviewReviewer;
                }

                public Integer getDealerReviewRating() {
                    return dealerReviewRating;
                }

                public void setDealerReviewRating(Integer dealerReviewRating) {
                    this.dealerReviewRating = dealerReviewRating;
                }

                public Integer getDealerReviewCount() {
                    return dealerReviewCount;
                }

                public void setDealerReviewCount(Integer dealerReviewCount) {
                    this.dealerReviewCount = dealerReviewCount;
                }

                public Boolean getOnlineOnly() {
                    return onlineOnly;
                }

                public void setOnlineOnly(Boolean onlineOnly) {
                    this.onlineOnly = onlineOnly;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(carfaxId);
                    parcel.writeString(dealerInventoryUrl);
                    parcel.writeString(name);
                    parcel.writeString(address);
                    parcel.writeString(city);
                    parcel.writeString(state);
                    parcel.writeString(zip);
                    parcel.writeString(phone);
                    parcel.writeString(latitude);
                    parcel.writeString(longitude);
                    if (dealerAverageRating == null) {
                        parcel.writeByte((byte) 0);
                    } else {
                        parcel.writeByte((byte) 1);
                        parcel.writeDouble(dealerAverageRating);
                    }
                    parcel.writeString(dealerReviewDate);
                    parcel.writeString(dealerReviewReviewer);
                    if (dealerReviewRating == null) {
                        parcel.writeByte((byte) 0);
                    } else {
                        parcel.writeByte((byte) 1);
                        parcel.writeInt(dealerReviewRating);
                    }
                    if (dealerReviewCount == null) {
                        parcel.writeByte((byte) 0);
                    } else {
                        parcel.writeByte((byte) 1);
                        parcel.writeInt(dealerReviewCount);
                    }
                    parcel.writeByte((byte) (onlineOnly == null ? 0 : onlineOnly ? 1 : 2));
                }

                public static class MonthlyPaymentEstimate {

                    @SerializedName("price")
                    @Expose
                    private Double price;
                    @SerializedName("downPaymentPercent")
                    @Expose
                    private Double downPaymentPercent;
                    @SerializedName("interestRate")
                    @Expose
                    private Double interestRate;
                    @SerializedName("termInMonths")
                    @Expose
                    private Integer termInMonths;
                    @SerializedName("loanAmount")
                    @Expose
                    private Double loanAmount;
                    @SerializedName("downPaymentAmount")
                    @Expose
                    private Double downPaymentAmount;
                    @SerializedName("monthlyPayment")
                    @Expose
                    private Double monthlyPayment;

                    public Double getPrice() {
                        return price;
                    }

                    public void setPrice(Double price) {
                        this.price = price;
                    }

                    public Double getDownPaymentPercent() {
                        return downPaymentPercent;
                    }

                    public void setDownPaymentPercent(Double downPaymentPercent) {
                        this.downPaymentPercent = downPaymentPercent;
                    }

                    public Double getInterestRate() {
                        return interestRate;
                    }

                    public void setInterestRate(Double interestRate) {
                        this.interestRate = interestRate;
                    }

                    public Integer getTermInMonths() {
                        return termInMonths;
                    }

                    public void setTermInMonths(Integer termInMonths) {
                        this.termInMonths = termInMonths;
                    }

                    public Double getLoanAmount() {
                        return loanAmount;
                    }

                    public void setLoanAmount(Double loanAmount) {
                        this.loanAmount = loanAmount;
                    }

                    public Double getDownPaymentAmount() {
                        return downPaymentAmount;
                    }

                    public void setDownPaymentAmount(Double downPaymentAmount) {
                        this.downPaymentAmount = downPaymentAmount;
                    }

                    public Double getMonthlyPayment() {
                        return monthlyPayment;
                    }

                    public void setMonthlyPayment(Double monthlyPayment) {
                        this.monthlyPayment = monthlyPayment;
                    }
                }
            }

            @Entity(tableName = "image_table")
            public static class Images implements Parcelable{

                @PrimaryKey(autoGenerate = true)
                public int id;

                @SerializedName("baseUrl")
                @Expose
                @NonNull
                private String baseUrl;
                @Ignore
                @SerializedName("large")
                @Expose
                private List<String> large = null;
                @Ignore
                @SerializedName("medium")
                @Expose
                private List<String> medium = null;
                @Ignore
                @SerializedName("small")
                @Expose
                private List<String> small = null;
                @Ignore
                @SerializedName("firstPhoto")
                @Expose
                private FirstPhoto firstPhoto;

                protected Images(Parcel in) {
                    baseUrl = in.readString();
                    large = in.createStringArrayList();
                    medium = in.createStringArrayList();
                    small = in.createStringArrayList();
                }

                public static final Creator<Images> CREATOR = new Creator<Images>() {
                    @Override
                    public Images createFromParcel(Parcel in) {
                        return new Images(in);
                    }

                    @Override
                    public Images[] newArray(int size) {
                        return new Images[size];
                    }
                };

                public Images() {}

                public String getBaseUrl() {
                    return baseUrl;
                }

                public void setBaseUrl(String baseUrl) {
                    this.baseUrl = baseUrl;
                }

                public List<String> getLarge() {
                    return large;
                }

                public void setLarge(List<String> large) {
                    this.large = large;
                }

                public List<String> getMedium() {
                    return medium;
                }

                public void setMedium(List<String> medium) {
                    this.medium = medium;
                }

                public List<String> getSmall() {
                    return small;
                }

                public void setSmall(List<String> small) {
                    this.small = small;
                }

                public FirstPhoto getFirstPhoto() {
                    return firstPhoto;
                }

                public void setFirstPhoto(FirstPhoto firstPhoto) {
                    this.firstPhoto = firstPhoto;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(baseUrl);
                    parcel.writeStringList(large);
                    parcel.writeStringList(medium);
                    parcel.writeStringList(small);
                }

                @Entity(tableName = "firstPhoto")
                public static class FirstPhoto implements Parcelable {

                    @PrimaryKey(autoGenerate = true)
                    public int id;

                    @SerializedName("small")
                    @Expose
                    private String small;
                    @SerializedName("large")
                    @Expose
                    @NonNull
                    private String large;
                    @SerializedName("medium")
                    @Expose
                    private String medium;

                    protected FirstPhoto(Parcel in) {
                        small = in.readString();
                        large = in.readString();
                        medium = in.readString();
                    }

                    public static final Creator<FirstPhoto> CREATOR = new Creator<FirstPhoto>() {
                        @Override
                        public FirstPhoto createFromParcel(Parcel in) {
                            return new FirstPhoto(in);
                        }

                        @Override
                        public FirstPhoto[] newArray(int size) {
                            return new FirstPhoto[size];
                        }
                    };

                    public FirstPhoto() {}

                    public String getSmall() {
                        return small;
                    }

                    public void setSmall(String small) {
                        this.small = small;
                    }

                    public String getLarge() {
                        return large;
                    }

                    public void setLarge(String large) {
                        this.large = large;
                    }

                    public String getMedium() {
                        return medium;
                    }

                    public void setMedium(String medium) {
                        this.medium = medium;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel parcel, int i) {
                        parcel.writeString(small);
                        parcel.writeString(large);
                        parcel.writeString(medium);
                    }
                }

            }

        }
    }
}
