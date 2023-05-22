package com.example.unimon

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PreferenceDatastore(context: Context) {
  val Context.dataStore: DataStore<Preferences> by preferencesDataStore("USER_NAME")
  var pref = context.dataStore

  companion object {
    var name = stringPreferencesKey("USER_NAME")
    var level = intPreferencesKey("USER_LEVEL")
    var body = intPreferencesKey("USER_BODY")
    var mind = intPreferencesKey("USER_MIND")
    var social = intPreferencesKey("USER_SOCIAL")
    var sleep = intPreferencesKey("USER_SLEEP")
  }

  suspend fun setStats(stats: Stats) {
      pref.edit {
        it[name] = stats.name
        it[level] = stats.level
        it[body] = stats.body
        it[mind] = stats.mind
        it[social] = stats.social
        it[sleep] = stats.sleep
      }
  }

  fun getStats() = pref.data.map {
    Stats(
      name = it[name] ?: "",
      level = it[level] ?: 0,
      body =it[body] ?: 0,
      mind = it[mind] ?: 0,
      social = it[social] ?: 0,
      sleep = it[sleep] ?: 0
    )
  }


}