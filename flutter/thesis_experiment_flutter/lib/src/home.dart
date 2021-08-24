import 'package:flutter/material.dart';
import 'package:thesis_experiment/src/h1.dart';
import 'package:thesis_experiment/src/h2.dart';
import 'package:thesis_experiment/src/h3.dart';
import 'package:thesis_experiment/src/h4.dart';
import 'package:thesis_experiment/src/h5.dart';
import 'package:thesis_experiment/src/h6.dart';
import 'package:thesis_experiment/src/h7.dart';
import 'package:thesis_experiment/src/h8.dart';

class Home extends StatelessWidget {
  final List<String> data = <String>[
    "Chapter 1 Executable size",
    "Chapter 2 Start-up performance",
    "Chapter 3 CPU usage",
    "Chapter 4 Asynchronous",
    "Chapter 5 API's",
    "Chapter 6 Security",
    "Chapter 7 Code complexity",
    "Chapter 8 Tooling"
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
        widget = H1();
        break;
      case 1:
        widget = H2();
        break;
      case 2:
        widget = H3();
        break;
      case 3:
        widget = H4();
        break;
      case 4:
        widget = H5();
        break;
      case 5:
        widget = H6();
        break;
      case 6:
        widget = H7();
        break;
      case 7:
        widget = H8();
        break;
      default:
        return;
    }

    Navigator.of(context).push(MaterialPageRoute(builder: (context) => widget));
  }
}
