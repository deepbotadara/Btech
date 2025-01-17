import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

// Import your required screens
import '../Lab-11/Listview_City_P1.dart';
import '../Lab-12/DateFormats_P3.dart';
import '../Lab-12/ScrollScreen_P1&P2.dart';

class BottomSheetExample extends StatefulWidget {
  const BottomSheetExample({super.key});

  @override
  _BottomSheetExampleState createState() => _BottomSheetExampleState();
}

class _BottomSheetExampleState extends State<BottomSheetExample> {
  int idx = 0; // Current selected index for the BottomNavigationBar

  final List<Widget> pages = [
    Demo(), // Replace with your actual widget
    Demo1(), // Replace with your actual widget
    CityListScreen(), // Replace with your actual widget
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Hello World"),
      ),
      body: pages[idx], // Display the current selected page
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: idx,
        onTap: (value) {
          setState(() {
            idx = value; // Update the selected page index
          });
        },
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home_filled),
            label: "Home",
            backgroundColor: Colors.red,
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.phone),
            label: "Contact",
            backgroundColor: Colors.blue,
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: "Profile",
            backgroundColor: Colors.green,
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          showModalBottomSheet(
            context: context,
            builder: (context) {
              return Container(
                height: 200,
                child: const Center(
                  child: Text('Hello from Bottom Sheet!'),
                ),
              );
            },
          );
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}

