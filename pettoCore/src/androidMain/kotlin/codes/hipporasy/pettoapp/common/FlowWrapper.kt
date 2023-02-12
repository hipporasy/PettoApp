package codes.hipporasy.pettoapp.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

actual class FlowWrapper<T> actual constructor(private val suspender: suspend () -> T) {

    fun asFlow(): Flow<T> = flow {
        emit(suspender())
    }

    fun subscribe(
        scope: CoroutineScope,
        onSuccess: (item: T) -> Unit,
        onThrow: (error: Throwable) -> Unit
    ): Job = scope.launch {
        try {
            onSuccess(suspender())
        } catch (error: Throwable) {
            onThrow(error)
        }
    }
}
