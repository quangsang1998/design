package vn.htv.fresher.todoapp.presentation.category

import android.annotation.SuppressLint
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.threeten.bp.LocalDateTime
import vn.htv.fresher.todoapp.R
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.presentation.common.BaseActivity

class CategoryActivity : BaseActivity() {
  private val viewModel by viewModel<CategoryViewModel>()

  override val fragment  : Fragment
    get() = CategoryFragment.newInstance()

  override val layoutId  : Int
    get() = R.layout.activity_category

  override fun init() {
    super.init()

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
          name       = title.toString(),
          id         = viewModel.categoryId?.toInt(),
          createdAt  = LocalDateTime.now()
        )
        viewModel.updateName(model)
        supportActionBar?.title = model.name
        }
        positiveButton(R.string.button_save)
        negativeButton(R.string.button_delete)
    }
  }

  fun deleteName() {
    MaterialDialog(this).show {
      title(R.string.title_delete_category)
      positiveButton(
        res    = R.string.button_delete_category,
        click  = {
          val model = CategoryModel(
            name       = supportActionBar?.title.toString(),
            id         = viewModel.categoryId?.toInt(),
            createdAt  = LocalDateTime.now()
          )
          viewModel.deleteCategory(model)
        }
      )
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
