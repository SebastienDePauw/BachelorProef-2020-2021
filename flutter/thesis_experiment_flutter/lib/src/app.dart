import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:thesis_experiment/example/listSample.dart';
import 'package:thesis_experiment/src/home.dart';

class App extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        appBarTheme: Theme.of(context).appBarTheme.copyWith(brightness: Brightness.dark),
        primaryColor: Color.fromARGB(255, 98, 0, 238),
        accentColor: Colors.white,
      ),
      home: Home()
    );
  }
}