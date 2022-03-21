package bit.max.portfolio.app

import android.app.Application
import bit.max.portfolio.di.AppComponent
import bit.max.portfolio.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .build()
    }
}