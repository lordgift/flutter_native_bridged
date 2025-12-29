# flutter_native_bridged

Sample code that represent the simplest way to communicate between flutter and native code.

Source code started from Android Studio excluding unnecessary files, please only focus on following files.

- [main.dart](lib/main.dart)
- [MainActivity.kt](android/app/src/main/kotlin/th/in/lordgift/flutter_native_bridged/MainActivity.kt)
- [AppDelegate.swift](ios/Runner/AppDelegate.swift)

## Understanding 
- **Channel** : unique name for communicate between flutter and natives.
- **Method** : method's name in `String`.
- **arguments** : yep, arguments passing also available.