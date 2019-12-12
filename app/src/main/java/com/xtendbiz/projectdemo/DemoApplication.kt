package com.xtendbiz.projectdemo

import android.app.Application
import com.xtendbiz.projectdemo.repository.IProductRepo
import com.xtendbiz.projectdemo.repository.IProductRepoImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class DemoApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@DemoApplication))

        bind<IProductRepo>() with singleton { IProductRepoImpl() }

        bind() from provider {
            ViewModelFactory(instance())
        }

    }

    override fun onCreate() {
        super.onCreate()

    }

}