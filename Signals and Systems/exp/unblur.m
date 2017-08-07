%Orignal Image
I = im2double(rgb2gray(imread('test.jpg')));
figure,subplot(3, 2, 1),imshow(I);
imwrite(I, 'origin.bmp');
title('1.ԭͼ');

temp = fft2(I);
temp = fftshift(temp);
temp = log(1 + abs(temp));
subplot(3,2,2),imshow(temp, []);
imwrite(temp, 'origin_fft.bmp');
title('2.ԭͼ�ĸ���ҶƵ��ͼ');

%Blurred Image
PSF = fspecial('motion', 20, 45);
blurred_I = imfilter(I, PSF, 'conv', 'circular');
subplot(3, 2, 3), imshow(blurred_I);
imwrite(blurred_I, 'blurred_I.bmp');
title('3.�˶�ģ��������ͼ(�߶�Ϊ20,�Ƕ�Ϊ45)')

temp = fft2(blurred_I);
temp = fftshift(temp);
temp = log(1 + abs(temp));
subplot(3,2,4),imshow(temp, []);
imwrite(temp, 'blurred_fft.bmp');
title('4.ģ��ͼ�ĸ���ҶƵ��ͼ');

%Blurred Noisy Image
noise_mean = 0;
noise_var = 0.0001;
blurred_noisy_I = imnoise(blurred_I, 'gaussian', noise_mean, noise_var);
subplot(3, 2, 5),imshow(blurred_noisy_I);
imwrite(blurred_noisy_I, 'noisy.bmp');
title('5.��ǰģ��ͼ�����ϼӾ�ֵΪ1������Ϊ0.0001֮��Ĵ�����ģ��ͼ');

temp = fft2(blurred_noisy_I);
temp = fftshift(temp);
temp = log(1 + abs(temp));
subplot(3,2,6),imshow(temp, []);
imwrite(temp, 'noisy_fft.bmp');
title('6.�����ģ��ͼ�ĸ���ҶƵ��ͼ');

figure();

%Direct on Blurred Image
wnr1 = deconvwnr(blurred_I, PSF, 0);
subplot(2,2,1),imshow(wnr1);
imwrite(wnr1, 'direct1.bmp');

%Weiner on Blurred Image
wnr2 = deconvwnr(blurred_I, PSF, 0);
subplot(2, 2, 2), imshow(wnr2);
imwrite(wnr2, 'weiner1.bmp');

%Direct on Blurred and Noisy Image
wnr3 = deconvwnr(blurred_noisy_I, PSF, 0);
subplot(2, 2, 3), imshow(wnr3);
imwrite(wnr3, 'direct2.bmp');

%Weiner on Blurred and Noisy Image
signal_var = var(I(:));
wnr4 = deconvwnr(blurred_noisy_I, PSF, noise_var/signal_var);
imwrite(wnr4, 'weiner2.bmp');
subplot(2, 2, 4), imshow(wnr4);
subplot(2, 2, 3), imshow(wnr3);
