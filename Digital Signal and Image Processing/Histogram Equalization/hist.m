clc;
clear;
filename= 'image.jpg'; % the filename to be read
im=imread(filename);
im=imresize(im,[256,256]);
im=rgb2gray(im);
figure(1);
subplot(1,2,1);
imshow(im);

subplot(1,2,2);
imagesc(im);  % display
axis('square');
colormap('gray');
imhist(im);
im_histeq=histeq(im);
figure(2);
subplot(1,2,1);
imshow(im_histeq);  
%axis('square');
colormap('gray');

subplot(1,2,2);
imhist(im_histeq);