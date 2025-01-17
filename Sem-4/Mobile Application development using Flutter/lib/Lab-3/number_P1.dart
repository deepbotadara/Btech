import 'dart:io';

void main(){
    int s1,s2;
    stdout.write("Enter Starting number:");
    s1=int.parse(stdin.readLineSync()!);

    stdout.write("Enter Ending number:");
    s2=int.parse(stdin.readLineSync()!);
    
    for(int i=s1;i<=s2;i++){
        if( i%2 == 0 && i%3 != 0 ){
            stdout.write('$i, ');
        }
    }
}