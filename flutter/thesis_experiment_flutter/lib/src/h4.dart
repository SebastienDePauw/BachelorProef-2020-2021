import 'dart:math';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:thesis_experiment/src/AsynchronousStatefulWidget.dart';
import 'package:thesis_experiment/src/AsynchronousStreamBuilder.dart';
import 'AsynchronousFutureBuilder.dart';

class H4 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Chapter 4: Asynchronous"),
        ),
        body: Center(
            child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Padding(
              padding: EdgeInsets.all(10),
              child: Container(
                height: 300,
                width: 250,
                alignment: Alignment.center,
                decoration: BoxDecoration(
                    border: Border.all(
                  color: Colors.deepPurple,
                )),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Padding(
                        padding: EdgeInsets.fromLTRB(0, 50, 0, 30),
                        child: Text('See console for output')),
                    Padding(
                      padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
                      child: OutlinedButton(
                          child: Text("Future without callback"),
                          onPressed: () => futurePressed()),
                    ),
                    Padding(
                      padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
                      child: OutlinedButton(
                          child: Text("Future with callback"),
                          onPressed: () => futureCallbackPressed()),
                    ),
                  ],
                ),
              ),
            ),
            Padding(
              padding: EdgeInsets.all(10),
              child: Container(
                height: 300,
                width: 250,
                alignment: Alignment.center,
                decoration: BoxDecoration(
                    border: Border.all(
                  color: Colors.deepPurple,
                )),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Padding(
                      padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
                      child: OutlinedButton(
                        child: Text("StatefulWidget"),
                        onPressed: () => Navigator.of(context).push(
                            MaterialPageRoute(
                                builder: (context) =>
                                    AsynchronousWithStatefulWidgetExample())),
                      ),
                    ),
                    Padding(
                      padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
                      child: OutlinedButton(
                        child: Text("FutureBuilder"),
                        onPressed: () => Navigator.of(context).push(
                            MaterialPageRoute(
                                builder: (context) =>
                                    AsynchronousWithFutureBuilderExample())),
                      ),
                    ),
                    Padding(
                      padding: EdgeInsets.fromLTRB(0, 10, 0, 0),
                      child: OutlinedButton(
                        child: Text("StreamBuilder"),
                        onPressed: () => Navigator.of(context).push(
                            MaterialPageRoute(
                                builder: (context) =>
                                    AsynchronousWithStreamBuilderExample())),
                      ),
                    ),
                  ],
                ),
              ),
            )
          ],
        )));
  }

  /*region future without callback*/
  Future<void> futurePressed() async {
    await openShop(4); //4 is the number of customers
  }

  Future<void> openShop(int totalClients) async{
    for (var i = 1; i <= totalClients; i++) {
      await Future.delayed(Duration(seconds: i), () => ordered(i));
    }
  }

  Future<void> ordered(int clientNr) async {
    print('Client $clientNr: Order placed - checkout');
    await startBestelling(clientNr);
  }

  Future<void> startBestelling(int clientNr) async {
    print('Client $clientNr: Start making order - bar');
    await fetchUserOrder(clientNr);
  }

  Future<void> fetchUserOrder(int clientNr) {
    Random r = new Random();
    var ranInt = r.nextInt(3) + 1;
    return Future.delayed(Duration(seconds: ranInt),
        () => print('Client $clientNr: Order finished - bar'));
  }

  /*endregion*/

  /*region future with callback*/

  void futureCallbackPressed() {
    print("Start getting http request");

    http.get(Uri.parse('https://flutterdevs.com')).then((response) {
      if (response.statusCode == 200)
        print("Response successful received.");
      else
        print("Response not received");
    }).catchError((error) {
      print("Error!");
    }).whenComplete(() {
      print("Future complete.");
    });

    for (var i = 1; i <= 5; i++) {
      Future.delayed(Duration(seconds: i), () => print(i));
    }
  }

/*endregion*/
}
