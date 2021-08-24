import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class APIHttp extends StatelessWidget {
  const APIHttp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("API Http"),
        ),
        body: Center(
          child: APIHttpExample(),
        ));
  }
}

class APIHttpExample extends StatefulWidget {
  const APIHttpExample({Key? key}) : super(key: key);

  @override
  State<APIHttpExample> createState() =>
      _APIHTTPExampleState();
}

class _APIHTTPExampleState extends State<APIHttpExample> {
  Future getUserData() async {
    var response = await http.get(Uri.https('jsonplaceholder.typicode.com', 'users'));
    var jsonData = jsonDecode(response.body);
    List<User> users = [];
    for(var u in jsonData){
      User user = User(u['name'], u['email'], u['username']);
      users.add(user);
    }
    return users;
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: getUserData(),
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          List<User> users = snapshot.data as List<User>;
          return ListView.builder(itemCount: users.length, itemBuilder: (context, i) {
            return ListTile(
              title: Text(users[i].name),
              trailing: Text(users[i].userName),
              subtitle: Text(users[i].email),
            );
          });
        }

        if (snapshot.hasError) {
          return Text(snapshot.error.toString());
        }

        return Container(
          width: 50,
          height: 50,
          child: CircularProgressIndicator(),
        );
      },
    );
  }
}

class User {
  final String name, email, userName;
  User(this.name, this.email, this.userName);
}