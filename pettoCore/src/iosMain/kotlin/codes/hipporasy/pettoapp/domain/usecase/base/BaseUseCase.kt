package codes.hipporasy.pettoapp.domain.usecase.base

import codes.hipporasy.pettoapp.common.FlowWrapper
import codes.hipporasy.pettoapp.common.Resource

actual abstract class BaseUseCase<Type : Any, in Params : Any> : AbstractUseCase() {

    protected actual abstract suspend fun execute(params: Params): Resource<Type>

    suspend fun invokeAsync(params: Params) = execute(params)

    fun invoke(params: Params): FlowWrapper<Resource<Type>> {
        return FlowWrapper { execute(params = params) }
    }
}