package codes.hipporasy.pettoapp.domain.usecase

import codes.hipporasy.pettoapp.common.Resource
import codes.hipporasy.pettoapp.data.model.Pet
import codes.hipporasy.pettoapp.domain.usecase.base.BaseUseCase

class FetchPetTypeUseCase : BaseUseCase<List<Pet.PetType>, Unit>() {
    override suspend fun execute(params: Unit): Resource<List<Pet.PetType>> {
        return executeAsync { Pet.PetType.values().map { it } }
    }
}

