// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorLocationAccuracyPrompt",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorLocationAccuracyPrompt",
            targets: ["LocationAccuracyPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "LocationAccuracyPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/LocationAccuracyPluginPlugin"),
        .testTarget(
            name: "LocationAccuracyPluginPluginTests",
            dependencies: ["LocationAccuracyPluginPlugin"],
            path: "ios/Tests/LocationAccuracyPluginPluginTests")
    ]
)