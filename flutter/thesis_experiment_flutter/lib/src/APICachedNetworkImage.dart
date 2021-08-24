import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:cached_network_image/cached_network_image.dart';

class APICachedNetworkImage extends StatelessWidget {
  const APICachedNetworkImage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("API Cached Network Image"),
        ),
        body: Center(
          child: APICachedNetworkImageExample(),
        ));
  }
}

class APICachedNetworkImageExample extends StatefulWidget {
  const APICachedNetworkImageExample({Key? key}) : super(key: key);

  @override
  State<APICachedNetworkImageExample> createState() =>
      _APICachedNetworkImageExampleState();
}

class _APICachedNetworkImageExampleState
    extends State<APICachedNetworkImageExample> {
  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: EdgeInsets.all(8),
        itemCount: 50,
        itemBuilder: (context, i) => Card(
              color: Colors.white,
              child: ListTile(
                contentPadding:
                    EdgeInsets.symmetric(horizontal: 16, vertical: 2),
                leading: buildImage(i),
                title: Text('Image ${i + 1}'),
              ),
            ));
  }

  Widget buildImage(int index) => ClipRRect(
      borderRadius: BorderRadius.circular(12),
      child: CachedNetworkImage(
        imageUrl: 'https://source.unsplash.com/random?sig=$index',
        height: 50,
        width: 50,
        fit: BoxFit.cover,
        placeholder: (context, url) => Center(
          child: CircularProgressIndicator(),
        ),
        errorWidget: (context, url, error) => Container(
          color: Colors.deepPurple,
          child: Icon(
            Icons.error_outline,
            color: Colors.white,
          ),
        ),
      ));
}
