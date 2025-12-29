import Flutter
import UIKit

@main
@objc class AppDelegate: FlutterAppDelegate {

  private let CHANNEL_NAME = "th.in.lordgift.flutter_native_bridged/call_channel"

  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {

    if let controller = window?.rootViewController as? FlutterViewController {
        let channel = FlutterMethodChannel(name: CHANNEL_NAME, binaryMessenger: controller.binaryMessenger)
        channel.setMethodCallHandler { call, result in
          switch call.method {
          case "getDeviceModel":
            // return value to Dart
            result(UIDevice.current.model)

            // invokes another method
            channel.invokeMethod("nativeInvokesDart", arguments: "iOS")

          default:
            result(FlutterMethodNotImplemented)
          }
        }
    }

    GeneratedPluginRegistrant.register(with: self)
    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }
}
