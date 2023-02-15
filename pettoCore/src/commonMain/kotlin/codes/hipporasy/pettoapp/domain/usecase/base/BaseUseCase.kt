package codes.hipporasy.pettoapp.domain.usecase.base

import codes.hipporasy.pettoapp.common.Resource

expect abstract class BaseUseCase<Type : Any, in Params : Any>() : AbstractUseCase {

    protected abstract suspend fun execute(params: Params): Resource<Type>
}
