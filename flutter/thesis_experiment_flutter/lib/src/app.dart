// Import the Material Widgets, such as MaterialApp & Scaffold.
// This implicitly also imports 'flutter/widgets.dart'.
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

class SnackbarButton extends StatelessWidget {
  void navigate(BuildContext context){
    Navigator.of(context).push(
      MaterialPageRoute(builder: (context) => ListSample())
    );
  }

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      child: Text("Press Me!"),
      // TODO(Sébastien): try replacing onPressed with () => navigate(context)
      // while the app is running. Then save and press it.
      //
      // (you can even keep the snackbar code,
      // the ScaffoldMessenger delays the showing of the Snackbar,
      // this however feels odd as it somewhat collides
      // with the sliding up navigation transition)
      onPressed: (){
        // The ScaffoldMessenger is an InheritedWidget
        // that can be accessed using the BuildContext.
        // It can be used to display snackbars.
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            backgroundColor: Colors.orange,
            duration: Duration(seconds: 1),
            content: Row(
              children: [
                Text("Snacc Snacc :D")
              ],
            ),
          ),
        );
      },
    );
  }
}