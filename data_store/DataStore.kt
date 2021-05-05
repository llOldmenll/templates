package com.exercise.data.storage.data_store

import androidx.datastore.preferences.core.Preferences
import io.reactivex.Completable
import io.reactivex.Maybe

interface DataStore {
    /**
     * Save integer value to DataStore with key.
     *
     * @param key - key for values stored in Preferences
     * @param value - integer value associated with the key
     * @return Completable
     */
    fun writeInt(key: Preferences.Key<Int>, value: Int): Completable

    /**
     * Save long value to DataStore with key.
     *
     * @param key - key for values stored in Preferences
     * @param value - long value associated with the key
     * @return Completable
     */
    fun writeLong(key: Preferences.Key<Long>, value: Long): Completable

    /**
     * Save float value to DataStore with key.
     *
     * @param key - key for float values stored in Preferences
     * @param value - float value associated with the key
     * @return Completable
     */
    fun writeFloat(key: Preferences.Key<Float>, value: Float): Completable

    /**
     * Save string value to DataStore with key.
     *
     * @param key - key for string values stored in Preferences
     * @param value - string value associated with the key
     * @return Completable
     */
    fun writeString(key: Preferences.Key<String>, value: String): Completable

    /**
     * Save boolean value to DataStore with key.
     *
     * @param key - key for boolean values stored in Preferences
     * @param value - boolean value associated with the key
     * @return Completable
     */
    fun writeBoolean(key: Preferences.Key<Boolean>, value: Boolean): Completable

    /**
     * Save set of strings to DataStore with key.
     *
     * @param key - key for set of strings stored in Preferences
     * @param value - set of strings associated with the key
     * @return Completable
     */
    fun writeStringSet(key: Preferences.Key<Set<String>>, value: Set<String>): Completable

    /**
     * Get integer value from DataStore by key.
     *
     * @param key - key for string values stored in Preferences
     * @return Maybe<Int?>
     */
    fun readInt(key: Preferences.Key<Int>): Maybe<Int?>

    /**
     * Get long value from DataStore by key.
     *
     * @param key - key for long values stored in Preferences
     * @return Maybe<Long?>
     */
    fun readLong(key: Preferences.Key<Long>): Maybe<Long?>

    /**
     * Get float value from DataStore by key.
     *
     * @param key - key for float values stored in Preferences
     * @return Maybe<Float?>
     */
    fun readFloat(key: Preferences.Key<Float>): Maybe<Float?>

    /**
     * Get string value from DataStore by key.
     *
     * @param key - key for string values stored in Preferences
     * @return Maybe<String?>
     */
    fun readString(key: Preferences.Key<String>): Maybe<String?>

    /**
     * Get boolean value from DataStore by key.
     *
     * @param key - key for boolean values stored in Preferences
     * @return Maybe<Boolean?>
     */
    fun readBoolean(key: Preferences.Key<Boolean>): Maybe<Boolean?>
    
    /**
     * Get set of strings from DataStore by key.
     *
     * @param key - key for set of strings stored in Preferences
     * @return Maybe<Set<String>?>
     */
    fun readStringSet(key: Preferences.Key<Set<String>>): Maybe<Set<String>?>
}