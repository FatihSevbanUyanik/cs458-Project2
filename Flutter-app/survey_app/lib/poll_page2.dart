import 'package:flutter/material.dart';
import 'custom_appbar2.dart';

class PollPage2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: CustomAppBar(),
        body: Material(child: Column(children: <Widget>[MyCustomForm2()])));
  }
}

// Define a custom Form widget.
class MyCustomForm2 extends StatefulWidget {
  @override
  MyCustomFormState2 createState() {
    return MyCustomFormState2();
  }
}

// Define a corresponding State class.
// This class holds data related to the form.
class MyCustomFormState2 extends State<MyCustomForm2> {
  // Create a global key that uniquely identifies the Form widget
  // and allows validation of the form.
  //
  // Note: This is a `GlobalKey<FormState>`,
  // not a GlobalKey<MyCustomFormState>.
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    // Build a Form widget using the _formKey created above.
    return Form(
        key: _formKey,
        child: Column(children: <Widget>[
          // Add TextFormFields and RaisedButton here.
          new Align(
              alignment: Alignment.topLeft,
              child: Container(
                  child: Text(
                    "What kind of changes did you experience after the corona pandemia?",
                    style: TextStyle(
                      color: Colors.indigo,
                      fontSize: 25,
                      fontWeight: FontWeight.bold,

                    ),
                  )
              )
          ),

          TextFormField(
            // The validator receives the text that the user has entered.
            validator: (value) {
              if (value.isEmpty) {
                return 'Please fill this field';
              }
              return null;
            },
            textAlign: TextAlign.left,
            keyboardType: TextInputType.multiline,
            maxLines: 5,
            decoration: InputDecoration(
              hintText: 'Text',
              border: OutlineInputBorder(borderRadius: BorderRadius.circular(2.0)),
            ),
          ),
          RaisedButton(
            onPressed: () {
              // Validate returns true if the form is valid, otherwise false.
              if (_formKey.currentState.validate()) {
                // If the form is valid, display a snackbar. In the real world,
                // you'd often call a server or save the information in a database.

                Navigator.push(context, MaterialPageRoute(builder: (context) => PollPage2()));

                //Scaffold.of(context)
                //    .showSnackBar(SnackBar(content: Text('Processing Data')));
              }
            },
            child: Text('SEND'),
          )
        ]));
  }
}