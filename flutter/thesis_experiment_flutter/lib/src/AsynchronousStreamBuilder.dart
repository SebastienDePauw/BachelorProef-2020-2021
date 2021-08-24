import 'package:flutter/material.dart';

/// This is the main application widget.
class AsynchronousWithStreamBuilderExample extends StatelessWidget {
  const AsynchronousWithStreamBuilderExample({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("AsynchronousStreamBuilder"),
        ),
        body: Center(
          child: StreamBuilderExampleStatefulWidget(),
        ));
  }
}

/// This is the stateful widget that the main application instantiates.
class StreamBuilderExampleStatefulWidget extends StatefulWidget {
  const StreamBuilderExampleStatefulWidget({Key? key}) : super(key: key);

  @override
  State<StreamBuilderExampleStatefulWidget> createState() =>
      _StreamBuilderExampleStatefulWidgetState();
}

/// This is the private State class that goes with MyStatefulWidget.
class _StreamBuilderExampleStatefulWidgetState
    extends State<StreamBuilderExampleStatefulWidget> {
  Stream<String> _count() async* {
    for (var i = 1; i <= 5; i++) {
      await Future.delayed(Duration(seconds: 1));
      yield "$i";
    }
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Container(
          height: 300,
          width: 250,
          alignment: Alignment.center,
          decoration: BoxDecoration(
              border: Border.all(
            color: Colors.deepPurple,
          )),
          child: StreamBuilder(
            stream: _count(),
            builder: (BuildContext context, AsyncSnapshot<String> snapshot) {
              if (snapshot.connectionState == ConnectionState.waiting) {
                return Container(
                  width: 50,
                  height: 50,
                  child: CircularProgressIndicator(),
                );
              } else if (snapshot.connectionState == ConnectionState.done) {
                return Icon(
                  Icons.done,
                  color: Colors.green,
                  size: 50,
                );
              } else {
                return Text(
                  snapshot.data!,
                    style: TextStyle(fontSize: 50, color: Colors.deepPurple)
                );
              }
            },
          ),
        ),
      ],
    );
  }
}
