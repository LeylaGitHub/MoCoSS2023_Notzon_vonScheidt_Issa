package com.example.unimon.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "unimon")

val UNIMON_LEVEL_KEY = "level"
val UNIMON_LEVEL = intPreferencesKey(UNIMON_LEVEL_KEY)

fun getUnimonLevel(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_LEVEL] ?: 1
    }
}
