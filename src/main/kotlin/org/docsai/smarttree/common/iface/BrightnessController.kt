package org.docsai.smarttree.common.iface

object BrightnessController : AlexaInterface() {
    override val `interface`: String
        get() = "Alexa.BrightnessController"
    override val properties: InterfaceProperties<Map<String, String>>
        get() = InterfaceProperties(listOf(mapOf("name" to "brightness")))

}