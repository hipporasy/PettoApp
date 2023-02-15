package codes.hipporasy.pettoapp.domain.usecase.base

import codes.hipporasy.pettoapp.common.Resource


abstract class AbstractUseCase {
    protected suspend fun <T> executeAsync(executor: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(executor())
        } catch (exception: Exception) {
            Resource.Error(exception)
        }
    }
}
