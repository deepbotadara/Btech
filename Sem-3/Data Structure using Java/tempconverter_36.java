import java.util.*;
public class tempconverter_36 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 for Convert Celsius to Fahrenheit");
        System.out.println("Enter 2 for Convert Fahrenheit to Celsius");
        int choice=sc.nextInt();

        double temperature,tempinfahrenheit,tempincelsius;
        temp t=new temp();

        Switch(choice){
            case 1:
                System.out.println("Enter temprature in Celsius:");
                temperature=sc.nextDouble();
                t.celsiusToFahrenheit(celsius);
                System.out.println("Temprature in Fahrenheit: "+tempinfahrenheit);
                break;
            case 2:
                System.out.println("Enter temprature in Fahrenheit:");
                temperature=sc.nextDouble();     
                t.fahrenheitToCelsius(fahrenheit);
                System.out.println("Temprature in Celsius: "+tempincelsius);
                        break;
            default:
                System.out.println("Invalid Choice");
        }


    }
}
class temp{
    public double celsiusToFahrenheit(double celsius){
        return (celsius*9/5)+32;
    }

    public double fahrenheitToCelsius(double fahrenheitahrenheit){
        return (fahrenheit-32)*5/9;
    }
}
