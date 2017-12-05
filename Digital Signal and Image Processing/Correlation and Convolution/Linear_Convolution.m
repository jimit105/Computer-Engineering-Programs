%Linear Convolution- Direct Function
clear

x=input('Enter x: ') 
h=input('Enter h: ') 
conv(x,h)

stem(conv(x,h)); 
ylabel('Y(n)'); 
xlabel('n'); 
title('Linear Convolution of Two Signals');