package com.example.unimon.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "unimon")

val UNIMON_NAME_KEY = "name"
val UNIMON_NAME = stringPreferencesKey(UNIMON_NAME_KEY)

fun getUnimonName(context: Context): Flow<String> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_NAME] ?: "Koko"
    }
}

//suspend fun updateName(context: Context) {
//    context.dataStore.edit { unimonData ->
//        val currentName = unimonData[UNIMON_NAME] ?: "Koko"
//        unimonData[UNIMON_NAME] = currentCount + 1
//    }
//}

val UNIMON_LEVEL_KEY = "level"
val UNIMON_LEVEL = intPreferencesKey(UNIMON_LEVEL_KEY)

fun getUnimonLevel(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_LEVEL] ?: 1
    }
}

suspend fun levelUp(context: Context) {
    context.dataStore.edit { unimonData ->
        val currentCount = unimonData[UNIMON_LEVEL] ?: 1
        unimonData[UNIMON_LEVEL] = currentCount + 1
    }
}

val UNIMON_BODY_KEY = "level"
val UNIMON_BODY = intPreferencesKey(UNIMON_BODY_KEY)

val UNIMON_MIND_KEY = "level"
val UNIMON_MIND = intPreferencesKey(UNIMON_MIND_KEY)

val UNIMON_SOCIAL_KEY = "level"
val UNIMON_SOCIAL = intPreferencesKey(UNIMON_SOCIAL_KEY)

val UNIMON_SLEEP_KEY = "level"
val UNIMON_SLEEP= intPreferencesKey(UNIMON_SLEEP_KEY)



