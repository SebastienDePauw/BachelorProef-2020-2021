import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class AsynchronousWithFutureBuilderExample extends StatelessWidget {
  const AsynchronousWithFutureBuilderExample({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("AsynchronousWithFutureBuilder"),
        ),
        body: Center(
          child: FutureBuilderExampleStatefulWidget(),
        ));
  }
}

/// This is the stateful widget that the main application instantiates.
class FutureBuilderExampleStatefulWidget extends StatefulWidget {
  const FutureBuilderExampleStatefulWidget({Key? key}) : super(key: key);

  @override
  State<FutureBuilderExampleStatefulWidget> createState() =>
      _FutureBuilderExampleStatefulWidgetState();
}

/// This is the private State class that goes with MyStatefulWidget.
class _FutureBuilderExampleStatefulWidgetState
    extends State<FutureBuilderExampleStatefulWidget> {
  Future<String>? _dataFuture;

  @override
  void initState() {
    super.initState();
    _dataFuture = getData();
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
          child: FutureBuilder(
            future: getData(),
            builder: (BuildContext context, AsyncSnapshot snapshot) {
              if (snapshot.hasData) {
                return Column(
                  children: [
                    Padding(
                      padding: EdgeInsets.fromLTRB(0, 10, 0, 20),
                      child: Icon(
                        Icons.done,
                        color: Colors.green,
                        size: 50,
                      ),
                    ),
                    Text('Data retrieved: \n \n' + snapshot.data! + ' ...',
                        textAlign: TextAlign.center,
                        style:
                            TextStyle(fontSize: 18, color: Colors.deepPurple))
                  ],
                );
              } else {
                return Container(
                  width: 50,
                  height: 50,
                  child: CircularProgressIndicator(),
                );
              }
            },
          ),
        ),
      ],
    );
  }
}

Future<String> getData() async {
  final response = await http.get(Uri.parse('https://flutterdevs.com'));
  return response.body.substring(0, 74);
}