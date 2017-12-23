package org.docsai.smarttree.common.iface

object ColorController : ReportingAlexaInterface() {
    override val `interface`: String
        get() = "Alexa.ColorController"
    override val properties: InterfaceProperties<Map<String, String>>
        get() = InterfaceProperties(listOf(mapOf("name" to "color")))

}