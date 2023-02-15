package codes.hipporasy.pettoapp.common

sealed class Resource<out T> {
    data class Success<out T>(val result: T) : Resource<T>()
    data class Error(val error: Throwable) : Resource<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$result]"
            is Error -> "Error[exception=$error]"
        }
    }

    inline fun <R : Any> map(transform: (T) -> R): Resource<R> {
        return when (this) {
            is Error -> Error(this.error)
            is Success -> Success(transform(this.result))
        }
    }

    suspend inline fun <R : Any> suspendMap(crossinline transform: suspend (T) -> R): Resource<R> {
        return when (this) {
            is Error -> Error(this.error)
            is Success -> Success(transform(this.result))
        }
    }

    fun fold(onSuccess: (T) -> Unit, onFailure: (Throwable) -> Unit) {
        when (this) {
            is Error -> onFailure(this.error)
            is Success -> onSuccess(this.result)
        }
    }
}
