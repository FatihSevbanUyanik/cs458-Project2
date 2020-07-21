import 'package:flutter/material.dart';
import 'custom_appbar.dart';

class PollPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Material(
      // Column is a vertical, linear layout.
      child: Column(
        children: <Widget>[
          MyAppBar(
            title: Text(
              'Corona Survey App',
              style: Theme.of(context).primaryTextTheme.headline6,
            ),
          ),
          
        ],
      ),
    );
  }
}