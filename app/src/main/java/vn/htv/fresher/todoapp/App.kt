package vn.htv.fresher.todoapp

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import vn.htv.fresher.todoapp.di.appModule
import vn.htv.fresher.todoapp.di.dbModule

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    initTimber()

    AndroidThreeTen.init(this)

    startKoin {
      printLogger()
      androidContext(this@App)
      modules(
        listOf(
          dbModule,
          appModule
        )
      )
    }

  }

  private fun initTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}