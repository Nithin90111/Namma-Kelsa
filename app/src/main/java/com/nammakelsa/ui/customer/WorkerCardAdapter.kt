package com.nammakelsa.ui.customer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nammakelsa.R
import com.nammakelsa.data.model.WorkerSearchResult
import com.nammakelsa.databinding.ItemWorkerCardBinding

/**
 * RecyclerView adapter for displaying worker search result cards.
 *
 * Each card shows the worker's profile photo, name, skill badge, daily rate,
 * and distance from the customer. Tapping a card invokes [onCardClick] with
 * the worker's UID.
 */
class WorkerCardAdapter(
    private val onCardClick: (workerId: String) -> Unit
) : ListAdapter<WorkerSearchResult, WorkerCardAdapter.WorkerCardViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerCardViewHolder {
        val binding = ItemWorkerCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WorkerCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkerCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WorkerCardViewHolder(
        private val binding: ItemWorkerCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(result: WorkerSearchResult) {
            binding.tvWorkerName.text = result.name

            // Skill badge
            binding.chipSkillBadge.text = result.skillType.name
                .lowercase()
                .replaceFirstChar { it.uppercase() }

            // Daily rate formatted as "₹500 / day"
            binding.tvDailyRate.text = binding.root.context.getString(
                R.string.label_daily_rate_display,
                result.dailyRateInr
            )

            // Distance formatted as "1.2 km away"
            binding.tvDistance.text = binding.root.context.getString(
                R.string.label_distance_display,
                result.distanceKm
            )

            // Profile photo via Coil; fall back to placeholder on error
            binding.ivProfilePhoto.load(result.profilePhotoUrl) {
                placeholder(R.drawable.ic_person_placeholder)
                error(R.drawable.ic_person_placeholder)
            }

            binding.root.setOnClickListener {
                onCardClick(result.uid)
            }
        }
    }

    private companion object DiffCallback : DiffUtil.ItemCallback<WorkerSearchResult>() {
        override fun areItemsTheSame(
            oldItem: WorkerSearchResult,
            newItem: WorkerSearchResult
        ): Boolean = oldItem.uid == newItem.uid

        override fun areContentsTheSame(
            oldItem: WorkerSearchResult,
            newItem: WorkerSearchResult
        ): Boolean = oldItem == newItem
    }
}
