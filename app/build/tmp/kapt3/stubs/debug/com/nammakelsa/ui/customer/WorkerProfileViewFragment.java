package com.nammakelsa.ui.customer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import coil.transform.CircleCropTransformation;
import com.google.android.material.snackbar.Snackbar;
import com.nammakelsa.R;
import com.nammakelsa.data.model.UiResult;
import com.nammakelsa.databinding.FragmentWorkerProfileViewBinding;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/nammakelsa/ui/customer/WorkerProfileViewFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/nammakelsa/databinding/FragmentWorkerProfileViewBinding;", "args", "Lcom/nammakelsa/ui/customer/WorkerProfileViewFragmentArgs;", "getArgs", "()Lcom/nammakelsa/ui/customer/WorkerProfileViewFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "binding", "getBinding", "()Lcom/nammakelsa/databinding/FragmentWorkerProfileViewBinding;", "currentPhoneNumber", "", "viewModel", "Lcom/nammakelsa/ui/customer/WorkerProfileViewViewModel;", "getViewModel", "()Lcom/nammakelsa/ui/customer/WorkerProfileViewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "app_debug"})
public final class WorkerProfileViewFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.nammakelsa.databinding.FragmentWorkerProfileViewBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentPhoneNumber = "";
    
    public WorkerProfileViewFragment() {
        super();
    }
    
    private final com.nammakelsa.databinding.FragmentWorkerProfileViewBinding getBinding() {
        return null;
    }
    
    private final com.nammakelsa.ui.customer.WorkerProfileViewViewModel getViewModel() {
        return null;
    }
    
    private final com.nammakelsa.ui.customer.WorkerProfileViewFragmentArgs getArgs() {
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
}