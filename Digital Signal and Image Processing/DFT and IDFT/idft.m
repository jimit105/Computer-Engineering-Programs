%IDFT
clc
clear
x = [6 -2+2i -2 -2-2i];
N = length(x);
X = zeros(N,1);
for k = 0:N-1
    for n = 0:N-1
        X(k+1) = X(k+1) + x(n+1)*(exp(j*2*pi*n*k/N)/N);
    end
end
X         % to check |X(k)|
