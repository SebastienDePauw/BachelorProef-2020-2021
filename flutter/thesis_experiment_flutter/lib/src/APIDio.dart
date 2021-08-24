import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';

class APIDio extends StatelessWidget {
  const APIDio({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("API Dio"),
        ),
        body: Center(
          child: APIDioExample(),
        ));
  }
}

class APIDioExample extends StatefulWidget {
  const APIDioExample({Key? key}) : super(key: key);

  @override
  State<APIDioExample> createState() =>
      _APIDioExampleState();
}

class _APIDioExampleState extends State<APIDioExample> {
  Future getUserData() async {
    var response = await Dio().get('https://jsonplaceholder.typicode.com/users');
    var data = response.data;
    List<User> users = [];
    for(var u in data){
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