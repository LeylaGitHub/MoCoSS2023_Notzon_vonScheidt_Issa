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

val UNIMON_BODY_KEY = "body"
val UNIMON_BODY = intPreferencesKey(UNIMON_BODY_KEY)

fun getUnimonBody(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_BODY] ?: 100
    }
}

val UNIMON_MIND_KEY = "mind"
val UNIMON_MIND = intPreferencesKey(UNIMON_MIND_KEY)

fun getUnimonMind(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_MIND] ?: 100
    }
}

val UNIMON_SOCIAL_KEY = "social"
val UNIMON_SOCIAL = intPreferencesKey(UNIMON_SOCIAL_KEY)

fun getUnimonSocial(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_SOCIAL] ?: 100
    }
}

val UNIMON_SLEEP_KEY = "sleep"
val UNIMON_SLEEP= intPreferencesKey(UNIMON_SLEEP_KEY)

fun getUnimonSleep(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_SLEEP] ?: 100
    }
}



