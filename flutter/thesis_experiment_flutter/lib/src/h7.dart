import 'package:flutter/material.dart';

class H7 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Chapter 7 Code complexity"),
      ),
      body: Container(
        child: Padding(
          padding: EdgeInsets.only(top: 50.0, bottom: 40),
          child: ListView.builder(
              itemCount: 20,
              itemBuilder: (context, index) {
                return Container(
                  decoration: BoxDecoration(
                      border: Border(
                    bottom: BorderSide(
                        style: BorderStyle.solid, color: Colors.black12),
                  )),
                  child: ListTile(
                    contentPadding: EdgeInsets.only(left: 15),
                    title: Text("Notification"),
                  ),
                );
              }),
        ),
      ),
    );
  }
}
