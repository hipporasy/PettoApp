package codes.hipporasy.pettoapp.data.model

import codes.hipporasy.pettoapp.common.Parcelable
import codes.hipporasy.pettoapp.common.Parcelize

interface Breed : Parcelable {
    val detail: String
}

@Parcelize
data class Pet(
    val id: String = "",
    val name: String,
    val age: Int,
    val type: PetType,
    val gender: Gender,
    val images: List<String>,
    val breed: Breed,
    val weight: Double
): Parcelable {


    val description: String
        get() = "The $name is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet."

    @Parcelize
    enum class PetType: Parcelable {
        DOGS, CATS
    }
    @Parcelize
    enum class Gender: Parcelable {
        MALE, FEMALE
    }

    val isAdult: Boolean
        get() {
            return age > 8
        }

    val displayType: String
        get() {
            if (isAdult) {
                return "Adult"
            }
            return when (type) {
                PetType.DOGS -> "Puppy"
                PetType.CATS -> "Kitten"
            }

        }

    companion object {
        val dogs = listOf(
            Pet(
                name = "Bruno",
                age = 7,
                type = PetType.DOGS,
                gender = Gender.MALE,
                images = listOf("golden", "golden.1", "golden.2"),
                breed = DogBreed.GOLDEN,
                weight = 2.0
            ),
            Pet(
                name = "Maya", age = 16, type = PetType.DOGS, gender = Gender.FEMALE,
                images = listOf("maya", "maya.1", "maya.2"),
                breed = DogBreed.SAMOYED,
                weight = 2.0
            ),
            Pet(
                name = "Indra",
                age = 14,
                type = PetType.DOGS,
                gender = Gender.FEMALE,
                images = listOf("shiba", "shiba.1", "shiba.2"),
                breed = DogBreed.SHIBA,
                weight = 4.0
            ),
            Pet(
                name = "Mao",
                age = 22,
                type = PetType.DOGS,
                gender = Gender.MALE,
                images = listOf("husky", "husky.1", "husky.2"),
                breed = DogBreed.HUSKY,
                weight = 5.0
            ),
            Pet(
                name = "Nora",
                age = 7,
                type = PetType.DOGS,
                gender = Gender.MALE,
                images = listOf("corgi.cover"),
                breed = DogBreed.CORGI,
                weight = 1.5
            ),
            Pet(
                name = "Dora",
                age = 3,
                type = PetType.DOGS,
                gender = Gender.FEMALE,
                images = listOf("malamute", "malamute.1"),
                breed = DogBreed.MALAMUTE,
                weight = 0.8
            ),
        )

        val cats = listOf(
            Pet(
                name = "Tou",
                age = 3,
                type = PetType.CATS,
                gender = Gender.MALE,
                images = listOf("ragdoll"),
                breed = CatBreed.RAG_DOLL,
                weight = 0.5
            ),
            Pet(
                name = "Toy",
                age = 12,
                type = PetType.CATS,
                gender = Gender.FEMALE,
                images = listOf("birman", "birman.1"),
                breed = CatBreed.BIRMAN,
                weight = 3.0
            ),
            Pet(
                name = "Reach",
                age = 24,
                type = PetType.CATS,
                gender = Gender.MALE,
                images = listOf("bth"),
                breed = CatBreed.BRITISH_SHORT_HAIR,
                weight = 3.0
            ),
            Pet(
                name = "Haru",
                age = 7,
                type = PetType.CATS,
                gender = Gender.FEMALE,
                images = listOf("scottish-fold"),
                breed = CatBreed.SCOTTISH_FOLD,
                weight = 1.2
            ),
            Pet(
                name = "Pok",
                age = 18,
                type = PetType.CATS,
                gender = Gender.FEMALE,
                images = listOf("sc"),
                breed = CatBreed.SIAMESE_CAT,
                weight = 3.0
            ),
            Pet(
                name = "King",
                age = 22,
                type = PetType.CATS,
                gender = Gender.MALE,
                images = listOf("pc"),
                breed = CatBreed.PERSIAN_CAT,
                weight = 3.0
            )
        )

    }


}

@Parcelize
enum class CatBreed(private val value: String) : Breed {

    BRITISH_SHORT_HAIR("British Short Hair"),
    RAG_DOLL("Rag Doll"),
    BIRMAN("Birman"),
    SIAMESE_CAT("Siamese Cat"),
    SCOTTISH_FOLD("Scottish Fold"),
    PERSIAN_CAT("Persian Cat");

    override val detail: String
        get() {
            return value
        }

}
@Parcelize
enum class DogBreed(private val value: String) : Breed {

    GOLDEN("Golden Retriever"),
    HUSKY("Siberian Husky"),
    SAMOYED("Samoyed"),
    SHIBA("Shiba Inu"),
    CORGI("Corgi"),
    MALAMUTE("Malamute");


    override val detail: String
        get() {
            return value
        }

}
