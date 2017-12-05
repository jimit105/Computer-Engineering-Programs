%Operations on Discrete Time Signals -1
clear
x=[2 3 4 2];
subplot(3,2,1);
stem(x);
title('Signal X');
y=[2 1 1 2];
subplot(3,2,2);
stem(y);
title('Signal Y');

%Addition
z=x+y;
subplot(3,2,3);
stem(z);
title('Addition');

%Subtraction
z=x-y;
subplot(3,2,4);
stem(z);
title('Subtraction');

%Multiplication
z=x.*y;
subplot(3,2,5);
stem(z);
title('Multiplication');

%Division
z=x./y;
subplot(3,2,6);
stem(z);
title('Division');