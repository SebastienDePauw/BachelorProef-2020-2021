import 'package:flutter/material.dart';
import 'package:thesis_experiment/src/h4.dart';
import 'package:thesis_experiment/src/h5.dart';
import 'package:thesis_experiment/src/h6.dart';
import 'package:thesis_experiment/src/h7.dart';

class Home extends StatelessWidget {
  final List<String> data = <String>[
    "Chapter 4 Asynchronous tasks",
    "Chapter 5 Network calls",
    "Chapter 6 Security",
    "Chapter 7 Code complexity",
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Home"),
      ),
      body: ListView.separated(
        separatorBuilder: (BuildContext context, int index) =>
            Divider(color: Colors.deepPurple),
        itemBuilder: (_, index) {
          return ListTile(
            title: Text(data[index]),
            onTap: () => onTap(context, index),
          );
        },
        itemCount: data.length,
      ),
    );
  }

  void onTap(BuildContext context, int index) {
    Widget widget;

    switch (index) {
      case 0:
        widget = H4();
        break;
      case 1:
        widget = H5();
        break;
      case 2:
        widget = H6();
        break;
      case 3:
        widget = H7();
        break;
      default:
        return;
    }

    Navigator.of(context).push(MaterialPageRoute(builder: (context) => widget));
  }
}
