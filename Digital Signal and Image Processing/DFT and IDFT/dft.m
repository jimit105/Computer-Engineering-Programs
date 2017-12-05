%DFT
clc
clear
x = [0 1 2 3];
N = length(x);
X = zeros(N,1);
for k = 0:N-1
    for n = 0:N-1
        X(k+1) = X(k+1) + x(n+1)*exp(-j*2*pi*n*k/N);
    end
end
X         % to check |X(k)|
