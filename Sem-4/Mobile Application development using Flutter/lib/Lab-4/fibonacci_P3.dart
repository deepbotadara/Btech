import 'dart:io';

void main() {
  stdout.write("Enter a number: ");
  int num = int.parse(stdin.readLineSync()!);
  fib(num);
}

void fib(int num) {
  int n1 = 0;
  int n2 = 1;

  stdout.write("$n1");
  stdout.write(" $n1 ");

  for (int i = 0; i < num-2; i++) {
    int temp = n1 + n2;
    stdout.write('${n1 + n2}  ');
    n1 = n2;
    n2 = temp;
  }
}
