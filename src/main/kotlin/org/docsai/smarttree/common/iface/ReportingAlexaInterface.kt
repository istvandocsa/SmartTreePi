package org.docsai.smarttree.common.iface

abstract class ReportingAlexaInterface: AlexaInterface() {
    abstract val properties: InterfaceProperties<Map<String, String>>
    val proactivelyReported: Boolean = false
    val retrievable: Boolean = false
}