clc;
clear;
img = imread('image.jpg');
img = im2double(rgb2gray(img));
[rows, cols] = size(img);
hpf = -1 * ones(3);
hpf(2, 2) = 8;
img2 = img;

for i = 2:rows-1
    for j = 2:cols-1
        img2(i, j) = sum(sum((img(i-1:i+1, j-1:j+1) .* hpf)));
    end
end

subplot(1,2,1);
imshow(img);
title('Original Image')

subplot(1,2,2);
imshow(img2);
title('After HPF')