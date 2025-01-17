import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:madflabs/Lab-12/DateFormats_P3.dart';
import 'package:madflabs/Lab-12/ScrollScreen_P1&P2.dart';
import 'package:madflabs/Lab-2/main.dart';
import 'package:madflabs/Lab-9/TabView_P1.dart';

import 'Lab-13/BottomSheet_ButtonClick_P1&P3.dart';
import 'Lab-13/BottomSheet_Dialog_B_P5.dart';
import 'Lab-13/FormValidation_B_P4.dart';
import 'Lab-13/NavigationBar_P2.dart';

void main(){
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // title: 'City List App',
      home: BottomSheetForm(),
      // Set the CityListScreen as the home screen.
      debugShowCheckedModeBanner: false,
    );
  }
}
