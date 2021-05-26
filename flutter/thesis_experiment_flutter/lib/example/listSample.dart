import 'package:flutter/material.dart';

/// A [StatefulWidget] maintains a state.
class ListSample extends StatefulWidget {
  @override
  _ListSampleState createState() => _ListSampleState();
}

class _ListSampleState extends State<ListSample> {

  // This future can be null.
  Future<List<String>>? future;

  void loadData(){
    // The Future.delayed named constructor is an easy way
    // of returning a Future that completes after a delay.
    // You could also use async / await to await a computation.
    future = Future.delayed(Duration(seconds: 5), (){
      //TODO(Sébastien): What happens if you return Future.error("oops") ?

      return Future.value(<String>["Bob", "Sébastien", "Hans", "Tim"]);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("List Sample"),
      ),
      // FutureBuilders wrap an asynchronous computation (a Future) into a Widget.
      // This one wraps a Future<List<String>>.
      body: FutureBuilder<List<String>>(
        future: future,
        // The AsyncSnapshot contains a 'snapshot' of the computation.
        // It includes the data and the connection state.
        // (See the docs for ConnectionState, they are pretty helpful)
        builder: (context, snapshot){
          // The Future is null. Present a button.
          if(snapshot.connectionState == ConnectionState.none){
            return Center(
              child: ElevatedButton(onPressed: (){
                // setState((){}) executes the callback argument
                // & triggers a redraw. This is how we manually update the state.
                setState(loadData);
              }, child: Text("Load some data from a fancy API")),
            );
          }else if(snapshot.connectionState == ConnectionState.done){
            if(snapshot.hasError){
              return Center(
                child: Column(
                  // The main axis is the layout axis for Columns & Rows.
                  // For a column this is the vertical axis.
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(Icons.warning, color: Colors.orange),
                    Padding(
                      padding: const EdgeInsets.only(top: 20),
                      child: Text("Well shit, something broke."),
                    ),
                  ],
                ),
              );
            }

            // The bang operator (!)
            // explicitly converts a nullable value to non-null.
            final data = snapshot.data!;

            // The ListView.builder creates items on demand.
            // This is good for large lists.
            return ListView.builder(
              itemCount: data.length,
              // ListTile is a Material Widget commonly used as a list item.
              // (Spoiler alert, there is a Cupertino equivalent in the works)
              itemBuilder: (context, index) => ListTile(
                title: Text(data[index]),
              ),
            );
          }else {
            return Center(
              // Show a Material style circular progress indicator.
              child: CircularProgressIndicator(
                // The valueColor is a little tricky,
                // since we 'could' animate the color based on the progress.
                // But if we want a single color,
                // we use an AlwaysStoppedAnimation<Color>.
                valueColor: AlwaysStoppedAnimation<Color>(Colors.blue),
                // If we don't set value, it is an infinite looping indicator.
              ),
            );
          }
        },
      ),
    );
  }
}
