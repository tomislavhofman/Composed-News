package hr.hofman.composednews

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

object AppSchedulers {
    val database: Scheduler = Schedulers.single()
    val network: Scheduler = Schedulers.io()
}