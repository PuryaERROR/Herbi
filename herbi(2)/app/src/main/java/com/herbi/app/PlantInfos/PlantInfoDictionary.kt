package com.herbi.app.PlantInfos

data class PlantInfo(
    val herbName: String,
    val scientificName: String,
    val description: String,
    val medicinalUses: String
)

object PlantInfoDictionary {

    val alugbatiInfo = PlantInfo(
        "Alugbati",
        "Basella Alba L.",
        "An edible perennial vine in the family Basellaceae. A frost-tender perennial grown as an annual, native to tropical regions in Asia. The plant typically grows to a six-foot vine, but can often reach 30 feet in length. The succulent leaves and stems are used as a vegetable, either raw in salads or cooked in soups, salads, stir-fry or as a pot herb for stews.",
        "The roots are astringent to reduce local swellings. They are cooked and used in the treatment of diarrhea. The leaves and stems are cooked for ulcers and eaten for their mild laxative properties for pregnant women. A red dye is obtained from the juice of the fruits of the 'Rubra' cultivar."
    )

     val ampalayaInfo = PlantInfo(
        "Ampalaya",
        "Mommordica Charantia",
        "A climbing vine with a bitter taste attributed to the presence of momordicin, making it one of the most bitter vegetables. The plant grows up to 5m and features heart-shaped leaves with 5-10 cm diameter, cut into 5-7 lobes. Ampalaya has separate yellow male and female flowers, and its fleshy green fruit is oblong with pointed ends, ribbed, and wrinkled. When mature, the fruit bursts open to release seeds, which are flat with ruminated margins.",
        "Bitter gourd, or ampalaya, has a rich history of traditional medicinal use with recognized health benefits, particularly in addressing conditions such as diabetes through its ability to lower blood sugar levels. Additionally, its juice is employed as an analgesic for fever, headaches, and body pains, while ampalaya is also valued for its potential in promoting weight loss by enhancing metabolism and fat burning."
    )

    val bayabasInfo = PlantInfo(
        "Bayabas",
        "Psidium Guajava",
        "Guava leaves are oblong to oval in shape and average 7-15 centimeters long and 3-5 centimeters wide. The leaves have short petioles, or stalks that join the leaf to the stem. The surface of the deep green Guava leaf is wide and leathery with faint white veins and some light brown patches.",
        "Guava leaves have anti-inflammatory action and antibacterial ability that fights infections and kills germs. People consuming guava leaves at home will help curb toothaches. Its leaf’s extract is being used as a medicine in cough, diarrhea, and oral ulcers and in some swollen gums wound."
    )

    val malunggayInfo = PlantInfo(
        "Malunggay",
        "Moringa oleifera",
        "Leaves are alternate, usually thrice pinnate, 25 to 50 centimeters long. Each compound leaf contains 3-9 very thin leaflets dispersed on a compound (3 times pinnate) stalk.",
        "Decoction of leaves is used for sores and ulcers. Fresh stem and leaves are pounded and applied as a poultice to sprains, contusion pains, eczema, furuncle, and carbuncle infections."
    )

    val oreganoInfo = PlantInfo(
        "Oregano",
        "Origanum Amboinicus",
        "Typically grows to 1-3' tall and to 2' wide on square stems clad with aromatic, glandular-spotted, rounded to ovate leaves (to 1 1/2” long) which are usually entire but sometimes have slightly toothed margins.",
        "Oregano contains chemicals that might help reduce cough. Oregano also might help with digestion and with fighting against some bacteria and viruses. People use oregano for wound healing, parasite infections, and many other conditions, but there is no good scientific evidence to support these uses."
    )

    // Map each plant class to its information
    val plantInfoMap = mapOf(
        "Alugbati" to alugbatiInfo,
        "Ampalaya" to ampalayaInfo,
        "Bayabas" to bayabasInfo,
        "Malunggay" to malunggayInfo,
        "Oregano" to oreganoInfo
    )
}
