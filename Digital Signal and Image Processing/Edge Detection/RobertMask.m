clc;
clear;
img = imread('books.jpg');
img = im2double(rgb2gray(img));
[rows, cols] = size(img);
robert(1,1) = 1;
robert(1,2) = 1;
robert(2,1) = -1;
robert(2,2) = -1;
img2 = img;

for i = 1:rows-1
    for j = 1:cols-1
        img2(i, j) = sum(sum((img(i:i+1, j:j+1) .* robert)));
    end
end

subplot(1,2,1);
imshow(img);
title('Original Image')

subplot(1,2,2);
imshow(img2);
title('Using Robert mask:')