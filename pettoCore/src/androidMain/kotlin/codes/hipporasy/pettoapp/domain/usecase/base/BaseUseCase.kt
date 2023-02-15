package codes.hipporasy.pettoapp.domain.usecase.base

import codes.hipporasy.pettoapp.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

actual abstract class BaseUseCase<Type : Any, in Params : Any> : AbstractUseCase() {

    protected actual abstract suspend fun execute(params: Params): Resource<Type>

    suspend operator fun invoke(params: Params): Resource<Type> {
        return execute(params)
    }

    suspend fun invokeFlow(params: Params): Flow<Resource<Type>> {
        return flow {
            emit(execute(params))
        }
    }
}