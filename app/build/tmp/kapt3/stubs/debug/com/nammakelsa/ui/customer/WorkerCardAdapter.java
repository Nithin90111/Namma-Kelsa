package com.nammakelsa.ui.customer;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.nammakelsa.R;
import com.nammakelsa.data.model.WorkerSearchResult;
import com.nammakelsa.databinding.ItemWorkerCardBinding;

/**
 * RecyclerView adapter for displaying worker search result cards.
 *
 * Each card shows the worker's profile photo, name, skill badge, daily rate,
 * and distance from the customer. Tapping a card invokes [onCardClick] with
 * the worker's UID.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0014\u0015B(\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\n2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/nammakelsa/ui/customer/WorkerCardAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/nammakelsa/data/model/WorkerSearchResult;", "Lcom/nammakelsa/ui/customer/WorkerCardAdapter$WorkerCardViewHolder;", "onCardClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "workerId", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "WorkerCardViewHolder", "app_debug"})
public final class WorkerCardAdapter extends androidx.recyclerview.widget.ListAdapter<com.nammakelsa.data.model.WorkerSearchResult, com.nammakelsa.ui.customer.WorkerCardAdapter.WorkerCardViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onCardClick = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.nammakelsa.ui.customer.WorkerCardAdapter.DiffCallback DiffCallback = null;
    
    public WorkerCardAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCardClick) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.nammakelsa.ui.customer.WorkerCardAdapter.WorkerCardViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.ui.customer.WorkerCardAdapter.WorkerCardViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/nammakelsa/ui/customer/WorkerCardAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/nammakelsa/data/model/WorkerSearchResult;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.nammakelsa.data.model.WorkerSearchResult> {
        
        private DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.nammakelsa.data.model.WorkerSearchResult oldItem, @org.jetbrains.annotations.NotNull()
        com.nammakelsa.data.model.WorkerSearchResult newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.nammakelsa.data.model.WorkerSearchResult oldItem, @org.jetbrains.annotations.NotNull()
        com.nammakelsa.data.model.WorkerSearchResult newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/nammakelsa/ui/customer/WorkerCardAdapter$WorkerCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/nammakelsa/databinding/ItemWorkerCardBinding;", "(Lcom/nammakelsa/ui/customer/WorkerCardAdapter;Lcom/nammakelsa/databinding/ItemWorkerCardBinding;)V", "bind", "", "result", "Lcom/nammakelsa/data/model/WorkerSearchResult;", "app_debug"})
    public final class WorkerCardViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.nammakelsa.databinding.ItemWorkerCardBinding binding = null;
        
        public WorkerCardViewHolder(@org.jetbrains.annotations.NotNull()
        com.nammakelsa.databinding.ItemWorkerCardBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.nammakelsa.data.model.WorkerSearchResult result) {
        }
    }
}