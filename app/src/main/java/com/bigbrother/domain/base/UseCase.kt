package com.bigbrother.domain.base

import com.bigbrother.Result
import kotlinx.coroutines.*

abstract class UseCase<Params, Response> {
    protected abstract suspend fun run(params: Params): Result<Response>

    operator fun invoke(
        scope: CoroutineScope = GlobalScope,
        params: Params,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Result<Response>) -> Unit = {}
    ) {
        val job = scope.async(dispatcher) { run(params) }
        scope.launch(Dispatchers.Main) { onResult(job.await()) }
    }
}