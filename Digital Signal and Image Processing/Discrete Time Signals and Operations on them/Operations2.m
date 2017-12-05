%Operations on Discrete Time Signals -2
clear

x=[1 3 2 4 1 2];
subplot(2,2,1);
stem(x);
title('Signal X');

%Upscaling
for i=1:6
    y(i)=2*x(i);
end
subplot(2,2,2);
stem(y);
title('y(n)=2x(n)');

clear y
for i=1:3
    y(i)=x(2*i);
end
subplot(2,2,3);
stem(y);
title('y(n)=x(2n)');

%Downscaling
clear y
for i=1:12
    if(mod(i,2)==0)
        y(i)=x(i/2);           
    end   
end
subplot(2,2,4);
stem(y);
title('y(n)=x(n/2)');
