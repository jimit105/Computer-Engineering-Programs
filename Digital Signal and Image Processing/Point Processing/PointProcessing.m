clc;
clear;
path = 'image.jpg';
img1 = imread(path)
t=input('Enter threshold: ')
subplot(2,2,1)
imshow(img1)
title('Original')


img = rgb2gray(imread(path))

%Negation
l=256;
mat = img;
mat = l - 1 - mat;
subplot(2,2,2)
imshow(mat);
title('Negative')

%Threshold
mat=img;
[row col]=size(img);

for i=1:row
    for j=1:col
        if(img(i,j)<t) mat(i,j)=0;
        else mat(i,j)=255;
        end
    end
end
subplot(2,2,3)
imshow(mat);
title('Threshold')

%Contrast Stretching
l=0.5;
m=1.2;
n=2;
a=20;
b=50;
mat = img;
if(mat<=a)
mat = l*mat;

elseif(and((mat>a),(mat<=b)))
        mat = (m*mat) + (l*a) 
   
elseif(and((mat>b),(mat<=255)))
        mat=n*mat+(m*b);   
end
        
subplot(2,2,4)
imshow(mat);
title('Constrast Stretching')

