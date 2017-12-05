clc;
clear;
img = imread('image.jpg');
img = im2double(rgb2gray(img));
img3 = imnoise(img,'gaussian',0,0.02);
[rows, cols] = size(img3);
lpf = 1/9 * ones(3);
img2 = img3;

for i = 2:rows-1
    for j = 2:cols-1
        img2(i, j) = sum(sum((img3(i-1:i+1, j-1:j+1) .* lpf)));
    end
end

subplot(1,3,1);
imshow(img);
title('Original Image')

subplot(1,3,2);
imshow(img3);
title('Image with Gaussian Noise')

subplot(1,3,3);
imshow(img2);
title('After LPF')


