import 'package:flutter/material.dart';
class DropdownItemsWidget extends StatefulWidget {
  final String listName;
  final List<String> items;
  DropdownItemsWidget(String listName, List items, {Key key}) :this.listName = listName, this.items = items, super(key: key);

  @override
  _DropdownItemsWidget createState() => new _DropdownItemsWidget(this.listName, this.items);
}

class _DropdownItemsWidget extends State<DropdownItemsWidget> {
  final String _listName;
  final List _items;

  _DropdownItemsWidget(this._listName, this._items);

  List<DropdownMenuItem<String>> _dropDownMenuItems;
  String _currentItem;

  @override
  void initState() {
    _dropDownMenuItems = getDropDownMenuItems();
    _currentItem = _dropDownMenuItems[0].value;
    super.initState();
  }

  List<DropdownMenuItem<String>> getDropDownMenuItems() {
    List<DropdownMenuItem<String>> items = new List();
    for (String item in _items) {
      items.add(new DropdownMenuItem(
          value: item,
          child: new Text(item)
      ));
    }
    return items;
  }

  @override
  Widget build(BuildContext context) {
    return new Container(
      color: Colors.white,
      child: new Center(
          child: new Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              new Align(
                  alignment: Alignment.topLeft,
                  child: Container(
                      child: Text(
                        _listName,
                        style: TextStyle(
                          color: Colors.indigo,
                          fontSize: 20,
                          fontWeight: FontWeight.bold,

                        ),
                      )
                  )
              ),
              new Align(
                  alignment: Alignment.topLeft,
                  child: Container(
                      child: new DropdownButton(
                        value: _currentItem,
                        items: _dropDownMenuItems,
                        onChanged: changedDropDownItem,
                      )
                  )
              ),

            ],
          )
      ),
    );
  }

  void changedDropDownItem(String selectedItem) {
    setState(() {
      _currentItem = selectedItem;
    });
  }

}