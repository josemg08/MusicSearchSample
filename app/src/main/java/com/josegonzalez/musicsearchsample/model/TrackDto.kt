package com.josegonzalez.musicsearchsample.model

import android.os.Parcel
import android.os.Parcelable

class TrackDto protected constructor(parcel: Parcel) : Parcelable {
    var isStreamable: Boolean = parcel.readByte().toInt() != 0
    var artistId: Long = parcel.readLong()
    var amgArtistId: Long = parcel.readLong()
    var collectionId: Long = parcel.readLong()
    var trackId: Long = parcel.readLong()
    var primaryGenreId: Long = parcel.readLong()
    var trackTimeMillis: Long = parcel.readLong()
    var discNumber: Int = parcel.readInt()
    var trackCount: Int = parcel.readInt()
    var trackNumber: Int = parcel.readInt()
    var discCount: Int = parcel.readInt()
    var collectionPrice: Double = parcel.readDouble()
    var trackPrice: Double = parcel.readDouble()
    var wrapperType: String? = parcel.readString()
    var artistType: String? = parcel.readString()
    var artistName: String? = parcel.readString()
    var artistLinkUrl: String? = parcel.readString()
    var primaryGenreName: String? = parcel.readString()
    var radioStationUrl: String? = parcel.readString()
    var kind: String? = parcel.readString()
    var collectionName: String? = parcel.readString()
    var trackName: String? = parcel.readString()
    var collectionCensoredName: String? = parcel.readString()
    var trackCensoredName: String? = parcel.readString()
    var artistViewUrl: String? = parcel.readString()
    var collectionViewUrl: String? = parcel.readString()
    var trackViewUrl: String? = parcel.readString()
    var previewUrl: String? = parcel.readString()
    var artworkUrl30: String? = parcel.readString()
    var artworkUrl60: String? = parcel.readString()
    var artworkUrl100: String? = parcel.readString()
    var releaseDate: String? = parcel.readString()
    var collectionExplicitness: String? = parcel.readString()
    var trackExplicitness: String? = parcel.readString()
    var country: String? = parcel.readString()
    var currency: String? = parcel.readString()

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeByte((if (isStreamable) 1 else 0).toByte())
        dest.writeLong(artistId)
        dest.writeLong(amgArtistId)
        dest.writeLong(collectionId)
        dest.writeLong(trackId)
        dest.writeLong(primaryGenreId)
        dest.writeLong(trackTimeMillis)
        dest.writeInt(discNumber)
        dest.writeInt(trackCount)
        dest.writeInt(trackNumber)
        dest.writeInt(discCount)
        dest.writeDouble(collectionPrice)
        dest.writeDouble(trackPrice)
        dest.writeString(wrapperType)
        dest.writeString(artistType)
        dest.writeString(artistName)
        dest.writeString(artistLinkUrl)
        dest.writeString(primaryGenreName)
        dest.writeString(radioStationUrl)
        dest.writeString(kind)
        dest.writeString(collectionName)
        dest.writeString(trackName)
        dest.writeString(collectionCensoredName)
        dest.writeString(trackCensoredName)
        dest.writeString(artistViewUrl)
        dest.writeString(collectionViewUrl)
        dest.writeString(trackViewUrl)
        dest.writeString(previewUrl)
        dest.writeString(artworkUrl30)
        dest.writeString(artworkUrl60)
        dest.writeString(artworkUrl100)
        dest.writeString(releaseDate)
        dest.writeString(collectionExplicitness)
        dest.writeString(trackExplicitness)
        dest.writeString(country)
        dest.writeString(currency)
    }

    companion object {
        val CREATOR: Parcelable.Creator<TrackDto?> = object : Parcelable.Creator<TrackDto?> {
            override fun createFromParcel(`in`: Parcel): TrackDto? {
                return TrackDto(`in`)
            }

            override fun newArray(size: Int): Array<TrackDto?> {
                return arrayOfNulls(size)
            }
        }
    }

}