package com.nammakelsa.domain.repository;

import com.nammakelsa.data.model.LatLng;
import com.nammakelsa.data.model.SkillType;
import com.nammakelsa.data.model.WorkerSearchResult;
import kotlinx.coroutines.flow.Flow;

/**
 * Abstraction over the Firestore geo-query used for customer worker discovery.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/nammakelsa/domain/repository/SearchRepository;", "", "searchWorkers", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/nammakelsa/data/model/WorkerSearchResult;", "skill", "Lcom/nammakelsa/data/model/SkillType;", "customerLocation", "Lcom/nammakelsa/data/model/LatLng;", "radiusKm", "", "app_debug"})
public abstract interface SearchRepository {
    
    /**
     * Returns a [Flow] of worker search results that match [skill], are available,
     * and are within [radiusKm] of [customerLocation].
     *
     * Results are sorted by distance ascending (nearest first).
     * Workers with `isAvailable == false` are never included.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammakelsa.data.model.WorkerSearchResult>> searchWorkers(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.model.SkillType skill, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.model.LatLng customerLocation, double radiusKm);
}