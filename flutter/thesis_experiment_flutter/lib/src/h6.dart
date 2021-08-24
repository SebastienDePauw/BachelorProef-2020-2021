import 'package:flutter/material.dart';

import 'package:permission_handler/permission_handler.dart';

class H6 extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Chapter 5 API's"),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () async {
              final status = await Permission.camera.status;
              if (status == PermissionStatus.granted) {
                print('Permission granted');
              } else if (status == PermissionStatus.denied) {
                showDialog(
                    context: context,
                    builder: (BuildContext context){
                      return AlertDialog(
                        title: const Text('Camera Permission'),
                        content: const Text('Do you want to grant camera permissions to this app?'),
                        actions: <Widget>[
                          TextButton(
                            onPressed: () { Navigator.of(context).pop(); },
                            child: const Text('No'),
                          ),
                          TextButton(
                            onPressed: () { openAppSettings(); },
                            child: const Text('Open Settings'),
                          ),
                        ],
                      );
                    }
                );
              } else if (status == PermissionStatus.permanentlyDenied) {
                print('Permission Permanently Denied');
                await openAppSettings();
              }
          },
          child: Text('Check Camera Permission'),
        ),
      ),
    );
  }
}