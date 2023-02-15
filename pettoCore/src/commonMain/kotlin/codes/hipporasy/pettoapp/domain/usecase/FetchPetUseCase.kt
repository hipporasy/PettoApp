package codes.hipporasy.pettoapp.domain.usecase

import codes.hipporasy.pettoapp.common.Resource
import codes.hipporasy.pettoapp.data.model.Pet
import codes.hipporasy.pettoapp.domain.usecase.base.BaseUseCase

class FetchPetUseCase : BaseUseCase<List<Pet>, Pet.PetType>() {
    override suspend fun execute(params: Pet.PetType): Resource<List<Pet>> {
        return executeAsync {
            when (params) {
                Pet.PetType.CATS -> Pet.cats
                Pet.PetType.DOGS -> Pet.dogs
            }
        }
    }
}

