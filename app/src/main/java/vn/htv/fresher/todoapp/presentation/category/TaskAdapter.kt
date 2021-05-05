package vn.htv.fresher.todoapp.presentation.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_item.*
import kotlinx.android.synthetic.main.task_item.view.*
import vn.htv.fresher.todoapp.R
import vn.htv.fresher.todoapp.databinding.TaskItemBinding
import vn.htv.fresher.todoapp.domain.model.TaskModel

class TaskAdapter(
    private val importantCallback: ((model: TaskModel) -> Unit),
    private val finishedCallback: ((model: TaskModel) -> Unit)
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val taskList = mutableListOf<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
//    return when(MainTaskItemType.from(viewType)) {
//     MainTaskItemType.NOT_FINISH-> TaskViewHolder(TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//     MainTaskItemType.FINISHED_STATE->SepViewHolder(ItemSepBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//    }
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task: TaskModel = taskList.get(position)
        holder.bind(task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setItems(items: List<TaskModel>) {
        taskList.clear()
        taskList.addAll(items)
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(itemView: TaskItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding: TaskItemBinding = itemView

        fun bind(model: TaskModel) {
            val string: String? = "<strike>${binding.root.textView}</strike>"
            binding.model = model
            binding.root.setImportant.setImageResource(
                if (model.important) R.drawable.ic_baseline_star_24 else R.drawable.ic_baseline_star_outline_24
            )
            binding.root.setImportant.setOnClickListener {
                importantCallback.invoke(model)
            }
            binding.root.setComplete.setImageResource(
                if (model.finished) R.drawable.ic_baseline_brightness_1_24 else R.drawable.ic_baseline_check_circle_24
            )
            binding.root.setComplete.setOnClickListener {
                finishedCallback.invoke(model)
                binding.textView.setText(android.text.Html.fromHtml(string))
            }
        }
    }
}
//   inner class SepViewHolder(itemView: ItemSepBinding) : RecyclerView.ViewHolder(itemView.root)
