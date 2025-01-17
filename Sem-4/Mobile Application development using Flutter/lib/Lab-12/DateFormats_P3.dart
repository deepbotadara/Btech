import 'package:flutter/material.dart';
// import 'package:intl/intl.dart';

class Demo1 extends StatefulWidget {
  const Demo1({super.key});

  @override
  State<Demo1> createState() => _DemoState();
}

class _DemoState extends State<Demo1> {
  DateTime date = DateTime.now();
  DateTime? d2;

  @override
  Widget build(BuildContext context) {
    List<String> colleges = [
      "Darshan University",
      "Marvadi University",
      "Christ College",
      "Gujarat Technological University",
      "Atmiya University",
    ];

    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: [
            // Date Picker Section
            Column(
              children: [
                Text(
                  d2?.toString() ?? "Select a date",
                  style: const TextStyle(fontSize: 20),
                ),
                ElevatedButton(
                  onPressed: () async {
                    DateTime? d = await showDatePicker(
                      context: context,
                      initialDate: d2 ?? DateTime.now(),
                      firstDate: DateTime(2000),
                      lastDate: DateTime(3000),
                    );

                    if (d != null && d2 != d) {
                      setState(() {
                        d2 = d;
                      });
                    }
                  },
                  child: const Text("Pick a Date"),
                ),
              ],
            ),
            const SizedBox(height: 20),
            // Scrollable Content Section
            Container(
              color: Colors.red,
              height: 200,
              width: double.infinity,
            ),
            Container(
              color: Colors.blueAccent,
              height: 200,
              width: double.infinity,
              child: ListView.builder(
                itemCount: colleges.length,
                itemBuilder: (context, index) {
                  return Text(
                    colleges[index],
                    style: const TextStyle(fontSize: 18),
                  );
                },
              ),
            ),
            Container(
              color: Colors.red,
              height: 200,
              width: double.infinity,
              child: GridView.builder(
                itemCount: colleges.length,
                gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 3,
                  childAspectRatio: 2,
                ),
                itemBuilder: (context, index) {
                  return Center(
                    child: Text(
                      colleges[index],
                      textAlign: TextAlign.center,
                      style: const TextStyle(fontSize: 14),
                    ),
                  );
                },
              ),
            ),
            Container(
              color: Colors.green,
              height: 200,
              width: double.infinity,
            ),
            Container(
              color: Colors.red,
              height: 200,
              width: double.infinity,
            ),
          ],
        ),
      ),
    );
  }
}
