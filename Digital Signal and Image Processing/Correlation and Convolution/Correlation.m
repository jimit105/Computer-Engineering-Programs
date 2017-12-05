clc;
clear all;
close all;

x=input('Enter the first sequence: ');
h=input('Enter the second sequence: ');

n=length(x);
m=length(h);
k=n+m-1;
x=[x zeros(1,k-n)]';
h=fliplr(h);
h=[h zeros(1,k-m)]';

for i=1:k
    c(:,i)=circshift(x,i-1);
end
y=c*h;
disp('Cross Correlation')
disp(y);
stem(y)
title('Cross Correlation')