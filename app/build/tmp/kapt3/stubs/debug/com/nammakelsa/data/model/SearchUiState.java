package com.nammakelsa.data.model;

/**
 * UI state for the customer search screen.
 *
 * [locationPermissionDenied] is set to true when the app does not have
 * ACCESS_FINE_LOCATION permission. The fragment should render an explanatory
 * message with a deep-link to Settings when this flag is true.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\nH\u00c6\u0003J\t\u0010 \u001a\u00020\nH\u00c6\u0003JY\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\fH\u00d6\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\'"}, d2 = {"Lcom/nammakelsa/data/model/SearchUiState;", "", "selectedSkill", "Lcom/nammakelsa/data/model/SkillType;", "radiusKm", "", "results", "", "Lcom/nammakelsa/data/model/WorkerSearchResult;", "isLoading", "", "error", "", "isEmpty", "locationPermissionDenied", "(Lcom/nammakelsa/data/model/SkillType;DLjava/util/List;ZLjava/lang/String;ZZ)V", "getError", "()Ljava/lang/String;", "()Z", "getLocationPermissionDenied", "getRadiusKm", "()D", "getResults", "()Ljava/util/List;", "getSelectedSkill", "()Lcom/nammakelsa/data/model/SkillType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class SearchUiState {
    @org.jetbrains.annotations.Nullable()
    private final com.nammakelsa.data.model.SkillType selectedSkill = null;
    private final double radiusKm = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.nammakelsa.data.model.WorkerSearchResult> results = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    private final boolean isEmpty = false;
    private final boolean locationPermissionDenied = false;
    
    public SearchUiState(@org.jetbrains.annotations.Nullable()
    com.nammakelsa.data.model.SkillType selectedSkill, double radiusKm, @org.jetbrains.annotations.NotNull()
    java.util.List<com.nammakelsa.data.model.WorkerSearchResult> results, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, boolean isEmpty, boolean locationPermissionDenied) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.nammakelsa.data.model.SkillType getSelectedSkill() {
        return null;
    }
    
    public final double getRadiusKm() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.nammakelsa.data.model.WorkerSearchResult> getResults() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public final boolean isEmpty() {
        return false;
    }
    
    public final boolean getLocationPermissionDenied() {
        return false;
    }
    
    public SearchUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.nammakelsa.data.model.SkillType component1() {
        return null;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.nammakelsa.data.model.WorkerSearchResult> component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammakelsa.data.model.SearchUiState copy(@org.jetbrains.annotations.Nullable()
    com.nammakelsa.data.model.SkillType selectedSkill, double radiusKm, @org.jetbrains.annotations.NotNull()
    java.util.List<com.nammakelsa.data.model.WorkerSearchResult> results, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, boolean isEmpty, boolean locationPermissionDenied) {
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