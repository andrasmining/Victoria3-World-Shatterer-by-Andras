package org.victoriaThreeShatterer


import org.victoriaThreeShatterer.creators.*
import org.victoriaThreeShatterer.parsers.customFiles.readColorPalette
import org.victoriaThreeShatterer.parsers.gameFiles.getConsolidatedBuildingsMap
import org.victoriaThreeShatterer.parsers.gameFiles.getConsolidatedPopMap
import org.victoriaThreeShatterer.parsers.gameFiles.readStatesFile
import org.victoriaThreeShatterer.utils.setBarracksToAtLeast

fun main(args: Array<String>) {
    println("Start parsing files")
    var colorPalette = readColorPalette("src/main/resources/colorPalette.json")
    var stateMap = readStatesFile("src/main/resources/realGame/00_states.txt")
    var compactPopMap = getConsolidatedPopMap()
    var buildingsMap = getConsolidatedBuildingsMap()
    println("Done parsing files")

    println("Start modifying parsed data")
    buildingsMap = setBarracksToAtLeast(10, buildingsMap)
    println("Done modifying parsed data")

    println("Start creating new files")
    createBuildingsFile(buildingsMap)
    createBuildingsOnlyBarracks(stateMap)
    createPopsFile(compactPopMap)
    createStatesFile(stateMap)
    createPopulationsFiles(compactPopMap)
    createCountryDefinitionsFile(stateMap, compactPopMap, colorPalette)
    createCountriesFiles(compactPopMap)
    createLocalization(stateMap)
    println("Done creating new files")

    println("Program done")
}
