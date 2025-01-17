import 'package:flutter/material.dart';

class CityListScreen extends StatelessWidget {
  List<String> colleges = [
  "Ahmedabad",
  "Surat",
  "Vadodara",
  "Rajkot",
  "Bhavnagar",
  "Jamnagar",
  "Junagadh",
  "Gandhinagar",
  "Anand",
  "Nadiad",
  "Morbi",
  "Mehsana",
  "Navsari",
  "Vapi",
  "Bharuch",
  "Palanpur",
  "Porbandar",
  "Godhra",
  "Dahod",
  "Valsad"
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('City List', textAlign: TextAlign.center,style: TextStyle(color: Colors.pink),),

        centerTitle: true,
      ),
      body: ListView.builder(
        itemCount: colleges.length,
        itemBuilder: (context, index) {
          return ListTile(
            leading: Icon(Icons.location_city),
            title: Text(colleges[index],textAlign: TextAlign.center,style: TextStyle(backgroundColor: Colors.blueAccent),),
            //trailing: Icon(Icons.account_tree) ,
          );
        },
      ),
    );
  }
}
