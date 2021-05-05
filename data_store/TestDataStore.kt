package com.exercise.data.storage.data_store

import android.content.Context
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class TestDataStore(context: Context): DataStore by BaseDataStore(context)