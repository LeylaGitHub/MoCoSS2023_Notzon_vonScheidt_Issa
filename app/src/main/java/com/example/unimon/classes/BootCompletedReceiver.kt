package com.example.unimon.classes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class BootCompletedReceiver : BroadcastReceiver() {
  override fun onReceive(context: Context, intent: Intent) {
    if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
      // Erstelle eine WorkRequest für decreaseStats und plane sie mit dem WorkManager
      val workRequest = OneTimeWorkRequestBuilder<DecreaseStatsWorker>().build()
      WorkManager.getInstance(context).enqueue(workRequest)
    }
  }
}