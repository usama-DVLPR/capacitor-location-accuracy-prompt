import Foundation

@objc public class LocationAccuracyPlugin: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
