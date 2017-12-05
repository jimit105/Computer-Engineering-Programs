%Unit Step Function
clear
x=[-5:5];
for i=1:11
    if (i<=5)
        y(i)=0;
    else 
        y(i)=1;
    end
end
subplot(2,2,1)
stem(x,y)
title('Unit Step Function');
xlabel('X-Axis');
ylabel('Y-Axis');

%Ramp Function
clear
m=0;
x=[-5:5];
for i=1:11
    if(i<=5)
        y(i)=0
    else
        y(i)=m;
        m=m+1;
    end
end
subplot(2,2,2)
stem(x,y)
title('Ramp Function');
xlabel('X-Axis');
ylabel('Y-Axis');

%Impulse Function
clear
x=[-5:5];
for i=1:11
    if (i==6)
        y(i)=1;
    else 
        y(i)=0;
    end
end
subplot(2,2,3)
stem(x,y)
title('Impulse Function');
xlabel('X-Axis');
ylabel('Y-Axis');

%Exponential Function
clear
m=0;
x=[-5:5];
for i=1:11
    if (i<=5)
        y(i)=0;
    else 
        y(i)=2^m;
        m=m+1;
    end
end
subplot(2,2,4)
stem(x,y)
title('Exponential Function');
xlabel('X-Axis');
ylabel('Y-Axis');