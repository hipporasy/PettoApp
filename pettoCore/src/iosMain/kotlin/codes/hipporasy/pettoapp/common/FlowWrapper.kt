package codes.hipporasy.pettoapp.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


actual class FlowWrapper<T> actual constructor(private val suspender: suspend () -> T) {

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

class NullableSuspendWrapper<T>(
    private val suspender: suspend () -> T
) {

    fun subscribe(
        scope: CoroutineScope,
        onSuccess: (item: T) -> Unit,
        onThrow: (error: Throwable) -> Unit
    ) = scope.launch {
        try {
            onSuccess(suspender())
        } catch (error: Throwable) {
            onThrow(error)
        }
    }
}

class NullableFlowWrapper<T>(
    private val scope: CoroutineScope,
    private val flow: Flow<T>
) {

    fun subscribe(
        scope: CoroutineScope,
        onEach: (item: T) -> Unit,
        onComplete: () -> Unit,
        onThrow: (error: Throwable) -> Unit
    ) = flow
        .onEach { onEach(it) }
        .catch { onThrow(it) }
        .onCompletion { onComplete() }
        .launchIn(scope)
}
