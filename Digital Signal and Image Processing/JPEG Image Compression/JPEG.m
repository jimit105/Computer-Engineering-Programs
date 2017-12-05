clc;
clear;
a=imread('image.jpg'); 
w = size(a,2); 
halfsamples = floor(w/2); 
quartersamples = floor(w/4); 
eightsamples = floor(w/8); 
ci2 = [ ]; 
ci4 = [ ]; 
ci8 = [ ]; 
for k= 1:3 % all color layers 
for i=1:size(a,1) % all rows 
rowdct = dct(double(a(i,:,k))); 
ci2(i,:,k) = idct(rowdct(1:halfsamples),w);
ci2(i,:,k) = idct(rowdct(1:halfsamples),w); 
ci4(i,:,k) = idct(rowdct(1: quartersamples),w); 
ci8(i,:,k) = idct(rowdct(1:eightsamples),w);
end 
end 
h = size(a,1); 
halfsamples = floor(h/2); 
quartersamples = floor(h/4); 
eightsamples = floor(h/8); 
ci2f = [ ]; 
ci4f = [ ]; 
ci8f = [ ]; 
for k= 1:3 % all color layers 
for i=1:size(a,2) % all columns 
columndct2 = dct(double(ci2(:,i,k))); 
columndct4 = dct(double(ci4(:,i,k))); 
columndct8 = dct(double(ci8(:,i,k))); 
ci2f(:,i,k) = idct(columndct2(1:halfsamples),h); 
ci4f(:,i,k) = idct(columndct4(1: quartersamples),h); 
ci8f(:,i,k) = idct(columndct8(1:eightsamples),h); 
end 
end 
subplot (2,2,1); 
image(uint8(a)); 
title('Original Image'); 
subplot (2,2,2); 
image(uint8(ci2f)); 
title('Compression Factor 2 '); 
subplot (2,2,3); 
image(uint8(ci4f)); 
title('Compression Factor 4 '); 
subplot (2,2,4); 
image(uint8(ci8f)); 
title('Compression Factor 8');
