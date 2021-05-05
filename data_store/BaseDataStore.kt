package com.exercise.data.storage.data_store

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class BaseDataStore(
    private val context: Context,
    private val dataStoreName: String = "default-data-store"
) : DataStore {
    private val dataStore by lazy { RxPreferenceDataStoreBuilder(context, dataStoreName).build() }

    override fun writeInt(key: Preferences.Key<Int>, value: Int) = write(key, value)
    override fun writeLong(key: Preferences.Key<Long>, value: Long) = write(key, value)
    override fun writeFloat(key: Preferences.Key<Float>, value: Float) = write(key, value)
    override fun writeString(key: Preferences.Key<String>, value: String) = write(key, value)
    override fun writeBoolean(key: Preferences.Key<Boolean>, value: Boolean) = write(key, value)
    override fun writeStringSet(key: Preferences.Key<Set<String>>, value: Set<String>) = write(key, value)

    override fun readInt(key: Preferences.Key<Int>) = read(key)
    override fun readLong(key: Preferences.Key<Long>) = read(key)
    override fun readFloat(key: Preferences.Key<Float>) = read(key)
    override fun readString(key: Preferences.Key<String>) = read(key)
    override fun readBoolean(key: Preferences.Key<Boolean>) = read(key)
    override fun readStringSet(key: Preferences.Key<Set<String>>) = read(key)

    /**
     * Write T-type value to preferences with a key.
     * T must be one of the following: Boolean, Int, Long, Float, String, Set<String>.
     *
     * Construct Keys for your data type using: [booleanPreferencesKey], [intPreferencesKey],
     * [longPreferencesKey], [floatPreferencesKey], [stringPreferencesKey], [stringSetPreferencesKey]
     *
     * @param key - preferences key with supportable value type
     * @return Completable
     */
    private fun <T> write(key: Preferences.Key<T>, value: T): Completable =
        dataStore.updateDataAsync {
            Single.just(it.toMutablePreferences().apply { set(key, value) })
        }.ignoreElement()

    /**
     * Read required T-type value from preferences by a key.
     * T must be one of the following: Boolean, Int, Long, Float, String, Set<String>.
     *
     * Construct Keys for your data type using: [booleanPreferencesKey], [intPreferencesKey],
     * [longPreferencesKey], [floatPreferencesKey], [stringPreferencesKey], [stringSetPreferencesKey]
     *
     * @param key - preferences key with supportable value type
     * @return Maybe<T?>
     */
    private fun <T> read(key: Preferences.Key<T>): Maybe<T?> =
        dataStore.data().map { it[key] }.firstElement()
}