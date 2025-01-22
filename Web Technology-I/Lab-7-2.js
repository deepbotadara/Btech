function Primenumber(num) {
    if (num <= 1) 
        return false;

    for (let i = 2; i <= num/2; i++) {
        if (num % i === 0) 
            return false;
    }

    return true;
}

let num = 5;
if (Primenumber(num)) {
    console.log(num + " is a prime number.");
} 
else {
    console.log(num + " is not a prime number.");
}
