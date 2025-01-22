function factorial(n){
    
    for(let i=n-1;i>0;i--){
        n=n*i;
    }
    console.log("Factorial of "+ num + " is "+ n)
}

let num=5;
factorial(num);