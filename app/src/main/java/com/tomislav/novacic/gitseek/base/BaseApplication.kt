package com.tomislav.novacic.gitseek.base

import android.app.Activity
import android.app.Application
import com.tomislav.novacic.gitseek.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}