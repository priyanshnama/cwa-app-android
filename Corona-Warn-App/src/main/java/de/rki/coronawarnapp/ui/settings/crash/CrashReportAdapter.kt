package de.rki.coronawarnapp.ui.settings.crash

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.rki.coronawarnapp.crash.CrashReportEntity
import de.rki.coronawarnapp.databinding.ViewCrashreportListItemBinding

class CrashReportAdapter(private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<CrashReportAdapter.CrashHolder>() {

    private var crashReports = listOf<CrashReportEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrashHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewCrashreportListItemBinding.inflate(inflater)
        return CrashHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: CrashHolder, position: Int) {
        val crashReport = crashReports[position]
        holder.bind(crashReport, position)
        holder.itemView.setOnClickListener { itemClickListener.crashReportClicked(crashReport) }
    }

    override fun getItemCount() = crashReports.size

    fun updateCrashReports(crashReportList: List<CrashReportEntity>) {
        crashReports = crashReportList
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun crashReportClicked(crashReport: CrashReportEntity)
    }

    class CrashHolder(private val binding: ViewCrashreportListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(crashReport: CrashReportEntity, pos: Int) {
            binding.crashReport = crashReport
            binding.pos = (pos + 1)
        }
    }
}