package com.nammakelsa.ui.worker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import coil.transform.CircleCropTransformation;
import com.google.android.material.chip.Chip;
import com.google.android.material.snackbar.Snackbar;
import com.nammakelsa.R;
import com.nammakelsa.data.model.SkillType;
import com.nammakelsa.data.model.UiResult;
import com.nammakelsa.databinding.FragmentWorkerProfileEditBinding;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0%H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006&"}, d2 = {"Lcom/nammakelsa/ui/worker/WorkerProfileEditFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/nammakelsa/databinding/FragmentWorkerProfileEditBinding;", "binding", "getBinding", "()Lcom/nammakelsa/databinding/FragmentWorkerProfileEditBinding;", "galleryPhotoPicker", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "profilePhotoPicker", "viewModel", "Lcom/nammakelsa/ui/worker/WorkerProfileViewModel;", "getViewModel", "()Lcom/nammakelsa/ui/worker/WorkerProfileViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "skillTypeToChipId", "", "skill", "Lcom/nammakelsa/data/model/SkillType;", "updateGalleryGrid", "urls", "", "app_debug"})
public final class WorkerProfileEditFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.nammakelsa.databinding.FragmentWorkerProfileEditBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> profilePhotoPicker = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> galleryPhotoPicker = null;
    
    public WorkerProfileEditFragment() {
        super();
    }
    
    private final com.nammakelsa.databinding.FragmentWorkerProfileEditBinding getBinding() {
        return null;
    }
    
    private final com.nammakelsa.ui.worker.WorkerProfileViewModel getViewModel() {
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
    
    private final int skillTypeToChipId(com.nammakelsa.data.model.SkillType skill) {
        return 0;
    }
    
    private final void updateGalleryGrid(java.util.List<java.lang.String> urls) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}