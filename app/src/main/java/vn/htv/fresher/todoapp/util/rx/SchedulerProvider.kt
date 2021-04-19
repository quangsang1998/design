package vn.htv.fresher.todoapp.util.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
  fun ui(): Scheduler

  fun computation(): Scheduler

  fun newThread(): Scheduler

  fun io(): Scheduler
}