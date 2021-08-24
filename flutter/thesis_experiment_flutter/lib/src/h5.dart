import 'package:flutter/material.dart';

class H5 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Chapter 5 API's"),
      ),
      body: Center(
        child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Padding(
            padding: EdgeInsets.all(10),
            child: Container(
              height: 350,
              width: 320,
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
                        child: Text("GET with http"),
                        onPressed: () => httpCall()),
                  ),
                  Padding(
                    padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
                    child: OutlinedButton(
                        child: Text("GET with dio"),
                        onPressed: () => dioCall()),
                  ),
                  Padding(
                    padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
                    child: OutlinedButton(
                        child: Text("GET with cached_network_image"),
                        onPressed: () => cniCall()),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
      ),
    );
  }
}

void httpCall(){}
void dioCall(){}
void cniCall(){}
