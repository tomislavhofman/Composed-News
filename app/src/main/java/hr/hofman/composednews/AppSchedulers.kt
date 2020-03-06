package hr.hofman.composednews

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

object AppSchedulers {
    val database: Scheduler = Schedulers.single()
    val network: Scheduler = Schedulers.io()
}