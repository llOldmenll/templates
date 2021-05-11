#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}#end

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.AsyncListDiffer
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater

#parse("File Header.java")
class ${NAME}(
private val listener: Listener? = null
) : RecyclerView.Adapter<${NAME}.${ViewHolder_name}>(){

    private val differ = AsyncListDiffer(this, DiffCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ${ViewHolder_name} {
        return ${ViewHolder_name}(LayoutInflater.from(parent.context)
        .inflate(R.layout.${Item_layout_id}, parent, false))
    }

    override fun onBindViewHolder(holder: ${ViewHolder_name}, position: Int) =
    holder.bindView(differ.currentList[position])

    override fun onBindViewHolder(
        holder: AvailableFlightsVH,
        position: Int,
        payloads: MutableList<Any>
    ) {
        TODO("Implement or remove")
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submit(list: List<${Data_class}>) = differ.submitList(list)

    inner class ${ViewHolder_name}(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(data: ${Data_class}): Unit = with(itemView) {
        TODO("Bind view")
    }
    }

    class DiffCallback : DiffUtil.ItemCallback<${Data_class}>() {
        override fun areItemsTheSame(oldItem: ${Data_class}, newItem: ${Data_class}): Boolean {
        TODO("Not yet implemented")
    }

        override fun areContentsTheSame(oldItem: ${Data_class}, newItem: ${Data_class}): Boolean {
        TODO("Not yet implemented")
    }

        override fun getChangePayload(oldItem: ${Data_class}, newItem: ${Data_class}): Any? {
        TODO("Implement or remove")
    }
    }

    // TODO: Implement item actions
    interface Listener
}