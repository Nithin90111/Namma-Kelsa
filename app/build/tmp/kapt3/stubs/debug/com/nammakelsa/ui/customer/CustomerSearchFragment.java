package com.nammakelsa.ui.customer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.chip.Chip;
import com.nammakelsa.R;
import com.nammakelsa.data.model.SkillType;
import com.nammakelsa.databinding.FragmentCustomerSearchBinding;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * Customer-facing screen for discovering nearby available workers.
 *
 * Displays a skill [ChipGroup] and a radius [ChipGroup] as filters. Results are
 * shown in a [RecyclerView] backed by [WorkerCardAdapter]. Handles the
 * location-permission-denied state by showing an explanatory layout with a
 * deep-link to the app's system settings page.
 *
 * Requirements: 4.1, 4.2, 4.3, 4.4, 4.5, 4.6, 4.7, 7.1, 7.3
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u001a\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010\'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/nammakelsa/ui/customer/CustomerSearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/nammakelsa/databinding/FragmentCustomerSearchBinding;", "binding", "getBinding", "()Lcom/nammakelsa/databinding/FragmentCustomerSearchBinding;", "locationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "viewModel", "Lcom/nammakelsa/ui/customer/SearchViewModel;", "getViewModel", "()Lcom/nammakelsa/ui/customer/SearchViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "workerCardAdapter", "Lcom/nammakelsa/ui/customer/WorkerCardAdapter;", "chipTextToSkillType", "Lcom/nammakelsa/data/model/SkillType;", "chipText", "getSelectedRadius", "", "getSelectedSkill", "observeUiState", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "requestLocationPermissionIfNeeded", "setupChipListeners", "setupRecyclerView", "setupSettingsButton", "app_debug"})
public final class CustomerSearchFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.nammakelsa.databinding.FragmentCustomerSearchBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.nammakelsa.ui.customer.WorkerCardAdapter workerCardAdapter;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> locationPermissionLauncher = null;
    
    public CustomerSearchFragment() {
        super();
    }
    
    private final com.nammakelsa.databinding.FragmentCustomerSearchBinding getBinding() {
        return null;
    }
    
    private final com.nammakelsa.ui.customer.SearchViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupChipListeners() {
    }
    
    private final void setupSettingsButton() {
    }
    
    private final void observeUiState() {
    }
    
    private final void requestLocationPermissionIfNeeded() {
    }
    
    private final com.nammakelsa.data.model.SkillType getSelectedSkill() {
        return null;
    }
    
    private final double getSelectedRadius() {
        return 0.0;
    }
    
    /**
     * Maps a chip label (e.g. "Painting") to the corresponding [SkillType] enum value.
     * Returns null if the label does not match any known skill.
     */
    private final com.nammakelsa.data.model.SkillType chipTextToSkillType(java.lang.String chipText) {
        return null;
    }
}