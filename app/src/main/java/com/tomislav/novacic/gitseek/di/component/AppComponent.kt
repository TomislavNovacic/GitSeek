package com.tomislav.novacic.gitseek.di.component

import com.tomislav.novacic.gitseek.base.BaseApplication
import com.tomislav.novacic.gitseek.di.module.ActivityModule
import com.tomislav.novacic.gitseek.di.module.ApplicationModule
import com.tomislav.novacic.gitseek.di.module.ViewModelModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class, ActivityModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {
    fun inject(app: BaseApplication)
}