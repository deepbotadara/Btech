import 'package:flutter/material.dart';

class Demo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    List<String> colleges = [
      "Darshan University",
      "Marvadi university",
      "Christ College",
      "Gujarat technological university",
      "Atmiya university",
      "Darshan University",
      "Marvadi university",
      "Christ College",
      "Gujarat technological university",
      "Atmiya university",
      "Darshan University",
      "Marvadi university",
      "Christ College",
      "Gujarat technological university",
      "Atmiya university",
      "Darshan University",
      "Marvadi university",
      "Christ College",
      "Gujarat technological university",
      "Atmiya university",
      "Darshan University",
      "Marvadi university",
      "Christ College",
      "Gujarat technological university",
      "Atmiya university",
      "Darshan University",
      "Marvadi university",
      "Christ College",
      "Gujarat technological university",
      "Atmiya university"
    ];
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('SingleChildScrollView Example')),
        body: SingleChildScrollView(
          child: Column(
            children: <Widget>[
              Container(
                height: 200,
                color: Colors.blue,
                child: Center(child: Text('Item 1',
                    style: TextStyle(color: Colors.white, fontSize: 20))),
              ),
              Container(
                  height: 200,
                  color: Colors.green,
                  child: ListView.builder(
                    itemCount: colleges.length,
                    itemBuilder: (context, index) {
                      return Text(
                        colleges[index], style: TextStyle(fontSize: 20),);
                    },)
              ),
              Container(
                height: 200,
                color: Colors.red,
                child: GridView.builder(
                          itemCount: colleges.length,
                          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount:4 ,childAspectRatio: 5),
                            itemBuilder: (context, index) {
                              return Padding(
                                padding: const EdgeInsets.all(8.0),
                                child: Container(
                                    color: Colors.grey,child: Text(colleges[index],style: TextStyle(fontSize: 20))),
                              );},)
              ),
              Container(
                height: 200,
                color: Colors.yellow,
                child: Center(child: Text('Item 4',
                    style: TextStyle(color: Colors.black, fontSize: 20))),
              ),
              // Add more items as needed
            ],
          ),
        ),
      ),
    );
  }
}
