import Foundation
import Capacitor

@objc(LocationAccuracyPluginPlugin)
public class LocationAccuracyPluginPlugin: CAPPlugin {
    private let implementation = LocationAccuracyPlugin()

    @objc func echo(_ call: CAPPluginCall) {
        // This method is only implemented for Android; provide a message for iOS
        call.reject("The 'echo' method is not available on iOS.")
    }
}
