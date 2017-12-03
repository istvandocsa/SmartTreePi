package org.docsai.smarttree.common

object SmartTreeDetails {

    // This id needs to be unique across all devices discovered for a given manufacturer
    val applianceId: String = "3a1ecbf7-c907-4063-85f0-bafdc0b20448"

    val applianceTypes: List<String> = listOf("LIGHT")

    // Company name that produces and sells the smart home device
    val manufacturerName: String = "Raspberry"

    // Model name of the device
    val modelName: String = "Raspberry Pi 3 - SmartTree"

    // Version number of the product
    val version: String = "1.0"

    // The name given by the user in your application. Examples include "Bedroom light" etc
    val friendlyName: String = "SmartTree"

    val friendlyDescription: String =  "Raspberry Pi powered SmartTree"

    val isReachable: Boolean = true

    // List the actions the device can support from our API
    // The action should be the name of the actions listed here
    // https: String = //developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/smart-home-skill-api-reference#discoverappliancesresponse
    val actions: List<String> =  listOf("turnOn", "turnOff")

    val additionalApplianceDetails: Map<String, String> =  mapOf("Additional" to "None")
        
}