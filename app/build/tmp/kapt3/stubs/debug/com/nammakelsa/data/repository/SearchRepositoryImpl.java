package com.nammakelsa.data.repository;

import com.google.firebase.firestore.FirebaseFirestore;
import com.nammakelsa.data.model.LatLng;
import com.nammakelsa.data.model.SkillType;
import com.nammakelsa.data.model.WorkerProfile;
import com.nammakelsa.data.model.WorkerSearchResult;
import com.nammakelsa.domain.repository.SearchRepository;
import com.nammakelsa.util.GeoHashUtil;
import com.nammakelsa.util.HaversineUtil;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/nammakelsa/data/repository/SearchRepositoryImpl;", "Lcom/nammakelsa/domain/repository/SearchRepository;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "searchWorkers", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/nammakelsa/data/model/WorkerSearchResult;", "skill", "Lcom/nammakelsa/data/model/SkillType;", "customerLocation", "Lcom/nammakelsa/data/model/LatLng;", "radiusKm", "", "app_debug"})
public final class SearchRepositoryImpl implements com.nammakelsa.domain.repository.SearchRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    
    @javax.inject.Inject()
    public SearchRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.nammakelsa.data.model.WorkerSearchResult>> searchWorkers(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.model.SkillType skill, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.model.LatLng customerLocation, double radiusKm) {
        return null;
    }
}