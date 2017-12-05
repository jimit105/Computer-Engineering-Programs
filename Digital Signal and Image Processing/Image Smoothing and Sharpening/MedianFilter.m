clc;
clear;
B=imread('image.jpg');
A= rgb2gray(B);
img=imnoise(A,'salt & pepper',0.03);

modifyA=zeros(size(img)+2);
B=zeros(size(img));


        for x=1:size(img,1)
            for y=1:size(img,2)
                modifyA(x+1,y+1)=img(x,y);
            end
        end
        
for i= 1:size(modifyA,1)-2
    for j=1:size(modifyA,2)-2
        window=zeros(9,1);
        inc=1;
        for x=1:3
            for y=1:3
                window(inc)=modifyA(i+x-1,j+y-1);
                inc=inc+1;
            end
        end
       
        med=sort(window);
       
        B(i,j)=med(5);
       
    end
end

B=uint8(B);

subplot(1,3,1);
imshow(A);
title('Original Image')

subplot(1,3,2);
imshow(img);
title('Image with Salt and Pepper Noise')

subplot(1,3,3);
imshow(B);
title('After Median Filtering')
