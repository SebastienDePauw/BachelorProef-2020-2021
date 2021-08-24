import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class AsynchronousWithStatefulWidgetExample extends StatelessWidget {
  const AsynchronousWithStatefulWidgetExample({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("AsynchronousWithStatefulWidget"),
        ),
        body: Center(
          child: MyFutureWidget(),
        ));
  }
}

class MyFutureWidget extends StatefulWidget {
  const MyFutureWidget({Key? key}) : super(key: key);

  @override
  _MyFutureWidgetState createState() => _MyFutureWidgetState();
}

class _MyFutureWidgetState extends State<MyFutureWidget> {
  String? value;

  @override
  void initState() {
    super.initState();
    fetchName().then((result) {
      setState(() {
        value = result;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(mainAxisAlignment: MainAxisAlignment.center, children: [
      Container(
          height: 300,
          width: 250,
          alignment: Alignment.center,
          decoration: BoxDecoration(
              border: Border.all(
            color: Colors.deepPurple,
          )),
          child: (() {
            if (value == null) {
              return Container(
                width: 50,
                height: 50,
                child: CircularProgressIndicator(),
              );
            }
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
                Text('Data retrieved: \n \n' + value! + ' ...',
                    textAlign: TextAlign.center,
                    style: TextStyle(fontSize: 18, color: Colors.deepPurple))
              ],
            );
          })())
    ]);
  }
}

Future<String> fetchName() async {
  final response = await http.get(Uri.parse('https://flutterdevs.com'));
  return response.body.substring(0, 74);
}
