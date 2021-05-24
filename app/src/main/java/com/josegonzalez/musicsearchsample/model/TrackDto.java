package com.josegonzalez.musicsearchsample.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TrackDto implements Parcelable {

    private boolean isStreamable;

    private long artistId;
    private long amgArtistId;
    private long collectionId;
    private long trackId;
    private long primaryGenreId;

    private long trackTimeMillis;

    private int discNumber;
    private int trackCount;
    private int trackNumber;
    private int discCount;

    private double collectionPrice;
    private double trackPrice;

    private String wrapperType;
    private String artistType;
    private String artistName;
    private String artistLinkUrl;

    private String primaryGenreName;

    private String radioStationUrl;
    private String kind;

    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;

    private String artistViewUrl;
    private String collectionViewUrl;
    private String trackViewUrl;
    private String previewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;

    private String releaseDate;

    private String collectionExplicitness;
    private String trackExplicitness;

    private String country;

    private String currency;

    protected TrackDto(Parcel in) {
        isStreamable = in.readByte() != 0;
        artistId = in.readLong();
        amgArtistId = in.readLong();
        collectionId = in.readLong();
        trackId = in.readLong();
        primaryGenreId = in.readLong();
        trackTimeMillis = in.readLong();
        discNumber = in.readInt();
        trackCount = in.readInt();
        trackNumber = in.readInt();
        discCount = in.readInt();
        collectionPrice = in.readDouble();
        trackPrice = in.readDouble();
        wrapperType = in.readString();
        artistType = in.readString();
        artistName = in.readString();
        artistLinkUrl = in.readString();
        primaryGenreName = in.readString();
        radioStationUrl = in.readString();
        kind = in.readString();
        collectionName = in.readString();
        trackName = in.readString();
        collectionCensoredName = in.readString();
        trackCensoredName = in.readString();
        artistViewUrl = in.readString();
        collectionViewUrl = in.readString();
        trackViewUrl = in.readString();
        previewUrl = in.readString();
        artworkUrl30 = in.readString();
        artworkUrl60 = in.readString();
        artworkUrl100 = in.readString();
        releaseDate = in.readString();
        collectionExplicitness = in.readString();
        trackExplicitness = in.readString();
        country = in.readString();
        currency = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isStreamable ? 1 : 0));
        dest.writeLong(artistId);
        dest.writeLong(amgArtistId);
        dest.writeLong(collectionId);
        dest.writeLong(trackId);
        dest.writeLong(primaryGenreId);
        dest.writeLong(trackTimeMillis);
        dest.writeInt(discNumber);
        dest.writeInt(trackCount);
        dest.writeInt(trackNumber);
        dest.writeInt(discCount);
        dest.writeDouble(collectionPrice);
        dest.writeDouble(trackPrice);
        dest.writeString(wrapperType);
        dest.writeString(artistType);
        dest.writeString(artistName);
        dest.writeString(artistLinkUrl);
        dest.writeString(primaryGenreName);
        dest.writeString(radioStationUrl);
        dest.writeString(kind);
        dest.writeString(collectionName);
        dest.writeString(trackName);
        dest.writeString(collectionCensoredName);
        dest.writeString(trackCensoredName);
        dest.writeString(artistViewUrl);
        dest.writeString(collectionViewUrl);
        dest.writeString(trackViewUrl);
        dest.writeString(previewUrl);
        dest.writeString(artworkUrl30);
        dest.writeString(artworkUrl60);
        dest.writeString(artworkUrl100);
        dest.writeString(releaseDate);
        dest.writeString(collectionExplicitness);
        dest.writeString(trackExplicitness);
        dest.writeString(country);
        dest.writeString(currency);
    }

    public static final Creator<TrackDto> CREATOR = new Creator<TrackDto>() {
        @Override
        public TrackDto createFromParcel(Parcel in) {
            return new TrackDto(in);
        }

        @Override
        public TrackDto[] newArray(int size) {
            return new TrackDto[size];
        }
    };

    public boolean isStreamable() {
        return isStreamable;
    }

    public void setStreamable(boolean streamable) {
        isStreamable = streamable;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public long getAmgArtistId() {
        return amgArtistId;
    }

    public void setAmgArtistId(long amgArtistId) {
        this.amgArtistId = amgArtistId;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public long getPrimaryGenreId() {
        return primaryGenreId;
    }

    public void setPrimaryGenreId(long primaryGenreId) {
        this.primaryGenreId = primaryGenreId;
    }

    public long getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(long trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getDiscCount() {
        return discCount;
    }

    public void setDiscCount(int discCount) {
        this.discCount = discCount;
    }

    public double getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getArtistType() {
        return artistType;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistLinkUrl() {
        return artistLinkUrl;
    }

    public void setArtistLinkUrl(String artistLinkUrl) {
        this.artistLinkUrl = artistLinkUrl;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getRadioStationUrl() {
        return radioStationUrl;
    }

    public void setRadioStationUrl(String radioStationUrl) {
        this.radioStationUrl = radioStationUrl;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
