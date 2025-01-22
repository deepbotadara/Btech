let sum=0, n1=0,n2=1;
let n=15;
console.log(n1);
console.log(n2);

for(let i=0;i<n-2;i++){
    sum=n1+n2;
    n1=n2;
    n2=sum;
    console.log(sum)
}