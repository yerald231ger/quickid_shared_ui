import platform.Foundation.NSUUID

//Guid creator for iOS
actual fun createGuid(): String {
    return NSUUID().UUIDString()
}