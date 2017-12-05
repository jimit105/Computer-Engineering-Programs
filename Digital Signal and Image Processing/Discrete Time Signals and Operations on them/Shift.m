%Shifting of Signals
clear
n1=input('Enter the delay time \n');
n2=input('Enter the time to be advanced \n');

n = 0:1:5;
x = [ 4 3 2 1 5 3];
subplot(3,1,1);
stem(n,x);
title('Signal x(n)');

%Delayed Signal
m = n+n1;
subplot (3,1,2);
stem(m,x);
title('Delayed Signal x(m)');

%Advanced Signal
m = n - n2;
subplot (3,1,3);
stem(m,x);
title('Advanced Signal x(m)');