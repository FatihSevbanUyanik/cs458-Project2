import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:survey_app/poll_page2.dart';
import 'poll_page.dart';
import 'custom_appbar2.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  SystemChrome.setEnabledSystemUIOverlays([SystemUiOverlay.bottom]);
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    title: 'My app', // used by the OS task switcher
    initialRoute: '/',
    routes:{
      '/': (context) => MyHomeWidget(),
      '/pollPage': (context) => PollPage(),
      '/pollPage2': (context) => PollPage2(),
    }
  ));
}

class MyHomeWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Material is a conceptual piece of paper on which the UI appears.
    return Scaffold(
      appBar: CustomAppBar(),
      body: Material(
        child: Column(
          children: <Widget>[
            Center(child: Image.asset("assets/images/corona-img-1.jpeg"),
            ),
            RaisedButton(
              child: Text("Attend Corona Poll"),
              onPressed: (){navigateToPollPage(context);},
            )
          ]
        )
      )
    );

  }

  Future navigateToPollPage(context) async {
    Navigator.pushNamed(context, '/pollPage');
  }
}


