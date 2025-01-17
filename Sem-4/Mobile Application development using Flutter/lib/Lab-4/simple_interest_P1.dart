import 'dart:io';

void main() {
  double p, r, t;
  stdout.write("Enter Principal Amount: ");
  p = double.parse(stdin.readLineSync()!);

  stdout.write("Enter Rate of  Interest: ");
  r = double.parse(stdin.readLineSync()!);

  stdout.write("Enter Time Period (in years): ");
  t = double.parse(stdin.readLineSync()!);

  print('Interest: ${interestCalc(p, r: r, t: t)}');
  print(
      'Interest rate using named optional with default value(t): ${interestCalc(p, r: r)}');
  print(
      'Interest rate using named optional with default value(r): ${interestCalc(p, t: t)}');
}

double interestCalc(double? p, {double? r = 8, double? t = 10}) {
  return (p! * r! * t!) / 100;
}
