package com.example.unimon.ui

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class StatWorker(con: Context, workerParams: WorkerParameters) : Worker(con, workerParams) {
  override fun doWork(): Result {

    return Result.success()
  }
}