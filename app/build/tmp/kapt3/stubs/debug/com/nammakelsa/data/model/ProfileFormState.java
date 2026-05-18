package com.nammakelsa.data.model;

import android.net.Uri;

/**
 * UI state for the worker registration and profile edit forms.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Je\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020&H\u00d6\u0001J\t\u0010\'\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006("}, d2 = {"Lcom/nammakelsa/data/model/ProfileFormState;", "", "name", "", "skillType", "Lcom/nammakelsa/data/model/SkillType;", "dailyRateInr", "profilePhotoUri", "Landroid/net/Uri;", "nameError", "skillError", "rateError", "photoError", "(Ljava/lang/String;Lcom/nammakelsa/data/model/SkillType;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDailyRateInr", "()Ljava/lang/String;", "getName", "getNameError", "getPhotoError", "getProfilePhotoUri", "()Landroid/net/Uri;", "getRateError", "getSkillError", "getSkillType", "()Lcom/nammakelsa/data/model/SkillType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class ProfileFormState {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final com.nammakelsa.data.model.SkillType skillType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String dailyRateInr = null;
    @org.jetbrains.annotations.Nullable()
    private final android.net.Uri profilePhotoUri = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String nameError = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String skillError = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String rateError = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String photoError = null;
    
    public ProfileFormState(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    com.nammakelsa.data.model.SkillType skillType, @org.jetbrains.annotations.NotNull()
    java.lang.String dailyRateInr, @org.jetbrains.annotations.Nullable()
    android.net.Uri profilePhotoUri, @org.jetbrains.annotations.Nullable()
    java.lang.String nameError, @org.jetbrains.annotations.Nullable()
    java.lang.String skillError, @org.jetbrains.annotations.Nullable()
    java.lang.String rateError, @org.jetbrains.annotations.Nullable()
    java.lang.String photoError) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.nammakelsa.data.model.SkillType getSkillType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDailyRateInr() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getProfilePhotoUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNameError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSkillError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRateError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhotoError() {
        return null;
    }
    
    public ProfileFormState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.nammakelsa.data.model.SkillType component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammakelsa.data.model.ProfileFormState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    com.nammakelsa.data.model.SkillType skillType, @org.jetbrains.annotations.NotNull()
    java.lang.String dailyRateInr, @org.jetbrains.annotations.Nullable()
    android.net.Uri profilePhotoUri, @org.jetbrains.annotations.Nullable()
    java.lang.String nameError, @org.jetbrains.annotations.Nullable()
    java.lang.String skillError, @org.jetbrains.annotations.Nullable()
    java.lang.String rateError, @org.jetbrains.annotations.Nullable()
    java.lang.String photoError) {
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