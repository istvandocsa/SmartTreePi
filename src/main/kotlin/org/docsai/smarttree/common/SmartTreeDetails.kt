package org.docsai.smarttree.common

import org.docsai.smarttree.common.iface.*

object SmartTreeDetails {
    val endpointId: String = "3a1ecbf7-c907-4063-85f0-bafdc0b20448"
    val displayCategories: List<String> = listOf("LIGHT")
    val manufacturerName: String = "Docsa Brothers"
    val modelName: String = "Raspberry Pi 3 - SmartTree"
    val version: String = "1.0"
    val friendlyName: String = "Christmas tree"
    val description: String =  "Raspberry Pi powered SmartTree"
    val isReachable: Boolean = true
    val cookie: Map<String, String> =  mapOf("Additional" to "None")
    val capabilities: List<AlexaInterface> = listOf(PowerController, BrightnessController, ColorController, ChannelController)
}