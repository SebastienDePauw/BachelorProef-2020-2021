// An import that contains everything related to generic Widgets.
// These are Widgets that don't specifically belong
// to the Material (Android) or Cupertino (iOS) themes.
// runApp(Widget) is located herein.
import 'package:flutter/widgets.dart';

// An import that imports things from the project sources.
// Here we import the App Widget from src/app.dart.
// It is preferable to use a full path import instead of a relative one.
import 'package:thesis_experiment/src/app.dart';

// The main function is the entrypoint of a Dart application.
// This is not Flutter specific, as we could also write a CLI app in Dart.
void main() {
  // The runApp(Widget) method initializes the Flutter app.
  // The Widget argument of runApp becomes the root of the Widget tree.
  runApp(App());
}


