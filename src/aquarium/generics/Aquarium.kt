package aquarium.generics

fun main(args: Array<String>) {
    genericExample()
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater: WaterSupply(true) {

    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

class Aquarium<out T: WaterSupply>(val waterSupply: T) {

    fun addWater(cleaner: Cleaner<T>) {
        //check(!waterSupply.needsProcessed) {"water supply needs processed"}
        if(waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }

        println("adding water from $waterSupply")
    }
}

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R


fun addItemTo(aquarium: Aquarium<WaterSupply>) {
    aquarium.waterSupply
    println("item added")
}


// 'in' types can only be passed into an object ...
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {

    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }

}

// Generic function example ...
fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessed}")
}

fun genericExample() {
    //TODO - Part 1
    /*val aquarium0 = Aquarium<TapWater>(TapWater())
    aquarium0.waterSupply.addChemicalCleaners()*/

    // When using only <T>, we can do the below two without any errors ...
    // val aquarium2: Aquarium<String> = Aquarium("string")

    // val aquarium3 = Aquarium(null)

    //TODO - Part 2
    /*val aquarium4 = Aquarium(LakeWater())

    // Commenting the below line would throw an IllegalStateException with message "water supply needs processed"
    aquarium4.waterSupply.filter()

    aquarium4.addWater()*/


    // 'out' types can only be passed out of the object or returned ...
    //TODO - Generic In and Out ...
    val cleaner = TapWaterCleaner()
    val aquarium: Aquarium<TapWater> = Aquarium(TapWater())
    val aquarium1 = Aquarium(LakeWater())
    addItemTo(aquarium)
    addItemTo(aquarium1)

    aquarium.addWater(cleaner)

    // TODO - Generic functions ...
    isWaterClean(aquarium)

    println(aquarium.hasWaterSupplyOfType<TapWater>()) // true
    aquarium.waterSupply.isOfType<LakeWater>() // false
}