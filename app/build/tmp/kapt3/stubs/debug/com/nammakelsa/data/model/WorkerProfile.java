package com.nammakelsa.data.model;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.GeoPoint;

/**
 * Represents a worker's full profile stored in Firestore under `workers/{uid}`.
 * Default values are required for Firestore deserialization.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0011H\u00c6\u0003J\t\u0010*\u001a\u00020\u0013H\u00c6\u0003J\t\u0010+\u001a\u00020\u0013H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\t\u0010/\u001a\u00020\tH\u00c6\u0003J\t\u00100\u001a\u00020\u000bH\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u00c6\u0003J\u0087\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u00c6\u0001J\u0013\u00105\u001a\u00020\u00112\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00107\u001a\u00020\tH\u00d6\u0001J\t\u00108\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0017\u00a8\u00069"}, d2 = {"Lcom/nammakelsa/data/model/WorkerProfile;", "", "uid", "", "name", "phoneNumber", "skillType", "Lcom/nammakelsa/data/model/SkillType;", "dailyRateInr", "", "location", "Lcom/google/firebase/firestore/GeoPoint;", "geoHash", "profilePhotoUrl", "galleryPhotoUrls", "", "isAvailable", "", "createdAt", "Lcom/google/firebase/Timestamp;", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/nammakelsa/data/model/SkillType;ILcom/google/firebase/firestore/GeoPoint;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLcom/google/firebase/Timestamp;Lcom/google/firebase/Timestamp;)V", "getCreatedAt", "()Lcom/google/firebase/Timestamp;", "getDailyRateInr", "()I", "getGalleryPhotoUrls", "()Ljava/util/List;", "getGeoHash", "()Ljava/lang/String;", "()Z", "getLocation", "()Lcom/google/firebase/firestore/GeoPoint;", "getName", "getPhoneNumber", "getProfilePhotoUrl", "getSkillType", "()Lcom/nammakelsa/data/model/SkillType;", "getUid", "getUpdatedAt", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class WorkerProfile {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String uid = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String phoneNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.data.model.SkillType skillType = null;
    private final int dailyRateInr = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.GeoPoint location = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String geoHash = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String profilePhotoUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> galleryPhotoUrls = null;
    private final boolean isAvailable = false;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.Timestamp createdAt = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.Timestamp updatedAt = null;
    
    public WorkerProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.model.SkillType skillType, int dailyRateInr, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.GeoPoint location, @org.jetbrains.annotations.NotNull()
    java.lang.String geoHash, @org.jetbrains.annotations.NotNull()
    java.lang.String profilePhotoUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> galleryPhotoUrls, boolean isAvailable, @org.jetbrains.annotations.NotNull()
    com.google.firebase.Timestamp createdAt, @org.jetbrains.annotations.NotNull()
    com.google.firebase.Timestamp updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammakelsa.data.model.SkillType getSkillType() {
        return null;
    }
    
    public final int getDailyRateInr() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.GeoPoint getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGeoHash() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfilePhotoUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getGalleryPhotoUrls() {
        return null;
    }
    
    public final boolean isAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.Timestamp getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.Timestamp getUpdatedAt() {
        return null;
    }
    
    public WorkerProfile() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.Timestamp component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.Timestamp component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammakelsa.data.model.SkillType component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.GeoPoint component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammakelsa.data.model.WorkerProfile copy(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.model.SkillType skillType, int dailyRateInr, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.GeoPoint location, @org.jetbrains.annotations.NotNull()
    java.lang.String geoHash, @org.jetbrains.annotations.NotNull()
    java.lang.String profilePhotoUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> galleryPhotoUrls, boolean isAvailable, @org.jetbrains.annotations.NotNull()
    com.google.firebase.Timestamp createdAt, @org.jetbrains.annotations.NotNull()
    com.google.firebase.Timestamp updatedAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}