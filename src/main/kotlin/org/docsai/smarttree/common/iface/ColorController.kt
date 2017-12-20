package org.docsai.smarttree.common.iface

object ColorController : AlexaInterface() {
    override val `interface`: String
        get() = "Alexa.ColorController"
    override val properties: InterfaceProperties<Map<String, String>>
        get() = InterfaceProperties(listOf(mapOf("name" to "color")))

}