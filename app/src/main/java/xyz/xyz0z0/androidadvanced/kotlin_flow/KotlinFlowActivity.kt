package xyz.xyz0z0.androidadvanced.kotlin_flow

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xyz.xyz0z0.androidadvanced.R

class KotlinFlowActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_flow)


        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                test1()
            }
        }


    }

    private suspend fun test1() {
        flow<Int> {
            Log.d("cxg1", Thread.currentThread().name)
            emit(1)
        }
            .flowOn(Dispatchers.IO)
            .collect {
                Log.d("cxg2", Thread.currentThread().name)
                Log.d("cxg3", "" + it)
            }
    }
}