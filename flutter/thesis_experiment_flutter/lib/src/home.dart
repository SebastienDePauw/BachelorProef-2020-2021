import 'package:flutter/material.dart';
import 'package:thesis_experiment/src/h1.dart';
import 'package:thesis_experiment/src/h2.dart';
import 'package:thesis_experiment/src/h3.dart';
import 'package:thesis_experiment/src/h4.dart';
import 'package:thesis_experiment/src/h5.dart';
import 'package:thesis_experiment/src/h6.dart';
import 'package:thesis_experiment/src/h7.dart';
import 'package:thesis_experiment/src/h8.dart';
import 'package:thesis_experiment/src/h9.dart';

class Home extends StatelessWidget {
  final List<String> data = <String>["test", "test", "test"];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Home"),),
      body: ListView.builder(itemBuilder: (_, index) {
        return ListTile(title: Text(data[index]),onTap: () => onTap(context, index) ,);
      }, itemCount: data.length,),
    );
  }

  void onTap(BuildContext context, int index){
    Widget widget;

    switch(index){
      case 0: widget = H1(); break;
      case 1: widget = H2(); break;
      case 2: widget = H3(); break;
      case 3: widget = H4(); break;
      case 4: widget = H5(); break;
      case 5: widget = H6(); break;
      case 6: widget = H7(); break;
      case 7: widget = H8(); break;
      case 8: widget = H9(); break;
      default: return;
    }

    Navigator.of(context).push(MaterialPageRoute(builder: (context) => widget));
  }
}
