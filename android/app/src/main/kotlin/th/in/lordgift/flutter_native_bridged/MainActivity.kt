package th.`in`.lordgift.flutter_native_bridged

import io.flutter.embedding.android.FlutterActivity
import android.os.Build
import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel


class MainActivity : FlutterActivity() {
    private val CHANNEL_NAME = "th.in.lordgift.flutter_native_bridged/call_channel"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        // Set up the MethodChannel to listen for calls from Flutter
        val channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL_NAME)
        channel.setMethodCallHandler { call, result ->
            when (call.method) {
                "getDeviceModel" -> {
                    // return value to Dart
                    result.success(Build.MODEL)

                    // invokes another method
                    channel.invokeMethod("nativeInvokesDart", "Android")
                }
                else -> result.notImplemented()
            }
        }
    }

}