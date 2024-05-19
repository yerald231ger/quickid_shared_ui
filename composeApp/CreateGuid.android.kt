package org.gsh.qid

actual fun createGuid(): String {
    return java.util.UUID.randomUUID().toString()
}