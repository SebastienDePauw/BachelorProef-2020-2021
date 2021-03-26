// Import the Material Widgets, such as MaterialApp & Scaffold.
// This implicitly also imports 'flutter/widgets.dart'.
import 'package:flutter/material.dart';
import 'package:thesis_experiment/example/listSample.dart';

/// A [StatelessWidget] that does not manage any state.
/// Its sole purpose is to present something.
class App extends StatelessWidget {

  // The build method specifies how the Widget's UI looks.
  // It is called for every draw-call.
  @override
  Widget build(BuildContext context) {
    // A MaterialApp Widget is typically the root of an Material-style app.
    // As Android apps follow the Material theme,
    // we use it as the ancestor for all our other Widgets.
    return MaterialApp(
      // This fixes the dark status bar text.
      // Since the default is Brightness.light
      // it uses grey text instead of white >.<
      theme: ThemeData(
        appBarTheme: Theme.of(context).appBarTheme.copyWith(
          brightness: Brightness.dark
        ),
      ),
      // The home parameter of the MaterialApp specifies the 'home' screen.
      // This is the first screen the user will see.
      // A Scaffold is the typical screen ancestor
      // for screens within a MaterialApp.
      // It provides things such as a DefaultTextStyle Widget to children.
      home: Scaffold(
        // An AppBar Widget is the equivalent
        // of the toolbar component in native Android.
        appBar: AppBar(
          title: Text(
            "Thesis Experiment App",
            // Text takes a TextStyle to style itself.
            // If none is provided,
            // it uses the value of the nearest DefaultTextStyle.
            // (provided by the Scaffold above)
            style: TextStyle(fontStyle: FontStyle.italic),
          ),
        ),
        body: Center(
          child: SnackbarButton(),
        ),
      ),
    );
  }
}

class SnackbarButton extends StatelessWidget {
  void navigate(BuildContext context){
    // The Navigator handles navigation.
    // Push puts a new route (MaterialPageRoute in this case)
    // on the navigation stack.
    // Push returns a Future ( contains the value of pop([value]) )
    Navigator.of(context).push(
      // MaterialPageRoute provides a default animation,
      // that follows the platform specification for navigation transitions.
      // On Android this slides upwards and on iOS this moves sideways.
      // The funny part is, this works on all platforms,
      // even though it is called MaterialPageRoute.
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