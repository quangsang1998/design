package vn.htv.fresher.todoapp.presentation.category

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.threeten.bp.LocalDateTime
import vn.htv.fresher.todoapp.R
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.presentation.common.BaseActivity
import vn.htv.fresher.todoapp.presentation.main.MainViewModel

class CategoryActivity : BaseActivity() {

    private lateinit var viewModel: CategoryViewModel
    private lateinit var viewModel1: MainViewModel
//  private val actionbar = getSupportActionBar()

    override val fragment: Fragment
        get() = CategoryFragment.newInstance()

    override val layoutId: Int
        get() = R.layout.activity_category

    override fun init() {
        super.init()

        // Lay catId tu intent o day
        val i = getIntent()
        val catId = i.getLongExtra("category", 0)
        val model = CategoryModel(
            name =
            id = catId.toInt(),
            createdAt = LocalDateTime.now()
        )
        supportActionBar?.title = model.name
    }

    override fun initUi() {
        super.initUi()
        lateinit var model: CategoryModel
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        fun start(activity: AppCompatActivity, catId: Long) {
            val intent = Intent(activity, CategoryActivity::class.java)
            intent.putExtra("category", catId)
            activity.startActivity(intent)
        }
    }
}
