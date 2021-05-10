package vn.htv.fresher.todoapp.presentation.category

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.task_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.threeten.bp.LocalDateTime
import vn.htv.fresher.todoapp.R
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.presentation.common.BaseActivity

class CategoryActivity : BaseActivity() {

    private val viewModel by viewModel<CategoryViewModel>()

    override val fragment: Fragment
        get() = CategoryFragment.newInstance()

    override val layoutId: Int
        get() = R.layout.activity_category

    override fun init() {
        super.init()

        // Lay catId tu intent o day
        val catId = intent.getLongExtra("category", 0)
        viewModel.categoryId = catId
    }

    override fun initUi() {
        super.initUi()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            R.id.updateName -> {
                onNewName()
            }
            R.id.sortedItem -> {

            }
            R.id.delete -> {
                deleteName()
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun onNewName() {
        MaterialDialog(this).show {
            title(R.string.new_name_category)
            input(
                prefill = supportActionBar?.title.toString()
            ) { _, title ->
                val model = CategoryModel(
                    name = title.toString(),
                    id = viewModel.categoryId?.toInt(),
                    createdAt = LocalDateTime.now()
                )
                viewModel.updateName(model)
                supportActionBar?.title = model.name
            }
            positiveButton(R.string.button_save)
            negativeButton(R.string.button_delete)
        }
    }
//    private val itemTouchHelper by lazy {
//        val UP = 0
//        val DOWN = 1
//        val START = 2
//        val END = 3
//        val simpleItemTouchCallback =
//            object : ItemTouchHelper.SimpleCallback(UP or
//                DOWN or
//                START or
//                END, 0) {
//                override fun onMove(recyclerView: RecyclerView,
//                                    viewHolder: RecyclerView.ViewHolder,
//                                    target: RecyclerView.ViewHolder): Boolean {
//
//                    val adapter = recyclerView.adapter as TaskAdapter
//                    val from = viewHolder.adapterPosition
//                    val to = target.adapterPosition
//                    adapter.moveItem(from, to)
//                    adapter.notifyItemMoved(from, to)
//                    return  true
//            }
//                override fun onSwiped(viewHolder: RecyclerView.ViewHolder,
//                                      direction: Int) {
//                }
//            }
//        ItemTouchHelper(simpleItemTouchCallback)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        itemTouchHelper.attachToRecyclerView(recycleView1)
//    }

    fun deleteName() {
        MaterialDialog(this).show {
            title(R.string.title_delete_category)
            positiveButton(res = R.string.button_delete_category, click = {
                val model = CategoryModel(
                    name = supportActionBar?.title.toString(),
                    id = viewModel.categoryId?.toInt(),
                    createdAt = LocalDateTime.now()
                )
                viewModel.deleteCategory(model)
            })
            negativeButton(R.string.button_cancel)
        }
    }

    companion object {

        fun start(activity: AppCompatActivity, catId: Long) {
            val intent = Intent(activity, CategoryActivity::class.java)
            intent.putExtra("category", catId)
            activity.startActivity(intent)
        }
    }
}
