import 'package:flutter/material.dart';
import 'custom_appbar2.dart';
import 'dropdownmenu.dart';
import 'poll_page2.dart';

class PollPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: CustomAppBar(),
        body: Material(child: Column(children: <Widget>[MyCustomForm()])));
  }
}

// Define a custom Form widget.
class MyCustomForm extends StatefulWidget {
  @override
  MyCustomFormState createState() {
    return MyCustomFormState();
  }
}

// Define a corresponding State class.
// This class holds data related to the form.
class MyCustomFormState extends State<MyCustomForm> {
  // Create a global key that uniquely identifies the Form widget
  // and allows validation of the form.
  //
  // Note: This is a `GlobalKey<FormState>`,
  // not a GlobalKey<MyCustomFormState>.
  final _formKey = GlobalKey<FormState>();

  final List<String> cities = [
    'Adana',
    'Adıyamam',
    'Afyonkarahisar',
    'Ağrı',
    'Aksaray',
    'Amasya',
    'Ankara',
    'Antalya',
    'Ardahan',
    'Artvin',
    'Aydın',
    'Balıkesir',
    'Bartın',
    'Batman',
    'Bayburt',
    'Bilecik',
    'Bingöl',
    'Bitlis',
    'Bolu',
    'Burdur',
    'Bursa',
    'Çanakkale',
    'Çankırı',
    'Çorum',
    'Denizli',
    'Diyarbakır',
    'Düzce',
    'Edirne',
    'Elazığ',
    'Erzincan',
    'Erzurum',
    'Eskişehir',
    'Gaziantep',
    'Giresun',
    'Gümüşhane',
    'Hakkari',
    'Hatay',
    'Iğdır',
    'Isparta',
    'İstanbul',
    'İzmir',
    'Kahramanmaraş',
    'Karabük',
    'Karaman',
    'Kars',
    'Kastamonu',
    'Kayseri',
    'Kırıkkale',
    'Kırklareli',
    'Kırşehir',
    'Kilis',
    'Kocaeli',
    'Konya',
    'Kütahya',
    'Malatya',
    'Manisa',
    'Mardin',
    'Mersin',
    'Muğla',
    'Muş',
    'Nevşehir',
    'Niğde',
    'Ordu',
    'Osmaniye',
    'Rize',
    'Sakarya',
    'Samsun',
    'Siirt',
    'Sinop',
    'Sivas',
    'Şanlıurfa',
    'Şırnak',
    'Tekirdağ',
    'Tokat',
    'Trabzon',
    'Tunceli',
    'Uşak',
    'Van',
    'Yalova',
    'Yozgat',
    'Zonguldak'
  ];

  final List<String> genders = ['male', "female"];

  @override
  Widget build(BuildContext context) {
    // Build a Form widget using the _formKey created above.
    return Center(
        child: Container(
            width: 280.0,
            child: Align(
                alignment: Alignment(-5, 0.5),
                child: Form(
                    key: _formKey,
                    child: Column(children: <Widget>[
                      // Add TextFormFields and RaisedButton here.
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: new Align(
                            alignment: Alignment.topLeft,
                            child: Container(
                                child: Text(
                              "Poll Credentials",
                              style: TextStyle(
                                color: Colors.indigo,
                                fontSize: 30,
                                fontWeight: FontWeight.bold,
                              ),
                            ))),
                      ),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: new Align(
                            alignment: Alignment.topLeft,
                            child: Container(
                                child: Text(
                                  "Name&Surname",
                                  style: TextStyle(
                                    color: Colors.indigo,
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                  ),
                                ))),
                      ),

                      TextFormField(
                        decoration: InputDecoration(
                          hintText: "Name&Surname",
                          fillColor: Color.fromRGBO(0, 0, 0, 0),
                          prefixIcon: Icon(Icons.alternate_email),
                          border: new OutlineInputBorder(
                            borderRadius: new BorderRadius.circular(5.0),
                            borderSide:
                                new BorderSide(color: Colors.transparent),
                          ),
                        ),
                        // The validator receives the text that the user has entered.
                        validator: (value) {
                          if (value.isEmpty) {
                            return 'Please fill this field';
                          }
                          return null;
                        },
                      ),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: new Align(
                            alignment: Alignment.topLeft,
                            child: Container(
                                child: Text(
                                  "Birth Date",
                                  style: TextStyle(
                                    color: Colors.indigo,
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                  ),
                                ))),
                      ),
                      TextFormField(
                        decoration: InputDecoration(
                          hintText: "31.12.2020",
                          fillColor: Color.fromRGBO(0, 0, 0, 0),
                          prefixIcon: Icon(Icons.calendar_today),
                          border: new OutlineInputBorder(
                            borderRadius: new BorderRadius.circular(5.0),
                            borderSide:
                                new BorderSide(color: Colors.transparent),
                          ),
                        ),
                        // The validator receives the text that the user has entered.
                        validator: (value) {
                          if (value.isEmpty) {
                            return 'Please fill this field';
                          }
                          return null;
                        },
                      ),

                      DropdownItemsWidget("Gender", this.genders),
                      DropdownItemsWidget("City", this.cities),
                      RaisedButton(
                        color: Colors.lightBlue,
                        disabledColor: Colors.blueGrey,
                        textColor: Colors.white,
                        splashColor: Colors.blueAccent,
                        onPressed: () {
                          // Validate returns true if the form is valid, otherwise false.
                          if (_formKey.currentState.validate()) {
                            // If the form is valid, display a snackbar. In the real world,
                            // you'd often call a server or save the information in a database.

                            Navigator.pushNamed(context, '/pollPage2');

                            //Scaffold.of(context)
                            //    .showSnackBar(SnackBar(content: Text('Processing Data')));
                          }
                        },
                        child: Text('Submit'),
                      )
                    ])))));
  }
}
