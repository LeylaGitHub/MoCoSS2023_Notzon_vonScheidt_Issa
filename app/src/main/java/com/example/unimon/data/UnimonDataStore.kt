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

//____________________________________________________________________________
// Name

val UNIMON_NAME_KEY = "name"
val UNIMON_NAME = stringPreferencesKey(UNIMON_NAME_KEY)

fun getUnimonName(context: Context): Flow<String> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_NAME] ?: "Koko"
    }
}

//____________________________________________________________________________
// Level

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

//____________________________________________________________________________
// Body

val UNIMON_BODY_KEY = "body"
val UNIMON_BODY = intPreferencesKey(UNIMON_BODY_KEY)

fun getUnimonBody(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_BODY] ?: 100
    }
}

suspend fun updateBody(value: Int, context: Context) {
    context.dataStore.edit { unimonData ->
        val currentCount = unimonData[UNIMON_BODY] ?: 100
        if (currentCount + value >= 100) unimonData[UNIMON_BODY] = 100
        else if (currentCount > 0) unimonData[UNIMON_BODY] = currentCount + value
        else unimonData[UNIMON_BODY] = 0
    }
}

//____________________________________________________________________________
// Mind

val UNIMON_MIND_KEY = "mind"
val UNIMON_MIND = intPreferencesKey(UNIMON_MIND_KEY)

fun getUnimonMind(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_MIND] ?: 100
    }
}

suspend fun updateMind(value: Int, context: Context) {
    context.dataStore.edit { unimonData ->
        val currentCount = unimonData[UNIMON_MIND] ?: 100
        if (currentCount + value >= 100) unimonData[UNIMON_MIND] = 100
        else if (currentCount > 0) unimonData[UNIMON_MIND] = currentCount + value
        else unimonData[UNIMON_MIND] = 0
    }
}

//____________________________________________________________________________
// Social

val UNIMON_SOCIAL_KEY = "social"
val UNIMON_SOCIAL = intPreferencesKey(UNIMON_SOCIAL_KEY)

fun getUnimonSocial(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_SOCIAL] ?: 100
    }
}

suspend fun updateSocial(value: Int, context: Context) {
    context.dataStore.edit { unimonData ->
        val currentCount = unimonData[UNIMON_SOCIAL] ?: 100
        if (currentCount + value >= 100) unimonData[UNIMON_SOCIAL] = 100
        else if (currentCount > 0) unimonData[UNIMON_SOCIAL] = currentCount + value
        else unimonData[UNIMON_SOCIAL] = 0
    }
}


//____________________________________________________________________________
// Sleep

val UNIMON_SLEEP_KEY = "sleep"
val UNIMON_SLEEP = intPreferencesKey(UNIMON_SLEEP_KEY)

fun getUnimonSleep(context: Context): Flow<Int> {
    return context.dataStore.data.map { unimonData ->
        unimonData[UNIMON_SLEEP] ?: 100
    }
}

suspend fun updateSleep(value: Int, context: Context) {
    context.dataStore.edit { unimonData ->
        val currentCount = unimonData[UNIMON_SLEEP] ?: 100
        if (currentCount + value >= 100) unimonData[UNIMON_SLEEP] = 100
        else if (currentCount > 0) unimonData[UNIMON_SLEEP] = currentCount + value
        else unimonData[UNIMON_SLEEP] = 0
    }
}



