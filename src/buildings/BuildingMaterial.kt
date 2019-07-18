package buildings

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)

class Brick: BaseBuildingMaterial(8)

class Building<T: BaseBuildingMaterial>(val buildingMaterial: T) {

    private val baseMaterialsNeeded: Int
    val actualMaterialNeeded: Int


    init {
        baseMaterialsNeeded = 100
        actualMaterialNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded
    }

    fun build() {
        println(" ${actualMaterialNeeded} ${buildingMaterial::class.simpleName} needed")
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if(building.actualMaterialNeeded < 500) {
        println("Small building")
    } else {
        println("Large building")
    }
}

fun main(args: Array<String>) {
    val b = Building(Wood())

    b.build()

    isSmallBuilding(b)
}