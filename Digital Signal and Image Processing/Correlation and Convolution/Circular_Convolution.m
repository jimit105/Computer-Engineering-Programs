%Circular Convolution
clear
x = input('Enter a Sequence: ');
h = input('Enter another Sequence: ');

n1 = length(x);
n2 = length(h);

n = max(n1,n2);

a = 0:n-1;

x = [x,zeros(1,n-n1)];
h = [h,zeros(1,n-n2)];

y = zeros(1,n);

for i = 0:n-1

            for j = 0:n-1

                      k = mod((i-j),n);

                      y(i+1) = y(i+1) + x(j+1)*h(k+1);

            end

end
y
stem(a,y);
xlabel('n');
ylabel('Y(n)');
title('Circular Convolution');